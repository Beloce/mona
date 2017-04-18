package com.xiangyang.AO;

import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
public interface TeamUserAO {

    boolean addTeamLeader(List<Long> userIds,Long teamId);

    List<Long> findTeamIdsByUserId(Long UserId);

    /**
     * 用户是否在这个团队中
     * @param userId
     * @param teamId
     * @return
     */
    boolean isUserInTeam(Long userId,Long teamId);

    boolean isUserTheLeader(Long userId,Long teamId);


}
