package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysql_search_suiji {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	public ArrayList<id_type> sub_getData(String kcbianhao,String gonghao) {
		ArrayList<id_type> sublist=new ArrayList<id_type> ();
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				
				for(int i=1;i<=10;i++){
				int random=(int)(Math.random()*4+1);
				switch (random) {
				  case 1:
					  pstm=conn.prepareStatement("select blankid from kaoshi_blank where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
						if(rs.next()) {	
							id_type a=new id_type(rs.getInt(1),"blank");
							boolean boo=sublist.contains(a);
							if(!boo) {
								id_type bean=new id_type(rs.getInt(1), "blank");
								sublist.add(bean);
							}else break;
					  }
					  break;
				  case 2:
					  pstm=conn.prepareStatement("select judgementid from kaoshi_judgement where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							id_type a=new id_type(rs.getInt(1),"judgement");
							boolean boo=sublist.contains(a);
							if(!boo) {
								id_type bean=new id_type(rs.getInt(1), "judgement");
								sublist.add(bean);
							}else break;
					  }
					  break;
				  case 3:
					  pstm=conn.prepareStatement("select multiid from kaoshi_multi where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							id_type a=new id_type(rs.getInt(1),"multi");
							boolean boo=sublist.contains(a);
							if(!boo) {
								id_type bean=new id_type(rs.getInt(1), "multi");
								sublist.add(bean);
							}else break;
					  }
				      break;
				  case 4:
					  pstm=conn.prepareStatement("select singleid from kaoshi_single where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							id_type a=new id_type(rs.getInt(1),"single");
							boolean boo=sublist.contains(a);
							if(!boo) {
								id_type bean=new id_type(rs.getInt(1), "single");
								sublist.add(bean);
							}else break;
					  }
			          break;
				 }
				}
				db.close(conn);
								
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 return sublist;
	}
}
