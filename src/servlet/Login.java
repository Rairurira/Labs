package servlet;

import app.AccountBO;
import dao.AccountDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.io.FileDescriptor.out;


public class Login extends HttpServlet {

	AccountDAO accDAO = new AccountDAO();

	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();


        String fName = req.getParameter("firstName");
		String lName = req.getParameter("lastName");

   		AccountBO accBO = accDAO.getAccountbyName(fName, lName);

		if (accBO != null) {

		 session.setAttribute("fName", req.getParameter("firstName"));
		 session.setAttribute("lName", req.getParameter("lastName"));

		 req.getRequestDispatcher("account.jsp").forward(req, resp);
     }
     else  {

			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
	}

}
