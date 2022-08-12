package com.hcb.p2p.base.util;
/**
 * @Author: HCB
 * @Description:  存放当前线程需要访问的DS名字
 * @Date: 2022-07-13
 */
public class DataSourceContext {

    private static ThreadLocal<String> dataSourcePool = new ThreadLocal<>();

    public static void set(String dsName){
        dataSourcePool.set(dsName);
    }

    public static String get(){
        return dataSourcePool.get();
    }

}
