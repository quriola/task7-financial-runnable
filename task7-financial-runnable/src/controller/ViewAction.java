//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
 * Action called when viewing a photo given it's "id" number.
 * 
 * If successful, looks up the Photo bean by id and sets the
 * "photo" attribute to that bean.  Also sets the "title"
 * attribute to the photo's caption and the "userList"
 * attribute to the list of users.
 * 
 * On success, forward to view.jsp for formatting.
 * 
 * Note: view.jsp simply generates an html <img> tag
 * that uses ImageAction to fetch the bytes for the image.
 * ViewAction allows us to have the template around the image.
 */
public class ViewAction extends Action {
	private FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;
	
    public ViewAction(Model model) {
    	favoriteDAO = model.getFavoriteDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "view.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            
	    	IdForm form = formBeanFactory.create(request);
	    	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "error.jsp";
	        }
        
    		int id = form.getIdAsInt();
    		User cur_user = userDAO.read(id);
    		FavoriteBean[] favoriteList = favoriteDAO.getItems(id);
    		if (favoriteList == null) {
    			errors.add("No favorites with ="+cur_user.getFirstName()+" "+cur_user.getLastName());
    			return "error.jsp";
    		}
    		request.setAttribute("favoriteList",favoriteList);
    		request.setAttribute("cur_user",cur_user);
            return "view.jsp";
    	} catch (RollbackException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
