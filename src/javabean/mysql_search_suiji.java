package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mysql_search_suiji {
	private PreparedStatement pstm;     	 
	private Connection conn;
	private ResultSet rs;
	
	public ArrayList<id_type> sub_getData(String kcbianhao,String gonghao,ArrayList<Tlist> list) {
		System.out.println("随机抽题开始");
		Map<String,Integer> typeS=new HashMap<String,Integer>(){
			{put("single",4);
			put("multi",2);
			put("judgement",3);
			put("blank",1);}
		};
		ArrayList<id_type> sublist=new ArrayList<id_type>();
		ArrayList<Integer> a_blank=new ArrayList<Integer>();//填空
		ArrayList<Integer> a_multi=new ArrayList<Integer>();//多选
		ArrayList<Integer> a_judge=new ArrayList<Integer>();//判断
		ArrayList<Integer> a_single=new ArrayList<Integer>();//单选
		if(list.size()>0){
			for(Tlist k:list){
				switch(typeS.get(k.getType())){
					case 1:
						a_blank.add(k.getId());
						break;
					case 2:
						a_multi.add(k.getId());
						break;
					case 3:
						a_judge.add(k.getId());
					case 4:
						a_single.add(k.getId());
					default:
						System.out.print("已出题list有错");
				}
			}
		
		  }
		 try {
			 mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				
				for(int i=1;i<=10;i++){
					int random=(int)(Math.random()*4+1);
					id_type a=new id_type();
					int tid = 0;
				switch (random) {
				  case 1://填空题
					  String sql1="select * from kaoshi_blank where kcbianhao ='"+kcbianhao+ "' and gonghao ='"+gonghao+"'";
					  if(a_blank.size()>0){
						  sql1+=" and blankid not in(";
						  for(int ax=0;ax<a_blank.size()-1;ax++){
							  sql1+=a_blank.get(ax)+",";
						  }
						  sql1+=a_blank.get(a_blank.size()-1)+") ORDER BY rand() limit 1";
					  }
					  pstm=conn.prepareStatement(sql1);		
					  rs=pstm.executeQuery();
						while(rs.next()) {	
							tid=rs.getInt(1);
							String front=rs.getString(3);
							String back=rs.getString(4);
							a.setId(tid);
							a.setType("blank");
							a.setTitle("");
							a.setSelect_A(front);
							a.setSelect_B(back);
							a.setSelect_C("");
							a.setSelect_D("");
							a.setValue("");
							sublist.add(a);
							a_blank.add(tid);
						}
						System.out.print("yichublank"+a_blank);
					  break;
				  case 2://判断题
					  String sql2="select * from kaoshi_judgement where kcbianhao ='"+kcbianhao+ "' and gonghao ='"+gonghao+"'";
					  if(a_judge.size()>0){
						  sql2+=" and judgementid not in(";
						  for(int ax=0;ax<a_judge.size()-1;ax++){
							  sql2+=a_judge.get(ax)+",";
						  }
						  sql2+=a_judge.get(a_judge.size()-1)+") ORDER BY rand() limit 1";
					  }
					  pstm=conn.prepareStatement(sql2);	
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							tid=rs.getInt(1);
							String title=rs.getString(3);
							a.setId(tid);
							a.setTitle(title);
							a.setType("judgement");
							a.setSelect_A("对");
							a.setSelect_B("错");
							a.setSelect_C("");
							a.setSelect_D("");
							a.setValue("");
							sublist.add(a);
							a_judge.add(tid);
							}
					 break;
				  case 3://多选题
					  String sql3="select * from kaoshi_multi where kcbianhao ='"+kcbianhao+ "' and gonghao ='"+gonghao+"'";
					  if(a_multi.size()>0){
						  sql3+=" and multiid not in(";
						  for(int ax=0;ax<a_multi.size()-1;ax++){
							  sql3+=a_multi.get(ax)+",";
						  }
						  sql3+=a_multi.get(a_multi.size()-1)+") ORDER BY rand() limit 1";
					  }
					  pstm=conn.prepareStatement(sql3);		
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
							 tid=rs.getInt(1);
							String title=rs.getString(3);
							String mA=rs.getString(4);
							String mB=rs.getString(5);
							String mC=rs.getString(6);
							String mD=rs.getString(7);
							a.setId(tid);a.setTitle(title);
							a.setType("multi");
							a.setSelect_A(mA);
							a.setSelect_B(mB);a.setSelect_C(mC);a.setSelect_D(mD);
							a.setValue("");
							sublist.add(a);
							a_multi.add(tid);
					  }
				      break;
				  case 4://单选题
					  String sql4="select * from kaoshi_single where kcbianhao ='"+kcbianhao+ "' and gonghao ='"+gonghao+"'";
					  if(a_single.size()>0){
						  sql4+=" and singleid not in(";
						  for(int ax=0;ax<a_single.size()-1;ax++){
							  sql4+=a_single.get(ax)+",";
						  }
						  sql4+=a_single.get(a_single.size()-1)+") ORDER BY rand() limit 1";
					  }
					  pstm=conn.prepareStatement(sql4);		
					  rs=pstm.executeQuery();
					  if(rs.next()) {	
						   tid=rs.getInt(1);
							String title=rs.getString(3);
							String mA=rs.getString(4);
							String mB=rs.getString(5);
							String mC=rs.getString(6);
							String mD=rs.getString(7);
							a.setId(tid);a.setTitle(title);
							a.setType("single");
							a.setSelect_A(mA);
							a.setSelect_B(mB);a.setSelect_C(mC);a.setSelect_D(mD);
							a.setValue("");
							sublist.add(a);
							a_single.add(tid);
					  }
			          break;
				 }
				System.out.println("抽到题目"+tid+" "+random);
				System.out.println("随机次数" +i);
				}
				db.close(conn);
								
			}catch(SQLException ex){
			ex.printStackTrace();
			}
		 System.out.println(sublist.size());
		 return sublist;
	}
}
