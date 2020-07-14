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

<%
String timeorall=request.getParameter("timeorall");
String all="all";
if(timeorall.compareTo("all")==0){
	timeorall="全部错题";
}
int pagestart=Integer.parseInt(request.getParameter("pagestart"));
int pagetotal=100;
int pagecount=5;
page1 p=new page1();
int pagelast=p.getLast(pagetotal,pagecount);
int pageye=p.getTotalPage(pagetotal,pagecount);
ArrayList<Integer> indexs=new ArrayList<Integer>();
if(pagetotal<=5){
	for(int i=1;i<=pageye;i++){
	     indexs.add(i);
	}
}else{
	if(pagestart<(2*pagecount)){
		for(int i=1;i<=5;i++){
		     indexs.add(i);
		}
	}else{
		if(pagestart>=(pagelast-2*pagecount)){
			for(int i=0;i<5;i++){
				int j=pageye-i;
			     indexs.add(j);
			}
		}else{
			int currentpage=(pagestart/pagecount)+1;
			for(int i=-2;i<=2;i++){
			     indexs.add(currentpage+i);
			}
		}
	}
}

%>

<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>
<div class="limit">
<form action="" method="post">
<table border="0" cellspacing="0" cellpadding="15"  >
<tr>
<td >
<div class="dropdown">
  <button class="dropbtn"><%=timeorall %></button>
  <div class="dropdown-content">
    <a href="Wrongservlet?timeorall=<%=all%>&pagestart=0">全部错题</a>
    <a href="Wrong.jsp?timeorall=&pagestart=0">2019-2020</a>
    <a href="Wrong.jsp?timeorall=“2020-2021”&pagestart=0">2020-2021</a>    
     
  </div>
</div>
</td>

</tr>
</table>
</form>
</div>
<div id="content">

<table border="0" cellspacing="0" cellpadding="10"  >
<tr>
<td >1、（单选题）2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加
2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="a" disabled checked>A.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="b" disabled>B.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="c" disabled>C.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="radio" name="danxuan" value="d" disabled>D.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：（错误）</p>
</td>
</tr>
<tr>
<td >2、（多选题）2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加
2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="a" disabled checked>A.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="b" disabled checked>B.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="c" disabled>C.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<input type="checkbox" name="duoxuan" value="d" disabled>D.90%大多所发生的规范化和健康还健康还健康还根据根据数
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：（错误）</p>
</td>
</tr>
<tr>
<td >3、（判断题）2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加
2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加</td>
</tr>
<tr>
<td>
<input type="radio" name="panduan" value="a" disabled checked>对
</td>
</tr>
<tr>
<td>
<input type="radio" name="panduan" value="b" disabled>错
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：（错误）</p>
</td>
</tr>

<tr>
<td >4、（填空题）2019-2020年可视化信息交互设计方法是：
<input  type="text" name="" value="哈哈哈" class="xian" disabled>
</td>
</tr>
<tr>
<td>
<p class="pred">正确答案：（错误）</p>
</td>
</tr>
</table>

<div class="center">
  <ul class="pagination">
    <li><a href="wrongservlet?timeorall=<%=timeorall %>&pagestart=0">«</a></li>
    <li<% if(pagestart==0){%>class="disabled"<%} %>>><a href="wrongservlet?timeorall=<%=timeorall %>&pagestart=<%=pagestart-pagecount %>">❮</a></li>
    <%for(int i=1;i<=5;i++){ int ps=pagecount*(indexs.get(i)-1);if(i==3){%>
    <li><a class="active"  href="wrongservlet?timeorall=<%=timeorall %>&pagestart=<%=ps%>"><%=indexs.get(i) %></a></li>
    <%}else{ %>
    <li><a href="wrongservlet?timeorall=<%=timeorall %>&pagestart=<%=ps%>"><%=indexs.get(i) %></a></li>
    <%}} %>

    <li <% if(pagestart==pagelast){%>class="disabled"<%} %>><a href="wrongservlet?timeorall=<%=timeorall %>&pagestart=<%=pagestart+pagecount %>">❯</a></li>
    <li><a href="wrongservlet?timeorall=<%=timeorall %>&pagestart=<%=pagelast %>">»</a></li>
   
  </ul>
</div>
<div class="center">
<table border="0" cellspacing="0" cellpadding="15" style="margin:auto"  >
<tr>
<td >共<%=pageye %>页</td>
<td ><form action="wrongservlet?timeorall=<%=timeorall %>"><label>第<input type="text" style="width:35px">页<input type="submit" value="跳转" ></label></form></td>
</tr>
</table>
</div>
</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









