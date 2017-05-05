package com.xiangyang.VO;

import lombok.Data;

import java.util.Date;

/**
 * Created by peiji on 2017/5/5.
 */
@Data
public class QuestionShowVO {

    private Long questionId;

    private String title;

    private Long authorId;

    private String authorName;

    private String description;

    private String content;

    private Long productId;

    private String productName;

    private Integer status;

    private Date gmtCreate;

    private String gmtCreateStr;

    private Date gmtModified;
}
