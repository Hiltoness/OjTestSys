package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql_update_goal {
	private PreparedStatement pstm;     
	private Connection conn;
	private ResultSet rs;
	
	public void goal_update(int pid) {
		int sum=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select sum(goal) from TestInf where pid=?");
				pstm.setInt(1, pid);
				rs=pstm.executeQuery();
				while(rs.next()) {
					sum=rs.getInt(1);
				}
				
				pstm=conn.prepareStatement("update StuTest set goal =? where pid =?");
				pstm.setInt(1, sum);
				pstm.setInt(2, pid);
				pstm.executeUpdate();				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
}
