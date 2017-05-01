/**
 * Created by peiji on 2017/4/30.
 */



function setCardHtml(errorVO) {
    var statusHtml;
    if(errorVO.status == 7){
        statusHtml=' <i class="fa fa-window-close" style="color:red" aria-hidden="true">当前状态:'+errorVO.statusDesc+'</i>'
    }
    else if(errorVO.status == 6){
        statusHtml='<i class="fa fa-check-square" style="color:green" aria-hidden="true">当前状态:'+errorVO.statusDesc+'</i>'
    }
    else{
        statusHtml=' <span style="color:orange">当前状态:'+errorVO.statusDesc+'</span>'
    }
    var cardHtml = '<div class="card" onclick = "getDetail('+ errorVO.errorId+')" >'
        +'     <div class="card-header"><span style="color: #0a8ddf">「'+errorVO.title+'」</span><small style="font-size: 60%" class="pull-right">'+errorVO.typeDesc+'</small></div>'
        +'     <div class="card-content">'
        +'        <div class="card-content-inner">'+errorVO.description+'</div>'
        +'     </div>'
        +'     <div class="card-footer"><small>最后操作：'+errorVO.relativeModified+'</small>'
    +'     <div class="pull-right"><small>'+statusHtml+'</small></div>'+'</div>'
    +'</div>'
    return cardHtml;
}
function getDetail(id) {
    location.href="/mobileError/detail.htm?errorId="+id;
}
function loadWaitErrorListCard(errorList) {
    for(var i=0 ; i<errorList.length;i++){
        var htmlStr = setCardHtml(errorList[i]);
        $("#wait_solve").append(htmlStr);
    }
}

function loadOverErrorListCard(errorList) {
    for(var i=0 ; i<errorList.length;i++){
        var htmlStr = setCardHtml(errorList[i]);
        $("#has_over").append(htmlStr);
    }
}
$(function() {
    var pageSize = 10;
    var pageNo = 1;
    var data = {
        pageSize: pageSize,
        pageNo: pageNo
    }
    $.ajax({
        type: "GET",
        url: "/mobileError/getWaitResolveErrorListAjax.json",
        contentType: 'application/json',
        data: JSON.stringify(data),
        async: false,
        success: function (data) {
            if (data.success) {
                loadWaitErrorListCard(data.result);
            }else {
                $.alert(data.msg,"警告");
            }
        },
        error: function (data) {
            return;
        }
    });

    $.ajax({
        type: "GET",
        url: "/mobileError/getOverErrorListAjax.json",
        contentType: 'application/json',
        data: JSON.stringify(data),
        async: false,
        success: function (data) {
            if (data.success) {
                loadOverErrorListCard(data.result);
            }else {
                $.alert(data.msg,"警告");
            }
        },
        error: function (data) {
            return;
        }
    });
});