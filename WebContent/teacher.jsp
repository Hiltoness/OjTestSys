<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javabean.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/teacher.css"/>
<script type="text/javascript" src="http://localhost:8080/OjTestSys/jquery-3.5.1.js"></script>
<script src="javascript/teacher-ajax.js"></script>
<title>试卷管理</title>
</head>
<body>
	<%
		request.setAttribute("gonghao", "30003499");
		mysql_teacher operate_tea=new mysql_teacher();
		String gonghao="30003499";
		Map<String,String> typeS=new HashMap<String,String>(){
			{put("limit","限时");
			put("limitless","无限");}
		};
	%>
	<div class="container">
	<span style="float:right"><%=gonghao %>老师您好</span>
		<div class="testList">
			<div class="head">
				<div class="nums">序号</div>
				<div class="kcbianhao">课程编号</div>
				<div class="name">试卷名称</div>
				<div class="type">试卷类型</div>
				<div class="start">开始时间</div>
				<div class="end">结束时间</div>
				<div class="times">可做次数</div>
				<div class="operate">操作</div>
			</div>
			<div class="content">
			<%
				ArrayList<TeaTest> testlist=operate_tea.show_teatest(gonghao);
				for(int i=0;i<testlist.size();i++){
					TeaTest curr=testlist.get(i);
					%>
				<div class="row">
					<div class="nums"><%=i+1 %></div>
					<div class="kcbianhao"><%=curr.getKcbianhao() %></div>
					<div class="name"><%=curr.getName() %></div>
					<div class="type"><%=typeS.get(curr.getTtype()) %></div>
					<div class="start"><%=curr.getStart() %></div>
					<div class="end"><%=curr.getEnd() %></div>
					<div class="times"><%=curr.getTimes() %></div>
					<div class="operate">
						<a href="javascript:teacher_delete(<%=curr.getTpid()%>)">删除</a>
					</div>
				</div>
				<% 
				}
				int nums=testlist.size();
				%>
				</div>
				<div class="row">
					<div class="nums"><%=nums+1 %></div>
					<div class="kcbianhao"><input type="text" id="kcbianhao" name="kcbianhao"></div>
					<div class="name"><input type="text" id="tname" name="tname"></div>
					<div class="type"><input type="radio" name="ttype" value="limit" />限时  &nbsp<input type="radio" name="ttype" value="limitless" />无限</div>
					<div class="start"><input type="datetime-local" id="start" name="start"></div>
					<div class="end"><input type="datetime-local" id="end" name="end"></div>
					<div class="times"><input type="number" id="times" name="times" min="1" max="50"></div>
					<div class="operate">
						<a href="javascript:teacher_add(<%=gonghao%>)">添加</a>
					</div>
				</div>
		</div>
	</div>
</body>
</html>