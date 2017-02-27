package com.xiangyang.dto;

import com.xiangyang.VO.ErrorVO;
import com.xiangyang.model.ErrorDO;
import com.xiangyang.model.UserDO;
import lombok.Data;

/**
 * Created by peiji on 2017/2/21.
 */
@Data
public class ErrorInfoDTO {

    private ErrorVO errorVO;

    private UserDO userDO;

}
