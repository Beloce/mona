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
        $("#selected").append("<li id="+ button.id+">"+button.innerText+"</li>");
    }
}
