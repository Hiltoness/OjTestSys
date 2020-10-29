package myservlet;

import java.sql.Timestamp;
import java.util.*;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewTestTeacher
 */
@WebServlet("/NewTestTeacher")
public class NewTestTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTestTeacher() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		mysql_teacher operate_tea=new mysql_teacher();
		
		String operate_type=request.getParameter("op");//操作类型--insert/delete
		String gonghao=request.getParameter("gonghao");
		boolean insertFlag=false,deleteFlag=false;
		PrintWriter out=response.getWriter();
		if(operate_type.equals("insert")){
			System.out.print("添加servlet");
			String kcbianhao=request.getParameter("kcbianhao");
			String name=request.getParameter("name");
			String type=request.getParameter("type");//试卷类型--限时/不限时
			String begin=request.getParameter("begin");
			String begin1=begin.replace("T", " ").concat(":00");//开始时间
			String end=request.getParameter("end").replace("T", " ").concat(":00");//结束时间
			int times=Integer.parseInt(request.getParameter("times"));//可做次数
			
			//时间类型转换
			Timestamp begintime=Timestamp.valueOf(begin1);
			Timestamp endtime=Timestamp.valueOf(end);
			//添加成功返回成功
			insertFlag=operate_tea.insert_teatest(kcbianhao, name, gonghao, type, begin1, end, times);

			out.println(insertFlag);
		}else if(operate_type.equals("delete")){
			System.out.print("delete");
			int tpid=Integer.parseInt(request.getParameter("tpid"));//要删除的试卷编号
			//删除成功
			deleteFlag=operate_tea.delete_teatest(tpid);
			System.out.print("delete success");
			out.println(deleteFlag);
		}
		//response.sendRedirect("teacher.jsp?gonghao="+gonghao+"?insertFlag="+insertFlag+"?deleteFlag="+deleteFlag);//返回完成页面
		
	}

}
