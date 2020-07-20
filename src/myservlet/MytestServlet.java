package myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MytestServlet")
public class MytestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MytestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		int pid=Integer.parseInt(request.getParameter("pid"));		
		String xuehao=request.getParameter("xuehao");
		String kcbianhao=request.getParameter("kcbianhao");
		String gonghao=request.getParameter("gonghao");
		HttpSession session=request.getSession(true);
		session.setAttribute("xuehao", xuehao);
		session.setAttribute("pid", pid);
		session.setAttribute("kcbianhao", kcbianhao);
		session.setAttribute("gonghao", gonghao);
		response.sendRedirect("MyTest.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
