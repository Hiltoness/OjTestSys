package javabean;

import java.sql.Timestamp;
//判断表
public class kaoshi_judgement {
	private int judgementid;
	private String specialid;
	private String jtitle;
	private String janswer;
	private int jmark;
	private String kcbianhao;
	private String gonghao;
	private String gongxiang;
	private int difficulty;
	private String chapter;
	private String useage;
	private String explain;
	private String Knowledgepoint;
	private Timestamp addtime;
	public int getJudgementid() {
		return judgementid;
	}
	public void setJudgementid(int judgementid) {
		this.judgementid = judgementid;
	}
	public String getSpecialid() {
		return specialid;
	}
	public void setSpecialid(String specialid) {
		this.specialid = specialid;
	}
	public String getJtitle() {
		return jtitle;
	}
	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
	public String getJanswer() {
		return janswer;
	}
	public void setJanswer(String janswer) {
		this.janswer = janswer;
	}
	public int getJmark() {
		return jmark;
	}
	public void setJmark(int jmark) {
		this.jmark = jmark;
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
	public String getGongxiang() {
		return gongxiang;
	}
	public void setGongxiang(String gongxiang) {
		this.gongxiang = gongxiang;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getUseage() {
		return useage;
	}
	public void setUseage(String useage) {
		this.useage = useage;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getKnowledgepoint() {
		return Knowledgepoint;
	}
	public void setKnowledgepoint(String knowledgepoint) {
		Knowledgepoint = knowledgepoint;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	
}
