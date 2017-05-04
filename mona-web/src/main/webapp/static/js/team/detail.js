/**
 * Created by xiangyang on 17/4/1.
 */

function  showTeamDetail(teamId) {
    layer.open({
        title:"团队详情",
        type:2,
        // area: ['500px', '300px'],
        shadeClose: true,//点击遮罩关闭层
        shade: 0.6,
        area: ['50%', '90%'],
        content: '/team/detail.htm?teamId='+teamId
    });
}
