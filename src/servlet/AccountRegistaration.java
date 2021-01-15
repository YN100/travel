package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NewRegistaration;
import beans.AccountBeans;

/**
 * Servlet implementation class AccountRegistaration
 */
public class AccountRegistaration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegistaration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");


		AccountBeans ab = new AccountBeans();

		ab.setUid(loginId);
		ab.setPasswd(password);
		ab.setUserName(userName);

		HttpSession session = request.getSession();
		session.setAttribute("account", ab);

		NewRegistaration nr = new NewRegistaration();
		nr.registar(ab);



		RequestDispatcher rd = request.getRequestDispatcher("registarationSuccess.jsp");
		rd.forward(request, response);

	}

}
