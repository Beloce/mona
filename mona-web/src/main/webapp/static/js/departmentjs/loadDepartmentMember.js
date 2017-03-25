function getDepartmentmember(departmentId) {
    var departmentNemberList;
    var deparmentData ={
        departmentId:departmentId
    };
    $.ajax({
        type:"GET",
        data:deparmentData,
        contentType:"application/json",
        url:"/department/getDepartmentMemberAjax.json",
        async:false,
        success:function (data) {
            if(data.success){
                departmentNemberList = data.result;
            }else{
                layer.open({
                    title:"加载失败，请刷新重试",
                    type:false,
                    content: '测试回调',
                    yes: function(index, layero){
                        layer.close(index);
                    }
                });
            }
        },
        error:function (data) {
            $("#screenshot").val("");//上传失败变全部刷新
            return false;
        }
    });
    return departmentNemberList;
}
function openD(departmentId) {
    var memberList = getDepartmentmember(departmentId);
    $("#memberList").empty();
    if(memberList.length == 0){
        $("#memberList").append('<p>暂无人员</p>')
    }else{
        for(var i = 0; i < memberList.length ; i++){
            $("#memberList").append('<li><button id='+memberList[i].userId+' class=" layui-btn layui-btn-normal layui-btn-small" ' +
                'style="margin-top: 5px" onclick = "select(this)">'+memberList[i].flowerName+'</button></li>');
        }
    }
}