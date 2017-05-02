/**
 * Created by peiji on 2017/4/30.
 */
var star = 0;
$('.star').on('click',function(){
    $(".star").removeClass("button-fill");
    $(this).addClass("button-fill");
    star = $(this).attr('id');
});
//已解决-----
$('#comt_submit').on('click',function(){
    if(star == 0){
        $.alert("请选择分数");
        return;
    }
    var opid = 5;
    var errorId = $("#errorid").val();
    var memo = $("#comt_memo").val();
    var postdata = {
        opid:opid,
        errorId:errorId,
        memo:memo,
        appraiseLevel:star
    }
    console.log(postdata);
    $.ajax({
        type:"POST",
        url:"/errorop/mobilePost.json",
        dataType: 'json',
        contentType:"application/json",
        data:JSON.stringify(postdata),
        async:false,
        success:function (data) {
            if(data.success){
                $.alert('提交成功');
                location.reload();
            }else{
                $.alert("失败",data.msg);
            }
        },
        error:function(){
            layer.msg('网络异常请重试')
        }
    });
});
$('#reject_submit').on("click",function () {
    var opid = 6;
    var errorId = $("#errorid").val();
    var memo = $("#reject_memo").val();
    if(memo == null || memo == ""){
        $.alert("请填写原因");
        return;
    }
    var postdata = {
        opid:opid,
        errorId:errorId,
        memo:memo,
    }
    $.confirm('确认驳回？', function () {
            console.log(postdata);
            $.ajax({
                    type:"POST",
                    url:"/errorop/mobilePost.json",
                    dataType: 'json',
                    contentType:"application/json",
                    data:JSON.stringify(postdata),
                    async:false,
                    success:function (data) {
                        if(data.success){
                            $.alert('驳回成功');
                            location.reload();
                        }else{
                            $.alert("失败",data.msg);
                        }
                    },
                    error:function(){
                        layer.msg('网络异常请重试')
                    }
            }),

        function () {
            return;
        };
    });
});


$(document).on('click','.create-actions', function () {
    var buttons1 = [
        {
            text: '请选择',
            label: true
        },
        {
            text: '已解决',
            onClick: function() {
                $.popup('.popup-confirm');
            }
        },
        {
            text: '未解决',
            color: 'danger',
            onClick: function() {
                $.popup('.popup-reject');
            }
        }
    ];
    var buttons2 = [
        {
            text: '取消',
            bg: 'danger'
        }
    ];
    var groups = [buttons1, buttons2];
    $.actions(groups);
});
