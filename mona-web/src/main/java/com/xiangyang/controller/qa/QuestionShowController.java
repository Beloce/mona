package com.xiangyang.controller.qa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiangyang on 17/1/16.
 */
@Controller
@RequestMapping("/qa")
public class QuestionShowController {
    @RequestMapping("/questionList.htm")
    public String questionList(){


        return "/qa/questionList";
    }
}
