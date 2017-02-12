package com.xiangyang.manager;

import com.xiangyang.BizResult;

import java.io.File;
import java.io.IOException;

/**
 * Created by peiji on 2017/2/12.
 */
public interface ImageManager {

    BizResult upload(File file) throws IOException;
}
