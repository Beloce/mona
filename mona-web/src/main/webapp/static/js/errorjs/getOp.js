/**
 * Created by xiangyang on 17/4/21.
 */
$(function(){
    var errorId = $("#errorid").val();
    var opMap ="";

    $.ajax({
        type:"GET",
        url:"/verify/getOpMap.json?errorId="+errorId,
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            opMap = data;
        },
    });

    for(var opDesc in opMap){
        var butH5="<button style='margin-left: 10px' id="+opMap[opDesc]+" class='btn btn-primary pull-right' >"+opDesc+"</button>";
        $("#footer").append(butH5);
    }


});