package com.xiangyang.AO;

import com.xiangyang.BizResult;
import com.xiangyang.VO.ErrorVO;
import com.xiangyang.dto.ErrorInfoDTO;
import com.xiangyang.form.error.ErrorForm;
import com.xiangyang.form.error.QueryErrorForm;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;

import java.util.Date;
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


    /**
     * 统计目前所有的待处理问题数量
     * @return
     */
    int countAllWaitToSolveError();



    /**
     * 统计目前所有的待处理问题数量
     * @return
     */
    int countTodayNewError();

    /**
     * 统计目前所有的待处理问题数量
     * @return
     */
    int countTodayDoneError();


    /**
     * 根据id获取errorVO
     * @param errorId
     * @return
     */
    ErrorVO findErrorVOById(Long errorId);

    /**
     * 通过问题编号寻找确认问题的人
     * @param errorId
     * @return
     */
    UserDO findSolverByErrorId(Long errorId);

    /**
     * 根据时间去获取当天的日志信息
     * @param date
     * @return
     */
    List<ErrorVO> findErrorVOByLogDate(Date date);

    /**
     * 根据用户查询历史所有问题列表
     * @param queryErrorForm
     * @return
     */
    List<ErrorVO> queryUserSolveErrorList(QueryErrorForm queryErrorForm);

    List<ErrorVO> queryAllHisErrorList(QueryErrorForm queryErrorForm);


    int countQueryError(QueryErrorForm queryErrorForm);



}
