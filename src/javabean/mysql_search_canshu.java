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
					pstm=conn.prepareStatement("select * from select where "+whereat+" =?");	
					pstm.setString(1, wherevalue);
					rs=pstm.executeQuery();
					while(rs.next()) {
						select bean=new select();
						bean.setXuehao(rs.getString(1));
						bean.setKcbianhao(rs.getString(2));
						bean.setGonghao(rs.getString(2));
						selectlist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return selectlist;
		 }
}
