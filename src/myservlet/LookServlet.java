package myservlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.LorLL;
import javabean.mysql_insert;

@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=request.getSession(true);
		String conornew=request.getParameter("conornew");		 //继续答卷或开始答卷
		String xuehao=request.getParameter("xuehao");
		String gonghao=request.getParameter("gonghao");
		String kcbianhao=request.getParameter("kcbianhao");
		String LLLpattern=request.getParameter("LLLpattern");	//限制或不限制	
		String flag;      //暂存标记
		int times=Integer.parseInt(request.getParameter("times"));   //第几次,在创建新的学生答卷的话要记得加1
		session.setAttribute("xuehao", xuehao);	
		session.setAttribute("gonghao", gonghao);	
		session.setAttribute("kcbianhao", kcbianhao);	
		session.setAttribute("LLLpattern", LLLpattern);              //限时和不限时 limit limitless
			if(conornew.equals("con")) {                              //继续答卷
				//老师答卷表
				int pid=Integer.parseInt(request.getParameter("pid"));
				int tpid=Integer.parseInt(request.getParameter("tpid"));
				int pages=1;                                               //继续答卷传pages为1
				LorLL l=new LorLL();
				int tno=l.getsearchtno(pid);
				flag="true";
				String start=request.getParameter("start");              //开始时间
				session.setAttribute("tpid", tpid);
				session.setAttribute("pid",pid);
				session.setAttribute("pages",pages);
				session.setAttribute("tno",tno);
				session.setAttribute("flag",flag);
				session.setAttribute("start", start);				
			}else {                                                                       //开始新的答卷
				int pages=0;
				int tno=0;
				int tpid=Integer.parseInt(request.getParameter("tpid"));
				flag="false";
				session.setAttribute("times", times);	
				session.setAttribute("tpid", tpid);	
				session.setAttribute("pages", pages);
				session.setAttribute("tno", tno);
				session.setAttribute("flag",flag);							
		}
			response.sendRedirect("BeginTest.jsp");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
