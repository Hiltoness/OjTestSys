package javabean;
//试卷属性表
import java.sql.Timestamp;
public class TeaTest {
	private int tpid;
	private String kcbianhao;//试卷所属课程
	private String gonghao;//负责老师
	private Timestamp start;//试卷开放时间-开始时间
	private Timestamp end;//
	private String name;//试卷名
	private int times;//可刷次数
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public String getKcbianhao() {
		return kcbianhao;
	}
	public void setKcbianhao(String kcbianhao) {
		this.kcbianhao = kcbianhao;
	}
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
