package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TravelControl
 */
public class TravelControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelControl() {
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
		try {
		RequestDispatcher dispatcher = null;

		HttpSession session = request.getSession();

		//日付の形式判定
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//うるう年などを判定
		sdf.setLenient(false);
		String startInputdate = request.getParameter("startDay");
		if(startInputdate == null) {
			request.setAttribute("errorMessage", "date is required");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}else {
			try {
				sdf.parse(startInputdate);
				request.setAttribute("startInputdate", startInputdate);

			}catch(ParseException e) {
				request.setAttribute("errorMessage", "date format is invalied");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		String goalInputdate = request.getParameter("goalDay");
		if(goalInputdate == null) {
			request.setAttribute("errorMessage", "date is required");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}else {
			try {
				sdf.parse(goalInputdate);
				request.setAttribute("goalInputdate", goalInputdate);

			}catch(ParseException e) {
				request.setAttribute("errorMessage", "date format is invalied");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		String people = request.getParameter("people");
		String room = request.getParameter("room");
		String cook = request.getParameter("cook");


		session.setAttribute("people", people);
		session.setAttribute("room", room);
		session.setAttribute("cook", cook);
		dispatcher = request.getRequestDispatcher("order.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
