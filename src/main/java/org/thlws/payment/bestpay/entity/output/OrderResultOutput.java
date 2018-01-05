package org.thlws.payment.bestpay.entity.output;

public class OrderResultOutput {

	private boolean success;
	private String errorCode;
	private String errorMsg;
	private Result result;
	
	public static class Result{
		private String merchantId;
		private String orderNo;
		private String orderReqNo;
		private String orderDate;
		private String ourTransNo;
		private String transAmt;
		private String transStatus;//A：请求（支付中）B：成功（支付成功）C：失败（订单状态结果）
		private String encodeType;//1代表MD5；3代表RSA；9代表CA；
		private String sign;
		
		private String coupon;//优惠金额 ,订单优惠金额，用户使用代金 券或立减的金额，金额为分
		private String scValue;//商 户营 销 优惠成本
		private String payerAccount;//付 款人 账 号
		private String payeeAccount;//收 款人 账 号
		private String payChannel;//付款明细
		private String productDesc;
		
		private String refundFlag;//0 代表没有退款，1 已退款 2 部分退款 3 已冲正
		private String customerId;
		private String mchntTmNum;
		private String deviceTmNum;
		private String attach;
		private String transPhone;
		private String respCode;
		private String respDesc;
		
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
		public String getOurTransNo() {
			return ourTransNo;
		}
		public String getTransAmt() {
			return transAmt;
		}
		public String getTransStatus() {
			return transStatus;
		}
		public String getEncodeType() {
			return encodeType;
		}
		public String getSign() {
			return sign;
		}
		public String getCoupon() {
			return coupon;
		}
		public String getScValue() {
			return scValue;
		}
		public String getPayerAccount() {
			return payerAccount;
		}
		public String getPayeeAccount() {
			return payeeAccount;
		}
		public String getPayChannel() {
			return payChannel;
		}
		public String getProductDesc() {
			return productDesc;
		}
		public String getRefundFlag() {
			return refundFlag;
		}
		public String getCustomerId() {
			return customerId;
		}
		public String getMchntTmNum() {
			return mchntTmNum;
		}
		public String getDeviceTmNum() {
			return deviceTmNum;
		}
		public String getAttach() {
			return attach;
		}
		public String getTransPhone() {
			return transPhone;
		}
		public String getRespCode() {
			return respCode;
		}
		public String getRespDesc() {
			return respDesc;
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
		public void setOurTransNo(String ourTransNo) {
			this.ourTransNo = ourTransNo;
		}
		public void setTransAmt(String transAmt) {
			this.transAmt = transAmt;
		}
		public void setTransStatus(String transStatus) {
			this.transStatus = transStatus;
		}
		public void setEncodeType(String encodeType) {
			this.encodeType = encodeType;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public void setCoupon(String coupon) {
			this.coupon = coupon;
		}
		public void setScValue(String scValue) {
			this.scValue = scValue;
		}
		public void setPayerAccount(String payerAccount) {
			this.payerAccount = payerAccount;
		}
		public void setPayeeAccount(String payeeAccount) {
			this.payeeAccount = payeeAccount;
		}
		public void setPayChannel(String payChannel) {
			this.payChannel = payChannel;
		}
		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}
		public void setRefundFlag(String refundFlag) {
			this.refundFlag = refundFlag;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public void setMchntTmNum(String mchntTmNum) {
			this.mchntTmNum = mchntTmNum;
		}
		public void setDeviceTmNum(String deviceTmNum) {
			this.deviceTmNum = deviceTmNum;
		}
		public void setAttach(String attach) {
			this.attach = attach;
		}
		public void setTransPhone(String transPhone) {
			this.transPhone = transPhone;
		}
		public void setRespCode(String respCode) {
			this.respCode = respCode;
		}
		public void setRespDesc(String respDesc) {
			this.respDesc = respDesc;
		}
		@Override
		public String toString() {
			return "Result [merchantId=" + merchantId + ", orderNo=" + orderNo + ", orderReqNo=" + orderReqNo
					+ ", orderDate=" + orderDate + ", ourTransNo=" + ourTransNo + ", transAmt=" + transAmt
					+ ", transStatus=" + transStatus + ", encodeType=" + encodeType + ", sign=" + sign + ", coupon="
					+ coupon + ", scValue=" + scValue + ", payerAccount=" + payerAccount + ", payeeAccount="
					+ payeeAccount + ", payChannel=" + payChannel + ", productDesc=" + productDesc + ", refundFlag="
					+ refundFlag + ", customerId=" + customerId + ", mchntTmNum=" + mchntTmNum + ", deviceTmNum="
					+ deviceTmNum + ", attach=" + attach + ", transPhone=" + transPhone + ", respCode=" + respCode
					+ ", respDesc=" + respDesc + "]";
		}
		
	}

	public boolean isSuccess() {
		return success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Result getResult() {
		return result;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "BarcodePayOutput [success=" + success + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg
				+ ", result=" + result + "]";
	}
	
	/***
	 * transStatus--> A：请求（支付中）	B：成功（支付成功）		C：失败（订单状态结果）
	 * @return
	 */
	public boolean isPaySuccess() {
		if(success == true && null != result && result.getTransStatus().equalsIgnoreCase("B")){
			return true;
		}else {
			return false;
		}
	}
	
}


