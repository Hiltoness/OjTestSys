package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_correctSub {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	//将做对的题放入一个用户list中
		public ArrayList<id_type> correctSub(int pid) {
			ArrayList<id_type> correctSublist=new ArrayList<id_type> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select type,tno from TestInf where pid =? and goal >0");
					pstm.setInt(1,pid);
					rs=pstm.executeQuery();
					while(rs.next()) {
						id_type bean=new id_type();
						bean.setType(rs.getString(1));
						bean.setId(rs.getInt(2));
						bean.setTitle("");
						bean.setSelect_A("");
						bean.setSelect_B("");
						bean.setSelect_C("");
						bean.setSelect_D("");
						correctSublist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return correctSublist;
       }
}
