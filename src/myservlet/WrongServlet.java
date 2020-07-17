package myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WrongServlet")
public class WrongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WrongServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String timeorall=request.getParameter("timeorall");
		String xuehao=request.getParameter("xuehao");
		int pagestart=Integer.parseInt(request.getParameter("pagestart"));	
		HttpSession session=request.getSession(true);
		session.setAttribute("timeorall", timeorall);
		session.setAttribute("pagestart", pagestart);
		session.setAttribute("xuehao", xuehao);
		request.getRequestDispatcher("Wrong.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
