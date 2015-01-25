//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.FavoriteBean;

public class FavoriteDAO extends GenericDAO<FavoriteBean> {
	public FavoriteDAO(String tableName, ConnectionPool cp) throws DAOException {
		super(FavoriteBean.class, tableName, cp);
	}

	public void create(FavoriteBean favorite) throws RollbackException {
		FavoriteBean[] favorites = match(MatchArg.and(MatchArg.equals("user_id", favorite.getUser_id()),
				MatchArg.equals("url", favorite.getUrl()))) ;
		if (favorites.length>0) {
			return;
		}
		try {
			Transaction.begin();

			createAutoIncrement(favorite);

			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}

	public FavoriteBean[] getItems(int user_id) throws RollbackException {

		FavoriteBean[] favorites = match(MatchArg.equals("user_id", user_id));
		return favorites;
	}

	public void addCount(int favorite_id) throws RollbackException {
		try {
			Transaction.begin();
			FavoriteBean favorite = read(favorite_id);
			favorite.addCount();
			update(favorite);
			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
}
