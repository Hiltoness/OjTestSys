package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysql_search {
	private PreparedStatement pstm;     	 
	private Connection conn;	
	//搜索填空题相关记录
	//搜索的那个字段是int类型
	public void  blank_getInt(int ziduan,int id) {
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_blank where blankid =?");
				pstm.setInt(1, id);
				pstm.executeUpdate();
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	//搜索的那个字段是String类型
	public void  blank_getString(String ziduan,int id) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_blank where blankid =?");
					pstm.setInt(1, id);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	}
	
	//搜索判断题相关记录
	//搜索的那个字段是int类型
	public void  judgement_getInt(int ziduan,int id) {
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_judgement where judgementid =?");
				pstm.setInt(1, id);
				pstm.executeUpdate();
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	//搜索的那个字段是String类型
	public void  judgement_getString(String ziduan,int id) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_judgement where judgementid =?");
					pstm.setInt(1, id);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	}
	
	//搜索多选题相关记录
	//搜索的那个字段是int类型
	public void  multi_getInt(int ziduan,int id) {
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_multi where multiid =?");
				pstm.setInt(1, id);
				pstm.executeUpdate();
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	//搜索的那个字段是String类型
	public void  multi_getString(String ziduan,int id) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_multi where multiid =?");
					pstm.setInt(1, id);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	}
	
	//搜索单选题相关记录
	//搜索的那个字段是int类型
	public void  single_getInt(int ziduan,int id) {
		try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_single where singleid =?");
				pstm.setInt(1, id);
				pstm.executeUpdate();
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	//搜索的那个字段是String类型
	public void  single_getString(String ziduan,int id) {
			try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select"+ziduan+"from kaoshi_single where singleid =?");
					pstm.setInt(1, id);
					pstm.executeUpdate();
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
	}
	
	
}
