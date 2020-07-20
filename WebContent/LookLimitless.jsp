<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="javabean.*" %> 
    <%@ page import="java.util.*" %>
    <%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试系统</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<%
String timeorall=session.getAttribute("timeorall").toString();
String xuehao=session.getAttribute("xuehao").toString(); 
String pattern=session.getAttribute("pattern").toString(); 
String all;
ArrayList<Integer> year=new ArrayList<Integer>();
if(timeorall.equals("all")){
	all="全部学年";
}else{
   all=timeorall;
}
ArrayList<TeaTest> teatestlist=new ArrayList<TeaTest>();
ArrayList<StuTest> stutestlist=new ArrayList<StuTest>();
ArrayList<String> teachername=new ArrayList<String>();
ArrayList<String> correctlist=new ArrayList<String>();
ArrayList<TeaTest> teatestlistcon=new ArrayList<TeaTest>();
ArrayList<TeaTest> teatestlistnew=new ArrayList<TeaTest>();
ArrayList<twoint> remaintimescon=new ArrayList<twoint>();
ArrayList<Integer> remaintimesnew=new ArrayList<Integer>();
ArrayList<String> teachernamecon=new ArrayList<String>();
ArrayList<String> teachernamenew=new ArrayList<String>();
LorLL l=new LorLL();
if(pattern.equals("finish")){ 	
	teatestlist=(ArrayList)session.getAttribute("teatestlist2");
	stutestlist=(ArrayList)session.getAttribute("stutestlist");
	teachername=(ArrayList)session.getAttribute("teachername");
	correctlist	=(ArrayList)session.getAttribute("correctlist");
	
	year=l.getyear1(stutestlist);	
	}else{ 		
		teatestlistcon=(ArrayList)session.getAttribute("teatestlistcon");
		teatestlistnew=(ArrayList)session.getAttribute("teatestlistnew");
		remaintimescon=(ArrayList)session.getAttribute("remaintimescon");
		remaintimesnew	=(ArrayList)session.getAttribute("remaintimesnew");
		teachernamecon=(ArrayList)session.getAttribute("teachernamecon");
		teachernamenew=(ArrayList)session.getAttribute("teachernamenew");
		year=l.getyear2(teatestlistcon,teatestlistnew);	
		
	
	}
int timeorallyear=-1;
for(int i=0;i<year.size();i++){
	 String year11=Integer.toString(year.get(i));  
	 String year22=Integer.toString(year.get(i)+1);  
	 String year33=year11+"-"+year22; 
	 if(year33.equals(timeorall)){
		 timeorallyear=year.get(i);
	 }
}

%>

<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>
<div class="limit">

<table border="0" cellspacing="0" cellpadding="15"  >
<tr>
<td ><a href="Lgoto?xuehao=<%=xuehao%>&timeorall=<%="all"%>&pattern=<%=pattern %>" class="afinw">限时模式</a> 
</td>
<td ><a href="#" class="afing">无限模式</a> 
</td>
<td >
<div class="dropdown">
  <button class="dropbtn"><%=all %></button>
  <div class="dropdown-content">
    <a href="LLgoto?xuehao=<%=xuehao%>&timeorall=<%="all"%>&pattern=<%=pattern %>">全部学年</a>
    <%    for(int i=0;i<year.size();i++){ 
    String year1=Integer.toString(year.get(i));  
    String year2=Integer.toString(year.get(i)+1);  
    String year3=year1+"-"+year2; 
    %>
    <a href="LLgoto?xuehao=<%=xuehao%>&timeorall=<%=year3%>&pattern=<%=pattern %>"><%=year3 %></a>
 <%} %>
  </div>
</div>
  
</td>
</tr>
</table>
</div>




<div id="content">

<table border="0" cellspacing="0" cellpadding="20"  >

<%if(pattern.equals("finish")){ 
	
%>
<tr>
<td class="tdcenter">考卷名称</td>
<td class="tdcenter">老师</td>
<td class="tdcenter">作答时间</td>
<td class="tdcenter">提交时间</td>
<td class="tdcenter">分数</td>
<td class="tdcenter">正确率</td>
<td class="tdcenter">操作</td>
</tr>
<% 
	for(int i=0;i<teatestlist.size();i++){
		TeaTest beant=new TeaTest();
		StuTest beans=new StuTest();
		beant=teatestlist.get(i);
		beans=stutestlist.get(i);
		String beantn=teachername.get(i);
		String beanc=correctlist.get(i);
		Timestamp tmp=beans.getStart();
		int year0=tmp.getYear()+1900;
		if(timeorallyear==-1||year0==timeorallyear){
%>

<tr>
<td><%=beant.getName() %></td>
<td><%=beantn %></td>
<td><%=beans.getStart() %></td>
<td><%=beans.getEnd() %></td>
<td><%=beans.getGoal() %></td>
<td><%=beanc %></td>
<td><a  href="MytestServlet?xuehao=<%=xuehao %>&pid=<%=beans.getPid() %>
&kcbianhao=<%=beant.getKcbianhao() %>&gonghao=<%=beant.getGonghao() %>" class="aleft">查看答卷</a></td>
</tr>
<%}}}if(pattern.equals("unfinish")){ 
	
%>
<tr>
<td class="tdcenter">考卷名称</td>
<td class="tdcenter">老师</td>
<td class="tdcenter">开始时间</td>
<td class="tdcenter">结束时间</td>
<td class="tdcenter">剩余次数</td>
<td class="tdcenter">可答次数</td>
<td class="tdcenter">操作</td>
</tr>
<%
for(int i=0;i<teatestlistcon.size();i++){
	TeaTest beant1=new TeaTest();
	beant1=teatestlistcon.get(i);
	twoint beanr1=remaintimescon.get(i);
	String beantn1=teachernamecon.get(i);
	Timestamp tmp=beant1.getStart();
	int year0=tmp.getYear()+1900;
	if(timeorallyear==-1||year0==timeorallyear){
%>
<tr>
<td><%=beant1.getName() %></td>
<td><%=beantn1 %></td>
<td><%=beant1.getStart() %></td>
<td><%=beant1.getEnd() %></td>
<td><%=beant1.getTimes()-beanr1.getTimes() %></td>
<td><%=beant1.getTimes() %></td>
<td><a  href="LookServlet?xuehao=<%=xuehao %>&pid=<%=beanr1.getPid() %>&times=<%=beanr1.getTimes() %>&LLLpattern=<%="limit" %>
&conornew=<%="con"%>&kcbianhao=<%=beant1.getKcbianhao() %>&gonghao=<%=beant1.getGonghao() %>&tpid=<%=beant1.getTpid() %>&start=<%=beanr1.getStart() %>" class="aleftred">继续答卷</a></td>
</tr>
<%}} %>
<%
for(int i=0;i<teatestlistnew.size();i++){
	TeaTest beant2=new TeaTest();
	beant2=teatestlistnew.get(i);
	int beanr2=remaintimesnew.get(i);
	String beantn2=teachernamenew.get(i);
	Timestamp tmp=beant2.getStart();
	int year0=tmp.getYear()+1900;
	if(timeorallyear==-1||year0==timeorallyear){
%>
<tr>
<td><%=beant2.getName() %></td>
<td><%=beantn2 %></td>
<td><%=beant2.getStart() %></td>
<td><%=beant2.getEnd() %></td>
<td><%=beanr2 %></td>
<td><%=beant2.getTimes() %></td>
<td><a  href="LookServlet?xuehao=<%=xuehao %>&times=<%=beant2.getTimes()-beanr2 %>&LLLpattern=<%="limit" %>
&conornew=<%="new" %>&tpid=<%=beant2.getTpid() %>&kcbianhao=<%=beant2.getKcbianhao() %>&gonghao=<%=beant2.getGonghao() %>" class="aleft">开始答卷</a></td>
</tr>
<%} }%>
<%} %>
</table>
</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









