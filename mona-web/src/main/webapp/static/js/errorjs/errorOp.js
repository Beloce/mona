/**
 * Created by xiangyang on 17/4/21.
 */
function sendOpData(opid,errorId,memo,pointTo,reason,resolveType,respType) {
    var postdata = {
        opid:opid,
        errorId:errorId,
        memo:memo,
        pointTo:pointTo,
        reason:reason,
        resolveType:resolveType,
        respType:respType
    }
    console.log(postdata);
    $.ajax({
        type:"POST",
        url:"/errorop/post.json",
        dataType: 'json',
        contentType:"application/json",
        data:JSON.stringify(postdata),
        async:false,
        success:function (data) {
            if(data.success){
                layer.msg('提交成功');
                location.reload();
            }else{
                layer.msg('失败'+data.msg);
            }
        },
    });
}

//***************生成产品列表HTML***************
function createProductHtml(){
    var productHtml;
    $.ajax({//获取所有的产品
        type:"GET",
        url:"/product/getAll.json",
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            productlist = data;
        },
    });
    //生成产品列表的弹框的H5
    //--------------------------------------------------------
    productHtml ="<div class='form-group' style='margin-left: 40px'>";
    $.each(productlist, function(idx, product) {//遍历产品列表json对象
        if(product.id == productId){
            return true;
        }
        productHtml += "<div class='radio'><lable>";
        productHtml += "<input type='radio' name='product' value='"+product.id+"'>"+product.productName;
        productHtml += "</lable></div><hr style='margin-left: -40px'>";
    });
    productHtml +="</div>";
    //--------------------------------------------------------
    return productHtml;
}

//*************生成问题清单HTML***************
function createErrorBill() {
    var resolveTypeMap = "";
    var respTypeMap = "";
    $.ajax({//获取所有解决方案
        type:"GET",
        url:"/error/getResolveType.json",
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            resolveTypeMap = data;
        },
    });
    $.ajax({//获取所有解决方案
        type:"GET",
        url:"/error/getRespType.json",
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            respTypeMap = data;
        },
    });
    var resolveTypeHtml = "";
    for(var resolveType in resolveTypeMap){
        resolveTypeHtml += "<option value="+resolveType+">"+resolveTypeMap[resolveType]+"</option>";
    }
    var respTypeHtml = "";
    for(var respType in respTypeMap){
        respTypeHtml += "<option value="+respType+">"+respTypeMap[respType]+"</option>";
    }
    console.log(JSON.stringify(resolveTypeMap));
    console.log(JSON.stringify(respTypeMap));

    var errorBillHtml = "<div class='form-group content'>" +
        "<div class='row'>" +
        "<div class='col-xs-6'><label>*责任方</label><select class='form-control' id='resolveType'>"+resolveTypeHtml+"</select></div>" +
        "<div class='col-xs-6'><label>*解决方案</label><select class='form-control' id='respType'>"+respTypeHtml+"</select></div>" +
        "</div>" +
        "<div class='row'>" +
        "<div class='col-xs-12'><label>*问题原因</label><textarea class='form-control' placeholder='请输入原因' id='reason' rows='7'></textarea></div>" +
        "</div>" +
        "</div>"

    return errorBillHtml;

}
$(function(){
    var errorId = $("#errorid").val();
    var productId =$("#productid").val();
    var opMap ="";
    var productlist;

    $.ajax({//获取问题的操作map
        type:"GET",
        url:"/verify/getOpMap.json?errorId="+errorId,
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            opMap = data;
        },
    });

    //----------------------按钮生成h5------------------------
    var isEmpty = true;
        var butH5="<div class='box-footer' id = 'footer'>"
        for(var opDesc in opMap){
            butH5 += "<button style='margin-left: 10px' id="+opMap[opDesc]+" class='btn btn-primary pull-right operation' >"+opDesc+"</button>";
            isEmpty =false;
        }
        butH5 += "</div>"
    if(!isEmpty){
        $(".box-primary").append(butH5);
    }

    //---------------------关闭问题h5------------------------
    var closeReason = "<div class='content' style='min-height: 100px'>" +
                            "<div class='form-group has-warnings'>" +
                            "<label  class='control-label'>*请填写问题关闭原因</label>" +
                            "<textarea id='reason' class='form-control' placeholder='原因...' rows='5'></textarea>" +
                            "</div>" +
                        "</div>"

    //-----------------------按钮点击事件------------------------
    $(".operation").on("click",function () {
        var opid = $(this).attr('id');
        var memo;
        var pointTo;
        //------------------------------------
        if(opid == 1){//确认问题
            layer.prompt({
                formType: 0,
                value: '例：1小时20分钟',
                title: '请输入预计完成时长',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index, elem){
                memo = value;
                sendOpData(opid,errorId,memo);
                layer.close(index);
            });
            return;
        }
        //------------------------------------
        if(opid == 2){//指派问题
            layer.open({
                type:1,
                title:"请选择要指派的产品",
                area: ['600px', '600px'],
                content:createProductHtml(),
                btn: ['确认', '取消'],
                yes: function(index){
                    var checked = $("input[name='product']:checked").val();
                    if(checked == "" || checked == null){
                        layer.msg('请选择产品');
                    }else{
                        pointTo = checked;
                        sendOpData(opid,errorId,memo,pointTo);
                    }
                }
            });
        }
        //------------------------------------
        if(opid == 3){//关闭问题
            layer.open({
                type:1,
                title:"关闭问题",
                area: ['500px', '300px'],
                content:closeReason,
                btn: ['确认提交', '取消'],
                yes: function(index){
                     var reason = $("#reason").val();
                     memo = reason;
                     if(reason == null || reason==""){
                         layer.msg('请填写内容');
                     }else{
                         sendOpData(opid,errorId,memo,pointTo,reason);
                     }
                }
            });
        }
        //------------------------------------
        if(opid == 4){//已解决问题
            layer.confirm('确认问题已经解决？', function(index){
                sendOpData(opid,errorId,memo,pointTo);
                layer.close(index);
            });
        }
        //------------------------------------
        if(opid == 7){//填写问题清单
            layer.open({
                type:1,
                title:"关闭问题",
                area: ['500px', '400px'],
                content:createErrorBill(),
                btn: ['确认提交', '取消'],
                yes: function(index){
                    var resolveType = $("#resolveType").val();
                    var respType= $("#respType").val();
                    var reason = $("#reason").val();
                    console.log(resolveType+'  '+respType+'  '+reason);
                    if(reason == null || reason=="" || resolveType==null || resolveType==""||respType==null||respType==""){
                        layer.msg('请填写内容');
                    }else{
                        sendOpData(opid,errorId,memo,pointTo,reason,resolveType,respType);
                    }
                }
            });
        }

    })
});