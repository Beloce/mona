package com.xiangyang.controller.log;

import com.xiangyang.AO.ErrorAO;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    final Logger logger  =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    ErrorAO errorAO;


    @RequestMapping("/show.htm")
    public String show(@RequestParam(value = "date", required = false) String date, ModelMap modelMap){
        if(date == null || date == ""){
            date = TimeUtils.getTodayDate();
        }
        modelMap.addAttribute("todayDate", date);
        try{
            Date queryDate = TimeUtils.formatStrToDate(TimeUtils.YYYY年MM月DD,date);
            List<ErrorVO> errorVOs = errorAO.findErrorVOByLogDate(queryDate);
            modelMap.addAttribute("errorVOs",errorVOs);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return "/log/show";
    }
}
