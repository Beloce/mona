package com.xiangyang.util;

import com.xiangyang.VO.ErrorRecordVO;
import com.xiangyang.enums.errorrecord.ErrorRecordOpTypeEnum;
import org.springframework.expression.Operation;

/**
 * Created by xiangyang on 17/4/18.
 */
public class ErrorRecodDescUtil {

    public static String transOperation(Integer operationId, ErrorRecordVO errorRecordVO){
        if(operationId == null){
            return "";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.PUBLISH.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 发布了该问题";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.POINT.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 将问题指派给—>"+ errorRecordVO.getReplacementFlowerName();
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.CLOSE.getCode())){
            return errorRecordVO.getOperatorFlowerName()+"关闭了该问题";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.FILL_INVENTORY.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 填写了该问题的问题清单";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.COMMENT.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 评论了该问题的解决者";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.RESOLVE.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 已经解决了该问题，待确认";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.CONFIRM.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 确认了该问题，正在解决中...";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.RESOLVE_CONFIRM.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 确认问题已经解决";
        }
        else if(operationId.equals(ErrorRecordOpTypeEnum.CONFIRM.getCode())){
            return errorRecordVO.getOperatorFlowerName()+" 确认问题没有被解决，待重新解决问题";
        }
        else{
            return "";
        }
    }
}
