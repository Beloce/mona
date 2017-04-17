package com.xiangyang.AO.impl;

import com.xiangyang.AO.TeamUserAO;
import com.xiangyang.enums.team.TeamRoleEnum;
import com.xiangyang.manager.TeamManager;
import com.xiangyang.manager.TeamUserManager;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.query.TeamUserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
