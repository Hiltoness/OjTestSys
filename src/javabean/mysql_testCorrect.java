package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class mysql_testCorrect {
	private PreparedStatement pstm;     
	private Connection conn;
	private ResultSet rs;
	
	public String testCorrect() {
		String correct="";
		int count=0,count0=0;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select count(tno) from TestInf");
				rs=pstm.executeQuery();
				while(rs.next()) {
					count=rs.getInt(1);
				}
				
				pstm=conn.prepareStatement("select count(tno) from TestInf where goal=0");
				rs=pstm.executeQuery();
				while(rs.next()) {
					count0=rs.getInt(1);
				}
				float num=(float)(count-count0)/count;
				NumberFormat numberFormat = NumberFormat.getInstance();
				numberFormat.setMaximumFractionDigits(1);
			    String result = numberFormat.format((float)num * 100);
			    correct=result+"%";
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		return correct;
	}
}
