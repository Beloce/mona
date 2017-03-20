package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.model.TeamDO;

import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
public interface TeamAO {

    /**
     * 获取所有的团队信息
     * @return
     */
    BizResult<List<TeamVO>> getTeamListInPage(QueryTeamForm queryTeamForm);


}
