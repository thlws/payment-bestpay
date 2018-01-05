package org.thlws.payment.bestpay.entity.input;

public class OrderReverseInput {

	private String merchantId;
	private String subMerchantId;
	private String merchantPwd;
	private String oldOrderNo;
	private String oldOrderReqNo;
	private String refundReqNo;
	private String refundReqDate;//yyyyMMDD
	private String transAmt;
	private String channel = "05";
	private String mac;
	public String getMerchantId() {
		return merchantId;
	}
	public String getSubMerchantId() {
		return subMerchantId;
	}
	public String getMerchantPwd() {
		return merchantPwd;
	}
	public String getOldOrderNo() {
		return oldOrderNo;
	}
	public String getOldOrderReqNo() {
		return oldOrderReqNo;
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
	public String getChannel() {
		return channel;
	}
	public String getMac() {
		return mac;
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
	public void setOldOrderNo(String oldOrderNo) {
		this.oldOrderNo = oldOrderNo;
	}
	public void setOldOrderReqNo(String oldOrderReqNo) {
		this.oldOrderReqNo = oldOrderReqNo;
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
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
}
