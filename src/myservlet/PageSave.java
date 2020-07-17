package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class PageSave
 * 试卷保存-保存当页作答结果-有value的题目分数为-1，总分也为-1
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
