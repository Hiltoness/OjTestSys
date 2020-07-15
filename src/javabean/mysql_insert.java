package javabean;

import java.sql.*;

public class mysql_insert {
	private PreparedStatement pstm;     
	private Connection conn;
	//学生答卷表
	public int studajuan_insert(String xuehao,int tpid,int goal,Timestamp start,int times) {
		int pid=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into StuTest values(0,?,?,?,?,?)");
				pstm.setString(1, xuehao);
				pstm.setInt(2, tpid);
				pstm.setInt(3,goal);
				pstm.setTimestamp(4,start);
				pstm.setInt(5,times);
				
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
	public int dajuanxq_insert(int pid,String type,int tno,String answer,int goal) {
		int no=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into TestInf values(?,0,?,?,?,?)");
				pstm.setInt(1, pid);
				pstm.setString(2, type);
				pstm.setInt(3,tno);
				pstm.setString(4,answer);
				pstm.setInt(5,goal);
				
				pstm.executeUpdate();
				
				pstm=conn.prepareStatement("SELECT LAST_INSERT_ID()");
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					no=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return no;		
	}
	//答卷题目表
	public int dajuantm_insert(int pid,String type,int atimes,int rtimes) {
		int tno=0; 
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into TestSub values(?,?,0,?,?)");
				pstm.setInt(1, pid);		
				pstm.setString(2,type);
				pstm.setInt(3, atimes);
				pstm.setInt(4, rtimes);
				
				pstm.executeUpdate();
				
				pstm=conn.prepareStatement("SELECT LAST_INSERT_ID()");
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					tno=rs.getInt(1);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return tno;
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
