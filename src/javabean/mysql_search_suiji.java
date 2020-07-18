package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					id_type a=new id_type();
				switch (random) {
				  case 1:
					  pstm=conn.prepareStatement("select blankid from kaoshi_blank where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
						while(rs.next()) {	
							int tid=rs.getInt(1);
							String front=rs.getString(2);
							String back=rs.getString(3);
							a.setId(tid);
							a.setType("blank");
							a.setTitle("");
							a.setSelect_A(front);
							a.setSelect_B(back);
							a.setSelect_C("");
							a.setSelect_D("");
							boolean boo=sublist.contains(a);
							if(!boo) {
								sublist.add(a);
							}else break;
					  }
					  break;
				  case 2:
					  pstm=conn.prepareStatement("select judgementid from kaoshi_judgement where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							int tid=rs.getInt(1);
							String title=rs.getString(2);
							a.setId(tid);
							a.setTitle(title);
							a.setType("judgement");
							a.setSelect_A("对");
							a.setSelect_B("错");
							a.setSelect_C("");
							a.setSelect_D("");
							boolean boo=sublist.contains(a);
							if(!boo) {
								sublist.add(a);
							}else break;
					  }
					  break;
				  case 3:
					  pstm=conn.prepareStatement("select multiid from kaoshi_multi where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							int tid=rs.getInt(1);
							String title=rs.getString(2);
							String mA=rs.getString(3);
							String mB=rs.getString(4);
							String mC=rs.getString(5);
							String mD=rs.getString(6);
							a.setId(tid);a.setTitle(title);
							a.setType("multi");
							a.setSelect_A(mA);
							a.setSelect_B(mB);a.setSelect_C(mC);a.setSelect_D(mD);
							boolean boo=sublist.contains(a);
							if(!boo) {
								sublist.add(a);
							}else break;
					  }
				      break;
				  case 4:
					  pstm=conn.prepareStatement("select singleid from kaoshi_single where kcbianhao =? and gonghao =? order by rand() limit 1");			
					  pstm.setString(1, kcbianhao);
					  pstm.setString(2, gonghao);
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
						  int tid=rs.getInt(1);
							String title=rs.getString(2);
							String mA=rs.getString(3);
							String mB=rs.getString(4);
							String mC=rs.getString(5);
							String mD=rs.getString(6);
							a.setId(tid);a.setTitle(title);
							a.setType("single");
							a.setSelect_A(mA);
							a.setSelect_B(mB);a.setSelect_C(mC);a.setSelect_D(mD);
							boolean boo=sublist.contains(a);
							if(!boo) {
								sublist.add(a);
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
