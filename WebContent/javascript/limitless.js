/**
 * 无限模式的计时器
 */

//计时器
setInterval(TimerUse, 1000);//无限模式

function TimerUse(){//计算已用时间-无限模式
    var current=new Date();
    var use=new Date();
    use.setHours(current.getHours()-time_begin.getHours());
    use.setMinutes(current.getMinutes()-time_begin.getMinutes());
    use.setSeconds(current.getSeconds()-time_begin.getSeconds());
    hoursUse=use.getHours();
    minutesUse=use.getMinutes();
    secondsUse=use.getSeconds();
    var timerDisplay = hoursUse+":"+minutesUse + ":" + secondsUse;
    $("#timer").text(timerDisplay);
}
