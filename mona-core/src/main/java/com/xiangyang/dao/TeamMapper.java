package com.xiangyang.dao;

import com.xiangyang.model.TeamDO;
import com.xiangyang.query.TeamQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Team.
 */
public interface TeamMapper {
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
    int insertSelective(TeamDO record);

    /**
     * select by query condition.
     */
    List<TeamDO> selectByQuery(TeamQuery query);

    /**
     * select by primary key.
     */
    TeamDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") TeamDO record, @Param("query") TeamQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") TeamDO record, @Param("query") TeamQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(TeamDO record);
}