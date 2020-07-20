package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class mysql_operate {
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
	   //搜索答卷详情表
	   public ArrayList<TestInf> continue_get(int pid){
		   ArrayList<TestInf> con_list=new ArrayList<TestInf> ();
		   try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from TestInf where pid =? and goal is null");	
					pstm.setInt(1, pid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						TestInf bean=new TestInf();
						bean.setPid(rs.getInt(1));
						bean.setNo(rs.getInt(2));
						bean.setType(rs.getString(3));
						bean.setTno(rs.getInt(4));
						bean.setAnswer(rs.getString(5));
						con_list.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		   return con_list;
	   }
	   
	   public ArrayList<TestInf> verify_get(int pid,int tid){
		   ArrayList<TestInf> con_list=new ArrayList<TestInf> ();
		   try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from TestInf where pid =? and tno=? and goal is null");	
					pstm.setInt(1, pid);
					pstm.setInt(2, tid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						TestInf bean=new TestInf();
						bean.setPid(rs.getInt(1));
						bean.setNo(rs.getInt(2));
						bean.setType(rs.getString(3));
						bean.setTno(rs.getInt(4));
						bean.setAnswer(rs.getString(5));
						con_list.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		   return con_list;
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
	   
	   public  void testinf_update1(String answer,int pid,int no) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update TestInf set answer =?  where pid =? and no =?");					
					pstm.setString(1, answer);
					pstm.setInt(2, pid);
					pstm.setInt(3, no);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	   
	   //更新结束时间
	   public void endtime_update(Timestamp end,int pid) {

			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("update StuTest set end =? where pid =?");
					pstm.setTimestamp(1, end);
					pstm.setInt(2, pid);
					pstm.executeUpdate();				
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	
	   
	   
	   
	}
	

