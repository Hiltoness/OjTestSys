package myservlet;

import java.util.*;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class GetTopic
 */
@WebServlet("/GetTopic")
public class GetTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTopic() {
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
		HttpSession session=request.getSession();
		//获取题目list
		String kcbianhao=request.getParameter("kcbianhao");
		String gonghao=request.getParameter("gonghao");
		String alist=request.getParameter("tlist");//已出题目列表
		ArrayList<Tlist> tlist=new ArrayList<Tlist> ();
		JSONArray jsonA=new JSONArray();
		try{
			jsonA = new JSONArray(alist);
			for(int j=0;j<jsonA.length();j++){
				Tlist eachT=new Tlist();
				JSONObject jsonO=jsonA.getJSONObject(j);
				int tid=(int)jsonO.get("id");//题目id
				String type=(String)jsonO.get("type");
				eachT.setId(tid);
				eachT.setType(type);
				tlist.add(eachT);
		}
			}catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String tplist;
		List<id_type> topiclist=topic.sub_getData(kcbianhao, gonghao, tlist);
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
				put("value","");
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
