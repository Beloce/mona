package com.xiangyang.form.product;

import lombok.Data;

/**
 * Created by peiji on 2017/5/4.
 */
@Data
public class AddProductForm {
    private String productName;

    private String productDesc;

    private Long teamId;
}
