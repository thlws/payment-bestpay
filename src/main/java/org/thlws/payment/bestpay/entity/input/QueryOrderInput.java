package org.thlws.payment.bestpay.entity.input;

public class QueryOrderInput {
	
	/**商户号	(必填)	length=30*/
	private String merchantId;
	
	/**订单号	(必填) length=30*/
	private String orderNo;
	
	/**订单请求交 易流水号(必填),由商户平台提供，支持纯数字、纯字母、字 母+数字组成，与订单号一致 （如果需要使 用条码退款业务，流水号必须为偶数位）*/
	private String orderReqNo;
	
	/**订单日期(必填),由商户提供，长度14位，格式 yyyyMMddhhmmss (说明：该时间必须为 24小时制)*/
	private String orderDate;
	
	/**MAC校验域(必填),采用标准的MD5算法，由商户实现， MD5 加密获得32位大写字符*/
	private String mac;

	public String getMerchantId() {
		return merchantId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getOrderReqNo() {
		return orderReqNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getMac() {
		return mac;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setOrderReqNo(String orderReqNo) {
		this.orderReqNo = orderReqNo;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
}
