package com.xiangyang.form.question;

import lombok.Data;

import java.util.List;

/**
 * Created by peiji on 2017/5/4.
 */
@Data
public class AddQuestionForm {

    private Long productId;

    private String questionTitle;

    private String questionDesc;

    private String content;
}
