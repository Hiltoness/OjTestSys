package myservlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javabean.mysql_insert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BeginTest
 */
@WebServlet("/BeginTest")
public class BeginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		mysql_insert insert=new mysql_insert();
		response.setContentType("application/json; charset=utf-8");
		//获取参数
		String xuehao=session.getAttribute("xuehao").toString();
		String kcbianhao=session.getAttribute("kcbianhao").toString();
		String gonghao=session.getAttribute("gonghao").toString();
		String flag=session.getAttribute("flag").toString();//暂存标记 true-暂存，false-新卷
		String model=session.getAttribute("LLLpattern").toString();//模式标记-limit-限时
		System.out.print("model:"+model);
		int tno=Integer.parseInt(session.getAttribute("tno").toString());//题号
		
		int tpid=Integer.parseInt(session.getAttribute("tpid").toString());//试卷号
		String tp=Integer.toString(tpid);
		String tarUrl = null;//目标链接
		String start;
		session.setAttribute("flag", flag);
		session.setAttribute("kcbianhao", kcbianhao);
		session.setAttribute("gonghao", gonghao);
		session.setAttribute("tpid", tp);//试卷号
		if(flag.equals("true")){//暂存
			int pid=Integer.parseInt(session.getAttribute("pid").toString());//学生答卷号
			start=session.getAttribute("start").toString();//开始时间
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date;
			try {
				date = sdf.parse(start);
				long ts=date.getTime();
				session.setAttribute("start",ts);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Timestamp sss=Timestamp.valueOf(start);
//			try {
//				Timestamp aaa=new Timestamp(sdf.parse(start).getTime()/1000);
//				System.out.print(aaa);
//				session.setAttribute("start", aaa);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			String p=Integer.toString(pid);
			session.setAttribute("pid", p);
			session.setAttribute("tno", tno);
			if(model.equals("limit")){//限时
				System.out.print("有限");
				tarUrl="LimitTest.jsp";
			}else{//无限
				System.out.print("无限");
				tarUrl="LimitlessTest.jsp";
			}
			
		}else{//新卷
			int times=Integer.parseInt(session.getAttribute("times").toString());//现在的次数,要+1
			
			tno=0;
			long start2 = System.currentTimeMillis();//开始时间
			Timestamp start1=new Timestamp(start2);
			int pid=insert.studajuan_insert(xuehao, tpid, -1, start1, null, times+1);//返回答卷id
			
			session.setAttribute("start", start2);
			session.setAttribute("pid", pid);//答卷号
			session.setAttribute("tno", tno);
			if(model.equals("limit")){//限时
				System.out.print("有限");
				tarUrl="LimitTest.jsp";
			}else{//无限
				System.out.print("无限");
				tarUrl="LimitlessTest.jsp";
			}
		}
		response.sendRedirect(tarUrl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
