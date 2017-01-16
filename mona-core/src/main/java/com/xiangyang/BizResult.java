package com.xiangyang;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangyang on 16/11/10.
 */

@Data
public class BizResult<T> implements Serializable{
    public boolean success = false;//是否成功
    private T result;//数据
    public String code;
    public String msg;

}