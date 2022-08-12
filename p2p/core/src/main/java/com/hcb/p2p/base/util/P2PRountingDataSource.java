package com.hcb.p2p.base.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
public class P2PRountingDataSource extends AbstractRoutingDataSource {
    /**
     * @Author: HCB
     * @Description:  这个方法返回当前目标的ds名字
     * @Date: 2022-07-13
     * @return: java.lang.Object
     */

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContext.get();
    }


}
