/**
 * 提交/保存答卷
 */
//提交
function submit_veri(){
    var anslist_1=[];
    var tDiv=$(".topic");
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
    console.log(JSON.stringify(list1))
    console.log(time_begin);
    if(flag==true){
    	let a=(s_flag=='1'?confirm_veri():confirm_next())
        console.log(a)
        if(a==true){
             $.ajax({
             url:"PageSubmit",
             type:"post",
             data:{"anslist":JSON.stringify(list1),
            	 "s_flag":s_flag,//提交or下一页标记
            	 "xuehao":nums,//学号
            	 "pid":pid},//答卷号
             success:function(adata){
            	 if(s_flag==0){
            		 console.log("下一页")
            		 get_topic(adata,nums,kc,gh);
                     //alert("提交成功")
            	 }else{
            		 location.href="LookLimit.jsp?xuehao="+nums //答卷页面
            	 }
                     
             },
             error:function(xhr){
            	 	 console.log("提交失败")
                     alert(xhr.status);
             },
             traditional: true
         })
//        clearInterval(saveAjax)
        
        
        }
    }else{
    	$.ajax({
            url:"PageSubmit",
            type:"post",
            data:{"anslist":JSON.stringify(list1),
           	 "s_flag":s_flag,//提交or下一页标记
           	 "xuehao":nums,//学号
           	 "pid":pid},//答卷号
            success:function(adata){
           	 if(s_flag==0){
           		 console.log("下一页");
           		 get_topic(adata,nums,kc,gh);
                    //alert("提交成功")
           	 }
                    
            },
            error:function(xhr){
           	 	 console.log("提交失败")
                    alert(xhr.status);
            },
            traditional: true
        })
//       clearInterval(saveAjax)
       
       location.href="LookLimit.jsp?xuehao="+nums //答卷页面
       }
    

}

//自动提交
function submit_auto(){
	let nums=arguments[0];//学号
	let pid=arguments[1];//答卷号
	let pa=arguments[2];//第几页
    let list2=submit_veri()
    console.log(JSON.stringify(list2));

     $.ajax({
         url:"PageSubmit",
         type:"post",
         data:{"anslist":JSON.stringify(list2),
        	 "xuehao":nums,//学号
        	 "pages":pa,//页数
        	 "pid":pid},//答卷号,
         success:function(msg){
                 alert(msg);
         },
         error:function(xhr){
                 alert(xhr.status);
         },
         traditional: true
     })
    
    //clearInterval(saveAjax)
    alert("已为你自动提交")
    location.href="LookLimit.jsp?xuehao="+nums //答卷页面
}

//定时保存
function save_veri(){
	let nums=arguments[0];//学号
	let pid=arguments[1];//答卷号
	let pa=arguments[2];//第几页
    var anslist_1=[];
    var tDiv=$(".topic");
    for(var i=0;i<tDiv.length;i++){
        var name="i"+i;
        var anslist={};
        (function(current){
        	let tno_1=$(current).find(".idset").attr("data-tno");
            let id_1=$(current).find(".idset").attr("data-tid");
            let type_1=$(current).find(".idset").attr("data-type");
            let type=$("input[name="+name+"]").attr("type");
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
            anslist.tno=tno_1;
            anslist.id=id_1;
            anslist.type=type_1;
            anslist.value=values;
            anslist_1.push(anslist);
        })(tDiv[i])
        
    }
    console.log(JSON.stringify(anslist_1));
    
    //使用ajax提交时把下面注释去掉
     $.ajax({
         url:"PageSave",//PageSave
         type:"post",
         data:{"anslist":JSON.stringify(anslist_1),
        	 "xuehao":nums,//学号
        	 "pages":pa,//页数
        	 "pid":pid,},//答卷号
         success:function(msg){
                 alert(msg);
                 alert("作答结果保存成功")
         },
         error:function(xhr){
                 alert(xhr.status);
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
	$.ajax({
		url:"GetTopic",
		type:"post",
		data:{"xuehao":nums,
			"pid":pid,
			"kcbianhao":kc,
			"gonghao":gh,
			"tlist":alist},
			  
		success:function(data){
			showT(data)
		},
		error:function(){
			
		}
	})
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