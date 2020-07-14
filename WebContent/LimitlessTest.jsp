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
		<div id="content">
			<h2>XX答卷</h2>
			<div class="float">
				<table border="1" cellspacing="0" cellpadding="10"
					bordercolor="#ffffff" style="margin: 30px">
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>6</td>
						<td class="tdunused">7</td>
						<td class="tdunused">8</td>
						<td class="tdunused">9</td>
						<td class="tdunused">10</td>
					</tr>
				</table>
			</div>
			<div class="left">
				<form action="" method="post">
					<table border="0" cellspacing="0" cellpadding="10">
					<%
					for(int i=0;i<list.size;i++){
						String title;
						String one;
						String two;
						String three;
						String four;
						String type;
						int tno;
					%>
						<tr>
							<td><%=title %></td>
						</tr>
						<tr>
							<td>
							<input type=<%=type %> name="danxuan" value="a">A.<%=one %>
							</td>
						</tr>
						<tr>
							<td>
							<input type=<%=type %> name="danxuan" value="b">B.<%=two %>
							</td>
						</tr>
						<tr>
							<td>
							<input type=<%=type %> name="danxuan" value="c">C.<%=three %>
							</td>
						</tr>
						<tr>
							<td>
							<input type=<%=type %> name="danxuan" value="d">D.<%=four %>
							</td>
						</tr>
						<%
						}
						%>
						<tr>
							<td>2、（多选题）2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加
								2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="duoxuan" value="a">A.90%大多所发生的规范化和健康还健康还健康还根据根据数
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="duoxuan" value="b">B.90%大多所发生的规范化和健康还健康还健康还根据根据数
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="duoxuan" value="c">C.90%大多所发生的规范化和健康还健康还健康还根据根据数
							</td>
						</tr>
						<tr>
							<td><input type="checkbox" name="duoxuan" value="d">D.90%大多所发生的规范化和健康还健康还健康还根据根据数
							</td>
						</tr>
						<tr>
							<td>3、（判断题）2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加
								2019-2020年可视化信息交互设计方法方法付斤斤计较军加加加加加加</td>
						</tr>
						<tr>
							<td><input type="radio" name="panduan" value="a">对</td>
						</tr>
						<tr>
							<td><input type="radio" name="panduan" value="b">错</td>
						</tr>

						<tr>
							<td>4、（填空题）2019-2020年可视化信息交互设计方法是： <input type="text"
								name="" placeholder="请输入答案" class="xian">
							</td>
						</tr>
					</table>
					<table border="0" cellspacing="0" cellpadding="60"
						style="margin: auto">
						<tr>
							<td><input type="submit" value="下一页" class="submitlv"></td>
							<td><input type="submit" value="提交" class="submitlv"></td>
						</tr>
					</table>

				</form>

			</div>

		</div>
	</div>
	<jsp:include page="mainfoot.jsp"></jsp:include>
<script>
	type:{"blank":"text",
		"judgement":"radio",
		"multi":"checkbox",
		"single":"radio"},
	

</script>
</body>

</html>








