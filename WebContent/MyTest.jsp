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
<script type="text/javascript" src="http://localhost:8080/OjTestSys/jquery-3.5.1.js"></script>
</head>
<body>
<style>
.title{
            display: inline;
        }
</style>

<%
	//获取参数
	String xuehao=session.getAttribute("xuehao").toString();//学号
	String kcbianhao=session.getAttribute("kcbianhao").toString();//课程编号
	String gonghao=session.getAttribute("gonghao").toString();//工号
	int pid=Integer.parseInt(session.getAttribute("pid").toString());//答卷号
	//获取试卷名
	mysql_operate op=new mysql_operate();
	String testname=op.selectName(pid);
%>
<jsp:include page="maintop.jsp"></jsp:include>
<div id="container">
<jsp:include page="mainleft.jsp"></jsp:include>

<div id="content">
	<h2><%=testname %></h2>
			
			<div class="left">
			<% 
				for(int i=0;i<1000;i++){
					%>
					<div class="topic" style="display: none;">
						<span class="tnum"></span>&nbsp;&nbsp;<label class="title"></label> 
						<input style="display: none;" class="idset" name="" data-tid="" data-type="" data-tno=""/> 
						<input class="input1" type="" value="a" name="" /><label class="option1"></label> 
						<input class="input2" type="" value="b" name="" /><label class="option2"></label> 
						<input class="input3" type="" value="c" name="" /><label class="option3"></label> 
						<input class="input4" type="" value="d" name="" /><label class="option4"></label>
						<span style="display:inline-flex">正确答案：</span><span class="answer"></span>
					</div>
					<%
						}
					%>

			</div>


</div>
</div>
<jsp:include page="mainfoot.jsp"></jsp:include>
</body>
<script>
var xuehao="<%=xuehao%>";//全局-学号
var kcbianhao="<%=kcbianhao%>";//课程编号
var gonghao="<%=gonghao%>";//教师工号
var tpid=<%=pid%>;//试卷号
//获取题目数据
function c(){
	var tlist=arguments[0]
	showT(tlist)
}
$.ajax({
	url:"CreatePage",
	type:"post",
	data:{"xuehao":xuehao,
		"pid":tpid},
	success:function(data){
		c(data)
	},
	error:function(){
		
	}
})
//显示题目
var tDiv=$(".topic");
function showT(){
	var ttlist=arguments[0]
	console.log(ttlist)
	for(var i=0;i<tDiv.length;i++){
		(function(current){
            var type=ttlist[i].type;
            var id=ttlist[i].id;
            var title=ttlist[i].title;
            var a=ttlist[i].a;
            var b=ttlist[i].b;
            var c=ttlist[i].c;
            var d=ttlist[i].d;
            var v=ttlist[i].value;
            var ans=ttlist[i].answer;
            var name="t"+i;
            var input_name="i"+i;
            var record="r"+(i+1);
            var tno_l=i+1;

            $(current).find(".idset").attr("data-tid",id);
            $(current).find(".idset").attr("data-type",type);
            $(current).find(".idset").attr("data-tno",tno_l);
            $(current).find(".idset").attr("name",name);
            $(current).find(".answer").text(ans);
            $(current).find(".tnum").text(tno_l);
            switch(type) {
            case "single"://单选
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","radio");
                $(current).find("input[type=radio]").attr("name",input_name);
                $(current).find(".option1").text(a);
                $(current).find(".option2").text(b);
                $(current).find(".option3").text(c);
                $(current).find(".option4").text(d);
                $(current).find("label").append("<br/>");
                if(v!=""){
                	$(current).find("input[type=radio][value="+v+"]").attr("checked","checked");
                }
                current.style.display="block";
                $(current).find("input[type=radio]").on("input",function(){
                    $("#"+record).removeClass("tdunused");
                })
                
                break;
            
            case "judgement"://判断
                $(current).find(".option3").css("display","none");
                $(current).find(".option4").css("display","none");
                $(current).find(".input3").css("display","none");
                $(current).find(".input4").css("display","none");
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","radio");
                $(current).find("input[type=radio]").attr("name",input_name);
                $(current).find(".option1").text("对");
                $(current).find(".option2").text("错");
                $(current).find(".input1").val("true");
                $(current).find(".input2").val("false");
                if(v!=""){
                $(current).find("input[type=radio][value="+v+"]").attr("checked","checked");
                }
                $(current).find("label").append("<br/>");
                current.style.display="block";
                $(current).find("input[type=radio]").on("input",function(){
                    $("#"+record).removeClass("tdunused");
                })
                break;
            case "multi"://多选
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","checkbox");
                $(current).find("input[type=checkbox]").attr("name",input_name);
                $(current).find(".option1").text(a);
                $(current).find(".option2").text(b);
                $(current).find(".option3").text(c);
                $(current).find(".option4").text(d);
                if(v!=""){
                let v2=v.split('')
                console.log(v2)
                for(var j in v2){
                    $(current).find("input[type=checkbox][value="+v2[j]+"]").attr("checked","checked")
                }
                }
                $(current).find("label").append("<br/>");
                current.style.display="block";
                $(current).find("input[type=checkbox]").click(function(){
                    $("#"+record).toggleClass("tdunused");
                })
                break;
            case "blank":
                $(current).find(".option3").css("display","none");
                $(current).find(".option4").css("display","none");
                $(current).find(".input1").css("display","none");
                $(current).find(".input3").css("display","none");
                $(current).find(".input4").css("display","none");
                $(current).find(".title").css("display","none");
                if(a !=null){
                    $(current).find(".option1").text(a);
                }else if(a==null){
                    $(current).find(".option1").css("display","none");
                }
                if(b!=null){
                    $(current).find(".option2").text(b);
                }else if(b==null){
                    $(current).find(".option2").css("display","none");
                }
                $(current).find(".input2").attr("type","text");
                $(current).find(".input2").attr("value","");
                $(current).find("input[type=text]").attr("name",input_name);
                if(v!=""){
                $(current).find("input[type=text]").val(v)}
                current.style.display="flex";
                $(current).find("input[type=text]").on("input",function(){
                    $("#"+record).toggleClass("tdunused");
                })
                break;
            default:
                console.log("")
    }; 
        })(tDiv[i])
	};

}
</script>
</html>









