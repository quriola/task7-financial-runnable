//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;

import model.CustomerDAO;
import model.EmployeeDAO;
import model.Model;
import databeans.CustomerBean;
import databeans.EmployeeBean;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public void init() throws ServletException {
		Model model = new Model(getServletConfig());

		Action.add(new CusLoginAction(model));
		Action.add(new EmpLoginAction(model));
		Action.add(new LogoutAction(model));
		CustomerDAO customerDAO = model.getCustomerDAO();
		EmployeeDAO employeeDAO = model.getEmployeeDAO();
		
		try {
			// Create the user bean

			CustomerBean customer = new CustomerBean();
			customer.setUsername("customer");
			customer.setPassword("abc");
			customer.setFirstname("First");
			customer.setLastname("Customer");
			customer.setAddrL1("5030 Centre Ave");
			customer.setAddrL2("APT 101");
			customer.setCity("Pittsburgh");
			customer.setState("PA");
			customer.setZip(15213);
			customer.setCash(1000);
			customerDAO.create(customer);
			
			EmployeeBean employee = new EmployeeBean();
			employee.setUsername("admin");
			employee.setPassword("abc");
			employee.setFirstname("First");
			employee.setLastname("Employee");
			
			employeeDAO.create(employee);
			
		} catch (RollbackException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = performTheAction(request);
		sendToNextPage(nextPage, request, response);
	}

	/*
	 * Extracts the requested action and (depending on whether the user is
	 * logged in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	private String performTheAction(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String servletPath = request.getServletPath();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		EmployeeBean employee = (EmployeeBean) session.getAttribute("employee");
		
		String action = getActionName(servletPath);

		// System.out.println("servletPath="+servletPath+" requestURI="+request.getRequestURI()+"  user="+user);

		if (action.equals("cuslogin.do") || action.equals("emplogin.do")) {
			// Allow these actions without logging in
			return Action.perform(action, request);
		}

		if (customer == null && employee == null) {
			// If the user hasn't logged in, direct him to the login page
			return Action.perform("cuslogin.do", request);
		}

		// Let the logged in user run his chosen action
		return Action.perform(action, request);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
	 * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
	 * page (the view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,
					request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}

		if (nextPage.endsWith(".jsp")) {
			RequestDispatcher d = request.getRequestDispatcher("WEB-INF/"
					+ nextPage);
			d.forward(request, response);
			return;
		} else {
			response.sendRedirect("http://" + nextPage);
			return;
		}

	}

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}
}
