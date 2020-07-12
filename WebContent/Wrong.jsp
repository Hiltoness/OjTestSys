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
<script type="text/javascript">
function mathPages(index,totalpage){
	var indexs [];
	for(var i=1;i<=totalpage;i++){
		indexs.push(i);
	}
	if(totalpage<=5){
		return indexs;
	}
	if(index<=2){
		indexs=indexs.slice(0,5);
		return indexs;
	}else{
		var indexs2=indexs.slice(index-2,index+3);
		if(indexs2.length>=5){
			return indexs2;
		}
		else{
			indexs2=indexs.slice(-5);
			return indexs2
		}
	}
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
  <button class="dropbtn">全部错题</button>
  <div class="dropdown-content">
  <a href="#">全部错题</a>
    <a href="#">2019-2020</a>
    <a href="#">2020-2021</a>    
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
    <li><a href="#">«</a></li>
    <li><a href="#">❮</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a class="active"  href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">❯</a></li>
    <li><a href="#">»</a></li>
   
  </ul>
</div>
<div class="center">
<table border="0" cellspacing="0" cellpadding="15" style="margin:auto"  >
<tr>
<td >共3页</td>
<td ><form action=""><label>第<input type="text" style="width:35px">页<input type="submit" value="跳转" ></label></form></td>
</tr>
</table>
</div>
</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>

</html>









