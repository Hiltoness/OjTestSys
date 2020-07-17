<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试系统</title>
<link rel="stylesheet" href="css/main.css">
<script src="jquery-3.5.1.js"></script>
<script src="javascript/ajax-submit.js"></script>
<script src="javascript/limitless.js"></script>
<style>
        .title{
            display: block;
        }
    </style>
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
						<td id="r1" class="tdunused"><a href="#t0">1</a></td>
						<td id="r2" class="tdunused"><a href="#t1">2</a></td>
						<td id="r3" class="tdunused"><a href="#t2">3</a></td>
						<td id="r4" class="tdunused"><a href="#t3">4</a></td>
						<td id="r5" class="tdunused"><a href="#t4">5</a></td>
					</tr>
					<tr>
						<td id="r6" class="tdunused"><a href="#t5">6</a></td>
						<td id="r7" class="tdunused"><a href="#t6">7</a></td>
						<td id="r8" class="tdunused"><a href="#t7">8</a></td>
						<td id="r9" class="tdunused"><a href="#t8">9</a></td>
						<td id="r10" class="tdunused"><a href="#t9">10</a></td>
					</tr>
				</table>
				<span>已用时间：</span><span id="timer"></span>
			</div>
			<div class="left">
			<% 
				for(int i=0;i<8;i++){
						String title;
						String one;
						String two;
						String three;
						String four;
						String type;
						int tno;
					%>
					<div class="topic" style="display: none;">
						<label class="title"></label> 
						<input style="display: none;" class="idset" name="" data-tid="" data-type="" /> 
						<input class="input1" type="" value="a" form="test" name="" /><label class="option1"></label> 
						<input class="input2" type="" value="b" form="test" name="" /><label class="option2"></label> 
						<input class="input3" type="" value="c" form="test" name="" /><label class="option3"></label> 
						<input class="input4" type="" value="d" form="test" name="" /><label class="option4"></label>
					</div>
					<%
						}
						%>
					<form id="test" action="" method="">
				        <button type="submit" onclick="submit_self()" id="submit_button"></button>
				    </form>
					

			</div>

		</div>
	</div>
	<jsp:include page="mainfoot.jsp"></jsp:include>
<script>
window.onload=function(){
	//测试数据
    var list=[{"type":"single","id":"10","title":"第一题","a":"答案A","b":"答案B","c":"答案C","d":"答案D"},
    {"type":"single","id":"11","title":"第二题","a":"答案aA二","b":"答案B","c":"答案C","d":"答案D"},
    {"type":"judge","id":"10","title":"第三题","a":"错","b":"对"},
    {"type":"multi","id":"10","title":"第四题","a":"答案A四","b":"答案B","c":"答案C","d":"答案D"},
    {"type":"blank","id":"10","title":"第5题","a":"前面的内容","b":"后面的内容"}]

    //显示题目
    var tDiv=$(".topic");
    for(var i=0;i<tDiv.length;i++){
        (function(current){
            var type=list[i].type;
            var id=list[i].id;
            var title=list[i].title;
            var a=list[i].a;
            var b=list[i].b;
            var c=list[i].c;
            var d=list[i].d;
            var name="t"+i;
            var input_name="i"+i;

            switch(type) {
            case "single"://单选
                $(current).find(".idset").attr("data-tid",id);
                $(current).find(".idset").attr("data-type",type);
                $(current).find(".idset").attr("name",name);
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","radio");
                $(current).find("input[type=radio]").attr("name",input_name);
                $(current).find(".option1").text(a);
                $(current).find(".option2").text(b);
                $(current).find(".option3").text(c);
                $(current).find(".option4").text(d);
                $(current).find("label").append("<br/>");
                current.style.display="block";
                $(current).find("input[type=radio]").on("input",function(){
                    $("#"+record).removeClass("tdunused");
                })
                
                break;
            
            case "judge"://判断
                $(current).find(".option3").css("display","none");
                $(current).find(".option4").css("display","none");
                $(current).find(".input3").css("display","none");
                $(current).find(".input4").css("display","none");
                $(current).find(".idset").attr("data-tid",id);
                $(current).find(".idset").attr("data-type",type);
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","radio");
                $(current).find("input[type=radio]").attr("name",input_name);
                $(current).find(".option1").text("对");
                $(current).find(".option2").text("错");
                $(current).find(".option1").val("true");
                $(current).find(".option2").val("false");
                $(current).find("label").append("<br/>");
                current.style.display="block";
                $(current).find("input[type=radio]").on("input",function(){
                    $("#"+record).removeClass("tdunused");
                })
                break;
            case "multi"://多选
                $(current).find(".idset").attr("data-tid",id);
                $(current).find(".idset").attr("data-type",type);
                $(current).find(".idset").attr("name",name);
                $(current).find(".title").text(title);
                $(current).find("input").attr("type","checkbox");
                $(current).find("input[type=checkbox]").attr("name",input_name);
                $(current).find(".option1").text(a);
                $(current).find(".option2").text(b);
                $(current).find(".option3").text(c);
                $(current).find(".option4").text(d);
                $(current).find("label").append("<br/>");
                current.style.display="block";
                $(current).find("input[type=checkbox]").click(function(){
                    $("#"+record).removeClass("tdunused");
                })
                break;
            case "blank":
                $(current).find(".option3").css("display","none");
                $(current).find(".option4").css("display","none");
                $(current).find(".input1").css("display","none");
                $(current).find(".input3").css("display","none");
                $(current).find(".input4").css("display","none");
                $(current).find(".title").css("display","none");
                $(current).find(".idset").attr("data-tid",id);
                $(current).find(".idset").attr("data-type",type);
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
                current.style.display="flex";
                $(current).find("input[type=text]").on("input",function(){
                    $("#"+record).toggleClass("tdunused");
                })
                break;
            default:
                console.log("1")
    } 
        })(tDiv[i])
    };

    var saveAjax=setInterval(save_veri,30000);
    
}
</script>
</body>

</html>








