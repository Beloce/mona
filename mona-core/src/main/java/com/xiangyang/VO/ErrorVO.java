package com.xiangyang.VO;

import lombok.Data;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by peiji on 2017/2/22.
 */
@Data
public class ErrorVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * This field corresponds to the database column mona_error.error_id
     */
    private Long errorId;

    /**
     * This field corresponds to the database column mona_error.product_id
     */
    private Long productId;

    private String productName;

    /**
     * This field corresponds to the database column mona_error.title
     */
    private String title;

    /**
     * This field corresponds to the database column mona_error.description
     */
    private String description;

    /**
     * This field corresponds to the database column mona_error.screenshot
     */
    private String screenshot;

    private List<String> pics;

    /**
     * This field corresponds to the database column mona_error.source
     */
    private Integer source;

    /**
     * This field corresponds to the database column mona_error.type
     */
    private Integer type;

    //类型描述
    private String typeDesc;
    /**
     * This field corresponds to the database column mona_error.status
     */
    private Integer status;

    //状态描述
    private String statusDesc;
    /**
     * This field corresponds to the database column mona_error.provider_id
     */
    private Long providerId;

    private String providerFlowerName;

    private String providerRealName;
    /**
     * This field corresponds to the database column mona_error.gmt_modified
     */
    private Date gmtModified;

    //相对于当前时间的修改时间
    private String relativeModified;

    /**
     * This field corresponds to the database column mona_error.gmt_create
     */
    private Date gmtCreate;

    //相对于当前时间的创建时间
    private String relativeCreate;
}
