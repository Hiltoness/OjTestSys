package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mysql_checkWrong {
	private PreparedStatement pstm;     
	private Connection conn;
	private ResultSet rs;
	
	public boolean check(int id,String type) {
		boolean result=false;
		List<String> list=new ArrayList<String>();
		String[] arr;
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select type from AllSub where tno =?");
				pstm.setInt(1, id);
				rs=pstm.executeQuery();
				while(rs.next()) {
					list.add(rs.getString(1));
				}				
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		if(list != null && list.size()>0){
			arr=new String[list.size()];
			for(int i=0;i<list.size();i++){
			   arr[i]=list.get(i);
			}
           result=Arrays.asList(arr).contains(type);
		}
		return result;
	}
}
