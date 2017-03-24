var departmentTree;
//一般直接写在一个js文件中
$(function() {
    layer.open({
        content: '测试回调',
        yes: function(index, layero){
            //do something
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });
    $.ajax({
        type:"GET",
        url:"/department/getDepartmentListAjax.json",
        async:false,
        success:function (data) {
            if(data.success){
                departmentTree = data.result;
            }
        },
        error:function (data) {
            $("#screenshot").val("");//上传失败变全部刷新
            return false;
        }
    });
});