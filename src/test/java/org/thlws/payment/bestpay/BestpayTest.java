package org.thlws.payment.bestpay;

import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.lang.Console;
import com.xiaoleilu.hutool.util.RandomUtil;
import org.junit.Test;
import org.thlws.payment.bestpay.core.BestpayCore;
import org.thlws.payment.bestpay.entity.input.BarcodePayInput;
import org.thlws.payment.bestpay.entity.input.OrderRefundInput;
import org.thlws.payment.bestpay.entity.input.OrderReverseInput;
import org.thlws.payment.bestpay.entity.input.QueryOrderInput;
import org.thlws.payment.bestpay.entity.output.OrderRefundOutput;
import org.thlws.payment.bestpay.entity.output.OrderResultOutput;
import org.thlws.payment.bestpay.entity.output.OrderReverseOutput;

import java.util.HashMap;

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

		String barcode = "510094008028763507";
		String orderAmt = "1";
		String orderNo = RandomUtil.randomNumbers(16);

		BarcodePayInput input = new BarcodePayInput();
		input.setMerchantId(merchantId);
		input.setBarcode(barcode);
		input.setOrderNo(orderNo);
		input.setOrderReqNo(orderNo);
		input.setOrderDate("20171224121212");
		input.setOrderAmt(orderAmt);
		input.setProductAmt(orderAmt);
		input.setGoodsName("测试商品");
		input.setStoreId("00001025104487");

		OrderResultOutput output = BestpayCore.barcode(input, key);
		assertTrue(output.isPaySuccess());

	}


	/**
	 * 查询交易-测试.
	 */
	@Test
	public  void testQuery() {
		QueryOrderInput input = new QueryOrderInput();
		input.setMerchantId(merchantId);
		input.setOrderNo("5241085967971143");
		input.setOrderReqNo("5241085967971143");
		input.setOrderDate("20171224121212");

		OrderResultOutput output = BestpayCore.query(input, key);
		assertNotNull(output.getResult());
	}

	/**
	 * 撤销支付-测试.
	 */
	@Test
	public  void testReverse() {

		OrderReverseInput input = new OrderReverseInput();
		input.setMerchantId(merchantId);
		input.setMerchantPwd(merchantPwd);
		input.setOldOrderNo("5241085967971143");
		input.setOldOrderReqNo("5241085967971143");
		input.setRefundReqNo(RandomUtil.randomNumbers(16));
		input.setRefundReqDate("20171224");
		input.setTransAmt("1");

		OrderReverseOutput output = BestpayCore.reverse(input, key);
		assertNotNull(output.getResult());
	}


	/**
	 * 退款-测试.
	 */
	@Test
	public  void testRefund() {
		OrderRefundInput input = new OrderRefundInput();
		input.setMerchantId("02450107030126669");
		input.setOldOrderNo("5241085967971143");
		input.setOldOrderReqNo("5241085967971143");
		input.setMerchantPwd(merchantPwd);
		input.setRefundReqDate("20171224");
		input.setRefundReqNo(RandomUtil.randomNumbers(16));
		input.setTransAmt("1");

		OrderRefundOutput output = BestpayCore.refund(input, key);
		assertNotNull(output.getResult());
	}








}
