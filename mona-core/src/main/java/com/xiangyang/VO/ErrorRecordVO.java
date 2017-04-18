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
    /*
    操作的中文描述
     */
    private String operationTypeDesc;

    private Long operatorId;

    private String operatorFlowerName;

    private Long replacementId;
    /*
    被指派者的花名
     */
    private String replacementFlowerName;

    private Date gmtCreate;

    private String relativeCreate;

    private Date gmtModified;

    private String relativeModified;

    private Integer status;

    private String memo;
}
