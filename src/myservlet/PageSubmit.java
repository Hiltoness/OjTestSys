package myservlet;

import javabean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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
 * Servlet implementation class PageSubmit
 * 试卷提交-数据库获取答案-判断对错-计算分数-存入数据库
 */
@WebServlet("/PageSubmit")
public class PageSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageSubmit() {
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
		mysql_checkWrong checkW=new mysql_checkWrong();
		mysql_insert insert=new mysql_insert();
		mysql_checkAppear appear=new mysql_checkAppear();
		mysql_operate update=new mysql_operate();
		mysql_update_goal sum=new mysql_update_goal();
		mysql_search_canshu search=new mysql_search_canshu();
		Map<String,String> typeS=new HashMap<String,String>(){
			{put("single","kaoshi_single");
			put("multi","kaoshi_multi");
			put("judgement","kaoshi_judgement");
			put("blank","kaoshi_blank");}
		};
		Map<String,String> ansS=new HashMap<String,String>(){
			{put("single","sanswer");
			put("multi","manswer");
			put("judgement","janswer");
			put("blank","banswer");}
		};
		Map<String,String> marS=new HashMap<String,String>(){
			{put("single","smark");
			put("multi","mmark");
			put("judgement","jmark");
			put("blank","bmark");}
		};
		boolean flag;//暂存标记
		boolean disappear = false;//是否再出现
		int apptime = 0;//出现次数
		int righttime = 0;//做对次数
		response.setContentType("application/json; charset=utf-8");
		String xuehao=request.getParameter("xuehao");//学号
		String s_flag=request.getParameter("s_flag");//提交标记
		System.out.print("提交标记"+s_flag);
		int pid=Integer.parseInt(request.getParameter("pid"));//试卷id
		
		session.setAttribute("xuehao", xuehao);
		
		long start1=System.currentTimeMillis();
//		System.out.print("时间1"+start1);
//		System.out.print("时间" +Timestamp.valueOf(start1));
		Timestamp start=new Timestamp(start1);//当前时间
		//用map来接收request发送过来的多维数组
        String list=request.getParameter("anslist");
        System.out.print("ser接收到的："+list);
        ArrayList<Tlist> tlist=new ArrayList<Tlist> ();
        JSONArray jsonA;
		try {
			jsonA = new JSONArray(list);
			for(int i=0;i<jsonA.length();i++){
				Tlist eachT=new Tlist();
				JSONObject jsonO=jsonA.getJSONObject(i);
				int tno=Integer.parseInt(jsonO.get("tno").toString());//题号
				int tid=Integer.parseInt(jsonO.get("id").toString());//题目id
				String type=jsonO.get("type").toString();//题目类型
			    String typeDB=typeS.get(type);//对应表名
			    String ansDB=ansS.get(type);
			    String marDB=marS.get(type);
				String value=jsonO.get("value").toString();//题目作答结果
				List<TestInf> s=update.verify_get(pid, tid);//验证该题是否有暂存testInf
				int a=appear.checksave(pid, tid, tno);//验证该题是否为之前出现过
				if(a>0){//之前出现过
					flag=true;
					apptime=search.getTimes("atime", pid, tid, type);
					righttime=search.getTimes("rtime", pid, tid, type); 
				}else{//新题
					flag=false;
				}
				apptime++;
				//获取题目答案
				String solution=search.getAnswer(typeDB,type+"id", ansDB, tid);
				//获取该题分数
				int mark=search.getMark(typeDB,type+"id", marDB, tid);
				System.out.print("结果" +value+" 答案"+solution);
				if(solution.equals(value)){//正确
					righttime++;
					disappear=true;
				}else{//错误
					mark=0;
					if(righttime>0)
						righttime--;
					float wr=(apptime-righttime)/apptime;
					if(wr>0.5 && apptime>3){//错误率>50%，不再出现
						disappear=true;
						//插入所有错题表
						if(!checkW.check(tid, type))
							insert.cuoti_insert(xuehao, type, tid, start);
					}
						
				}
				System.out.print("得分" +mark+" 答案"+solution);
				if(s.size()>0){
					update.testsub_update(apptime, righttime, pid, type, tid);
					update.testinf_update(value, mark, pid, tno);
				}else{
					System.out.println(pid+" "+type+" "+tid+" "+apptime+" "+righttime+" "+value+" "+mark);
					insert.dajuantm_insert(pid, type, tid,apptime, righttime);
					insert.dajuanxq_insert(pid, type, tid, value, mark);
				}
				
				if(disappear){
					eachT.setId(tid);
					eachT.setType(type);
					tlist.add(eachT);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		session.setAttribute("tlist", tlist);
		System.out.print(s_flag.equals("1"));
		if(s_flag.equals("1")){//提交
			System.out.print(" 开始提交");
			//计算总分
			sum.goal_update(pid);
			//获取完成时间
			long end=System.currentTimeMillis();//结束时间
			Timestamp end1=new Timestamp(end);
			update.endtime_update(end1, pid);//更新结束时间
			System.out.print("提交成，返回");
			response.sendRedirect("LookLimit.jsp");//返回完成页面
		}else{
			System.out.print(" 没有提交");
			//跳转出题servlet
			//返回数据到ajax中
			 
			PrintWriter out=response.getWriter();
			out.println(tlist);  
		}
		  
	}

}
