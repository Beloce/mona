/**
 * Created by peiji on 2017/5/4.
 */
$(function(){
   var recordNum = $("#recordNum").val();
   var pageCount = recordNum/10 +1;
   for(var i = 1; i<= pageCount ; i++){
       if($("#pageNo").val() == i){
           $("#pageIndex").append("<li ><a href='javascript:void(0);' id ="+i+" class='pageBtn' style='background:#CCCCCC'>"+i+"</a></li>");
       }else{
           $("#pageIndex").append("<li ><a href='javascript:void(0);' id ="+i+" class='pageBtn'>"+i+"</a></li>");
       }

   }
   $(".pageBtn").on("click",function () {
      var pageNo = $(this).attr('id');
      $("#pageNo").val(pageNo);
      $("#submit").click();
   });
});

