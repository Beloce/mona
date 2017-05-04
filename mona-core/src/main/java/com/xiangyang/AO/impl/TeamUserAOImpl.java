package com.xiangyang.AO.impl;

import com.xiangyang.AO.TeamUserAO;
import com.xiangyang.VO.TeamUserVO;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.enums.RoleEnum;
import com.xiangyang.enums.team.TeamRoleEnum;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.manager.TeamUserManager;
import com.xiangyang.manager.UserManager;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.query.TeamUserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
@Service
public class TeamUserAOImpl implements TeamUserAO{
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeamUserManager teamUserManager;

    @Autowired
    UserManager userManager;

    @Override
    public boolean addTeamLeader(List<Long> userIds, Long teamId) {
        if(userIds == null || userIds.size()==0 || teamId == null){
            return false;
        }
        try{
            TeamUserQuery teamUserQuery = new TeamUserQuery();
            teamUserQuery.createCriteria().andUserIdIn(userIds).andTeamIdEqualTo(teamId);
            List<TeamUserDO> teamUserDOs = teamUserManager.selectByQuery(teamUserQuery);
            for(TeamUserDO teamUserDO : teamUserDOs){
                teamUserDO.setRole(TeamRoleEnum.Leader.getCode());
                teamUserManager.updateByPrimaryKeySelective(teamUserDO);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Long> findTeamIdsByUserId(Long UserId) {
        List<Long> userIds = new ArrayList<>();
        TeamUserQuery query = new TeamUserQuery();
        query.createCriteria().andUserIdEqualTo(UserId);
        List<TeamUserDO> teamUserDOs = teamUserManager.selectByQuery(query);
        for(TeamUserDO teamUserDO : teamUserDOs){
            userIds.add(teamUserDO.getTeamId());
        }
        return userIds;
    }

    @Override
    public boolean isUserInTeam(Long userId, Long teamId) {
        TeamUserQuery query = new TeamUserQuery();
        query.createCriteria().andUserIdEqualTo(userId).andTeamIdEqualTo(teamId);
        List<TeamUserDO> teamUserDOs = teamUserManager.selectByQuery(query);
        if(CollectionUtils.isEmpty(teamUserDOs) || teamUserDOs.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean isUserTheLeader(Long userId, Long teamId) {
        TeamUserQuery query = new TeamUserQuery();
        query.createCriteria().andTeamIdEqualTo(teamId).andUserIdEqualTo(userId);
        List<TeamUserDO> teamUserDOs = teamUserManager.selectByQuery(query);
        if(CollectionUtils.isEmpty(teamUserDOs) || teamUserDOs.size() == 0){
            return false;
        }else{
            if(teamUserDOs.get(0).getRole().equals(TeamRoleEnum.Leader.getCode())){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public List<TeamUserVO> queryTeamUserVOByTeamId(Long teamId) {
        List<TeamUserVO> teamUserVOs = new ArrayList<>();
        if(teamId == null){
            return teamUserVOs;
        }
        else{
            TeamUserQuery teamUserQuery = new TeamUserQuery();
            teamUserQuery.createCriteria().andTeamIdEqualTo(teamId);
            List<TeamUserDO> teamUserDOs =  teamUserManager.selectByQuery(teamUserQuery);
            return teamUserDOs2VOs(teamUserDOs);

        }
    }

    private TeamUserVO teamUserDO2VO(TeamUserDO teamUserDO) {
        TeamUserVO teamUserVO = new TeamUserVO();
        if (teamUserDO == null) {
            return teamUserVO;
        }
        BeanUtils.copyProperties(teamUserDO,teamUserVO);
        teamUserVO.setLeaderCode(TeamRoleEnum.Leader.getCode());
        return teamUserVO;
    }

    private List<TeamUserVO> teamUserDOs2VOs(List<TeamUserDO> teamUserDOs) {
        List<TeamUserVO>  teamUserVOs = new ArrayList<>();
        if (teamUserDOs == null) {
            return teamUserVOs;
        }
        for(TeamUserDO teamUserDO : teamUserDOs){
            TeamUserVO teamUserVO = new TeamUserVO();
            BeanUtils.copyProperties(teamUserDO,teamUserVO);
            teamUserVO.setLeaderCode(TeamRoleEnum.Leader.getCode());
            teamUserVO.setUserFlowerName(userManager.selectByPrimaryKey(teamUserDO.getUserId()).getFlowerName());
            teamUserVOs.add(teamUserVO);
        }
        return teamUserVOs;
    }
}
