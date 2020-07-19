package myservlet;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javabean.id_type;
import javabean.mysql_search_suiji;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

/**
 * Servlet implementation class ContinueTopic
 */
@WebServlet("/ContinueTopic")
public class ContinueTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContinueTopic() {
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
		mysql_search_suiji topic=new mysql_search_suiji();
		mysql_operate getT=new mysql_operate();
		mysql_search_canshu getCon=new mysql_search_canshu();
		HttpSession session=request.getSession();
		//获取题目list
		int pid=Integer.parseInt(request.getParameter("pid"));//试卷号
		String xuehao=request.getParameter("xuehao");//学号
		List<TestInf> telist=getT.continue_get(pid);//暂存的题目
		ArrayList<id_type> topiclist=new ArrayList<id_type> ();
		for(TestInf j:telist){//获取暂存题目的题目选项内容
			id_type each=new id_type();
			int tid;
			String c_type;
			tid=j.getTno();
			c_type=j.getType();
			each.setValue(j.getAnswer());
			switch (c_type){
		 	  case "blank":
		 		  List<kaoshi_blank> blank=getCon.blank_getData("blankid", tid);
		 		  each.setId(tid);
		 		  each.setType("blank");
				  each.setTitle("");
				  each.setSelect_A(blank.get(0).getBfronttitle());
				  each.setSelect_B(blank.get(0).getBbacktitle());
				  each.setSelect_C("");
				  each.setSelect_D("");
		 		  break;
		 	  case "single":
		 		 List<kaoshi_single> sin=getCon.single_getData("singleid", tid);
			 		each.setId(tid);
					each.setTitle(sin.get(0).getSsubject());
					each.setType("single");
					each.setSelect_A(sin.get(0).getSoptionA());
					each.setSelect_B(sin.get(0).getSoptionB());
					each.setSelect_C(sin.get(0).getSoptionC());
					each.setSelect_D(sin.get(0).getSoptionD());
		 		  break;
		 	  case "multi":
		 		 List<kaoshi_multi> mul=getCon.multi_getData("multiid", tid);
			 		each.setId(tid);
			 		each.setTitle(mul.get(0).getMsubject());
					each.setType("multi");
					each.setSelect_A(mul.get(0).getMoptionA());
					each.setSelect_B(mul.get(0).getMoptionB());
					each.setSelect_C(mul.get(0).getMoptionC());
					each.setSelect_D(mul.get(0).getMoptionD());
		 		  break;
		 	  case "judgement":
		 		 List<kaoshi_judgement> jud=getCon.judgement_getData("judgementid", tid);
			 		each.setId(tid);
					each.setTitle(jud.get(0).getJtitle());
					each.setType("judgement");
					each.setSelect_A("对");
					each.setSelect_B("错");
					each.setSelect_C("");
					each.setSelect_D(""); 
		 		 break;
			}
			topiclist.add(each);
		}
		
		JSONArray js=new JSONArray();
		for(final id_type i:topiclist){
			Map<String,String> tpl=new HashMap<String,String>(){
				{put("id",Integer.toString(i.getId()));
				put("type",i.getType());
				put("title",i.getTitle());
				put("a",i.getSelect_A());
				put("b",i.getSelect_B());
				put("c",i.getSelect_C());
				put("d",i.getSelect_D());
				put("value",i.getValue());
				}
			};
			js.put(tpl);
		}
		session.setAttribute("tlist", js);
		//返回数据到ajax中
		PrintWriter out=response.getWriter();
		out.println(js);
	}

}
