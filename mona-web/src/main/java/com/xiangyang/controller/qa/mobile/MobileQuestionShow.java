package com.xiangyang.controller.qa.mobile;

import com.xiangyang.BizResult;
import com.xiangyang.contants.MobilePageContants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peiji on 2017/2/25.
 */
@Controller
@RequestMapping("/mobileQuestion")
public class MobileQuestionShow {

    /**
     * H5端的常见问题展示
     * @param modelMap
     * @return
     */
    @RequestMapping("/mobileQuestionShowList.htm")
    public String mobileQuestionShowList(ModelMap modelMap){
        modelMap.addAttribute("page", MobilePageContants.MOBILE_PAGE_3);
        return "/qa/mobile/mobileQuestionShowList";
    }
}
