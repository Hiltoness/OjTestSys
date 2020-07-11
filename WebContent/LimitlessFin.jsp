<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试系统</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>
<div class="limit">
<form action="" method="post">
<table border="0" cellspacing="0" cellpadding="15"  >
<tr>
<td ><input type="button" value="未完成"   class="bunone"/>
</td>
<td ><input type="button" value="已完成"  class="bugreen"/>
</td>
<td ><select>
<option value="2019-2020-1">2019-2020-1</option>
<option value="2019-2020-2">2019-2020-2</option>
</select>
</td>
</tr>
</table>
</form>
</div>
<div id="content">

<table border="0" cellspacing="0" cellpadding="20"  >
<tr>
<td class="tdcenter">考卷名称</td>
<td class="tdcenter">老师</td>
<td class="tdcenter">次数</td>
<td class="tdcenter">分数</td>
<td class="tdcenter">正确率</td>
<td class="tdcenter">操作</td>
</tr>

<tr>
<td>2019-2020年可视化信息交互设计</td>
<td>刘老师</td>
<td>1</td>
<td>97</td>
<td>90%</td>

<td><a  href="">我的答卷</a></td>
</tr>
<tr>
<td>2019-2020年可视化信息交互设计哈哈哈</td>
<td>哈哈哈</td>
<td>1</td>
<td>97</td>
<td>90%</td>
<td><a  href="">我的答卷</a></td>
</tr>
</table>
</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









