package com.xiangyang.form.product;

import lombok.Data;

/**
 * Created by xiangyang on 17/4/12.
 */
@Data
public class UpdateProductForm {
    private Long productId;

    private Long teamId;

    private String productName;

    private String productDesc;
}
