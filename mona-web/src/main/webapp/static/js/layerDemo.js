/**
 * Created by peiji on 2017/3/30.
 */
layer.open({
    title:"加载失败，请刷新重试",
    type:false,
    content: '测试回调',
    yes: function(index, layero){
        layer.close(index);
    }
});