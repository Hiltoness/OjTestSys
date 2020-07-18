package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_operate_ht {
	private PreparedStatement pstm;     	
	private Connection conn;
	private ResultSet rs;
	
	//搜索老师答卷表，返回答卷名称
	   public String selectName(int tpid) {
		   String result="";
		   try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select name from TeaTest where tpid =?");	
					pstm.setInt(1, tpid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						result=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		   return result;
	   }
	   
	   //搜索答卷题目表
	   public ArrayList<TestSub> testsub_getData(int pid,String type,int tno) {
			ArrayList<TestSub> testsublist=new ArrayList<TestSub> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from TestSub where pid =? and type =? and tno =?");	
					pstm.setInt(1, pid);
					pstm.setString(2, type);
					pstm.setInt(3, tno);
					rs=pstm.executeQuery();
					while(rs.next()) {
						TestSub bean=new TestSub();
						bean.setPid(rs.getInt(1));
						bean.setType(rs.getString(2));
						bean.setTno(rs.getInt(3));
						bean.setAtimes(rs.getInt(4));
						bean.setRtimes(rs.getInt(5));
						testsublist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return testsublist;
		 }
	   
	   //更新答卷题目表的两个次数
	   public  void testsub_update(int atimes,int rtimes,int pid,String type,int tno) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update TestSub set atimes =? and rtimes =? where pid =? and type =? and tno =?");					
					pstm.setInt(1, atimes);
					pstm.setInt(2, rtimes);
					pstm.setInt(3, pid);
					pstm.setString(4, type);
					pstm.setInt(5, tno);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	   
	   //更新答卷详情表答案和得分
	   public  void testinf_update(String answer,int goal,int pid,int no) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update TestInf set answer =? and goal =? where pid =? and no =?");					
					pstm.setString(1, answer);
					pstm.setInt(2, goal);
					pstm.setInt(3, pid);
					pstm.setInt(4, no);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	}
	

