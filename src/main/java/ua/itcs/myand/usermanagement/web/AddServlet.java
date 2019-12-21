package ua.itcs.myand.usermanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.itcs.myand.usermanagement.User;
import ua.itcs.myand.usermanagement.db.DaoFactory;
import ua.itcs.myand.usermanagement.db.DatabaseException;;

public class AddServlet extends EditServlet {

	
	protected void processUser(User user) throws DataBaseException {
		DaoFactory.getInstance().getUserDao().create(user);
	}
	
	protected void showPage(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.getRequestDispatcher("/add.jsp").forward(req, resp);
	}
}
