package myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WrongGoto")
public class WrongGoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WrongGoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		String timeorall=request.getParameter("timeorall");		
		int pageye=Integer.parseInt(request.getParameter("pageye"));
		String xuehao=request.getParameter("xuehao");
		int pagecount=5;
		int pagestart=(pageye*pagecount)-pagecount;
		HttpSession session=request.getSession(true);
		session.setAttribute("timeorall", timeorall);
		session.setAttribute("pagestart", pagestart);
		session.setAttribute("xuehao", xuehao);
		
		response.sendRedirect("Wrong.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
