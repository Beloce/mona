/**
 * Created by peiji on 2017/2/2.
 */
var fileArray = new Array();//保存文件的数组
//提交表单
function submitForm(){
    var errorType = $("#errorType").val();
    var productId = $("#productId").val();
    var title = $("#title").val();
    var description =  $("#description").val();
    if(errorType == -1 || productId == -1 || description =="" || title ==""){
        $.alert('请将信息填写完毕！', '警告');
        return;
    }
    var screenshot =  $("#screenshot").val();
    var postData = {
        title :   title,
        errorType : errorType,
        productId : productId,
        description : description,
        screenshot : screenshot
    }
    $.ajax({
        type: "POST",
        url: "/error/doAddError.json",
        data: JSON.stringify(postData),
        contentType:'application/json',
        async: false,
        success:function (data) {
            if(data.success){
                $.alert("提交成功","成功");
                self.location("/")
            }else{
                $.alert("服务器错误，提交失败","错误");
            }
        },
        error:function (data) {
            $.alert("网络异常","错误");
            return;
        }
    });

}
//异步上传图片
function uploadImgSync() {
    for(var i = 0;i < fileArray.length ; i++){
        var filedata = new FormData();
        filedata.append("uploadImgAjax",fileArray[i],fileArray[i].name);
        $.ajax({
            type:"POST",
            contentType:false,
            processData:false,
            url:"/img/uploadImg.json",
            data:filedata,
            dataType: 'json',
            async:false,
            success:function (data) {
                if(data.success){
                    layer.open({
                        title:"成功",
                        type:false,
                        content: '提交成功',
                        yes: function(index, layero){
                            layer.close(index);
                        }
                    });
                }
            },
            error:function (data) {
                $.alert("服务器错误，上传图片失败","错误");
                $("#screenshot").val("");//上传失败变全部刷新
                return false;
            }
        });

    }
    return true;
}
//初始化
$(function(){
    var tmpl = "<li class='weui-uploader__file' style='background-image:url(#url#)'></li>",
        $gallery = $("#gallery"),
        $galleryImg = $("#galleryImg"),
        $uploaderInput = $("#uploaderInput"),
        $uploaderFiles = $("#uploaderFiles")
        ;
    $uploaderInput.on("change", function(e){
        var src,
            url = window.URL || window.webkitURL || window.mozURL,
            files = e.target.files;
        for (var i = 0, len = files.length; i < len; ++i) {
            var file = files[i];
            if (url) {
                src = url.createObjectURL(file);
            } else {
                src = e.target.result;
            }
            fileArray.push(file);
            $uploaderFiles.append($(tmpl.replace('#url#', src)));
        }

    });
    $uploaderFiles.on("tap", "li", function(){
        $galleryImg.attr("style", this.getAttribute("style"));
        $gallery.show(100);
    });
    $gallery.on("tap", function(){
        $gallery.hide(100);
    });
    //点击提交按钮
    $("#submits").on("click",function(){
        var flag = true;
        if(fileArray.length > 0){
            $.showPreloader("上传图片中请稍等");
            flag = uploadImgSync();
            $.hidePreloader();
        }
        if(flag){
            submitForm();
        }
    });
});