package com.xiangyang.AO.impl;

import com.xiangyang.AO.TeamAO;
import com.xiangyang.AO.TeamUserAO;
import com.xiangyang.AO.UserAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.enums.team.TeamRoleEnum;
import com.xiangyang.form.team.AddTeamForm;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.form.team.UpdateTeamForm;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.manager.TeamUserManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.TeamDO;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.model.UserDO;
import com.xiangyang.query.TeamQuery;
import com.xiangyang.query.TeamUserQuery;
import com.xiangyang.query.UserQuery;
import com.xiangyang.util.TimeUtils;
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

    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    TeamUserAO teamUserAO;

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
            teamUserAO.addTeamLeader(addTeamForm.getLeaderIds(),teamId);//设置团队leader
            bizResult.setSuccess(true);
            bizResult.setMsg("添加成功");

        }catch (Exception e){
            logger.error(e.getMessage());
            bizResult.setSuccess(false);
            bizResult.setMsg("服务器异常");
        }
        return bizResult;
    }

    @Override
    public BizResult<TeamVO> queryTeamVOById(Long teamId) {
        BizResult<TeamVO> bizResult = new BizResult<>();
        if(teamId == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("参数为空");
            return bizResult;
        }
        TeamDO teamDO = teamManager.selectByPrimaryKey(teamId);
        if(teamDO.getTeamId() == null){
            bizResult.setSuccess(false);
            bizResult.setMsg("队伍不存在");
            return bizResult;
        }
        try{
            TeamVO teamVO = new TeamVO();
            BeanUtils.copyProperties(teamDO,teamVO);
            TeamUserQuery teamUserQuery = new TeamUserQuery();
            teamUserQuery.createCriteria().andTeamIdEqualTo(teamId);
            List<TeamUserDO> teamUserDOs = teamUserManager.selectByQuery(teamUserQuery);
            List<Long> leaderIds = new ArrayList<>();
            List<Long> userIds = new ArrayList<>();
            for(TeamUserDO teamUserDO : teamUserDOs){
                userIds.add(teamUserDO.getUserId());
                if(TeamRoleEnum.Leader.getCode().equals(teamUserDO.getRole())){
                    leaderIds.add(teamUserDO.getUserId());
                }
            }
            UserQuery normalUserQuery = new UserQuery();
            normalUserQuery.createCriteria().andUserIdIn(userIds);//普通队员
            List<UserDO> normalUserDOs = userManager.selectByQuery(normalUserQuery);

            UserQuery leaderUserQuery = new UserQuery();
            leaderUserQuery.createCriteria().andUserIdIn(leaderIds);//普通队员
            List<UserDO> leaderUserDOs = userManager.selectByQuery(leaderUserQuery);
            teamVO.setTeamUsers(normalUserDOs);
            teamVO.setTeamLeaders(leaderUserDOs);
            teamVO.setGmtCreateStr(TimeUtils.DateToStr(teamVO.getGmtCreate(),TimeUtils.YYYY_MM_DD));
            bizResult.setResult(teamVO);
            bizResult.setSuccess(true);
        }catch (Exception e){
            bizResult.setMsg("查询异常");
            bizResult.setSuccess(false);
            logger.error(e.getMessage());
        }
        return bizResult;
    }

    @Override
    public List<TeamVO> queryAllTeamVOs() {
        TeamQuery teamQuery = new TeamQuery();
        teamQuery.createCriteria().andTeamIdIsNotNull();
        List<TeamDO> teamDOs = teamManager.selectByQuery(teamQuery);
        return teamDOs2VOs(teamDOs);
    }

    @Override
    public BizResult updateTeamInfo(UpdateTeamForm updateTeamForm) {
        BizResult bizResult = new BizResult();
        try {
            if(updateTeamForm == null || updateTeamForm.getTeamUserIds()==null || updateTeamForm.getTeamUserIds().size()==0
                    || StringUtils.isBlank(updateTeamForm.getTeamDesc())|| StringUtils.isBlank(updateTeamForm.getTeamName())
                    || updateTeamForm.getLeaderIds()==null || updateTeamForm.getTeamUserIds().size()==0){
                bizResult.setSuccess(false);
                bizResult.setMsg("参数有误");
            }
            TeamDO teamDO = teamManager.selectByPrimaryKey(updateTeamForm.getTeamId());
            teamDO.setTeamDec(updateTeamForm.getTeamDesc());
            teamDO.setTeamName(updateTeamForm.getTeamName());
            teamManager.updateByPrimaryKeySelective(teamDO);

            TeamUserQuery teamUserQuery = new TeamUserQuery();
            teamUserQuery.createCriteria().andTeamIdEqualTo(updateTeamForm.getTeamId());
            teamUserManager.deleteByQuery(teamUserQuery);
            for(Long userId : updateTeamForm.getTeamUserIds()){
                TeamUserDO teamUserDO = new TeamUserDO();
                teamUserDO.setTeamId(updateTeamForm.getTeamId());
                teamUserDO.setUserId(userId);
                teamUserManager.insertSelective(teamUserDO);
            }
            teamUserAO.addTeamLeader(updateTeamForm.getLeaderIds(), updateTeamForm.getTeamId());//设置团队leader
            bizResult.setSuccess(true);
        }catch (Exception e){
            logger.error(e.toString());
            bizResult.setMsg("更新失败，服务器异常");
            bizResult.setSuccess(false);
        }
        return bizResult;
    }

    private TeamVO teamDO2VO(TeamDO teamDO){
        TeamVO teamVO = new TeamVO();
        if(teamDO == null){
            return teamVO;
        }
        BeanUtils.copyProperties(teamDO,teamVO);
        return teamVO;
    }

    private List<TeamVO> teamDOs2VOs(List<TeamDO> teamDOs){
        List<TeamVO> teamVOs = new ArrayList<>();
        if(teamDOs == null || teamDOs.size() == 0){
            return teamVOs;
        }
        for(TeamDO teamDO : teamDOs){
            TeamVO teamVO = new TeamVO();
            BeanUtils.copyProperties(teamDO,teamVO);
            teamVOs.add(teamVO);
        }
        return teamVOs;
    }
}
