package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql_checkAppear {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	public int checksave(int pid,int no,int tno) {
		int result=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select tno from TestInf where pid=? and no =? and tno <? order by tno desc limit 0,1");
				pstm.setInt(1, pid);
				pstm.setInt(2, no);
				pstm.setInt(3, tno);
				rs=pstm.executeQuery();
				while(rs.next()) {
					result=rs.getInt(1);
				}				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return result;
	}
}
