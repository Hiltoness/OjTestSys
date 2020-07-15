package javabean;

import java.sql.Timestamp;
//学生答卷表
public class StuTest {
	private int pid;//答卷id
	private String xuehao;
	private int tpid;//试卷id
	private int goal;//答卷分数
	private Timestamp start;//作答开始时间
	private int times;//作答完成时间
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
