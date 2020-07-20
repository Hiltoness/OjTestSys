package javabean;

import java.sql.*;

public class mysql_insert {
	private PreparedStatement pstm;     
	private Connection conn;
	//学生答卷表
	public int studajuan_insert(String xuehao,int tpid,int goal,Timestamp start,Timestamp end,int times) {
		int pid=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into StuTest values(0,?,?,?,?,?,?)");
				pstm.setString(1, xuehao);
				pstm.setInt(2, tpid);
				pstm.setInt(3,goal);
				pstm.setTimestamp(4,start);
				pstm.setTimestamp(5,end);
				pstm.setInt(6,times);
				
				pstm.executeUpdate();
				
				pstm=conn.prepareStatement("SELECT LAST_INSERT_ID()");
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					pid=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return pid;
	}
	//答卷详情表
	public void dajuanxq_insert(int pid,String type,int tno,String answer,int goal) {
		
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into TestInf values(?,0,?,?,?)");
				pstm.setInt(1, pid);
				pstm.setString(2, type);
				pstm.setString(3,answer);
				pstm.setInt(4,goal);
				
				pstm.executeUpdate();
				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}		
	}
	
	//答卷详情表
		public void dajuanxq_insert1(int pid,String type,int tno,String answer) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("insert into TestInf values(?,0,?,?,?)");
					pstm.setInt(1, pid);
					pstm.setString(2, type);
					pstm.setInt(3,tno);
					pstm.setString(4,answer);
					
					pstm.executeUpdate();
					
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
		}
	
	//答卷题目表
	public int dajuantm_insert(int pid,String type,int atimes,int rtimes) {
		
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into TestSub values(?,?,0,?,?)");
				pstm.setInt(1, pid);		
				pstm.setString(2,type);
				pstm.setInt(3, atimes);
				pstm.setInt(4, rtimes);
				
				pstm.executeUpdate();
				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	//所有错题表
	public void cuoti_insert(String xuehao,String type,int tno,Timestamp start) {
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into AllSub values(?,?,?,?)");		
				pstm.setString(1,xuehao);
				pstm.setString(2,type);
				pstm.setInt(3,tno);
				pstm.setTimestamp(4, start);
				pstm.executeUpdate();
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
}
