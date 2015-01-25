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
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.User;
import formbeans.IdForm;

/*
 * Removes a favorite.  Given an "id" parameter.
 * Checks to see that id is valid number for a favorite and that
 * the logged user is the owner.
 * 
 * Sets up the "userList" and "favoriteList" request attributes
 * and if successful, forwards back to to "manage.jsp".
 */
public class RemoveAction extends Action {
	private FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;

    public RemoveAction(Model model) {
    	favoriteDAO = model.getFavoriteDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "remove.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            IdForm form = formBeanFactory.create(request);
	    	
	    	User user = (User) request.getSession().getAttribute("user");

			int id = form.getIdAsInt();
			favoriteDAO.delete(id);

    		// Be sure to get the photoList after the delete
        	FavoriteBean[] favoriteList = favoriteDAO.getItems(user.getId());
	        request.setAttribute("favoriteList",favoriteList);

	        return "manage.jsp";
		} catch (RollbackException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
		} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
