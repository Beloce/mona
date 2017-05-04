package com.xiangyang.controller.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peiji on 2017/5/4.
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @RequestMapping("show.htm")
    public String show(){

        return "/statistics/show";
    }
}
