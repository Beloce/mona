function getDepartmentList() {
    var departmentTree;
    var deparmentData ={
        departmentId:12
    };
    $.ajax({
        type:"GET",
        data:deparmentData,
        contentType:"application/json",
        url:"/department/getDepartmentListAjax.json",
        async:false,
        success:function (data) {
            if(data.success){
                departmentTree = data.result;
            }else{
                layer.open({
                    title:"加载失败，请刷新重试",
                    type:false,
                    content: '测试回调',
                    yes: function(index, layero){
                        //do something
                        layer.close(index); //如果设定了yes回调，需进行手工关闭
                    }
                });
            }
        },
        error:function (data) {
            $("#screenshot").val("");//上传失败变全部刷新
            return false;
        }
    });
    return departmentTree;
}