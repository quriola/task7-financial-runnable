package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.CustomerBean;
import databeans.FundBean;
import databeans.TransactionBean;
import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;
import model.FundDAO;
import formbeans.BuyForm;

public class ConfirmBuyAction extends Action {
	private FormBeanFactory<BuyForm> formBeanFactory = FormBeanFactory.getInstance(BuyForm.class);
	private CustomerDAO customerDAO;
	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;
	
	public ConfirmBuyAction(Model model) {
		customerDAO = model.getCustomerDAO();
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
	}
	
	public String getName() {
		return "confirmbuy.do";
	}
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			CustomerBean customer = (CustomerBean) request.getSession(false).getAttribute("customer");
			BuyForm form  = formBeanFactory.create(request);
			request.setAttribute("form", form);
//			HttpSession session = request.getSession();
//			session.setAttribute("fundList", fundDAO.getFundList());
			TransactionBean transaction = new TransactionBean();
			transaction.setCustomer_id(customer.getCustomerId());
			transaction.setFund_id(form.getIdAsInt());; //should obtain from fund table, which is not established so far. So recorded as 0 temporarily here.
			transaction.setAmount(form.getAmountAsLong());
//			//加一个判断语句：amount<cash
			transactionDAO.createBuyTransaction(transaction);
//			
			customerDAO.updateCash(customer.getCustomerId(), 0-form.getAmountAsLong());
			
			HttpSession session = request.getSession();
			customer = customerDAO.read(customer.getCustomerId());
			session.setAttribute("customer",customer);
			return "buyFund.jsp";
		} catch(FormBeanException e) {
			errors.add(e.getMessage());
			return "sellFund.jsp";
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "buyFund.jsp";
		
	}
	

}
