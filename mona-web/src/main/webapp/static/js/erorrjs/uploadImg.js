/**
 * Created by peiji on 2017/2/2.
 */

function showLodingToast(){
    var $loadingToast = $("#loadingToast");
    if($loadingToast.css('display')!='none')return;

    $loadingToast.css('display','block');
}
function hideLodingToast() {
    var $loadingToast = $("#loadingToast");
    if($loadingToast.css('display')=='none')return;

    $loadingToast.css('display','none');
}

$(function(){
    var fileArray = new Array();//保存文件的数组
    var imgUrl = "";//截图的URL
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
    $("#submits").on("tap",function(){
        $.showPreloader("上传图片中请稍等");
        for(var i = 0;i < fileArray.length ; i++){
            var filedata = new FormData();
            filedata.append("uploadErrorImgAjax",fileArray[i],fileArray[i].name);
            $.ajax({
                type:"POST",
                contentType:false,
                processData:false,
                url:"/img/uploadErrorImg.json",
                data:filedata,
                dataType: 'json',
                async:false,
                success:function (data) {
                    if(data.success){
                        if($("#screenshot").val() == ""){
                            $("#screenshot").val(data.msg);
                        }else{
                            $("#screenshot").val($("#screenshot").val()+"#*#"+data.msg);
                        }
                    }
                },
                error:function (data) {
                    console.log(data);
                    $("#screenshot").val("");
                }
            });
         }
        setTimeout(function () {
            $.hidePreloader();
        }, 300);
    });
});