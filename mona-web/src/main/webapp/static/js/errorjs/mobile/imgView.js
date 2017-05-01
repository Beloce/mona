/**
 * Created by peiji on 2017/5/1.
 */
$(function() {
    /*=== 默认为 standalone ===*/
    var imgList = new Array();
    $("#imgList").find('img').each(function(){
        imgList.push($(this).attr('src'));
    });
    console.log(JSON.stringify(imgList));
    var myPhotoBrowserPopup = $.photoBrowser({
        photos:imgList,
        type: 'popup'

    });
    //点击时打开图片浏览器
    $(document).on('click', '.pb-popup', function () {
        myPhotoBrowserPopup.open();
    });
});