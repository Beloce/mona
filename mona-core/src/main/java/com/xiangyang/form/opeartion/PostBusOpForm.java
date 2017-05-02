package com.xiangyang.form.opeartion;

import lombok.Data;

/**
 * Created by xiangyang on 17/5/2.
 */
@Data
public class PostBusOpForm {
    private Integer opid;

    private Long errorId;

    private Integer appraiseLevel;//打分

    private String memo;


}
