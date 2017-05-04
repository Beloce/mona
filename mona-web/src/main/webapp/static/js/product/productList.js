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
        layer.open({
            type:1,
            title:"编辑产品",
            area: ['600px', '500px'],
            content:editProductHtml(productId),
            btn: ['确认', '取消'],
            yes: function(index){
                var teamId = $("input[name='team']:checked").val();
                var productName = $("#productName").val();
                var productDesc = $("#productDesc").val();
                if(teamId == "" || teamId == null){
                    layer.msg('请选择团队');
                }else{
                    if(teamId!="" && productName!="" && productDesc!=""){
                        updateAjax(productId,productName,teamId,productDesc);
                        window.location.reload();
                    }else{
                        layer.msg('请将信息补全');
                    }
                }
            }
        });
    });
});
function updateAjax(productId,productName,teamId,productDesc) {
    var updateData = {
        productId:productId,
        teamId:teamId,
        productName:productName,
        productDesc:productDesc
    }
    $.ajax({//获取所有解决方案
        type:"POST",
        url:"/product/update.json",
        dataType: 'json',
        contentType:"application/json",
        data:JSON.stringify(updateData),
        async:false,
        success:function (data) {
            if(data.success){
                layer.msg("更新成功!");
                return true;
            }
            else{
                layer.msg("更新失败!"+data.msg);
                return false;
            }
        },
    });

}
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
        url:"/product/getProduct.json?productId="+productId,
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
    teamHtml="<div class='form-group' >";
    $.each(teamListVOs, function(idx, team) {//遍历产品列表json对象

        if(team.teamId == productVO.teamId){
            teamHtml += "<div class='radio' style='margin-left: 20px'><lable>";
            teamHtml += "<input type='radio' name='team' value='"+team.teamId+"' checked/>"+team.teamName;
            teamHtml += "</lable></div></br>";
        }else{
            teamHtml += "<div class='radio' style='margin-left: 20px'><lable>";
            teamHtml += "<input type='radio' name='team' value='"+team.teamId+"'/>"+team.teamName;
            teamHtml += "</lable></div></br>";
        }
    });
    teamHtml +="</div>";
    html= "<div class='form-group content'><input type='hidden' value='"+productVO.id+"'>" +
        "<div class='row'>" +
        "<div class='col-xs-3'><label>*产品名称</label><input class='form-control' id='productName' value='"+productVO.productName+"'/></div>" +
        "<div class='col-xs-9'><label>*产品描述</label><input class='form-control' id='productDesc' value='"+productVO.productDesc+"'/></div>" +
        "</div>" +
        "<div class='row'>" +
        "<div class='col-xs-12' style='margin-top: 20px' ><label>*请选择团队"+teamHtml+"</div>" +
        "</div>" +
        "</div>";
    return html;
}