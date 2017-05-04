/**
 * Created by peiji on 2017/5/4.
 */
$(function () {
   $(".delete").on("click",function () {
       var productId = $(this).attr("id");
       layer.confirm('确认是否删除？', function(index){
           deleteAjax(productId);
           layer.close(index);
           window.location.reload();
       });
   });
    $(".edit").on("click",function () {
        var productId = $(this).attr("id");
        layer.confirm('确认是否删除？', function(index){
            deleteAjax(productId);
            layer.close(index);
            window.location.reload();
        });
    });
});
function deleteAjax(productId) {
    var deleteData={
        productId:productId
    }
    $.ajax({//获取所有解决方案
        type:"POST",
        url:"/product/delete.json",
        dataType: 'json',
        contentType:"application/json",
        data:JSON.stringify(deleteData),
        async:false,
        success:function (data) {
            if(data.success){
                layer.msg("删除成功!");

            }
            else{
                layer.msg("删除失败!");
            }
        },
    });
}
function editProductHtml(productId){
    var productVO;
    var teamListVOs;
    $.ajax({//获取所有的产品
        type:"GET",
        url:"/product/getProduct.json?product"+productId,
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            productVO = data;
        },
    });
    $.ajax({//获取所有的产品
        type:"GET",
        url:"/team/getTeamList.json",
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            teamListVOs = data;
        },
    });
    html= "<div class='form-group content'><input type='hidden' value='"+productVO.id+"'>" +
        "<div class='row'>" +
        "<div class='col-xs-3'><label>*产品名称</label><select class='form-control' id='productName'>"+productVO.productName+"</select></div>" +
        "<div class='col-xs-9'><label>*产品描述</label><select class='form-control' id='productDesc'>"+productVO.productDesc+"</select></div>" +
        "</div>" +
        "<div class='row'>" +
        "<div class='col-xs-12'><label>*问题原因</label><textarea class='form-control' placeholder='请输入原因' id='reason' rows='7'></textarea></div>" +
        "</div>" +
        "</div>"


}