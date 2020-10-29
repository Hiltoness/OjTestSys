package javabean;
import javabean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class mysql_teacher {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	public boolean insert_teatest(String kcbianhao,String name,String gonghao,String type,String begin,String end,int times){
		//老师添加试卷
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("insert into teatest(kcbianhao,gonghao,start,end,name,times,ttype) values(?,?,?,?,?,?,?)");
				pstm.setString(1,kcbianhao);
				pstm.setString(2, gonghao);
				pstm.setString(3, begin);
				pstm.setString(4, end);
				pstm.setString(5, name);
				pstm.setInt(6, times);
				pstm.setString(7, type);
				
				pstm.executeUpdate();
				db.close(conn);
				return true;
			}catch(SQLException ex){
			ex.printStackTrace();
			return false;
			}
	}
	
	public boolean delete_teatest(int tpid){
		//老师删除试卷
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("delete from stutest where tpid=?");
				pstm.setInt(1,tpid);
				
				boolean rs1=pstm.execute();
				pstm=conn.prepareStatement("delete from teatest where tpid=?");
				pstm.setInt(1,tpid);
				boolean rs2=pstm.execute();
				db.close(conn);
				return true;
			}catch(SQLException ex){
			ex.printStackTrace();
			return false;
			}
	}
	
	public ArrayList<TeaTest> show_teatest(String gonghao){
		//显示老师试卷
		ArrayList<TeaTest> testlist=new ArrayList<>();
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from teatest where gonghao =?");
				pstm.setString(1,gonghao);
				rs=pstm.executeQuery();
				while(rs.next()) {
					TeaTest bean=new TeaTest();
					bean.setTpid(rs.getInt(1));
					bean.setKcbianhao(rs.getString(2));
					bean.setStart(rs.getTimestamp(4));
					bean.setEnd(rs.getTimestamp(5));
					bean.setName(rs.getString(6));
					bean.setTimes(rs.getInt(7));
					bean.setTtype(rs.getString(8));
					testlist.add(bean);
				}
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return testlist;
	}
}
