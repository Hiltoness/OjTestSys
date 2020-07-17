/**
 * 提交/保存答卷
 */
//提交
console.log("111");
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
            if(values==null){
                flag=true
            }
            //list.append(id,type,values)
            anslist.id=id_1;
            anslist.type=type_1;
            anslist.value=values;
            anslist_1.push(anslist);
        })(tDiv[i])
        
    }
    return anslist_1
    console.log(JSON.stringify(anslist_1));

}   

//点击提交
function submit_self(){
    let list1=submit_veri()
    console.log(JSON.stringify(list1))
    if(flag==true){
        let a=confirm_veri()
        console.log(a)
        if(a==true){
             $.ajax({
             url:"PageSubmit",
             type:"post",
             data:{"anslist":JSON.stringify(list1),
            	 "xuehao":"123",//学号
            	 "page":"4",//页数
            	 "tpid":"23"},//试卷号
             success:function(msg){
                     alert(msg);
                     alert("提交成功")
             },
             error:function(xhr){
                     alert(xhr.status);
             },
             traditional: true
         })
//        clearInterval(saveAjax)
        
        //location.href="Finish.jsp" //答卷页面
        }
        
    }
    
}

//自动提交
function submit_auto(){
    let list2=submit_veri()
    console.log(JSON.stringify(list2));

     $.ajax({
         url:"PageSubmit",
         type:"post",
         data:JSON.stringify(list2),
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
    //location.href="Finish.jsp" //答卷页面
}

//定时保存
function save_veri(){
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
         data:JSON.stringify(anslist_1),
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

function confirm_veri(){
    if(window.confirm("未完成，是否提交")){
        return true
    }else{
        event.returnValue=false
    }
   
}