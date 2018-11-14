package org.thlws.payment.bestpay.client;

import cn.hutool.core.util.StrUtil;
import org.thlws.payment.bestpay.core.BestpayCore;
import org.thlws.payment.bestpay.entity.request.BarcodePayRequest;
import org.thlws.payment.bestpay.entity.request.OrderRefundRequest;
import org.thlws.payment.bestpay.entity.request.OrderReverseRequest;
import org.thlws.payment.bestpay.entity.request.QueryOrderRequest;
import org.thlws.payment.bestpay.entity.response.OrderRefundResponse;
import org.thlws.payment.bestpay.entity.response.OrderResultResponse;
import org.thlws.payment.bestpay.entity.response.OrderReverseResponse;


/***
 * 翼支付入口
 */
public class BestPayClient {


    /***
     * 扫码支付
     * {@link BestpayCore#barcode}
     * @param request
     * @param key
     * @return
     * @throws Exception
     */
    public static OrderResultResponse barcode(BarcodePayRequest request, String key) throws Exception {

        if (null == request)
            throw new Exception("request can not be null");
        if (StrUtil.isEmpty(key))
            throw new Exception("key can not be null");

        return BestpayCore.barcode(request,key);
    }


    /***
     * 支付查询
     * {@link BestpayCore#query}
     * @param request
     * @param key
     * @return
     * @throws Exception
     */
    public static OrderResultResponse query(QueryOrderRequest request, String key) throws Exception {

        if (null == request)
            throw new Exception("request can not be null");
        if (StrUtil.isEmpty(key))
            throw new Exception("key can not be null");

        return BestpayCore.query(request,key);
    }


    /***
     * 支付退款
     * {@link BestpayCore#refund}
     * @param request
     * @param key
     * @return
     * @throws Exception
     */
    public static OrderRefundResponse refund(OrderRefundRequest request, String key) throws Exception {

        if (null == request)
            throw new Exception("request can not be null");
        if (StrUtil.isEmpty(key))
            throw new Exception("key can not be null");

        return BestpayCore.refund(request,key);
    }


    /***
     * 撤销
     * {@link BestpayCore#reverse}
     * @param request
     * @param key
     * @return
     */
    public static OrderReverseResponse reverse(OrderReverseRequest request, String key) throws Exception {

        if (null == request)
            throw new Exception("request can not be null");
        if (StrUtil.isEmpty(key))
            throw new Exception("key can not be null");

        return BestpayCore.reverse(request,key);

    }
}
