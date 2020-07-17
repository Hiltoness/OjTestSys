package myservlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setContentType("application/json; charset=utf-8");
		//用map来接收request发送过来的多维数组
        String list=request.getParameter("list");
        System.out.print(list);
        JSONArray jsonA;
		try {
			jsonA = new JSONArray(list);
			for(int i=0;i<jsonA.length();i++){
				JSONObject jsonO=jsonA.getJSONObject(i);
				System.out.println(jsonO.get("id"));//题目id
				System.out.println(jsonO.get("type"));//题目类型
				System.out.println(jsonO.get("value"));//题目作答结果
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
   
            
	}

}
