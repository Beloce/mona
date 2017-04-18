package com.xiangyang.AO;

import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;

import java.util.List;

/**
 * Created by xiangyang on 17/4/18.
 */
public interface ErrorRecordAO {

    /**
     * 添加创建问题记录
     * @param errorDO
     * @return
     */
    boolean addCreateErrorRecord(ErrorDO errorDO);


    /**
     * 通过errorID查询问题记录
     * @param errorId
     * @return
     */
    List<ErrorRecordVO> queryErrorRecordList(Long errorId);

    /**
     * 获取当前问题的技术负责人（正在处理的人）
     * @param errorId
     * @return
     */
    Long getHeadTechUserId(Long errorId);


}
