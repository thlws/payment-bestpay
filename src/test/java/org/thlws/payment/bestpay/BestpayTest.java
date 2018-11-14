package org.thlws.payment.bestpay;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.junit.Test;
import org.thlws.payment.bestpay.core.BestpayCore;
import org.thlws.payment.bestpay.entity.request.BarcodePayRequest;
import org.thlws.payment.bestpay.entity.request.OrderRefundRequest;
import org.thlws.payment.bestpay.entity.request.OrderReverseRequest;
import org.thlws.payment.bestpay.entity.request.QueryOrderRequest;
import org.thlws.payment.bestpay.entity.response.OrderRefundResponse;
import org.thlws.payment.bestpay.entity.response.OrderResultResponse;
import org.thlws.payment.bestpay.entity.response.OrderReverseResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by HanleyTang on 2018/1/5
 * 电信天翼支付测试
 *
 * @author Hanley[hanley @thlws.com]
 * @version 1.0
 */
public class BestpayTest {

	private static final Log log = LogFactory.get();

	/**商户数据 KEY*/
	private final  String key = "E20356A94DA4E83810993FD14C10657F3120F1EDA1C43BF7";

	/**商户退款密码(又称 交易key)*/
	private final  String merchantPwd = "946476";

	/**商户号*/
	private final  String merchantId = "02450107030126669";


	/**
	 * 支付-测试.
	 */
	@Test
	public  void testPay() {

		try {
			String barcode = "510094008028763507";
			String orderAmt = "1";
			String orderNo = RandomUtil.randomNumbers(16);

			BarcodePayRequest input = new BarcodePayRequest();
			input.setMerchantId(merchantId);
			input.setBarcode(barcode);
			input.setOrderNo(orderNo);
			input.setOrderReqNo(orderNo);
			input.setOrderDate("20171224121212");
			input.setOrderAmt(orderAmt);
			input.setProductAmt(orderAmt);
			input.setGoodsName("测试商品");
			input.setStoreId("00001025104487");

			OrderResultResponse output = BestpayCore.barcode(input, key);
			assertTrue(output.isPaySuccess());
		} catch (Exception e) {
			log.error(e);
		}

	}


	/**
	 * 查询交易-测试.
	 */
	@Test
	public  void testQuery() {
		try {
			QueryOrderRequest input = new QueryOrderRequest();
			input.setMerchantId(merchantId);
			input.setOrderNo("5241085967971143");
			input.setOrderReqNo("5241085967971143");
			input.setOrderDate("20171224121212");

			OrderResultResponse output = BestpayCore.query(input, key);
			assertNotNull(output);
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 撤销支付-测试.
	 */
	@Test
	public  void testReverse() {

		try {
			OrderReverseRequest input = new OrderReverseRequest();
			input.setMerchantId(merchantId);
			input.setMerchantPwd(merchantPwd);
			input.setOldOrderNo("5241085967971143");
			input.setOldOrderReqNo("5241085967971143");
			input.setRefundReqNo(RandomUtil.randomNumbers(16));
			input.setRefundReqDate("20171224");
			input.setTransAmt("1");

			OrderReverseResponse output = BestpayCore.reverse(input, key);
			assertNotNull(output.getResult());
		} catch (Exception e) {
			log.error(e);
		}
	}


	/**
	 * 退款-测试.
	 */
	@Test
	public  void testRefund() {
		try {
			OrderRefundRequest input = new OrderRefundRequest();
			input.setMerchantId("02450107030126669");
			input.setOldOrderNo("5241085967971143");
			input.setOldOrderReqNo("5241085967971143");
			input.setMerchantPwd(merchantPwd);
			input.setRefundReqDate("20171224");
			input.setRefundReqNo(RandomUtil.randomNumbers(16));
			input.setTransAmt("1");

			OrderRefundResponse output = BestpayCore.refund(input, key);
			assertNotNull(output.getResult());
		} catch (Exception e) {
			log.error(e);
		}
	}


}
