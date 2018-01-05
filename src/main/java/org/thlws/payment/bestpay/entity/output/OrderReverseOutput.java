package org.thlws.payment.bestpay.entity.output;


public class OrderReverseOutput {

	private boolean success;
	private Result result;
	private String errorCode;
	private String errorMsg;
	
	public static class Result{
		
		private String sign;
		private String refundReqNo;
		private String oldOrderNo;
		private String transAmt;
		public String getSign() {
			return sign;
		}
		public String getRefundReqNo() {
			return refundReqNo;
		}
		public String getOldOrderNo() {
			return oldOrderNo;
		}
		public String getTransAmt() {
			return transAmt;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public void setRefundReqNo(String refundReqNo) {
			this.refundReqNo = refundReqNo;
		}
		public void setOldOrderNo(String oldOrderNo) {
			this.oldOrderNo = oldOrderNo;
		}
		public void setTransAmt(String transAmt) {
			this.transAmt = transAmt;
		}
		
		@Override
		public String toString() {
			return "Result [sign=" + sign + ", refundReqNo=" + refundReqNo + ", oldOrderNo=" + oldOrderNo
					+ ", transAmt=" + transAmt + "]";
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public Result getResult() {
		return result;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "OrderReverseOutput [success=" + success + ", result=" + result + ", errorCode=" + errorCode
				+ ", errorMsg=" + errorMsg + "]";
	}
	
}
