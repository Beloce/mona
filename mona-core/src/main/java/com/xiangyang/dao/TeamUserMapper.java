package com.xiangyang.dao;

import com.xiangyang.model.TeamUserDO;
import com.xiangyang.query.TeamUserQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for TeamUser.
 */
public interface TeamUserMapper {
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
    int insertSelective(TeamUserDO record);

    /**
     * select by query condition.
     */
    List<TeamUserDO> selectByQuery(TeamUserQuery query);

    /**
     * select by primary key.
     */
    TeamUserDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") TeamUserDO record, @Param("query") TeamUserQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") TeamUserDO record, @Param("query") TeamUserQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(TeamUserDO record);
}