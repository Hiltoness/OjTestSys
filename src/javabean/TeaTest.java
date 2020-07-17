package javabean;
//老师答卷表
import java.sql.Timestamp;
public class TeaTest {
	private int tpid;
	private String kcbianhao;
	private String gonghao;
	private Timestamp start;
	private Timestamp end;
	private String name;
	private int times;
	private String ttype;
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
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	
	
}
