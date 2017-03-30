package com.xiangyang.controller.team;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.AO.TeamAO;
import com.xiangyang.BizResult;
import com.xiangyang.VO.TeamVO;
import com.xiangyang.form.team.AddTeamForm;
import com.xiangyang.form.team.QueryTeamForm;
import com.xiangyang.model.DepartmentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("addTeam.htm")
    public String addTeamList(ModelMap modelMap){
        Long techDepartTopId = 12l;//暂时写死
        List<DepartmentDO> departmentDOs = departmentAO.querySonDepartmentListById(techDepartTopId);
        modelMap.addAttribute("departmentTreeList",departmentDOs);
        return "/team/addTeam";
    }

    @RequestMapping(value = "doAddTeam",method = RequestMethod.POST)
    @ResponseBody
    public Object doAddTeam(@RequestBody AddTeamForm addTeamForm){
        BizResult bizResult = new BizResult();
        bizResult = teamAO.addTeamByForm(addTeamForm);
        return bizResult;
    }
}
