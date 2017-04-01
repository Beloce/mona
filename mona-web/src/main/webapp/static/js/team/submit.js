/**
 * Created by peiji on 2017/3/30.
 */
$("#submitbtn").on("click",function(){
    var teamName = $("#teamName").val();
    var teamDesc = $("#teamDesc").val();
    var teamUserList = new Array();
    var leaderList = new Array();
    var UserLength = $("#selected li").size();
    for(var i = 0 ; i < UserLength ; i++){
        teamUserList.push($("#selected li").eq(i).attr('id'));
        if($("#selected li").eq(i).children('input').is(':checked')){
            leaderList.push($("#selected li").eq(i).attr('id'));
        }
    }
    if(teamName == "" || teamDesc == "" || teamUserList.length == 0){
        layer.open({
            title:"失败",
            content: '请填写必须的参数',
            icon:2,
            yes: function(index, layero){
                layer.close(index);

            }
        });
        return;
    }
var dataForm = {
        teamName:teamName,
        teamDesc:teamDesc,
        teamUserIds:teamUserList,
        leaderIds:leaderList
    }

    $.ajax({
        type:"POST",
        url:"/team/doAddTeam.json",
        data:JSON.stringify(dataForm),
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            if(data.success){
                layer.open({
                    title:"成功",
                    content: '团队创建成功',
                    icon:1,
                    yes: function(index, layero){
                        layer.close(index);
                        location.href="/team/teamList.htm"
                    }
                });
            }else{
                layer.open({
                    title:"失败",
                    content: data.msg,
                    icon:3,
                    yes: function(index, layero){
                        layer.close(index);
                    }
                });
            }

        },
        error:function (data) {
            layer.open({
                title:"失败",
                content: '网络错误',
                icon:3,
                yes: function(index, layero){
                    layer.close(index);
                }
            });
        }
    });


});