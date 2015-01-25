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

import model.FavoriteDAO;
import model.Model;
import model.UserDAO;
import databeans.FavoriteBean;
import databeans.User;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public void init() throws ServletException {
		Model model = new Model(getServletConfig());

		Action.add(new ChangePwdAction(model));
		Action.add(new ClickAction(model));
		Action.add(new LoginAction(model));
		Action.add(new LogoutAction(model));
		Action.add(new ManageAction(model));
		Action.add(new RegisterAction(model));
		Action.add(new RemoveAction(model));
		Action.add(new UploadAction(model));
		Action.add(new ViewAction(model));
		UserDAO userDAO = model.getUserDAO();
		FavoriteDAO favoriteDAO = model.getFavoriteDAO();
		try {
			// Create the user bean

			User user = new User();
			user.setEmail("default1@gmail.com");
			user.setFirstName("Default1");
			user.setLastName("AAA");
			user.setPassword("abc");
			userDAO.create(user);

			user.setEmail("default2@gmail.com");
			user.setFirstName("Default2");
			user.setLastName("BBB");
			user.setPassword("abc");
			userDAO.create(user);

			user.setEmail("default3@gmail.com");
			user.setFirstName("Default3");
			user.setLastName("CCC");
			user.setPassword("abc");
			userDAO.create(user);

			FavoriteBean favorite = new FavoriteBean();

			for (int i = 1; i < 4; i++) {
				favorite.setUser_id(userDAO.read("default" + i + "@gmail.com")
						.getId());

				favorite.setUrl("www.google.com");
				favorite.setComment("Search Engine");
				favoriteDAO.create(favorite);
				favorite.setUrl("www.imdb.com");
				favorite.setComment("Movie Website");
				favoriteDAO.create(favorite);
				favorite.setUrl("www.netflix.com");
				favorite.setComment("Video Site");
				favoriteDAO.create(favorite);
				favorite.setUrl("www.gamespot.com");
				favorite.setComment("Game Site");
				favoriteDAO.create(favorite);

			}
		} catch (RollbackException e) {

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
		User user = (User) session.getAttribute("user");
		String action = getActionName(servletPath);

		// System.out.println("servletPath="+servletPath+" requestURI="+request.getRequestURI()+"  user="+user);

		if (action.equals("register.do") || action.equals("login.do")
				|| action.equals("view.do") || action.equals("click.do")) {
			// Allow these actions without logging in
			return Action.perform(action, request);
		}

		if (user == null) {
			// If the user hasn't logged in, direct him to the login page
			return Action.perform("login.do", request);
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
