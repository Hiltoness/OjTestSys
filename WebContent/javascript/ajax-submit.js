/**
 * 提交/保存答卷
 */
//提交
function submit_veri(){
    var anslist_1=[];
    var tDiv=$(".topic");
    flag=false;
    for(var i=0;i<tDiv.length;i++){
        var name="i"+i;
        var anslist={};
        (function(current){
        	var tno_1=$(current).find(".idset").attr("data-tno");
            var id_1=$(current).find(".idset").attr("data-tid");
            var type_1=$(current).find(".idset").attr("data-type");
            var type=$("input[name="+name+"]").attr("type");
            switch(type){
                case "radio":
                    values=$("input[name="+name+"]:checked").val()
                    break;
                case "checkbox":
                    values=$("input[type=checkbox][name="+name+"]:checked").map(function(){
                        return $(this).val();
                    }).toArray().join("");
                    console.log(values);
                    break;
                case "text":
                    values=$("input[name="+name+"]").val()
                    break;
                default:
                    console.log("1")    
            }
            if(values==null){
            	values="";
                flag=true
            }
            //list.append(id,type,values)
            anslist.tno=tno_1;
            anslist.id=id_1;
            anslist.type=type_1;
            anslist.value=values;
            anslist_1.push(anslist);
        })(tDiv[i])
    }
    return anslist_1

}   

//点击提交
function submit_self(){
	let s_flag=arguments[0];//1-提交；0-下一页
	let nums=arguments[1];//学号
	let pid=arguments[2];//答卷号
	let kc=arguments[3];
	let gh=arguments[4];
    let list1=submit_veri();//作答结果
//    console.log(JSON.stringify(list1));
//    console.log(flag);
//    console.log(s_flag=="0");
    console.log(time_begin);
    if(flag==true){//未完成，提示
    	console.log("你运行什么了啊");
    	let a=(s_flag=='1'?confirm_veri():confirm_next())
        console.log(a)
        if(a==true){
             $.ajax({
             url:"PageSubmit",
             type:"post",
             async:"false",
             data:{"anslist":JSON.stringify(list1),
            	 "s_flag":s_flag,//提交or下一页标记
            	 "xuehao":nums,//学号
            	 "pid":pid},//答卷号
             success:function(adata){
            	 get_topic(adata,nums,pid,kc,gh,s_flag);
 
             },
             error:function(xhr){
            	 		alert("提交失败");
             },
             traditional: true
         })
        }
    }else{
//       location.href="LookLimit.jsp?xuehao="+nums //答卷页面
    	console.log("来这里啊");
    	 $.ajax({
             url:"PageSubmit",
             type:"post",
             async:"false",
             data:{"anslist":JSON.stringify(list1),
            	 "s_flag":s_flag,//提交or下一页标记
            	 "xuehao":nums,//学号
            	 "pid":pid},//答卷号
             success:function(adata){
            	 get_topic(adata,nums,pid,kc,gh,s_flag);
 
             },
             error:function(xhr){
            	 
            	 		alert("提交失败");
                     
             },
             traditional: true
         })
       }
    

}

//自动提交
function submit_auto(){
	let nums=arguments[0];//学号
	let pid=arguments[1];//答卷号
	let s_flag=arguments[2];
    let list2=submit_veri()
    console.log(JSON.stringify(list2));
    console.log("自动提交吗");
     $.ajax({
         url:"PageSubmit",
         type:"post",
         data:{"anslist":JSON.stringify(list2),
        	 "xuehao":nums,//学号
        	 "pid":pid,
        	 "s_flag":s_flag},//答卷号,
         success:function(msg){
                 alert("已为你自动提交");
         },
         error:function(xhr){
                 //alert(xhr.status);
         },
         traditional: true
     })
    
    //clearInterval(saveAjax)
    window.location.href="LookLimit.jsp?xuehao="+nums //答卷页面
}

//定时保存
function save_veri(){
	let nums=arguments[0];//学号
	let pid=arguments[1];//答卷号
	let pa=arguments[2];//第几页
    var anslist_11=[];
    var ttDiv=$(".topic");
    console.log("保存吗");
    for(var i=0;i<tDiv.length;i++){
        (function(current){
        	var name11="i"+i;
            var anslist11={};
        	var tno_11=$(current).find(".idset").attr("data-tno");
            var id_11=$(current).find(".idset").attr("data-tid");
            var type_11=$(current).find(".idset").attr("data-type");
            var type11=$("input[name="+name11+"]").attr("type");
            var values1="";
            switch(type11){
                case "radio":
                    values1=$("input[name="+name11+"]:checked").val()
                    break;
                case "checkbox":
                    values1=$("input[type=checkbox][name="+name11+"]:checked").map(function(){
                        return $(this).val();
                    }).toArray().join("");
                    console.log(values1);
                    break;
                case "text":
                    values1=$("input[name="+name+"]").val()
                    break;
                default:
                    console.log("1")   ; 
            }
            if(values1==null){
            	values1="";
            }
            anslist11.tno=tno_11;
            anslist11.id=id_11;
            anslist11.type=type_11;
            anslist11.value=values1;
            anslist_11.push(anslist11);
        })(ttDiv[i])
        
    }
    console.log(JSON.stringify(anslist_11));
    
    //使用ajax提交时把下面注释去掉
     $.ajax({
         url:"PageSave",//PageSave
         type:"post",
         data:{"anslist":JSON.stringify(anslist_11),
        	 "xuehao":nums,//学号
        	 "pid":pid,},//答卷号
         success:function(msg){
                 alert("作答结果保存成功")
         },
         error:function(xhr){
                 //alert(xhr.status);
         },
         traditional: true
     })

}

//获取题目
function get_topic(){
	let alist=arguments[0];
	let nums=arguments[1];//学号
	let pid=arguments[2];//答卷号
	let kc=arguments[3];
	let gh=arguments[4];
	let a_flag=arguments[5];
	console.log(alist);
	if(a_flag==0){
		$.ajax({
			url:"GetTopic",
			type:"post",
			async:"false",
			data:{"xuehao":nums,
				"pid":pid,
				"kcbianhao":kc,
				"gonghao":gh,
				"tlist":JSON.stringify(alist)},
				  
			success:function(data){
				showT(data)
			},
			error:function(){
				
			}
		})
	}else{
		alert("提交成功");
  		 window.location.href="LookLimit.jsp?xuehao="+nums //答卷页面
	}
	
}

function confirm_veri(){
    if(window.confirm("未完成，是否提交")){
        return true
    }else{
        event.returnValue=false
    }
   
}
function confirm_next(){
    if(window.confirm("未完成，是否进入下一页")){
        return true
    }else{
        event.returnValue=false
    }
   
}