package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javabean.*;
@WebServlet("/Lgoto")
public class Lgoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Lgoto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		String pattern=request.getParameter("pattern");		
		String xuehao=request.getParameter("xuehao");
		String timeorall=request.getParameter("timeorall");
		HttpSession session=request.getSession(true);
		session.setAttribute("pattern", pattern);
		session.setAttribute("xuehao", xuehao);
		session.setAttribute("timeorall", timeorall);
		LorLL l=new LorLL();
		String ttype="limit";
		ArrayList<TeaTest> teatestlist=new ArrayList<TeaTest>();
		ArrayList<TeaTest> teatestlist2=new ArrayList<TeaTest>();
		ArrayList<TeaTest> teatestlistcon=new ArrayList<TeaTest>();
		ArrayList<TeaTest> teatestlistnew=new ArrayList<TeaTest>();
		ArrayList<StuTest> stutestlist=new ArrayList<StuTest>();
		ArrayList<twoint> remaintimescon=new ArrayList<twoint>();
		ArrayList<Integer> remaintimesnew=new ArrayList<Integer>();
		ArrayList<String> teachername=new ArrayList<String>();
		ArrayList<String> teachernamecon=new ArrayList<String>();
		ArrayList<String> teachernamenew=new ArrayList<String>();
		ArrayList<String> correctlist=new ArrayList<String>();
		teatestlist=l.getteatest(xuehao,ttype);
		l.checkl(teatestlist,xuehao);
		if(pattern.equals("finish")) {
			stutestlist=l.getstutest2(teatestlist, xuehao);			
			teatestlist2=l.getteatest2(stutestlist);
			teachername=l.getteachername(teatestlist2);
			correctlist=l.getcorrect(stutestlist);
			session.setAttribute("stutestlist", stutestlist);
			session.setAttribute("teatestlist2", teatestlist2);
			session.setAttribute("teachername", teachername);
			session.setAttribute("correctlist", correctlist);
			
		}else {			
			teatestlistcon=l.getteatestcon(teatestlist,xuehao);
			teatestlistnew=l.getteatestnew(teatestlist, teatestlistcon, xuehao);			
			remaintimescon=l.gettimeandpid(teatestlistcon, xuehao);
			remaintimesnew=l.getremaintime(teatestlistnew, xuehao);			
			teachernamecon=l.getteachername(teatestlistcon);
			teachernamenew=l.getteachername(teatestlistnew);
			session.setAttribute("teatestlistcon", teatestlistcon);
			session.setAttribute("teatestlistnew", teatestlistnew);
			session.setAttribute("remaintimescon", remaintimescon);
			session.setAttribute("remaintimesnew", remaintimesnew);
			session.setAttribute("teachernamecon", teachernamecon);
			session.setAttribute("teachernamenew", teachernamenew);
		}		
		
		response.sendRedirect("LookLimit.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
