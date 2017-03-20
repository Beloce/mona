package com.xiangyang.manager;

import com.xiangyang.util.query.support.PageResult;
import com.xiangyang.model.TeamDO;
import com.xiangyang.query.TeamQuery;

import java.util.List;


/**
 * Manager for Team.
 */
public interface TeamManager {
    /**
     * query count by query condition.
     */
    int countByQuery(TeamQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(TeamQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(TeamDO record);

    /**
     * insert selective.
     */
    long insertSelective(TeamDO record);

    /**
     * select by query condition.
     */
    List<TeamDO> selectByQuery(TeamQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<TeamDO> selectByQueryWithPage(TeamQuery query);

    /**
     * select by primary key.
     */
    TeamDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( TeamDO record,  TeamQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(TeamDO record, TeamQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(TeamDO record);
}