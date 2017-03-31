/**
 * Created by xiangyang on 17/3/25.
 */
function isExit(userId) {
    for(var i = 0 ; i < $("#selected").children().length ; i++){
        if($("#selected").children()[i].id == userId){
            return true;
        }
    }
    return false;
}
function select(button){
    if(!isExit(button.id)){
        $("#selected").append("<li id="+ button.id+" title="+ button.id+">" +
            "<button class='layui-btn layui-btn-radius'>"+button.innerText+"</button>" +"  "+
            "<input type='checkbox'>负责人" +
            "<a href='javascript:deleteSelected("+button.id+")'><small>  删除 </small></a>" +
            "</li>");
    }
}
function deleteSelected(userId) {
    $("#selected li").remove('li[id='+userId+']');
}