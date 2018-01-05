package org.thlws.payment.bestpay.entity.input;

public class OrderRefundInput {

	/**商户号	(必填)	length=30*/
	private String merchantId;
	
	/**子商户号	length=30*/
	private String subMerchantId;
	
	/**商户调用密码（必填），商户执行时需填入相应密码 ，又称：交易key*/
	private String merchantPwd;
	
	/**原扣款订单号(必填) length=30*/
	private String oldOrderNo;
	
	/**原订单请求支付 流水号(必填)*/
	private String oldOrderReqNo;
	
	/**退款流水号(必填)*/
	private String refundReqNo;
	
	/**退款请求日期(必填),yyyyMMDD*/
	private String refundReqDate;
	
	/**退款交易金额(必填)*/
	private String transAmt;
	
	/**分账明细*/
	private String ledgerDetail;
	
	/**渠道(必填)*/
	private String channel = "05";
	
	/**Mac校验域(必填),MD5加密获得32位大写字符*/
	private String mac;
	
	/**退款回调地址*/
	private String bgUrl;

	public String getOldOrderNo() {
		return oldOrderNo;
	}

	public String getOldOrderReqNo() {
		return oldOrderReqNo;
	}

	public void setOldOrderNo(String oldOrderNo) {
		this.oldOrderNo = oldOrderNo;
	}

	public void setOldOrderReqNo(String oldOrderReqNo) {
		this.oldOrderReqNo = oldOrderReqNo;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public String getMerchantPwd() {
		return merchantPwd;
	}

	public String getRefundReqNo() {
		return refundReqNo;
	}

	public String getRefundReqDate() {
		return refundReqDate;
	}

	public String getTransAmt() {
		return transAmt;
	}

	public String getLedgerDetail() {
		return ledgerDetail;
	}

	public String getChannel() {
		return channel;
	}

	public String getMac() {
		return mac;
	}

	public String getBgUrl() {
		return bgUrl;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public void setMerchantPwd(String merchantPwd) {
		this.merchantPwd = merchantPwd;
	}

	public void setRefundReqNo(String refundReqNo) {
		this.refundReqNo = refundReqNo;
	}

	public void setRefundReqDate(String refundReqDate) {
		this.refundReqDate = refundReqDate;
	}

	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt;
	}

	public void setLedgerDetail(String ledgerDetail) {
		this.ledgerDetail = ledgerDetail;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}
	
	
}
