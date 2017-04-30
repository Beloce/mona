package com.xiangyang.form.opeartion;

import lombok.Data;

/**
 * Created by peiji on 2017/4/22.
 */
@Data
public class PostOpForm {
    private Integer opid;

    private Long errorId;

    private String memo;

    private Long pointTo;

    private String reason;
}
