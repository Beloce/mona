/**
 * Created by peiji on 2017/5/4.
 */
/**
 * Created by peiji on 2017/5/4.
 */
function checksubmit(){
    var teamId = $("#teamId").val();
    var productDesc = $("#productDesc").val();
    var productName = $("#productName").val();
    if(teamId == "" || productDesc=="" || productName==""){
        layer.msg("警告！请填所有的信息");
        return false;
    }
    else{
        return true;
    }
}
    // $("#submitbtn").submit(function (ev) {
    //     alert("sdfad");
    //     var teamId = $("#teamId").val();
    //     var productDesc = $("#productDesc").val();
    //     var productName = $("#productName").val();
    //     console.log(teamId+" "+productDesc+" ");
    //     ev.preventDefault();
    // })
