/**
 * ajax发送添加、删除指令 
 */
//删除
function teacher_delete(tpid){
	$.ajax({
        url:"NewTestTeacher",//教师控制servlet
        type:"post",
        data:{"op":"delete",
       	 "tpid":tpid
       	 },
        success:function(msg){
        	if(msg){
                alert("删除成功");
                location.reload();
        	}else{
        		alert("删除失败");
        	}
        },
        error:function(xhr){
                alert(xhr.status);
        },
        traditional: true
    })
}

//添加
function teacher_add(gonghao){
	var kcbianhao=$("#kcbianhao").val();
	var name=$("#tname").val();
	var type=$("input[name=ttype]:checked").val();
	var start=$("#start").val();
	var end=$("#end").val();
	var tmpstart=start.replace("T"," ").concat(":00.0").substring(0,19).replace(/-/g,'/');
	var tmpend=end.replace("T"," ").concat(":00.0").substring(0,19).replace(/-/g,'/');
	if(new Date(tmpstart).getTime()>=new Date(tmpend).getTime()){
		alert("开始时间应在结束时间之前");
		return;
	}
	var times=$("#times").val();
	var op="insert";
	console.log("type",type);
	$.ajax({
        url:"NewTestTeacher",//教师控制servlet
        type:"post",
        data:{"op":op,
        "gonghao":gonghao,
       	 "kcbianhao":kcbianhao,//课程编号
       	 "name":name,//课程名
       	 "type":type,//试卷类型
       	 "begin":start,//开始时间
       	 "end":end,//结束时间
       	 "times":times,//可答次数
       	 },
        success:function(msg){
        	if(msg){
                alert("添加成功");
        		//clearContent();//清除输入框
        		location.reload();
        	}else{
        		alert("添加失败，请检查课程编号等输入是否有误");
        	}
        		
        },
        error:function(xhr){
                alert(xhr.status);
        },
        traditional: true
    })

}

//清除输入框
function clearContent(){
	$("input").val("");
}