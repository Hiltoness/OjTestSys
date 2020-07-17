package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class LorLL {
	  private PreparedStatement pstm;     	
	  private Connection conn;
	  private ResultSet rs;
public ArrayList<TeaTest> getteatest(String xuehao,String ttype){
	mysql_search_canshu s=new mysql_search_canshu();
	ArrayList<select> selectlist=new ArrayList<select>();
	ArrayList<TeaTest> teatestlist=new ArrayList<TeaTest>();
	selectlist=s.select_getData("xuehao",xuehao);
	for(int i=0;i<selectlist.size();i++){ 
	select beans=new select();
	beans=selectlist.get(i);
	String kcbianhao=beans.getKcbianhao();
	String gonghao=beans.getGonghao();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from teatest where kcbianhao=? and gonghao =? and ttype=?");			
			pstm.setString(1,kcbianhao);
			pstm.setString(2,gonghao);
			pstm.setString(3,ttype);
			rs=pstm.executeQuery();
			while(rs.next()) {
				TeaTest bean=new TeaTest();
				bean.setTpid(rs.getInt(1));
				bean.setKcbianhao(rs.getString(2));
				bean.setGonghao(rs.getString(3));
				bean.setStart(rs.getTimestamp(4));
				bean.setEnd(rs.getTimestamp(5));
				bean.setName(rs.getString(6));
				bean.setTimes(rs.getInt(7));
				bean.setTtype(rs.getString(8));
				teatestlist.add(bean);
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}	
	return teatestlist;
}

public ArrayList<TeaTest> getteatest2(ArrayList<StuTest> stutestlist){
	ArrayList<TeaTest> teatestlist=new ArrayList<TeaTest>();
	 try {
		   mysql_DB db=new mysql_DB();
			conn=db.connectDB();
            for(int i=0;i<stutestlist.size();i++) {
            	StuTest beans=new StuTest();
            	beans=stutestlist.get(i);
            	pstm=conn.prepareStatement("select * from teatest where tpid=?");			
    			pstm.setInt(1,beans.getTpid());
    			rs=pstm.executeQuery();
    			while(rs.next()) {
    				TeaTest bean=new TeaTest();
    				bean.setTpid(rs.getInt(1));
    				bean.setKcbianhao(rs.getString(2));
    				bean.setGonghao(rs.getString(3));
    				bean.setStart(rs.getTimestamp(4));
    				bean.setEnd(rs.getTimestamp(5));
    				bean.setName(rs.getString(6));
    				bean.setTimes(rs.getInt(7));
    				bean.setTtype(rs.getString(8));
    				teatestlist.add(bean);
    			}		
            }
				
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	
	return teatestlist;
}

public ArrayList<TeaTest> getteatestcon(ArrayList<TeaTest> teatestlist,String xuehao){
	ArrayList<TeaTest> teatestlistcon=new ArrayList<TeaTest>();
	
	for(int i=0;i<teatestlist.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist.get(i);
	int tpid=beans.getTpid();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from stutest where tpid=? and xuehao=? and goal=?");			
			pstm.setInt(1,tpid);
			pstm.setString(2,xuehao);
			pstm.setInt(3,-1);
			rs=pstm.executeQuery();
			while(rs.next()) {
            	teatestlistcon.add(beans);           
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}	
	return teatestlistcon;
}

public ArrayList<TeaTest> getteatestnew(ArrayList<TeaTest> teatestlist,ArrayList<TeaTest> teatestlistcon,String xuehao){		
	//删掉可继续上次答卷的
	//删掉过期的	
	for(int i=0;i<teatestlistcon.size();i++) {
		TeaTest bean1=new TeaTest();
		bean1=teatestlistcon.get(i);
		for(int j=0;j<teatestlist.size();j++) {
			TeaTest bean2=new TeaTest();
			bean2=teatestlist.get(j);
			if(bean1.getTpid()==bean2.getTpid()) {
				teatestlist.remove(bean2);
			}else {				
				Calendar calendar2=Calendar.getInstance();
				Timestamp time2=new Timestamp(calendar2.getTimeInMillis());
				if(time2.after(bean2.getEnd())) {
					teatestlist.remove(bean2);
				}
				
			}
		}
	}
	//删掉次数已用完的
	for(int i=0;i<teatestlist.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist.get(i);
	int tpid=beans.getTpid();
	 try {
		    mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select times from stutest where tpid=? and xuehao=? ");			
			pstm.setInt(1,tpid);
			pstm.setString(2,xuehao);
			rs=pstm.executeQuery();
			int num=0;
			while(rs.next()) {
				num=num+1;
			}			        			
			if(num==beans.getTimes()) {
				teatestlist.remove(beans);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}	
	return teatestlist;
}


public ArrayList<StuTest> getstutest2(ArrayList<TeaTest> teatestlist,String xuehao){
	ArrayList<StuTest> stutestlist=new ArrayList<StuTest>();
	for(int i=0;i<teatestlist.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist.get(i);
	int tpid=beans.getTpid();
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from stutest where tpid=? and xuehao=? and goal<>?");			
			pstm.setInt(1,tpid);
			pstm.setString(2,xuehao);
			pstm.setInt(3,-1);
			rs=pstm.executeQuery();
			while(rs.next()) {
				StuTest bean=new StuTest();
				bean.setPid(rs.getInt(1));
				bean.setXuehao(rs.getString(2));
				bean.setTpid(rs.getInt(3));
				bean.setGoal(rs.getInt(4));
				bean.setStart(rs.getTimestamp(5));
				bean.setEnd(rs.getTimestamp(6));
				bean.setTimes(rs.getInt(7));
				stutestlist.add(bean);
			}			
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}	
	return stutestlist;

}



public ArrayList<String> getteachername(ArrayList<TeaTest> teatestlist){
	ArrayList<String> teacher=new ArrayList<String>();
	for(int i=0;i<teatestlist.size();i++) {
		TeaTest beans=new TeaTest();
		beans=teatestlist.get(i);
		String gonghao=beans.getGonghao();
		try {
			    mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select gname from teacher where gonghao=?");			
				pstm.setString(1,gonghao);
				rs=pstm.executeQuery();
				while(rs.next()) {
					teacher.add(rs.getString(1));
				}			
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}
	return teacher;
}

public void checkl(ArrayList<TeaTest> teatestlist,String xuehao) {
	ArrayList<StuTest> stutestlist=new ArrayList<StuTest>();
	for(int i=0;i<teatestlist.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist.get(i);
	int tpid=beans.getTpid();
	int goal=-1;
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from stutest where tpid=? and xuehao=? and goal=?");			
			pstm.setInt(1,tpid);
			pstm.setString(2,xuehao);
			pstm.setInt(3,goal);
			rs=pstm.executeQuery();
			while(rs.next()) {
				StuTest bean=new StuTest();
				bean.setPid(rs.getInt(1));
				bean.setXuehao(rs.getString(2));
				bean.setTpid(rs.getInt(3));
				bean.setGoal(rs.getInt(4));
				bean.setStart(rs.getTimestamp(5));
				bean.setEnd(rs.getTimestamp(6));
				bean.setTimes(rs.getInt(7));
				stutestlist.add(bean);
				Calendar calendar1=Calendar.getInstance();
				calendar1.add(Calendar.MINUTE,-30);
				Timestamp time1=new Timestamp(calendar1.getTimeInMillis());
				if(time1.after(bean.getStart())) {
					//计算总分
				}else {
					Calendar calendar2=Calendar.getInstance();
					Timestamp time2=new Timestamp(calendar2.getTimeInMillis());
					if(time2.after(beans.getEnd())) {
						//计算总分
					}
				}
				
			}				
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
}

public void checkll(ArrayList<TeaTest> teatestlist,String xuehao) {
	ArrayList<StuTest> stutestlist=new ArrayList<StuTest>();
	for(int i=0;i<teatestlist.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist.get(i);
	int tpid=beans.getTpid();
	int goal=-1;
	 try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from stutest where tpid=? and xuehao=? and goal=?");			
			pstm.setInt(1,tpid);
			pstm.setString(2,xuehao);
			pstm.setInt(3,goal);
			rs=pstm.executeQuery();
			while(rs.next()) {
				StuTest bean=new StuTest();
				bean.setPid(rs.getInt(1));
				bean.setXuehao(rs.getString(2));
				bean.setTpid(rs.getInt(3));
				bean.setGoal(rs.getInt(4));
				bean.setStart(rs.getTimestamp(5));
				bean.setEnd(rs.getTimestamp(6));
				bean.setTimes(rs.getInt(7));
				stutestlist.add(bean);				
					Calendar calendar2=Calendar.getInstance();
					Timestamp time2=new Timestamp(calendar2.getTimeInMillis());
					if(time2.after(beans.getEnd())) {
						//计算总分
					}				
			}				
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}
}

public ArrayList<Integer> getremaintime(ArrayList<TeaTest> teatestlist,String xuehao){
	ArrayList<Integer> remaintimeslist=new ArrayList<Integer>();
	for(int i=0;i<teatestlist.size();i++){ 
		TeaTest beans=new TeaTest();
		beans=teatestlist.get(i);
		int tpid=beans.getTpid();
		 try {
			    mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select times from stutest where tpid=? and xuehao=? ");			
				pstm.setInt(1,tpid);
				pstm.setString(2,xuehao);
				rs=pstm.executeQuery();
				int num=0;
				while(rs.next()) {
					num=num+1;
				}			        			
				remaintimeslist.add(beans.getTimes()-num);
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}	
	return remaintimeslist;
}




}
