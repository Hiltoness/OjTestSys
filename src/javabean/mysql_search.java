package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_search {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	//搜索填空题相关记录
	public ArrayList<kaoshi_blank> blank_getData() {
		ArrayList<kaoshi_blank> blanklist=new ArrayList<kaoshi_blank> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from kaoshi_blank ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					kaoshi_blank bean=new kaoshi_blank();
					bean.setBlankid(rs.getInt(1));
					bean.setBfronttitle(rs.getString(2));
					bean.setBbacktitle(rs.getString(3));
					bean.setBanswer(rs.getString(4));
					bean.setBmark(rs.getInt(5));
					bean.setKcbianhao(rs.getString(6));
					bean.setGonghao(rs.getString(7));
					blanklist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return blanklist;
	}
	
	//搜索判断题相关记录
	public ArrayList<kaoshi_judgement> judgement_getData() {
		ArrayList<kaoshi_judgement> judgementlist=new ArrayList<kaoshi_judgement> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from kaoshi_blank ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					kaoshi_judgement bean=new kaoshi_judgement();
					bean.setJudgementid(rs.getInt(1));
					bean.setJtitle(rs.getString(2));
					bean.setJanswer(rs.getString(3));
					bean.setJmark(rs.getInt(4));
					bean.setKcbianhao(rs.getString(5));
					bean.setGonghao(rs.getString(6));
					judgementlist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return judgementlist;
	}
	
	//搜索多选题相关记录
	public ArrayList<kaoshi_multi> multi_getData() {
		ArrayList<kaoshi_multi> multilist=new ArrayList<kaoshi_multi> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from kaoshi_multi ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					kaoshi_multi bean=new kaoshi_multi();
					bean.setMultiid(rs.getInt(1));
					bean.setMsubject(rs.getString(2));
					bean.setMoptionA(rs.getString(3));
					bean.setMoptionB(rs.getString(4));
					bean.setMoptionC(rs.getString(5));
					bean.setMoptionD(rs.getString(6));
					bean.setManswer(rs.getString(7));
					bean.setMmark(rs.getInt(4));
					bean.setKcbianhao(rs.getString(5));
					bean.setGonghao(rs.getString(6));
					multilist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return multilist;
	}
	
	//搜索单选题相关记录
	public ArrayList<kaoshi_single> single_getData() {
		ArrayList<kaoshi_single> singlelist=new ArrayList<kaoshi_single> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from kaoshi_single ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					kaoshi_single bean=new kaoshi_single();
					bean.setSingleid(rs.getInt(1));
					bean.setSsubject(rs.getString(2));
					bean.setSoptionA(rs.getString(3));
					bean.setSoptionB(rs.getString(4));
					bean.setSoptionC(rs.getString(5));
					bean.setSoptionD(rs.getString(6));
					bean.setSanswer(rs.getString(7));
					bean.setSmark(rs.getInt(4));
					bean.setKcbianhao(rs.getString(5));
					bean.setGonghao(rs.getString(6));
					singlelist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return singlelist;
	}
	
	//搜索老师答卷表
	public ArrayList<TeaTest> teatest_getData() {
		ArrayList<TeaTest> teatestlist=new ArrayList<TeaTest> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from TeaTest ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					TeaTest bean=new TeaTest();
					bean.setTpid(rs.getInt(1));
					bean.setKcbianhao(rs.getString(2));
					bean.setGonghao(rs.getString(3));
					bean.setStart(rs.getTimestamp(4));
					bean.setEnd(rs.getTimestamp(5));
					bean.setName(rs.getString(6));
					bean.setTimes(rs.getInt(6));
					bean.setTtype(rs.getString(7));
					teatestlist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return teatestlist;
	}
	
	//搜索学生答卷表
	public ArrayList<StuTest> stutest_getData() {
		ArrayList<StuTest> stutestlist=new ArrayList<StuTest> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from StuTest ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					StuTest bean=new StuTest();
					bean.setPid(rs.getInt(1));
					bean.setXuehao(rs.getString(2));
					bean.setTpid(rs.getInt(3));
					bean.setGoal(rs.getInt(4));
					bean.setStart(rs.getTimestamp(5));
					bean.setTimes(rs.getInt(6));
				
					stutestlist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return stutestlist;
	}
		
	//搜索答卷详情表
	public ArrayList<TestInf> testinf_getData() {
		ArrayList<TestInf> testinflist=new ArrayList<TestInf> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from TestInf ");			
				rs=pstm.executeQuery();
				while(rs.next()) {
					TestInf bean=new TestInf();
					bean.setPid(rs.getInt(1));
					bean.setNo(rs.getInt(2));
					bean.setType(rs.getString(3));
					bean.setTno(rs.getInt(4));
					bean.setAnswer(rs.getString(5));
					bean.setGoal(rs.getInt(6));
				
					testinflist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return testinflist;
	}
		
	//搜索答卷题目表
		public ArrayList<TestSub> testsub_getData() {
			ArrayList<TestSub> testsublist=new ArrayList<TestSub> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from TestSub ");			
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
}
