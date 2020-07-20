package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_search_canshu {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	//搜索填空题相关记录
	//int类型
		public ArrayList<kaoshi_blank> blank_getData(String whereat,int wherevalue) {
			ArrayList<kaoshi_blank> blanklist=new ArrayList<kaoshi_blank> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_blank where "+whereat+" =?");
					pstm.setInt(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_blank bean=new kaoshi_blank();
						bean.setBlankid(rs.getInt(1));
						bean.setBfronttitle(rs.getString(3));
						bean.setBbacktitle(rs.getString(4));
						bean.setBanswer(rs.getString(5));
						bean.setBmark(rs.getInt(6));
						bean.setKcbianhao(rs.getString(7));
						bean.setGonghao(rs.getString(8));
						blanklist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return blanklist;
		}
	//String类型
		public ArrayList<kaoshi_blank> blank_getData(String whereat,String wherevalue) {
			ArrayList<kaoshi_blank> blanklist=new ArrayList<kaoshi_blank> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_blank where "+whereat+" =?");
					pstm.setString(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_blank bean=new kaoshi_blank();
						bean.setBlankid(rs.getInt(1));
						bean.setBfronttitle(rs.getString(3));
						bean.setBbacktitle(rs.getString(4));
						bean.setBanswer(rs.getString(5));
						bean.setBmark(rs.getInt(6));
						bean.setKcbianhao(rs.getString(7));
						bean.setGonghao(rs.getString(8));
						blanklist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return blanklist;
		}
		
		//搜索判断题相关记录
		public ArrayList<kaoshi_judgement> judgement_getData(String whereat,int wherevalue) {
			ArrayList<kaoshi_judgement> judgementlist=new ArrayList<kaoshi_judgement> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_judgement where "+whereat+" =?");			
					pstm.setInt(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_judgement bean=new kaoshi_judgement();
						bean.setJudgementid(rs.getInt(1));
						bean.setJtitle(rs.getString(3));
						bean.setJanswer(rs.getString(4));
						bean.setJmark(rs.getInt(5));
						bean.setKcbianhao(rs.getString(6));
						bean.setGonghao(rs.getString(7));
						judgementlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return judgementlist;
		}
		public ArrayList<kaoshi_judgement> judgement_getData(String whereat,String wherevalue) {
			ArrayList<kaoshi_judgement> judgementlist=new ArrayList<kaoshi_judgement> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_judgement where "+whereat+" =?");			
					pstm.setString(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_judgement bean=new kaoshi_judgement();
						bean.setJudgementid(rs.getInt(1));
						bean.setJtitle(rs.getString(3));
						bean.setJanswer(rs.getString(4));
						bean.setJmark(rs.getInt(5));
						bean.setKcbianhao(rs.getString(6));
						bean.setGonghao(rs.getString(7));
						judgementlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return judgementlist;
		}
		
		//搜索多选题相关记录
		public ArrayList<kaoshi_multi> multi_getData(String whereat,int wherevalue) {
			ArrayList<kaoshi_multi> multilist=new ArrayList<kaoshi_multi> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_multi where "+whereat+" =?");			
					pstm.setInt(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_multi bean=new kaoshi_multi();
						bean.setMultiid(rs.getInt(1));
						bean.setMsubject(rs.getString(3));
						bean.setMoptionA(rs.getString(4));
						bean.setMoptionB(rs.getString(5));
						bean.setMoptionC(rs.getString(6));
						bean.setMoptionD(rs.getString(7));
						bean.setManswer(rs.getString(8));
						bean.setMmark(rs.getInt(9));
						bean.setKcbianhao(rs.getString(10));
						bean.setGonghao(rs.getString(11));
						multilist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return multilist;
		}
		public ArrayList<kaoshi_multi> multi_getData(String whereat,String wherevalue) {
			ArrayList<kaoshi_multi> multilist=new ArrayList<kaoshi_multi> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_multi where "+whereat+" =?");			
					pstm.setString(1,wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_multi bean=new kaoshi_multi();
						bean.setMultiid(rs.getInt(1));
						bean.setMsubject(rs.getString(3));
						bean.setMoptionA(rs.getString(4));
						bean.setMoptionB(rs.getString(5));
						bean.setMoptionC(rs.getString(6));
						bean.setMoptionD(rs.getString(7));
						bean.setManswer(rs.getString(8));
						bean.setMmark(rs.getInt(9));
						bean.setKcbianhao(rs.getString(10));
						bean.setGonghao(rs.getString(11));
						multilist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return multilist;
		}
		
		//搜索单选题相关记录
		public ArrayList<kaoshi_single> single_getData(String whereat,int wherevalue) {
			ArrayList<kaoshi_single> singlelist=new ArrayList<kaoshi_single> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_single where "+whereat+" =?");			
					pstm.setInt(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_single bean=new kaoshi_single();
						bean.setSingleid(rs.getInt(1));
						bean.setSsubject(rs.getString(3));
						bean.setSoptionA(rs.getString(4));
						bean.setSoptionB(rs.getString(5));
						bean.setSoptionC(rs.getString(6));
						bean.setSoptionD(rs.getString(7));
						bean.setSanswer(rs.getString(8));
						bean.setSmark(rs.getInt(9));
						bean.setKcbianhao(rs.getString(10));
						bean.setGonghao(rs.getString(11));
						singlelist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return singlelist;
		}
		public ArrayList<kaoshi_single> single_getData(String whereat,String wherevalue) {
			ArrayList<kaoshi_single> singlelist=new ArrayList<kaoshi_single> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kaoshi_single where "+whereat+" =?");			
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kaoshi_single bean=new kaoshi_single();
						bean.setSingleid(rs.getInt(1));
						bean.setSsubject(rs.getString(3));
						bean.setSoptionA(rs.getString(4));
						bean.setSoptionB(rs.getString(5));
						bean.setSoptionC(rs.getString(6));
						bean.setSoptionD(rs.getString(7));
						bean.setSanswer(rs.getString(8));
						bean.setSmark(rs.getInt(9));
						bean.setKcbianhao(rs.getString(10));
						bean.setGonghao(rs.getString(11));
						singlelist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return singlelist;
		}
		
		//搜索所有错题表
	    public ArrayList<AllSub> cuoti_getData(String whereat,int wherevalue) {
			ArrayList<AllSub> cuotilist=new ArrayList<AllSub> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from AllSub where "+whereat+" =?");	
					pstm.setInt(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						AllSub bean=new AllSub();
						bean.setXuehao(rs.getString(1));
						bean.setType(rs.getString(2));
						bean.setTno(rs.getInt(3));
						bean.setStart(rs.getTimestamp(4));
						cuotilist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return cuotilist;
		 }
	    public ArrayList<AllSub> cuoti_getData(String whereat,String wherevalue) {
			ArrayList<AllSub> cuotilist=new ArrayList<AllSub> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from AllSub where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						AllSub bean=new AllSub();
						bean.setXuehao(rs.getString(1));
						bean.setType(rs.getString(2));
						bean.setTno(rs.getInt(3));
						bean.setStart(rs.getTimestamp(4));
						cuotilist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return cuotilist;
		 }
	    
	    //按pid搜索答卷详情表
	    public ArrayList<TestInf> test_getData(int pid) {
			ArrayList<TestInf> testlist=new ArrayList<TestInf> ();
			 try {
				 	mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from TestInf where pid=?");	
					pstm.setInt(1, pid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						TestInf bean=new TestInf();
						bean.setNo(rs.getInt(2));
						bean.setType(rs.getString(3));
						bean.setTno(rs.getInt(4));
						bean.setAnswer(rs.getString(5));
						testlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return testlist;
		 }
	    
	    
	    //搜索用户表
	    public ArrayList<student> student_getData(String whereat,String wherevalue) {
			ArrayList<student> studentlist=new ArrayList<student> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from student where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						student bean=new student();
						bean.setXuehao(rs.getString(1));
						bean.setXname(rs.getString(2));
						studentlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return studentlist;
		 }
	    
	    //搜索老师表
	    public ArrayList<teacher> teacher_getData(String whereat,String wherevalue) {
			ArrayList<teacher> teacherlist=new ArrayList<teacher> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from teacher where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						teacher bean=new teacher();
						bean.setGonghao(rs.getString(1));
						bean.setGname(rs.getString(2));
						teacherlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return teacherlist;
		 }
	    
	    //搜索课程表
	    public ArrayList<kc> kc_getData(String whereat,String wherevalue) {
			ArrayList<kc> kclist=new ArrayList<kc> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from kc where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						kc bean=new kc();
						bean.setKcbianhao(rs.getString(1));
						bean.setKcname(rs.getString(2));
						kclist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return kclist;
		 }
	  
	    //搜索选课表
	    public ArrayList<select> select_getData(String whereat,String wherevalue) {
			ArrayList<select> selectlist=new ArrayList<select> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from selectkc where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						select bean=new select();
						bean.setXuehao(rs.getString(1));
						bean.setKcbianhao(rs.getString(2));
						bean.setGonghao(rs.getString(3));
						selectlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return selectlist;
		 }
	    //次数
	    public int getTimes(String tar,int pid,int tid,String type){
	    	int times=0;
	    	try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select "+tar+" from TestSub where pid=? and type=? and tno= ?");	
					pstm.setInt(1, pid);
					pstm.setString(2, type);
					pstm.setInt(3, tid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						times=rs.getInt(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	    	return times;
	    }
	    //题目答案
	    public String getAnswer(String dbName,String idname,String ansName,int tid){
	    	String ans="";
	    	try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select "+ansName+" from "+dbName+" where "+idname+"= ?");	
					pstm.setInt(1, tid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						ans=rs.getString(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	    	return ans;
	    }
	    
	    //题目分值
	    public int getMark(String dbName,String idname,String marName,int tid){
	    	int ans=0;
	    	try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select "+marName+" from "+dbName+" where "+idname+" = ?");	
					pstm.setInt(1, tid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						ans=rs.getInt(1);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	    	return ans;
	    }
}
