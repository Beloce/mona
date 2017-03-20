package com.xiangyang.AO.impl;

import com.xiangyang.AO.TeamAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.TeamDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.TeamQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
@Service
public class TeamAOImpl implements TeamAO {
    @Autowired
    TeamManager teamManager;

    @Autowired
    UserManager userManager;

    @Override
    public BizResult<List<TeamVO>> getTeamListInPage(QueryTeamForm queryTeamForm) {
        BizResult<List<TeamVO>> bizResult = new BizResult<List<TeamVO>>();
        TeamQuery teamQuery = new TeamQuery();
        teamQuery.setPageNo(queryTeamForm.getPageNo());
        teamQuery.setPageSize(queryTeamForm.getPageSize());
        teamQuery.createCriteria().andTeamIdIsNotNull();
        List<TeamDO> teamDOs = teamManager.selectByQuery(teamQuery);
        List<TeamVO> teamVOs = new ArrayList<TeamVO>();
        for(TeamDO teamDO : teamDOs){
            TeamVO teamVO = new TeamVO();
            BeanUtils.copyProperties(teamDO,teamVO);
            if(teamVO.getLeaderId() != null)
            {
                UserDO userDO = userManager.selectByPrimaryKey(teamVO.getLeaderId());
                teamVO.setLeaderName(userDO.getFlowerName());
            }
            teamVOs.add(teamVO);
        }
        bizResult.setSuccess(true);
        bizResult.setResult(teamVOs);
        return bizResult;
    }
}
