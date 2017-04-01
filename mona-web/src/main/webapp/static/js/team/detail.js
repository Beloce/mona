/**
 * Created by xiangyang on 17/4/1.
 */

function  showTeamDetail(teamId) {
    var teamVO;
    $.ajax({
        type:"GET",
        url:"/team/detail.json?teamId="+teamId,
        dataType: 'json',
        contentType:"application/json",
        async:false,
        success:function (data) {
            if(data.success){
                teamVO = data.result;
            }else{
                layer.msg(data.msg, {
                    icon: 2,
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                }, function(){
                    //do something
                });
            }
        },
        error:function (data) {
            layer.msg('服务异常', {
                icon: 2,
                time: 2000 //2秒关闭（如果不配置，默认是3秒）
            }, function(){
                //do something
            });
        }
    });

    var userList = teamVO.teamUsers;
    var team_user_html = "";
    for(var i = 0 ; i< userList.length ; i++){
        team_user_html += "<li>"+userList[i].flowerName+"</li>";
    }

    var leaderList = teamVO.teamLeaders;
    var team_leader_html = "";
    for(var i = 0 ; i< leaderList.length ; i++ ){
        team_leader_html += "<li>"+leaderList[i].flowerName+"</li>";
    }

    var team_detail_html =
        "<p>团队名称:"+teamVO.teamName+"</p>" +
        "<p>团队描述:"+teamVO.teamDec+"</p>"+
        "<p>负责人:</p>" +
        "<ul>" +
        team_leader_html +
        "</ul>"+
        "<p>团队成员</p>" +
        "<ul>" +
        team_user_html +
        "</ul>";

    layer.open({
        title:"团队详情",
        type:1,
        area: ['500px', '300px'],
        content: team_detail_html,
    });
}
