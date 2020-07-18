/**
 * 开始答卷时创建答卷
 */
function beginAjax(){
	var num=arguments[0];
	var id=arguments[1];
	var time=arguments[2];
	$.ajax({
		url:"CreatePage",
		type:"post",
		data:{"xuehao":num,
			"tpid":id,
			"time":time},
		success:function(msg){
			pid=msg
		}
	})
	return pid;
}