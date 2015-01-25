//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014


package model;


import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.User;


public class UserDAO extends GenericDAO<User> {
	
	public UserDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(User.class, tableName, pool);
	}

	public void create(User newUser) throws RollbackException {
		if (read(newUser.getEmail())!=null){
			return;
		}
		try {
			Transaction.begin();
			createAutoIncrement(newUser);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}


	public User[] getUsers() throws RollbackException {
		User[] users = match();
		Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
		return users;
	}
	
	public void setPassword(String userName, String password) throws RollbackException {
        try {
        	Transaction.begin();
			User dbUser = read(userName);
			
			if (dbUser == null) {
				throw new RollbackException("User "+userName+" no longer exists");
			}
			
			dbUser.setPassword(password);
			
			update(dbUser);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	public User read(String email) throws RollbackException {
		User[] users = match(MatchArg.equals("email", email));
		if (users.length > 0)
			return users[0];
		else
			return null;

	}
}
