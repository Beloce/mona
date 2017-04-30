package com.xiangyang.VO;

import lombok.Data;

import java.util.Date;

/**
 * Created by xiangyang on 17/4/18.
 */
@Data
public class ErrorRecordVO {

    private Long recordId;

    private Long errorId;

    private Integer operationType;

    private String operationTypeName;
    /*
    操作的中文描述
     */
    private String operationTypeDesc;

    private Long operatorId;

    private String operatorFlowerName;

    private Long originalProductId;

    private Long replaceProductId;
    /*
    被指派前的产品名称
    */
    private String originalProductName;
    /*
    被指派的产品名称
     */
    private String replacementProductName;

    private Date gmtCreate;

    private String relativeCreate;

    private Date gmtModified;

    private String relativeModified;

    private Integer status;

    private String memo;
}
