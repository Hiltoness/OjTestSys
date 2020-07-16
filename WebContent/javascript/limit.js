/**
 * 限时模式的计时器
 */

    //计时器
    var time_begin=new Date();// 开始时间
    var lim=new Date();
    lim.setMinutes(time_begin.getMinutes()+1);//限制结束时间
    // console.log(lim.getMinutes()+":"+lim.getSeconds()+"now"+time_begin.getMinutes()+":"+time_begin.getSeconds());
    var mytime=setInterval(TimerSet,1000);//限时30分钟
    


    function TimerSet(){//倒计时-限时模式
        var current=new Date();
        var left=new Date();
        left.setMinutes(lim.getMinutes()-current.getMinutes());
        left.setSeconds(lim.getSeconds()-current.getSeconds());
        minutesLeft=left.getMinutes();
        secondsLeft=left.getSeconds();
        var timerDisplay = minutesLeft + ":" + secondsLeft;
        $("#timer").text(timerDisplay);
        if(minutesLeft==0 && secondsLeft==0){
            clearInterval(mytime);
            submit_veri();
            $("#submit_button").attr("disabled",true);
        }
    }
    