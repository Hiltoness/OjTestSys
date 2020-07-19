package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javabean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class CreatePage
 */
@WebServlet("/CreatePage")
public class CreatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePage() {
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
		mysql_insert insert=new mysql_insert();
		mysql_search_canshu getCon=new mysql_search_canshu();
		response.setContentType("application/json; charset=utf-8");
		String xuehao=request.getParameter("xuehao");
		int pid=Integer.parseInt(request.getParameter("pid"));
		
		ArrayList<TestInf> testlist=new ArrayList<TestInf> ();
		ArrayList<Topic_Answer> anslist=new ArrayList<Topic_Answer> ();
		
		testlist=getCon.test_getData(pid);
		for(TestInf i:testlist){
			Topic_Answer each=new Topic_Answer();
			String type=i.getType();
			String answer=i.getAnswer();
			int tid=i.getTno();
			each.setValue(answer);//作答结果
			switch(type){
			case "blank":
		 		  List<kaoshi_blank> blank=getCon.blank_getData("blankid", tid);
		 		  each.setId(tid);
		 		  each.setType("blank");
				  each.setTitle("");
				  each.setSelect_A(blank.get(0).getBfronttitle());
				  each.setSelect_B(blank.get(0).getBbacktitle());
				  each.setSelect_C("");
				  each.setSelect_D("");
				  each.setAnswer(blank.get(0).getBanswer());
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
					each.setAnswer(sin.get(0).getSanswer());
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
					each.setAnswer(mul.get(0).getManswer());
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
					each.setAnswer(jud.get(0).getJanswer());
		 		 break;
			}
			anslist.add(each);
			}
			
			JSONArray js=new JSONArray();
			for(final Topic_Answer j:anslist){
				Map<String,String> ans=new HashMap<String,String>(){
					{put("id",Integer.toString(j.getId()));
					put("type",j.getType());
					put("title",j.getTitle());
					put("a",j.getSelect_A());
					put("b",j.getSelect_B());
					put("c",j.getSelect_C());
					put("d",j.getSelect_D());
					put("value",j.getValue());
					put("answer",j.getAnswer());	
					}
				};
			}
		
		PrintWriter out=response.getWriter();
		out.println(js);
		out.close();
	}

}
