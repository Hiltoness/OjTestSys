package javabean;
//查询所有记录，没有条件语句
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_getall {
	  private PreparedStatement pstm;     	
	  private Connection conn;
	  private ResultSet rs;
	  //获取选课信息
	  public ArrayList<select> xuanke_getData() {
			ArrayList<select> xuankelist=new ArrayList<select> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from selectkc ");			
					rs=pstm.executeQuery();
					while(rs.next()) {
						select bean=new select();
						bean.setXuehao(rs.getString(1));
						bean.setKcbianhao(rs.getString(2));
						bean.setGonghao(rs.getString(3));
						xuankelist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return xuankelist;
		}
	    //获取所有错题
	    public ArrayList<AllSub> cuoti_getData() {
			ArrayList<AllSub> cuotilist=new ArrayList<AllSub> ();
			 try {
				 mysql_DB db=new mysql_DB();
					conn=db.connectDB();
					pstm=conn.prepareStatement("select * from AllSub ");			
					rs=pstm.executeQuery();
					while(rs.next()) {
						AllSub bean=new AllSub();
						bean.setXuehao(rs.getString(1));
						bean.setType(rs.getString(2));
						bean.setTno(rs.getInt(3));
						bean.setStart(rs.getTimestamp(4));
						cuotilist.add(bean);
					}
					db.close(conn);
				}catch(SQLException ex){
				ex.printStackTrace();
				}
			 return cuotilist;
		 }
	  
	  
}