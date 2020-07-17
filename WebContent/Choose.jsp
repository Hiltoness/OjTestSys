<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javabean.*" %> 
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试系统</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<%String xuehao=session.getAttribute("xuehao").toString(); 
mysql_search_canshu s=new mysql_search_canshu();
ArrayList<select> select=new ArrayList<select>();
select=s.select_getData("xuehao",xuehao);
%>
<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>
<div id="content">
<table border="0" cellspacing="0" cellpadding="20"  style="margin:30px">
<tr>
<td class="tdcenter">课程名称</td>
<td class="tdcenter">老师</td>
</tr>
<%for(int i=0;i<select.size();i++){ 
select beans=new select();
beans=select.get(i);
kc beank=new kc();
teacher beant=new teacher();
ArrayList<kc> kc=new ArrayList<kc>();
ArrayList<teacher> teacher=new ArrayList<teacher>();
kc=s.kc_getData("kcbianhao",beans.getKcbianhao());
teacher=s.teacher_getData("gonghao",beans.getGonghao());
beank=kc.get(1);
beant=teacher.get(1);
%>
<tr>
<td><%=beank.getKcname() %></td>
<td><%=beant.getGname() %></td>
</tr>
<%} %>

</table>

</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









