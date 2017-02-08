package com.xiangyang.form.error;

import lombok.Data;

/**
 * Created by peiji on 2017/2/8.
 */
@Data
public class ErrorForm{

    private String title;
    private Integer errorType;
    private Long productId;
    private String description;
    private String screenshot;

}
