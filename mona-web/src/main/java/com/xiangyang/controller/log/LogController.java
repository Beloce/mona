package com.xiangyang.controller.log;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by peiji on 2017/5/3.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    ErrorAO errorAO;


    @RequestMapping("/show.htm")
    public String show(@RequestParam String date, ModelMap modelMap){
        modelMap.addAttribute("todayDate", TimeUtils.getTodayDate());
        if(date == null || date == ""){
            date = TimeUtils.getTodayDate();
        }
        try{
            Date queryDate = TimeUtils.formatStrToDate(TimeUtils.YYYY年MM月DD,date);
            List<ErrorVO> errorVOs = errorAO.findErrorVOByLogDate(queryDate);
            modelMap.addAttribute("errorVOs",errorVOs);
        }catch (Exception e){
        }
        return "/log/show";
    }
}
