package org.thlws.payment.bestpay.core;

import com.xiaoleilu.hutool.bean.BeanUtil;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.thlws.payment.bestpay.api.BestpayApi;
import org.thlws.payment.bestpay.entity.input.BarcodePayInput;
import org.thlws.payment.bestpay.entity.input.OrderRefundInput;
import org.thlws.payment.bestpay.entity.input.OrderReverseInput;
import org.thlws.payment.bestpay.entity.input.QueryOrderInput;
import org.thlws.payment.bestpay.entity.output.OrderRefundOutput;
import org.thlws.payment.bestpay.entity.output.OrderResultOutput;
import org.thlws.payment.bestpay.entity.output.OrderReverseOutput;
import org.thlws.payment.bestpay.sign.MD5;

import java.util.Map;

public class BestpayCore implements BestpayApi{

	private static final Log log = LogFactory.get();

	public static OrderResultOutput barcode(BarcodePayInput input, String key) {

		OrderResultOutput out = null;

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("MERCHANTID=").append(input.getMerchantId());
			sb.append("&ORDERNO=").append(input.getOrderNo());
			sb.append("&ORDERREQNO=").append(input.getOrderReqNo());
			sb.append("&ORDERDATE=").append(input.getOrderDate());
			sb.append("&BARCODE=").append(input.getBarcode());
			sb.append("&ORDERAMT=").append(input.getOrderAmt());
			sb.append("&KEY=").append(key);
			String mac = MD5.sign(sb.toString());

			Map<String, Object> map = BeanUtil.beanToMap(input,false,true);
			map.put("mac", mac);

			String result = HttpUtil.get(barcode, map);
			out = JSONUtil.toBean(result,OrderResultOutput.class);
			log.info("天翼扫码支付返回参数[response]\n : {}",JSONUtil.formatJsonStr(result));
		} catch (Exception e) {
			log.error("天翼扫码支付异常,error={}",e.getMessage());
		}
		return out;
	}
	
	
	public static OrderResultOutput query(QueryOrderInput input, String key) {
		
		OrderResultOutput out = null;

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("MERCHANTID=").append(input.getMerchantId());
			sb.append("&ORDERNO=").append(input.getOrderNo());
			sb.append("&ORDERREQNO=").append(input.getOrderReqNo());
			sb.append("&ORDERDATE=").append(input.getOrderDate());
			sb.append("&KEY=").append(key);

			String mac = MD5.sign(sb.toString());
			Map<String, Object> map = BeanUtil.beanToMap(input,false,true);
			map.put("mac", mac);

			String result = HttpUtil.get(query, map);
			out = JSONUtil.toBean(result,OrderResultOutput.class);

		} catch (Exception e) {
			log.error("查询支付订单异常,error={}",e.getMessage());
		}
		return out;
	}
	
	
	public static OrderRefundOutput refund(OrderRefundInput input, String key) {
		
		OrderRefundOutput out = null;

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("MERCHANTID=").append(input.getMerchantId());
			sb.append("&MERCHANTPWD=").append(input.getMerchantPwd());
			sb.append("&OLDORDERNO=").append(input.getOldOrderNo());
			sb.append("&OLDORDERREQNO=").append(input.getOldOrderReqNo());
			sb.append("&REFUNDREQNO=").append(input.getRefundReqNo());
			sb.append("&REFUNDREQDATE=").append(input.getRefundReqDate() );
			sb.append("&TRANSAMT=").append(input.getTransAmt());
			sb.append("&LEDGERDETAIL=").append(input.getLedgerDetail());
			sb.append("&KEY=").append(key);

			String mac = MD5.sign(sb.toString());
			Map<String, Object> map = BeanUtil.beanToMap(input,false,true);
			map.put("mac", mac);

			String result = HttpUtil.get(refund, map);
			out = JSONUtil.toBean(result,OrderRefundOutput.class);

		} catch (Exception e) {
			log.error("退款异常,error={}",e.getMessage());
		}
		return out;
		
	}

	public static OrderReverseOutput reverse(OrderReverseInput input, String key) {
		
		
		OrderReverseOutput out = null;

		try {
			StringBuilder sb = new StringBuilder();//组装 mac 加密明文串
			sb.append("MERCHANTID=").append(input.getMerchantId());
			sb.append("&MERCHANTPWD=").append(input.getMerchantPwd());
			sb.append("&OLDORDERNO=").append(input.getOldOrderNo());
			sb.append("&OLDORDERREQNO=").append(input.getOldOrderReqNo());
			sb.append("&REFUNDREQNO=").append(input.getRefundReqNo());
			sb.append("&REFUNDREQDATE=").append(input.getRefundReqDate());
			sb.append("&TRANSAMT=").append(input.getTransAmt());
			sb.append("&KEY=").append(key);


			String mac = MD5.sign(sb.toString());
			Map<String, Object> map = BeanUtil.beanToMap(input,false,true);
			map.put("mac", mac);

			String result = HttpUtil.get(reverse, map);
			out = JSONUtil.toBean(result,OrderReverseOutput.class);

		} catch (Exception e) {
			log.error("撤销订单异常,error={}",e.getMessage());
		}
		return out;
		
	}
}
