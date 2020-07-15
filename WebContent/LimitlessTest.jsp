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
					<div class="topic" style="display: none;">
						<label class="title"></label> 
						<input style="display: none;" class="idset" name="" data-tid="" data-type="" /> 
						<input class="input1" type="" value="a" form="test" name="" /><label class="option1"></label> 
						<input class="input2" type="" value="b" form="test" name="" /><label class="option2"></label> 
						<input class="input3" type="" value="c" form="test" name="" /><label class="option3"></label> 
						<input class="input4" type="" value="d" form="test" name="" /><label class="option4"></label>
					</div>
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
						<form id="test" action="" method="">
					        <button type="submit" onclick="submit_veri()" id="submit_button"></button>
					    </form>
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
	var type={"blank":"text",
		"judgement":"radio",
		"multi":"checkbox",
		"single":"radio"};
	

</script>
<script>
    window.onload=function(){
        var list=[{"type":"single","id":"10","title":"第一题","a":"答案A","b":"答案B","c":"答案C","d":"答案D"},
        {"type":"single","id":"11","title":"第二题","a":"答案aA二","b":"答案B","c":"答案C","d":"答案D"},
        {"type":"judge","id":"10","title":"第三题","a":"错","b":"对"},
        {"type":"multi","id":"10","title":"第四题","a":"答案A四","b":"答案B","c":"答案C","d":"答案D"},
        {"type":"blank","id":"10","title":"第5题","a":"前面的内容","b":"后面的内容"},
    ]
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
                    current.style.display="flex";
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
                    break;
                
                case "judge"://判断
                    $(current).find(".option3").css("display","none");
                    $(current).find(".option4").css("display","none");
                    $(current).find(".input3").css("display","none");
                    $(current).find(".input4").css("display","none");
                    current.style.display="flex";
                    $(current).find(".idset").attr("data-tid",id);
                    $(current).find(".idset").attr("data-type",type);
                    $(current).find(".title").text(title);
                    $(current).find("input").attr("type","radio");
                    $(current).find("input[type=radio]").attr("name",input_name);
                    $(current).find(".option1").text("对");
                    $(current).find(".option2").text("错");
                    break;
                case "multi"://多选
                    current.style.display="flex";
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
                    break;
                default:
                    console.log("1")
        } 
            })(tDiv[i])
        };

        var tDiv=$(".topic");
        for(var i=0;i<tDiv.length;i++){
                var name="i"+i;
                
            }
        
    }
    
    function submit_veri(){
            var anslist_1=[];
            var tDiv=$(".topic");
            for(var i=0;i<tDiv.length;i++){
                var name="i"+i;
                var anslist={};
                (function(current){
                    var id_1=$(current).find(".idset").attr("data-tid");
                    var type_1=$(current).find(".idset").attr("data-type");
                    var type=$("input[name="+name+"]").attr("type");
                    switch(type){
                        case "radio":
                            var values=$("input[name="+name+"]:checked").val()
                            break;
                        case "checkbox":
                            var values=$("input[type=checkbox][name="+name+"]:checked").map(function(){
                                return $(this).val();
                            }).toArray().join("");
                            console.log(values);
                            break;
                        case "text":
                            var values=$("input[name="+name+"]").val()
                            break;
                        default:
                            console.log("1")    
                    }
                    //list.append(id,type,values)
                    anslist.id=id_1;
                    anslist.type=type_1;
                    anslist.value=values;
                    anslist_1.push(anslist);
                })(tDiv[i])
                
            }
            console.log(JSON.stringify(anslist_1));
            
            $.ajax({
                url:"07.form-ajax.php",
                type:"get",
                data:JSON.stringify(anslist_1),
                success:function(msg){
                        alert(msg);
                },
                error:function(xhr){
                        alert(xhr.status);
                }
            })
        }        
</script>
</body>

</html>








