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
function getMaxLevelNum(tree) {
    var minLevel = 0;
    for(var i = 0; i< tree.length;i++){
        if(tree[i].departmentLevel > minLevel){
            minLevel = tree[i].departmentLevel;
        }
    }
    return minLevel;
}
function loadDepartmentTree(tree) {
    d = new dTree('d');
    d.add(0,-1,'产品技术部');
    for(var i = 0 ; i < tree.length ; i++){
        d.add(tree[i].departmentId,tree[i].departmentId,'Node 1','default.html');
    }

    // d.add(2,0,'Node 2','default.html');
    // d.add(3,1,'Node 1.1','default.html');
    // d.add(4,0,'Node 3','default.html');
    // d.add(5,3,'Node 1.1.1','default.html');
    // d.add(6,5,'Node 1.1.1.1','default.html');
    // d.add(7,0,'Node 4','default.html');
    // d.add(8,1,'Node 1.2','default.html');
    // d.add(9,0,'My Pictures','default.html','Pictures I\'ve taken over the years','','','/static/dtree/img/imgfolder.gif');
    // d.add(10,9,'The trip to Iceland','default.html','Pictures of Gullfoss and Geysir');
    // d.add(11,9,'Mom\'s birthday','default.html');
    // d.add(12,0,'Recycle Bin','default.html','','','/static/dtree/img/trash.gif');
    document.write(d);
}