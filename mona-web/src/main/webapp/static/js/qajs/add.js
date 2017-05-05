/**
 * Created by peiji on 2017/5/5.
 */
$(function () {
    $("#add_submit").on("click",function () {
        var content = $("#content").val();
        var contentHtml = content.replace("\"","'");
        var questionDesc = $("#questionDesc").val();
        var questionTitle = $("#questionTitle").val();
        var productId = $("#productId").val();
        var addData = {
            content:contentHtml,
            questionDesc:questionDesc,
            questionTitle:questionTitle,
            productId:productId
        }
        $.ajax({
            type:"POST",
            url:"/qa/doAddQuestion.json",
            data:JSON.stringify(addData),
            dataType: 'json',
            contentType:"application/json",
            async:false,
            success:function (data) {
                if(data.success){
                    layer.msg("添加常见问题成功!");
                    window.location.href = "/qa/questionList.htm";
                }
                else{
                    layer.msg("添加常见问题失败!");
                }
            }
        });
    });
});
