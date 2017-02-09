package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.form.error.ErrorForm;
import org.springframework.stereotype.Service;

/**
 * Created by xiangyang on 17/2/9.
 */
public interface ErrorAO {


    /**
     * 添加新的问题反馈
     * @param errorForm
     * @return
     */
    BizResult addNewError(ErrorForm errorForm);

}
