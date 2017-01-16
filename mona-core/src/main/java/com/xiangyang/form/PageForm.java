package com.xiangyang.form;

import com.xiangyang.util.query.support.BaseQuery;

/**
 * Created by xiangyang on 17/1/16.
 */

public class PageForm {
    protected Integer pageSize = BaseQuery.DEFAULT_PAGE_SIZE;
    protected Integer pageNo = BaseQuery.DEFAULT_PAGE;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

