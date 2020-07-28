package myservlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javabean.TestInf;
import javabean.TestSub;
import javabean.mysql_insert;
import javabean.mysql_operate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class PageSave
 * 试卷保存-保存当页作答结果-有value的题目分数为null，总分也为-1
 */
@WebServlet("/PageSave")
public class PageSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSave() {
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
		HttpSession session = request.getSession();
		mysql_operate update=new mysql_operate();
		mysql_insert insert=new mysql_insert();
		Map<String,String> typeS=new HashMap<String,String>(){
			{put("single","kaoshi_single");
			put("multi","kaoshi_multi");
			put("judgement","kaoshi_judgement");
			put("blank","kaoshi_blank");}
		};
		boolean flag;//暂存标记
		int apptime;//出现次数
		response.setContentType("application/json; charset=utf-8");
		String xuehao=request.getParameter("xuehao");//学号
		int pid=Integer.parseInt(request.getParameter("pid"));//试卷id
//		int pages=Integer.parseInt(request.getParameter("pages"));
		//用map来接收request发送过来的多维数组
		System.out.print("暂存开始");
        String list=request.getParameter("anslist");
        System.out.print("暂存"+list);
        JSONArray jsonA;
		try {
			jsonA = new JSONArray(list);
			for(int i=0;i<jsonA.length();i++){
				JSONObject jsonO=jsonA.getJSONObject(i);
				System.out.print("isisisis: "+(String)jsonO.get("tno")+" ;;;"+jsonO.get("tno").toString().length());
				if(jsonO.get("tno").toString().length()==0)
					continue;
				int tno=Integer.parseInt( jsonO.get("tno").toString());//题号
				int tid=Integer.parseInt( jsonO.get("id").toString());//题目id
				String type=jsonO.get("type").toString();//题目类型
			    String typeDB=typeS.get(type);//对应表名
				String value=(String) jsonO.get("value");//题目作答结果
				List<TestInf> s=update.verify_get(pid, tid);//验证该题是否有暂存testInf
				
				
				if(s.size()>0){//暂存，update
					update.testsub_update(0, 0, pid, type, tid);
					update.testinf_update1(value, pid, tno);
				}else{//insert
					insert.dajuantm_insert(pid, type,tid, 0, 0);
					insert.dajuanxq_insert1(pid, type, tid, value);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
//		session.setAttribute("pages", pages);
	}
}
