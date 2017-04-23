/**
 * Created by xiangyang on 17/4/21.
 */
function sendOpId(opid,errorId,memo) {
    var postdata = {
        opid:opid,
        errorId:errorId,
        memo:memo
    }
    $.ajax({
        type:"POST",
        url:"/errorop/post.json",
        dataType: 'json',
        contentType:"application/json",
        data:JSON.stringify(postdata),
        async:false,
        success:function (data) {
            opMap = data;
        },
    });
}
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
        var butH5="<button style='margin-left: 10px' id="+opMap[opDesc]+" class='btn btn-primary pull-right operation' >"+opDesc+"</button>";
        $("#footer").append(butH5);
    }

    $(".operation").on("click",function () {
        var opid = $(this).attr('id');
        if(opid == 1){
            var memo;
            layer.prompt({
                formType: 0,
                value: '例：1小时20分钟',
                title: '请输入预计完成时长',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index, elem){
                memo = value;
                layer.close(index);
                sendOpId(memo);
            });
            return;
        }
        if(opid == 2){

        }
    })
});