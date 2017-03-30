package com.xiangyang.AO.impl;

import com.xiangyang.AO.TeamAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.AddTeamForm;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.manager.TeamUserManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.TeamDO;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.TeamQuery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
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

    @Autowired
    TeamUserManager teamUserManager;

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

    @Override
    public BizResult addTeamByForm(AddTeamForm addTeamForm) {
        final Logger logger  =  LoggerFactory.getLogger(this.getClass());
        BizResult bizResult = new BizResult();
        if(addTeamForm == null || StringUtils.isBlank(addTeamForm.getTeamName()) || StringUtils.isBlank(addTeamForm.getTeamDesc()) ||
                addTeamForm.getTeamUserIds()==null|| addTeamForm.getLeaderIds()==null || addTeamForm.getTeamUserIds().size()==0){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空");
            return bizResult;
        }
        try{
            TeamDO teamDO = new TeamDO();
            teamDO.setTeamName(addTeamForm.getTeamName());
            teamDO.setTeamDec(addTeamForm.getTeamDesc());
            teamManager.insertSelective(teamDO);
            Long teamId = teamDO.getTeamId();
            logger.info("[创建团队成功，团队id=]"+teamDO.getTeamId());
            for(Long userId : addTeamForm.getTeamUserIds()){
                TeamUserDO teamUserDO = new TeamUserDO();
                teamUserDO.setTeamId(teamId);
                teamUserDO.setUserId(userId);
                teamUserManager.insertSelective(teamUserDO);
            }
            bizResult.setSuccess(true);
            bizResult.setMsg("添加成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            bizResult.setSuccess(false);
            bizResult.setMsg("服务器异常");
        }
        return bizResult;
    }
}
