<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javabean.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试系统</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>

<div id="my">
<h3 class="myh3">系统功能</h3>
<ul style="padding: 0">

<li class="total">
<strong class="mystrong">我的</strong> 
</li>
<li class="part">
<a  href="ChooseServlet?xuehao=<%="001"%>" class="aleft">选课信息</a>
</li>
<li class="part">
<a href="WrongServlet?xuehao=<%="001"%>&timeorall=<%="all"%>&pagestart=0" class="aleft">我的错题</a>
</li>

<li class="total">
<strong class="mystrong">考试</strong>
</li>
<li class="part">
<a  href="Lgoto?xuehao=<%="001"%>&timeorall=<%="all"%>&pattern=<%="unfinish" %>" class="aleft">未完成</a>
</li>
<li class="part">
<a  href="Lgoto?xuehao=<%="001"%>&timeorall=<%="all"%>&pattern=<%="finish" %>" class="aleft">已完成</a>
</li>

</ul>

</div>


</body>

</html>








