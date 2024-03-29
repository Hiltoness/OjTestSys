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
<script src="jquery-3.5.1.js"></script>
<script src="javascript/ajax-submit.js"></script>
<script src="javascript/limitless.js"></script>
<style>
        .title{
            display: inline;
        }
        .submitStyle{
        	background-color:#008080;
			color:#ffffff;	
			width:70px;
			height:40px;
			font-size:15px;
			border-style:solid;
			border-color:#ffffff;
			top:25%;
			right:3%;
			position:absolute;
        }
        .floatBottom{
        	position:absolute;
        	top:70%;
        	left:22%;
        }
    </style>
</head>
<body>
<%
	//获取参数
	String xuehao=session.getAttribute("xuehao").toString();//学号

	String kcbianhao=session.getAttribute("kcbianhao").toString();//课程编号
	String gonghao=session.getAttribute("gonghao").toString();//工号
	int tpid=Integer.parseInt(session.getAttribute("tpid").toString());//试卷号
	String tp=Integer.toString(tpid);
	int tno=Integer.parseInt(session.getAttribute("tno").toString());//上一题号
	String c_flag=session.getAttribute("flag").toString();//是否暂存
								   
	int pid=Integer.parseInt(session.getAttribute("pid").toString());//答卷号
	String pp=Integer.toString(pid);
	long start1=Long.parseLong(session.getAttribute("start").toString());// 开始时间
	Timestamp start2=new Timestamp(start1);
	System.out.println(start1);																							 

	//获取试卷的已出题号列表list
	//设置参数
	session.setAttribute("xuehao", xuehao);
	session.setAttribute("tpid",tp);
	session.setAttribute("pid", pp);
	session.setAttribute("kcbianhao", kcbianhao);
	session.setAttribute("gonghao",gonghao);
	session.setAttribute("flag", "false");								   
	
	//获取试卷名
	mysql_operate op=new mysql_operate();
	String testname=op.selectName(tpid);
	
	
%>
	<jsp:include page="maintop.jsp"></jsp:include>
	<div id="container">
		<jsp:include page="mainleft.jsp"></jsp:include>
		<div id="content">
			<h2><%=testname %></h2>
			<div class="float">
			<div style="display:flex">
				<table class="recordFrame" border="1" cellspacing="0" cellpadding="10"
					bordercolor="#ffffff" style="margin: 30px;position:absolute;left:0%">
					<tr>
						<td name="recordFrame" id="r1" class="tdunused"><a href="#t0">1</a></td>
						<td name="recordFrame" id="r2" class="tdunused"><a href="#t1">2</a></td>
						<td name="recordFrame" id="r3" class="tdunused"><a href="#t2">3</a></td>
						<td name="recordFrame" id="r4" class="tdunused"><a href="#t3">4</a></td>
						<td name="recordFrame" id="r5" class="tdunused"><a href="#t4">5</a></td>
					</tr>
					<tr>
						<td name="recordFrame" id="r6" class="tdunused"><a href="#t5">6</a></td>
						<td name="recordFrame" id="r7" class="tdunused"><a href="#t6">7</a></td>
						<td name="recordFrame" id="r8" class="tdunused"><a href="#t7">8</a></td>
						<td name="recordFrame" id="r9" class="tdunused"><a href="#t8">9</a></td>
						<td name="recordFrame" id="r10" class="tdunused"><a href="#t9">10</a></td>
					</tr>
					
				</table>
				<button type="button" form="test" class="submitStyle" onclick="submit_self('1','<%=xuehao %>',<%=pid%>,'<%=kcbianhao %>','<%=gonghao %>');" id="submit_button">提交</button>
				<div class="floatBottom">
					<span>已用时间：</span><div style="display:contents;height: 30px;width:30px;"><span style="width:50px" id="timer"></span></div>
				</div>
				</div>
				
			</div>
			<div class="left">
			<%
				for(int i=0;i<10;i++){
			%>
					<div class="topic" style="display: none;">
						<span class="tnum"></span><a  >&nbsp;&nbsp;</a><label class="title"></label> 
						<span style="display: none;" class="idset" name="" data-tid="" data-type="" data-tno=""></span> 
						<input class="input1" type="" value="a" form="test" name="" /><label class="option1"></label> 
						<input class="input2" type="" value="b" form="test" name="" /><label class="option2"></label> 
						<input class="input3" type="" value="c" form="test" name="" /><label class="option3"></label> 
						<input class="input4" type="" value="d" form="test" name="" /><label class="option4"></label>
					</div>
		<%
				}
		%>
					<form id="test" action="" method="">
						<button type="button" class="submitlv" onclick="submit_self('0','<%=xuehao %>',<%=pid%>,'<%=kcbianhao %>','<%=gonghao %>');" id="next_button">下一页</button>
				        
				    </form>
					 <%--<form  method="post" action="LimitlessTest.jsp" id ="tnoForm"> 
				     	<input id ="tno" type ="hidden" name="tno"> 
				     </form>   --%>

			</div>

		</div>
	</div>
	<jsp:include page="mainfoot.jsp"></jsp:include>
<script>
window.addEventListener("onbeforeunload",function(){
	if(window.confirm("是否要离开答题页面")){
        return true;
    }else{
        return false;
    }
});
	var start2="<%=start2%>"//开始时间
		var date1=start2.replace(/-/g,'/');
		var time_str=new Date(date1);
		var start1=time_str.getTime().toString().substring(0, 10);
		console.log(start1)
		var time_begin=new Date(start1*1000)
		console.log(time_begin)
		var status="origin"
		var tno_l="<%=tno%>";//上一题号
		var xuehao= "<%=xuehao%>";//全局-学号
		var kcbianhao="<%=kcbianhao%>";//课程编号
		var gonghao="<%=gonghao%>";//教师工号
		var tpid=<%=tpid%>;//试卷号
		
		var c_flag="<%=c_flag%>";//暂存标记

			
			console.log(tpid)
			console.log(tno_l)
			
			//获取题目数据
			function c(){
				var tlist=arguments[0]
				showT(tlist)
			}
			function getLast(){
				var pid=<%=pid%>
				$.ajax({
					url:"ContinueTopic",
					type:"post",
					data:{"xuehao":xuehao,
						"pid":pid},
					success:function(data){
						if(data.length==0){
							getNew()
						}else{
							c(data)
						}
						
					},
					error:function(){
						
					}
				})
			}
			function getNew(){
				alist=""
				console.log("ajax获取")
					$.ajax({
						url:"GetTopic",
						type:"post",
						data:{"xuehao":xuehao,
							"tpid":tpid,
							"kcbianhao":kcbianhao,
							"gonghao":gonghao,
							"tlist":alist},
							  
						success:function(data){
							console.log("获取");
							c(data);
						},
						error:function(){
							
						}
					})
			}
			if(c_flag==="true"){//暂存
				console.log("暂存")
				getLast()

				c_flag="false"
			}else if(status==="origin"){//新建
				console.log(status)
				getNew()
				status="next"
				}
			//显示题目
		    var tDiv=$(".topic");
		    function showT(){
				var ttlist=arguments[0]
				if(ttlist.length==0){
					alert("你已抽空题库")
				}else{
				console.log(ttlist)
				//t1list=(JSON.parse(ttlist))
				$(".recordFrame").find("td").attr("class","tdunused");
					
				
				for(var i=0;i<tDiv.length;i++){
					(function(current){
						$(current).find("*").css("display","none");
						$(current).find("*").off();
						$(current).find("*").val("");
						var v="";
			            var type=ttlist[i].type;
			            var id=ttlist[i].id;
			            var title=ttlist[i].title;
			            var a=ttlist[i].a;
			            var b=ttlist[i].b;
			            var c=ttlist[i].c;
			            var d=ttlist[i].d;
			            v=ttlist[i].value;
			            var name="t"+i;
			            var input_name="i"+i;
			            var record="r"+(i+1);
			            tno_l=Number(tno_l)+1;
						
			            console.log(tno_l)
			            $(current).find(".idset").attr("data-tid",id);
			            $(current).find(".idset").attr("data-type",type);
			            $(current).find(".idset").attr("data-tno",tno_l);
			            $(current).find(".idset").attr("name",name);
			            $(current).find("a").attr("name",name);
			            $(current).find("a").css("display","inline");
			            $(current).find(".tnum").text(tno_l);
			            $(current).find(".tnum").css("display","inline");
			            $(current).find("input").val("");
			            for(var k=0;k<$(current).find("input ").length;k++){
		            		$(current).find("input")[k].checked=false;
		            		
		            	}
			            switch(type) {
			            case "single"://单选
			                $(current).find(".title").text(title);
			                $(current).find("input").attr("type","radio");
			                $(current).find("input[type=radio]").attr("name",input_name);
			                $(current).find(".input1").val("a");
			                $(current).find(".input2").val("b");
			                $(current).find(".input3").val("c");
			                $(current).find(".input4").val("d");
			                $(current).find(".option1").text("A."+a);
			                $(current).find(".option2").text("B."+b);
			                $(current).find(".option3").text("C."+c);
			                $(current).find(".option4").text("D."+d);
			                $(current).find("label").append("<br/>");
			                $(current).find("input[type=radio]").css("display","inline-block");
			                $(current).find("label").css("display","inline");
			                 
			                current.style.display="block";
			                $(current).find("input[type=radio]").on("input",function(){
			                	if(v!=""){
				                	$(current).find("input[type=radio][value="+v+"]").attr("checked","checked");
				                	values=$("input[type=radio][name="+input_name+"]:checked").val();
				                    console.log(values);
				                }
			                    $("#"+record).removeClass("tdunused");
			                })
			                
			                break;
			            
			            case "judgement"://判断
			                $(current).find(".title").text(title);
			                $(current).find(".title").css("display","inline");
			                $(current).find("input").attr("type","radio");
			                $(current).find("input[type=radio]").attr("name",input_name);
			                $(current).find(".option1").text("对");
			                $(current).find(".option2").text("错");
			                $(current).find(".option1").css("display","inline");
			                $(current).find(".option2").css("display","inline");
			                $(current).find(".input1").val("true");
			                $(current).find(".input2").val("false");
			                $(current).find(".input1").css("display","inline-block");
			                $(current).find(".input2").css("display","inline-block");
			                 
			                $(current).find("label").append("<br/>");
			                current.style.display="block";
			                $(current).find("input[type=radio]").on("input",function(){
			                	if(v !=""){
			    	                $(current).find("input[type=radio][value="+v +"]").attr("checked","checked");
			    	                }
			                    $("#"+record).removeClass("tdunused");
			                })
			                break;
			            case "multi"://多选
			                $(current).find(".title").text(title);
			                $(current).find("input").attr("type","checkbox");
			                $(current).find("input[type=checkbox]").attr("name",input_name);
			                $(current).find(".input1").val("a");
			                $(current).find(".input2").val("b");
			                $(current).find(".input3").val("c");
			                $(current).find(".input4").val("d");
			                $(current).find(".option1").text("A."+a);
			                $(current).find(".option2").text("B."+b);
			                $(current).find(".option3").text("C."+c);
			                $(current).find(".option4").text("D."+d);
			                $(current).find("input[type=checkbox").css("display","inline-block");
			                $(current).find("label").css("display","inline");
			                $(current).find("input[type=checkbox]").on('input',function(){
			                	if(v!=""){
			    	                let v2=v.split('')
			                        console.log(v2)
			                        for(var j in v2){
			                            $(current).find("input[type=checkbox][value="+v2[j]+"]").attr("checked","checked")
			                        }
			    	                }
			                })
			                $(current).find("label").append("<br/>");
			                current.style.display="block";
			                $(current).find("input[type=checkbox]").change(function(){
			                	if($("input[type=checkbox][name="+input_name+"]:checked").length>0){
			                		$("#"+record).removeClass("tdunused");
			                	}else{
			                		$("#"+record).addClass("tdunused");
			                	}
			                })
			                break;
			            case "blank":
			            	$(current).find("input").attr("type","text");
			                if(a !=null){
			                    $(current).find(".option1").text(a);
			                    $(current).find(".option1").css("display","inline");
			                }
			                if(b!=null){
			                    $(current).find(".option2").text(b);
			                    $(current).find(".option2").css("display","inline");
			                }
			                $(current).find(".input2").val("");
			                $(current).find(".input2").css("display","inline");
			                $(current).find("input[type=text]").attr("name",input_name);
		                	 
			                current.style.display="flex";
			                $(current).find(".input2").on("input",function(){
			                	if($(current).find(".input2").val()!=""){
			                		var v1=$(current).find(".input2").val();
			                		$("input[name="+input_name+"]").val(v1);
			                		console.log($("input[name="+input_name+"]").val());
				                	$("#"+record).removeClass("tdunused");
				                }else{
				                	$("#"+record).addClass("tdunused");
				                }
			                	//$("#"+record).toggleClass("tdunused");
			                })
			                break;
			            default:
			                console.log("")
			    }; 
			        })(tDiv[i])
				};
				}
					//$("#tno").val(tno_l);
					//$("#tnoForm").submit();
			}
			

		    setInterval("save_veri('<%=xuehao%>',<%=pid%>)",60000);
		    


</script>

</body>

</html>








