package myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LLgoto")
public class LLgoto extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public LLgoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		String pattern=request.getParameter("pattern");		
		String xuehao=request.getParameter("xuehao");
		HttpSession session=request.getSession(true);
		session.setAttribute("pattern", pattern);
		session.setAttribute("xuehao", xuehao);
		request.getRequestDispatcher("Limitless.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
