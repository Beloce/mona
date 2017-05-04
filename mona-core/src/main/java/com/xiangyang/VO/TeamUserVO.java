package com.xiangyang.VO;

import lombok.Data;

import java.util.Date;

/**
 * Created by peiji on 2017/5/4.
 */
@Data
public class TeamUserVO {
    private Long id;

    /**
     * This field corresponds to the database column mona_team_user.user_id
     */
    private Long userId;

    private String userFlowerName;

    /**
     * This field corresponds to the database column mona_team_user.team_id
     */
    private Long teamId;

    /**
     * This field corresponds to the database column mona_team_user.role
     */
    private Integer role;


    private Integer leaderCode;

    /**
     * This field corresponds to the database column mona_team_user.memo
     */
    private String memo;

    /**
     * This field corresponds to the database column mona_team_user.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column mona_team_user.gmt_modified
     */
    private Date gmtModified;
}
