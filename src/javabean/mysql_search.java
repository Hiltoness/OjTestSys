package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql_search {
	private PreparedStatement pstm;     	 
	private Connection conn;
	
	//搜索填空题相关记录
	//搜索的那个字段是int类型
	public int  blank_getInt(int ziduan,int id) {
		int result=0;	
		ResultSet rs = null;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_blank where blankid =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()){
					result=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return result;
	}
	//搜索的那个字段是String类型
	public String  blank_getString(String ziduan,int id) {
		String result="";	
		ResultSet rs = null;	
		try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_blank where blankid =?");
					pstm.setInt(1, id);
					rs=pstm.executeQuery();
					while(rs.next()){
						result=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		return result;
	}
	
	//搜索判断题相关记录
	//搜索的那个字段是int类型
	public int  judgement_getInt(int ziduan,int id) {
		int result=0;
		ResultSet rs = null;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_judgement where judgementid =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()){
					result=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return result;
	}
	//搜索的那个字段是String类型
	public String  judgement_getString(String ziduan,int id) {
		String result="";	
		ResultSet rs = null;	
		try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_judgement where judgementid =?");
					pstm.setInt(1, id);
					rs=pstm.executeQuery();
					while(rs.next()){
						result=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		return result;
	}
	
	//搜索多选题相关记录
	//搜索的那个字段是int类型
	public int  multi_getInt(int ziduan,int id) {
		int result=0;
		ResultSet rs = null;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_multi where multiid =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()){
					result=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return result;
	}
	//搜索的那个字段是String类型
	public String  multi_getString(String ziduan,int id) {
		String result="";	
		ResultSet rs = null;	
		try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_multi where multiid =?");
					pstm.setInt(1, id);
					rs=pstm.executeQuery();
					while(rs.next()){
						result=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		return result;
	}
	
	//搜索单选题相关记录
	//搜索的那个字段是int类型
	public int  single_getInt(int ziduan,int id) {
		int result=0;
		ResultSet rs = null;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_single where singleid =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()){
					result=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return result;
	}
	//搜索的那个字段是String类型
	public String  single_getString(String ziduan,int id) {
		String result="";	
		ResultSet rs = null;
		try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_single where singleid =?");
					pstm.setInt(1, id);
					rs=pstm.executeQuery();
					while(rs.next()){
						result=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		return result;
	}
	
	//搜索老师答卷表
	//搜索的那个字段是int类型
	public int  teatest_getInt(int ziduan,int id) {
		int result=0;
		ResultSet rs = null;
		try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from TeaTest where tpid =?");
					pstm.setInt(1, id);
					rs=pstm.executeQuery();
					while(rs.next()){
						result=rs.getInt(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		return result;
		}
	//搜索的那个字段是String类型
	public String  teatest_getString(String ziduan,int id) {
		String result="";	
		ResultSet rs = null;	
		try {
					 mysql_DB db=new mysql_DB();
						conn=db.connectDB();
						pstm=conn.prepareStatement("select"+ziduan+"from TeaTest where tpid =?");
						pstm.setInt(1, id);
						rs=pstm.executeQuery();
						while(rs.next()){
							result=rs.getString(1);
						}
						db.close(conn);
					}catch(SQLException ex){
					ex.printStackTrace();
					}
		return result;
		}
	
	//搜索学生答卷表
	//搜索的那个字段是int类型
		public int  stutest_getInt(int ziduan,int id) {
			int result=0;
			ResultSet rs = null;
			try {
					 mysql_DB db=new mysql_DB();
						conn=db.connectDB();
						pstm=conn.prepareStatement("select"+ziduan+"from StuTest where pid =?");
						pstm.setInt(1, id);
						rs=pstm.executeQuery();
						while(rs.next()){
							result=rs.getInt(1);
						}
						db.close(conn);
					}catch(SQLException ex){
					ex.printStackTrace();
					}
			return result;
			}
		//搜索的那个字段是String类型
		public String  stutest_getString(String ziduan,int id) {
			String result="";	
			ResultSet rs = null;	
			try {
						 mysql_DB db=new mysql_DB();
							conn=db.connectDB();
							pstm=conn.prepareStatement("select"+ziduan+"from StuTest where pid =?");
							pstm.setInt(1, id);
							rs=pstm.executeQuery();
							while(rs.next()){
								result=rs.getString(1);
							}
							db.close(conn);
						}catch(SQLException ex){
						ex.printStackTrace();
						}
			return result;
			}
		
		//搜索答卷详情表
		//搜索的那个字段是int类型
		public int  testinf_getInt(int ziduan,int id,int id2) {
			int result=0;
			ResultSet rs = null;
			try {
							 mysql_DB db=new mysql_DB();
								conn=db.connectDB();
								pstm=conn.prepareStatement("select"+ziduan+"from TestInf where pid =? and where no=?");
								pstm.setInt(1, id);
								pstm.setInt(2, id2);
								rs=pstm.executeQuery();
								while(rs.next()){
									result=rs.getInt(1);
								}
								db.close(conn);
							}catch(SQLException ex){
							ex.printStackTrace();
							}
			return result;
			}
		//搜索的那个字段是String类型
		public String  testinf_getString(String ziduan,int id,int id2) {
			String result="";	
			ResultSet rs = null;	
			try {
								 mysql_DB db=new mysql_DB();
									conn=db.connectDB();
									pstm=conn.prepareStatement("select"+ziduan+"from TestInf where pid =? and where no=?");
									pstm.setInt(1, id);
									pstm.setInt(2, id2);
									rs=pstm.executeQuery();
									while(rs.next()){
										result=rs.getString(1);
									}
									db.close(conn);
								}catch(SQLException ex){
								ex.printStackTrace();
								}
			return result;
			}
		
		//搜索答卷题目表
		//搜索的那个字段是int类型
		public int  testsub_getInt(int ziduan,int id,int id2,int id3) {
			int result=0;
			ResultSet rs = null;
			try {
					 mysql_DB db=new mysql_DB();
						conn=db.connectDB();
						pstm=conn.prepareStatement("select"+ziduan+"from TestSub where pid =? and where type =? and where tno =?");
						pstm.setInt(1, id);
						pstm.setInt(2, id2);
						pstm.setInt(3, id3);
						rs=pstm.executeQuery();
						while(rs.next()){
							result=rs.getInt(1);
						}
						db.close(conn);
					}catch(SQLException ex){
					ex.printStackTrace();
					}
			return result;
			}
		//搜索的那个字段是String类型
		public String  testsub_getString(String ziduan,int id,int id2,int id3) {
			String result="";	
			ResultSet rs = null;	
			try {
						 mysql_DB db=new mysql_DB();
							conn=db.connectDB();
							pstm=conn.prepareStatement("select"+ziduan+"from TestSub where pid =? and where type =? and where tno =?");
							pstm.setInt(1, id);
							pstm.setInt(2, id2);
							pstm.setInt(3, id3);
							rs=pstm.executeQuery();
							while(rs.next()){
								result=rs.getString(1);
							}
							db.close(conn);
						}catch(SQLException ex){
						ex.printStackTrace();
						}
			return result;
			}
}
