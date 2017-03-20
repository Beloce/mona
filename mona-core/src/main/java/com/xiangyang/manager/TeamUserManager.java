package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.TeamUserDO;
import com.xiangyang.query.TeamUserQuery;

import java.util.List;


/**
 * Manager for TeamUser.
 */
public interface TeamUserManager {
    /**
     * query count by query condition.
     */
    int countByQuery(TeamUserQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(TeamUserQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(TeamUserDO record);

    /**
     * insert selective.
     */
    long insertSelective(TeamUserDO record);

    /**
     * select by query condition.
     */
    List<TeamUserDO> selectByQuery(TeamUserQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<TeamUserDO> selectByQueryWithPage(TeamUserQuery query);

    /**
     * select by primary key.
     */
    TeamUserDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( TeamUserDO record,  TeamUserQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(TeamUserDO record, TeamUserQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(TeamUserDO record);
}