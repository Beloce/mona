package com.xiangyang.controller.team;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.AO.TeamAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.AddTeamForm;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.model.DepartmentDO;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by peiji on 2017/3/20.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    TeamAO teamAO;

    @Autowired
    DepartmentAO departmentAO;

    /**
     * 获取team信息
     * @param modelMap
     */
    @RequiresRoles("admin")
    @RequestMapping("teamList.htm")
    public String getTeamList(ModelMap modelMap){
        QueryTeamForm queryTeamForm = new QueryTeamForm();
        queryTeamForm.setPageSize(20);
        queryTeamForm.setPageNo(1);
        BizResult<List<TeamVO>> bizResult = teamAO.getTeamListInPage(queryTeamForm);
        modelMap.addAttribute("teamList",bizResult.getResult());
        return "/team/teamList";
    }

    @RequiresRoles("admin")
    @RequestMapping("addTeam.htm")
    public String addTeamList(ModelMap modelMap){
        Long techDepartTopId = 12l;//暂时写死
        List<DepartmentDO> departmentDOs = departmentAO.querySonDepartmentListById(techDepartTopId);
        modelMap.addAttribute("departmentTreeList",departmentDOs);
        return "/team/addTeam";
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "doAddTeam",method = RequestMethod.POST)
    @ResponseBody
    public Object doAddTeam(@RequestBody AddTeamForm addTeamForm){
        BizResult bizResult = teamAO.addTeamByForm(addTeamForm);
        return bizResult;
    }
    /**
     * 查询团队详情
     * @param teamId
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "detail.json",method = RequestMethod.GET)
    @ResponseBody
    public Object getDetail(@RequestParam("teamId") Long teamId){
        BizResult bizResult = teamAO.queryTeamVOById(teamId);
        return bizResult;
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "detail.htm")
    public String detail(@RequestParam("teamId") Long teamId,ModelMap modelMap){
        BizResult bizResult = teamAO.queryTeamVOById(teamId);
        TeamVO teamVO = (TeamVO)bizResult.getResult();
        modelMap.addAttribute("teamVO",teamVO);
        return "team/detail";
    }
}
