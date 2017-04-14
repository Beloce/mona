package com.xiangyang.AO;

import java.util.List;

/**
 * Created by peiji on 2017/3/19.
 */
public interface TeamUserAO {

    boolean addTeamLeader(List<Long> userIds,Long teamId);

    List<Long> findTeamIdsByUserId(Long UserId);

}
