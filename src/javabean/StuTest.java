package javabean;

import java.sql.Timestamp;
//学生答卷表
public class StuTest {
	private int pid;
	private String xuehao;
	private int tpid;
	private int goal;
	private Timestamp start;
	private int times;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
