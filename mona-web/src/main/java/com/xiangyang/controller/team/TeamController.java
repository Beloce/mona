package com.xiangyang.controller.team;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peiji on 2017/3/20.
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @RequestMapping("teamList.htm")
    public void getTeamList(ModelMap modelMap){


    }
}
