package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.AddTeamForm;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.form.team.UpdateTeamForm;
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

    /**
     * 添加团队
     * @param addTeamForm
     * @return
     */
    BizResult addTeamByForm(AddTeamForm addTeamForm);

    /**
     * 根据teamId获取TeamVO
     * @param teamId
     * @return
     */
    BizResult<TeamVO> queryTeamVOById(Long teamId);

    /**
     * 获取所有的团队信息
     * @return
     */
    List<TeamVO> queryAllTeamVOs();

    BizResult updateTeamInfo(UpdateTeamForm updateTeamForm);


}
