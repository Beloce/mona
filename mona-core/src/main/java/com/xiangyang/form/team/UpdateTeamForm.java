package com.xiangyang.form.team;

import lombok.Data;

import java.util.List;

/**
 * Created by peiji on 2017/5/4.
 */
@Data
public class UpdateTeamForm {
    private Long teamId;
    private String teamName;
    private String teamDesc;
    private List<Long> teamUserIds;
    private List<Long> leaderIds;
}
