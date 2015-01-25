//Jiayi Zhu
//jiayiz
//08-600
//Dec 10, 2014

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.User;
import formbeans.RegisterForm;

/*
 * Processes the parameters from the form in register.jsp.
 * If successful:
 *   (1) creates a new User bean
 *   (2) sets the "user" session attribute to the new User bean
 *   (3) redirects to view the originally requested photo.
 * If there was no photo originally requested to be viewed
 * (as specified by the "redirect" hidden form value),
 * just redirect to manage.do to allow the user to add some
 * photos.
 */
public class RegisterAction extends Action {
	private FormBeanFactory<RegisterForm> formBeanFactory = FormBeanFactory
			.getInstance(RegisterForm.class);

	private UserDAO userDAO;

	public RegisterAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "register.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			// Set up user list for nav bar
			HttpSession session = request.getSession(false);
			session.setAttribute("userList", userDAO.getUsers());
			RegisterForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "register.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());

			if (userDAO.read(form.getEmail()) != null) {
				errors.add("Email already registered");
			}

			if (errors.size() != 0) {
				return "register.jsp";
			}

			// Create the user bean
			User user = new User();
			user.setEmail(form.getEmail());
			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setPassword(form.getPassword());
			userDAO.create(user);

			// Attach (this copy of) the user bean to the session

			session.setAttribute("user", user);
			// Set up user list for nav bar
			session.setAttribute("userList", userDAO.getUsers());
			return "manage.do";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "register.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "register.jsp";
		}
	}
}
