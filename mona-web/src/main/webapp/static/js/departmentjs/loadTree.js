/**
 * Created by peiji on 2017/3/24.
 */
function getMaxLevelNum(tree) {
    var maxLevel = 100;
    for(var i = 0; i< tree.length;i++){
        if(tree[i].departmentLevel < maxLevel){
            maxLevel = tree[i].departmentLevel;
        }
    }
    return maxLevel;
}
function loadDepartmentTree(tree) {
    var maxLevel = getMaxLevelNum(tree);
    var topTree =


    layui.tree({
        elem: '#depatmentTree'//传入元素选择器
            ,nodes: [{ //节点
                name: '父节点1'
                ,children: [{
                    name: '子节点11'
                },{
                    name: '子节点12'
                }]
            },
        }
        {
            name: '父节点2（可以点左侧箭头，也可以双击标题）'
            ,children: [{
                name: '子节点21'
                ,children: [{
                    name: '子节点211'
                }]
            }]
        }]
    });

}