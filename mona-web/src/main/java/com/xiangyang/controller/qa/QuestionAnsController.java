package com.xiangyang.controller.qa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiangyang on 17/2/8.
 */
@Controller
@RequestMapping("/questionAns")
public class QuestionAnsController {
    @RequestMapping("/createQuestionAns")
    public String createQuestionAns(){


        return "/qa";
    }

}
