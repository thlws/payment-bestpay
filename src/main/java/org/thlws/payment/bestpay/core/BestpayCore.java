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
import org.thlws.payment.bestpay.utils.ThlwsJsonUtil;

import java.util.Map;

/**
 * 电信天翼支付 核心Class，提供支付相关接口
 * <h4>核心参数</h4>
 * <ul>
 *     <li>merchantId -商户号</li>
 *     <li>key -商户数据 KEY</li>
 *     <li>merchantPwd 商户密码(又称 交易key),退款&撤销时必须-</li>
 * </ul>
 * @see <a href="https://www.bestpay.com.cn/play/home">https://www.bestpay.com.cn/play/home</a>
 * Created by HanleyTang on 2018/1/5
 *
 * @author Hanley[hanley@thlws.com]
 * @version 1.0
 */
public class BestpayCore implements BestpayApi{

	private static final Log log = LogFactory.get();

	/**
	 * 天翼支付-付款码支付.
	 *
	 * @param input 支付参数对象 {@link BarcodePayInput}
	 * @param key   商户数据Key,签名需要
	 * @return 支付结果对象 {@link OrderResultOutput}
	 */
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
			log.info("天翼扫码支付请求数据[barcode]->request:\n {}", ThlwsJsonUtil.format(map));
			String result = HttpUtil.get(barcode, map);
			log.info("天翼扫码支付返回数据[barcode]->response \n : {}",ThlwsJsonUtil.format(result));
			out = JSONUtil.toBean(result,OrderResultOutput.class);
		} catch (Exception e) {
			log.error("天翼扫码支付异常[barcode],error={}",e.getMessage());
		}
		return out;
	}


	/**
	 * 查询支付订单
	 *
	 * @param input 查询参数对象 {@link QueryOrderInput}
	 * @param key   商户数据Key,签名需要
	 * @return 支付结果对象 {@link OrderResultOutput}
	 */
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
			log.info("翼支付查询请求数据[query]->request:\n {}", ThlwsJsonUtil.format(map));
			String result = HttpUtil.get(query, map);
			log.info("翼支付查询返回数据[query]->response \n : {}",ThlwsJsonUtil.format(result));
			out = JSONUtil.toBean(result,OrderResultOutput.class);

		} catch (Exception e) {
			log.error("查询支付订单异常[query],error={}",e.getMessage());
		}
		return out;
	}


	/**
	 * 商户退款,须商户密码 OrderRefundInput.merchantPwd
	 *
	 * @param input 退款参数对象 {@link OrderRefundInput}
	 * @param key   商户数据Key,签名需要
	 * @return 退款结果对象 {@link OrderRefundOutput}
	 */
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
			log.info("翼支付退款请求数据[refund]->request:\n {}", ThlwsJsonUtil.format(map));
			String result = HttpUtil.post(refund, map);
			log.info("翼支付退款返回数据[refund]->response \n : {}",ThlwsJsonUtil.format(result));
			out = JSONUtil.toBean(result,OrderRefundOutput.class);

		} catch (Exception e) {
			log.error("退款异常[refund],error={}",e.getMessage());
		}
		return out;
		
	}

	/**
	 * 撤销支付,须商户密码 OrderReverseInput.merchantPwd
	 *
	 * @param input 撤销参数对象 {@link OrderReverseInput}
	 * @param key   商户数据Key,签名需要
	 * @return 撤销结果对象 {@link OrderReverseOutput}
	 */
	public static OrderReverseOutput reverse(OrderReverseInput input, String key) {
		
		
		OrderReverseOutput out = null;

		try {
			StringBuilder sb = new StringBuilder();
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
			log.info("翼支付撤销请求数据[reverse]->request:\n {}", ThlwsJsonUtil.format(map));
			String result = HttpUtil.post(reverse, map);
			log.info("翼支付撤销返回数据[reverse]->response \n : {}",ThlwsJsonUtil.format(result));
			out = JSONUtil.toBean(result,OrderReverseOutput.class);

		} catch (Exception e) {
			log.error("撤销订单异常[reverse],error={}",e.getMessage());
		}
		return out;
		
	}
}
