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
String all;
if(timeorall.equals("all")){
	all="全部错题";
}else{
   all=timeorall;
}

mysql_search_canshu s=new mysql_search_canshu();
ArrayList<AllSub> allsub=new ArrayList<AllSub>();
ArrayList<AllSub> allsubshow=new ArrayList<AllSub>();
ArrayList<Integer> year=new ArrayList<Integer>();
allsub=s.cuoti_getData("xuehao",xuehao);
for(int i=0;i<allsub.size();i++){
	AllSub beana=new AllSub();
	beana=allsub.get(i);
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
int timeorallyear=-1;
if(timeorall.equals("all")){
	allsubshow=allsub;
}else{
	for(int i=0;i<year.size();i++){
		 String year11=Integer.toString(year.get(i));  
		 String year22=Integer.toString(year.get(i)+1);  
		 String year33=year11+"-"+year22; 
		 if(year33.equals(timeorall)){
			 timeorallyear=year.get(i);
		 }
	}
	for(int j=0;j<allsub.size();j++){
		AllSub beana=new AllSub();
		beana=allsub.get(j);
		Timestamp tmp=beana.getStart();
		int year0=tmp.getYear()+1900;
		if(year0==timeorallyear){
			allsubshow.add(beana);
		}
	}
	
}


int pagetotal=allsubshow.size();
int pagestart=Integer.parseInt(session.getAttribute("pagestart").toString());
int pagecount=5;
page1 p=new page1();
int pagelast=p.getLast(pagetotal,pagecount);
int pageye=p.getTotalPage(pagetotal,pagecount);
ArrayList<Integer> indexs=new ArrayList<Integer>();
indexs=p.getindexs(pagestart,pagetotal);
%>
<script>
function testgoto(){
	var pageyego=document.getElementById("pageye").value;
	var pageyelast=<%=pageye%>;
		if(pageyego<1){
			alert("当前输入页码不存在");
			 return false;
		}else if(pageyego>pageyelast){
			alert("当前输入页码不存在");
			return false;
		}
		else{return true;}
}
</script>
<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>
<div class="limit">
<form action="" method="post">
<table border="0" cellspacing="0" cellpadding="15"  >
<tr>
<td >
<div class="dropdown">
  <button class="dropbtn"><%=all %></button>
  <div class="dropdown-content">
    <a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%="all"%>&pagestart=0">全部错题</a>
    <%    for(int i=0;i<year.size();i++){ 
    String year1=Integer.toString(year.get(i));  
    String year2=Integer.toString(year.get(i)+1);  
    String year3=year1+"-"+year2; 
    %>
    <a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=year3 %>&pagestart=0"><%=year3%></a>
    <%} %> 
     
  </div>
</div>
</td>

</tr>
</table>
</form>
</div>
<div id="content">

<table border="0" cellspacing="0" cellpadding="10"  >
<%for(int i=pagestart;i<(pagecount+pagestart)&&i<pagetotal;i++){
	AllSub beana=new AllSub();
	beana=allsubshow.get(i);
	if(beana.getType().equals("single")){
		ArrayList<kaoshi_single> subjectlist=new ArrayList<kaoshi_single>();
		subjectlist=s.single_getData("singleid",beana.getTno());
		kaoshi_single subject=new kaoshi_single();
		subject=subjectlist.get(0);
%>				
<tr>
<td ><%=i+1 %>、（单选题）<%=subject.getSsubject() %></td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="a" disabled >A.<%=subject.getSoptionA() %>
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="b" disabled>B.<%=subject.getSoptionB() %>
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="c" disabled>C.<%=subject.getSoptionC() %>
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="d" disabled>D.<%=subject.getSoptionD() %>
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：<%=subject.getSanswer() %></p>
</td>
</tr>	
		
		
<%}
    if(beana.getType().equals("multi")){
    	ArrayList<kaoshi_multi> subjectlist=new ArrayList<kaoshi_multi>();
    	subjectlist=s.multi_getData("multiid",beana.getTno());
    	kaoshi_multi subject=new kaoshi_multi();  
    	subject=subjectlist.get(0);
%>
<tr>
<td ><%=i+1 %>、（多选题）<%=subject.getMsubject() %>
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="a" disabled>A.<%=subject.getMoptionA() %>
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="b" disabled >B.<%=subject.getMoptionB() %>
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="c" disabled>C.<%=subject.getMoptionC() %>
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="d" disabled>D.<%=subject.getMoptionD() %>
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：<%=subject.getManswer() %></p>
</td>
</tr>




<% 
	}
    if(beana.getType().equals("judgement")){
    	ArrayList<kaoshi_judgement> subjectlist=new ArrayList<kaoshi_judgement>();
    	subjectlist=s.judgement_getData("judgementid",beana.getTno());
    	kaoshi_judgement subject=new kaoshi_judgement();
    	subject=subjectlist.get(0);
%>
<tr>
<td ><%=i+1 %>、（判断题）<%=subject.getJtitle() %>
</td>
</tr>
<tr>
<td>
<input type="radio" name="panduan" value="a" disabled >对
</td>
</tr>
<tr>
<td>
<input type="radio" name="panduan" value="b" disabled>错
</td>
</tr>
<tr>
<td>
<%
String janswer=subject.getJanswer();
if(janswer.equals("true")){ 
	janswer="对";
	}else{janswer="错";} %>
<p class="pred">正确答案：<%=janswer %></p>
</td>
</tr>



<%
	}
    if(beana.getType().equals("blank")){
    	ArrayList<kaoshi_blank> subjectlist=new ArrayList<kaoshi_blank>();
    	subjectlist=s.blank_getData("blankid",beana.getTno());
    	kaoshi_blank subject=new kaoshi_blank();
    	subject=subjectlist.get(0);
%>
<tr>
<td ><%=i+1 %>、（填空题）<%=subject.getBfronttitle() %>：
<input  type="text" name="blankanswer" value="" class="xian" disabled>
<%=subject.getBfronttitle() %>
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：<%=subject.getBanswer() %></p>
</td>
</tr>


<%
	}
}
%>





</table>

<div class="center">
  <ul class="pagination">
    <li><a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=timeorall %>&pagestart=0" <%if(pagestart==0){ %> style="pointer-events: none;"<%} %>>«</a></li>
    <li>
    
    <a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=timeorall %>&pagestart=<%=pagestart-pagecount %>" <%if(pagestart==0){ %> style="pointer-events: none;"<%} %>>❮</a></li>

    <%for(int i=0;i<indexs.size();i++){ %>
    <%if(indexs.get(i)!=((pagestart/pagecount)+1)){ %>
    <li><a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=timeorall %>&pagestart=<%=pagecount*(indexs.get(i)-1)%>">   <%=indexs.get(i)%>   </a></li>
<% }else{ %>
     <li><a class="active"  href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=timeorall %>&pagestart=<%=pagecount*(indexs.get(i)-1)%>">  <%=indexs.get(i) %>  </a></li>
<%}} %>

    <li>
    <a href="WrongServlet?xuehao=<%= xuehao%>&timeorall=<%=timeorall %>&pagestart=<%=pagestart+pagecount %>" <% if(pagestart==pagelast){ %> style="pointer-events: none;"<% }%> >❯</a></li>
    <li><a href="WrongServlet?xuehao=<%=xuehao%>&timeorall=<%=timeorall %>&pagestart=<%=pagelast %>" <%if(pagestart==pagelast){ %> style="pointer-events: none;"<%} %>>»</a></li>
   
  </ul>
</div>
<div class="center">
<table border="0" cellspacing="0" cellpadding="15" style="margin:auto"  >
<tr>
<td >共<%=pageye %>页</td>
<td ><form action="WrongGoto?" onsubmit="return testgoto()"><label>第<input type="text" style="width:35px" name="pageye" id="pageye">页
<input  type="text" name="timeorall" value=<%=timeorall %>  style="display:none">
<input  type="text" name="xuehao" value=<%=xuehao %>  style="display:none">
<input type="submit" value="跳转" ></label></form></td>
</tr>
</table>
</div>
</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









