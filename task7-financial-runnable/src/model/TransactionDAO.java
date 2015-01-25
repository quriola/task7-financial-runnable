package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.TransactionBean;

public class TransactionDAO extends GenericDAO<TransactionBean>{
	
	public TransactionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(TransactionBean.class, tableName, pool);
	}
	
	public TransactionBean[] getTransactions (int customerId) {
	    try {
	    	Transaction.begin();
	    	
	    	TransactionBean[] transactions;
	    	transactions=match(MatchArg.equals("customer_id", customerId));
	    	//Need to sort??
	    	Transaction.commit();
			return transactions;
	    } catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
	    }
	    return null;
	}

	public void createBuyTransaction(TransactionBean transaction) {
		// TODO Auto-generated method stub
		 try {
		    	Transaction.begin();
		    	transaction.setTransaction_type(0);;
		    	createAutoIncrement(transaction);
		    	Transaction.commit();
				
		    } catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (Transaction.isActive()) Transaction.rollback();
		    }
		    
	}
}
