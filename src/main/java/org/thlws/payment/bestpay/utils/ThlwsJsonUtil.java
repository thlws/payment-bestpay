package org.thlws.payment.bestpay.utils;

import cn.hutool.json.JSONUtil;

/**
 * JSON格式化工具
 * Created by HanleyTang on 2018/1/5
 *
 * @author Hanley[hanley @thlws.com]
 * @version 1.0
 */
public class ThlwsJsonUtil {

    /**
     * 格式化JSON.
     *
     * @param o 任意对象
     * @return 格式友好的 JSON String
     */
    public static String format(Object o){
        return JSONUtil.parse(o).toStringPretty();
    }

    /**
     * 格式化JSON.
     *
     * @param jsonStr JSON格式字符串
     * @return 格式友好的 JSON String
     */
    public static String format(String jsonStr){
        return JSONUtil.formatJsonStr(jsonStr);
    }
}
