package com.xiangyang.form.team;

import lombok.Data;

import java.util.List;

/**
 * Created by peiji on 2017/3/30.
 */
@Data
public class AddTeamForm {
    private String teamName;
    private String teamDesc;
    private List<Long> teamUserIds;
    private List<Long> leaderIds;
}
