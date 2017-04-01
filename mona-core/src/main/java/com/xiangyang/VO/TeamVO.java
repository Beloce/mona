package com.xiangyang.VO;

import com.xiangyang.model.UserDO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by peiji on 2017/3/20.
 */
@Data
public class TeamVO {
    private Long teamId;

    /**
     * This field corresponds to the database column mona_team.team_name
     */
    private String teamName;

    /**
     * This field corresponds to the database column mona_team.team_dec
     */
    private String teamDec;

    /**
     * This field corresponds to the database column mona_team.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column mona_team.gmt_create
     */
    private Date gmtCreate;


    private String gmtCreateStr;

    private List<UserDO> teamUsers;//团队用户名称列表

    private List<UserDO> teamLeaders;//团队负责人名称列表


}
