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
	ArrayList<TeaTest> teatestlist0=new ArrayList<TeaTest>();
	for(int i=0;i<teatestlist.size();i++) {
		int flag=0;
		TeaTest bean1=new TeaTest();
		bean1=teatestlist.get(i);
		for(int j=0;j<teatestlistcon.size();j++) {
			TeaTest bean2=new TeaTest();
			bean2=teatestlistcon.get(j);
			if(bean1.getTpid()==bean2.getTpid()) {
				flag=1;			
			}
		}
		if(flag==0) {
		teatestlist0.add(bean1);
		}
	}
	ArrayList<TeaTest> teatestlist1=new ArrayList<TeaTest>();
	for(int i=0;i<teatestlist0.size();i++) {
		int flag=0;
		TeaTest bean3=new TeaTest();
		bean3=teatestlist0.get(i);
		Calendar calendar2=Calendar.getInstance();
		Timestamp time2=new Timestamp(calendar2.getTimeInMillis());
		Timestamp end=bean3.getEnd();
		if(time2.after(bean3.getEnd())) {
			flag=1;
		}
		if(flag==0) {
			teatestlist1.add(bean3);
		}
	}
	//删掉次数已用完的
	ArrayList<TeaTest> teatestlist2=new ArrayList<TeaTest>();
	for(int i=0;i<teatestlist1.size();i++){ 
	TeaTest beans=new TeaTest();
	beans=teatestlist1.get(i);
	int tpid=beans.getTpid();
	int flag=0;
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
				flag=1;
			}
			if(flag==0) {
				teatestlist2.add(beans);
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
}	
	return teatestlist2;
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
					mysql_update_goal up=new mysql_update_goal();
					up.goal_update(bean.getPid());
				}else {
					Calendar calendar2=Calendar.getInstance();
					Timestamp time2=new Timestamp(calendar2.getTimeInMillis());
					if(time2.after(beans.getEnd())) {
						//计算总分
						mysql_update_goal up=new mysql_update_goal();
						up.goal_update(bean.getPid());
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
						mysql_update_goal up=new mysql_update_goal();
						up.goal_update(bean.getPid());
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

public ArrayList<String> getcorrect(ArrayList<StuTest> stutestlist){
	ArrayList<String> correctlist=new ArrayList<String>();
	for(int i=0;i<stutestlist.size();i++){ 
		StuTest beans=new StuTest();
		beans=stutestlist.get(i);
		int pid=beans.getPid();
		mysql_testCorrect c=new mysql_testCorrect();
		correctlist.add(c.testCorrect(pid));
	}
	return correctlist;
}
public ArrayList<Integer> getyear1(ArrayList<TeaTest> teatestlist){
	ArrayList<Integer> year=new ArrayList<Integer>();
	for(int i=0;i<teatestlist.size();i++){
		TeaTest beana=new TeaTest();
		beana=teatestlist.get(i);
		Timestamp tmp=beana.getStart();
		int year0=tmp.getYear()+1900;
		int flag=0;
		for(int j=0;j<year.size();j++){
		if(year0==year.get(j)){
			flag=1;
		}	
		}
		if(flag==0){year.add(year0);}
	}
	return year;
}

public ArrayList<Integer> getyear2(ArrayList<TeaTest> teatestlistcon,ArrayList<TeaTest> teatestlistnew){
	ArrayList<Integer> year=new ArrayList<Integer>();
	for(int i=0;i<teatestlistcon.size();i++){
		TeaTest beana=new TeaTest();
		beana=teatestlistcon.get(i);
		Timestamp tmp=beana.getStart();
		int year0=tmp.getYear()+1900;
		int flag=0;
		for(int j=0;j<year.size();j++){
		if(year0==year.get(j)){
			flag=1;
		}	
		}
		if(flag==0){year.add(year0);}
	}
	for(int i=0;i<teatestlistnew.size();i++){
		TeaTest beana=new TeaTest();
		beana=teatestlistnew.get(i);
		Timestamp tmp=beana.getStart();
		int year0=tmp.getYear()+1900;
		int flag=0;
		for(int j=0;j<year.size();j++){
		if(year0==year.get(j)){
			flag=1;
		}	
		}
		if(flag==0){year.add(year0);}
	}
	return year;
}

public ArrayList<twoint> gettimeandpid(ArrayList<TeaTest> teatestlist,String xuehao){
	ArrayList<twoint> twointlist=new ArrayList<twoint>();
	for(int i=0;i<teatestlist.size();i++){ 
		TeaTest beans=new TeaTest();
		beans=teatestlist.get(i);
		int tpid=beans.getTpid();
		 try {
			    mysql_DB db=new mysql_DB();
				conn=db.connectDB();
				pstm=conn.prepareStatement("select * from stutest where tpid=? and xuehao=? ");			
				pstm.setInt(1,tpid);
				pstm.setString(2,xuehao);
				rs=pstm.executeQuery();
				twoint tit=new twoint();
				tit.setTimes(1);
				while(rs.next()) {
					int get=rs.getInt(7);
					if(tit.getTimes()<get) {
						tit.setTimes(get);
						tit.setPid(rs.getInt(1));
						tit.setStart(rs.getTimestamp(5));
					}
				}			        			
				twointlist.add(tit);
				db.close(conn);
			}catch(SQLException ex){
			ex.printStackTrace();
			}
	}	
	return twointlist;
}
public int getsearchtno(int pid) {
	int tno=0;
	try {
		 mysql_DB db=new mysql_DB();
			conn=db.connectDB();
			pstm=conn.prepareStatement("select * from TestInf where pid =?");	
			pstm.setInt(1, pid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int tno1=rs.getInt(2);
				String goal=rs.getInt(6)+"";
				if(tno<tno1) {
					if(!"".equals(goal)) {
						tno=tno1;
					}
				}
			}
			db.close(conn);
		}catch(SQLException ex){
		ex.printStackTrace();
		}
	return tno;
}

}
