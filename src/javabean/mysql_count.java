package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql_count {
	private PreparedStatement pstm;     
	private Connection conn;
	private ResultSet rs;
	
	public int count(String table,String whereat,int id) {
		int count=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select count(*) from "+table+" where "+whereat+" =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()) {
					count=rs.getInt(1);
				}				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return count;
	}
	public int count1(String table,String whereat,int id,String whereat1,String id1) {
		int count=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select count(*) from "+table+" where "+whereat+" =? and "+whereat1+" =?");
				pstm.setInt(1, id);
				pstm.setString(1, id1);
				rs=pstm.executeQuery();
				while(rs.next()) {
					count=rs.getInt(1);
				}				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return count;
	}
}
