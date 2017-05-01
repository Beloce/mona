package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;

import java.util.List;

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

    /**
     * 获取当前技术人员用户名下的业务问题列表
     * @param userDO
     * @return
     */
    List<ErrorVO> queryBussinessErrorListByUserDO(UserDO userDO);

    /**
     * 获取当前业务人员的所有业务问题
     * @param userDO
     * @return
     */
    List<ErrorVO> queryUserBussinessErrorList(UserDO userDO, QueryErrorForm queryErrorForm);

    /**
     * 获取当前业务人员的待解决业务问题
     * @param userDO
     * @param queryErrorForm
     * @return
     */
    List<ErrorVO> queryBussinessWaitErrorList(UserDO userDO, QueryErrorForm queryErrorForm);

    /**
     * 获取当前业务人员的待已解决业务问题
     * @param userDO
     * @param queryErrorForm
     * @return
     */
    List<ErrorVO> queryBussinessOverErrorList(UserDO userDO, QueryErrorForm queryErrorForm);


    /**
     * 通过产品Id获取该产品所有待处理的所有的问题
     * @param productIds
     * @return
     */
    List<ErrorVO> queryWaitBussErrorsByProductIds(List<Long> productIds);

    /**
     * 通过条件分类筛选，非精确检索
     * @param queryErrorForm
     * @return
     */
    BizResult<List<ErrorVO>> queryBussinessErrorList(QueryErrorForm queryErrorForm);


    ErrorVO findErrorVOById(Long errorId);




}
