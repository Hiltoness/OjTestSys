//提交
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
    console.log(JSON.stringify(anslist_1));
    if(flag==true){
        confirm_veri()
        
    }
    // $.ajax({
    //     url:"07.form-ajax.php",
    //     type:"post",
    //     data:JSON.stringify(anslist_1),
    //     success:function(msg){
    //             alert(msg);
    //             alert("提交成功")
    //     },
    //     error:function(xhr){
    //             alert(xhr.status);
    //     }
    // })
    clearInterval(saveAjax)
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
            //list.append(id,type,values)
            anslist.id=id_1;
            anslist.type=type_1;
            anslist.value=values;
            anslist_1.push(anslist);
        })(tDiv[i])
        
    }
    console.log(JSON.stringify(anslist_1));
    
    // $.ajax({
    //     url:"07.form-ajax.php",//saveServelt
    //     type:"post",
    //     data:JSON.stringify(anslist_1),
    //     success:function(msg){
    //             alert(msg);
    //             alert("作答结果保存成功")
    //     },
    //     error:function(xhr){
    //             alert(xhr.status);
    //     }
    // })

}     

function confirm_veri(){
    if(window.confirm("未完成，是否提交")){
        event.returnValue="正在提交"
    }else{
        event.returnValue=false
    }
   
}