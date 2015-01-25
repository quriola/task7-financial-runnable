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
import formbeans.UploadFavoriteForm;

public class UploadAction extends Action {
	private FormBeanFactory<UploadFavoriteForm> formBeanFactory = FormBeanFactory
			.getInstance(UploadFavoriteForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO userDAO;

	public UploadAction(Model model) {
		favoriteDAO = model.getFavoriteDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "upload.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up the errors list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {

			User user = (User) request.getSession(false).getAttribute("user");
			FavoriteBean[] favoriteList = favoriteDAO.getItems(user.getId());
			request.setAttribute("favoriteList", favoriteList);

			UploadFavoriteForm form = formBeanFactory.create(request);
			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0)
				return "error.jsp";

			FavoriteBean favorite = new FavoriteBean(); // id & position will be
														// set when created
			favorite.setComment(form.getComment());
			favorite.setUrl(form.getUrl());
			favorite.setUser_id(user.getId());

			favoriteDAO.create(favorite);

			// Update photoList (there's now one more on the list)
			FavoriteBean[] newFavoriteList = favoriteDAO.getItems(user.getId());
			request.setAttribute("favoriteList", newFavoriteList);
			return "manage.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
		}
	}
}
