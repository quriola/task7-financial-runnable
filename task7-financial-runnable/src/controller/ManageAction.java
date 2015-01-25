//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FavoriteDAO;
import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;

import databeans.User;
import databeans.FavoriteBean;

/*
 * Sets up the request attributes for manage.jsp.
 * This is the way to enter "Manage Your Photos"
 * from someplace else in the site.
 * 
 * Sets the "userList" request attribute in order to display
 * the list of users on the navbar.
 * 
 * Sets the "photoList" request attribute in order to display
 * the list of user's photos for management.
 * 
 * Forwards to manage.jsp.
 */
public class ManageAction extends Action {

	private FavoriteDAO favoriteDAO;
	private UserDAO userDAO;

	public ManageAction(Model model) {
		favoriteDAO = model.getFavoriteDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "manage.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up the errors list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {

			User user = (User) request.getSession(false).getAttribute("user");
			FavoriteBean[] favoriteList = favoriteDAO.getItems(user.getId());
			request.setAttribute("favoriteList", favoriteList);

			return "manage.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
