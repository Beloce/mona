package com.xiangyang.controller.team;

import com.xiangyang.AO.TeamAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.QueryTeamForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by peiji on 2017/3/20.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamAO teamAO;

    /**
     * 获取team信息
     * @param modelMap
     */
    @RequestMapping("teamList.htm")
    public String getTeamList(ModelMap modelMap){
        QueryTeamForm queryTeamForm = new QueryTeamForm();
        queryTeamForm.setPageSize(20);
        queryTeamForm.setPageNo(1);
        BizResult<List<TeamVO>> bizResult = new BizResult();
        bizResult = teamAO.getTeamListInPage(queryTeamForm);
        modelMap.addAttribute("teamList",bizResult.getResult());
        return "/team/teamList";
    }
}
