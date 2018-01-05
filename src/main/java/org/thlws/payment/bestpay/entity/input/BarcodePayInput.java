package org.thlws.payment.bestpay.entity.input;

public class BarcodePayInput {

	/**商户号	(必填)	length=30*/
	private String merchantId;
	
	/**子商户号	length=30*/
	private String subMerchantId;
	
	/**条形码号(必填)	 length=30*/
	private String barcode;
	
	/**订单号	(必填) length=30*/
	private String orderNo;
	
	/**订单请求交 易流水号(必填),由商户平台提供，支持纯数字、纯字母、字 母+数字组成，与订单号一致 （如果需要使 用条码退款业务，流水号必须为偶数位）*/
	private String orderReqNo;
	
	/**渠道(必填),默认填：05*/
	private String channel = "05";
	
	/**业务类型(必填), 默认填：0000001*/
	private String busiType = "0000001";
	
	/**订单日期(必填),由商户提供，长度14位，格式 yyyyMMddhhmmss (说明：该时间必须为 24小时制)*/
	private String orderDate;
	
	/**订单总金额(必填),length=10 单位：分。订单总金额 = 产品金额+附加金 额*/
	private String orderAmt;
	
	/**产品金额(必填), length=10*/
	private String productAmt;
	
	/**附加金额(必填),length=10*/
	private String attachAmt = "0";
	
	/**商品名称(必填),length=256*/
	private String goodsName;
	
	/**门店号(必填),length=10*/
	private String storeId;
	
	/**后台返回地址,商户提供的用于异步接收交易返回结果的后 台url，若不需要后台返回，可不填，若需要 后台返回，请保障地址可用*/
	private String backUrl;
	
	/**分账信息,length=256*/
	private String ledgerDetail;
	
	/**附加信息,length=128*/
	private String attach;
	
	/**MAC校验域(必填),采用标准的MD5算法，由商户实现， MD5 加密获得32位大写字符*/
	private String mac;
	
	/**商户自定义 终端号*/
	private String mchntTmNum;
	
	/**设备终端号*/
	private String deviceTmNum;

	public String getMerchantId() {
		return merchantId;
	}

	public String getSubMerchantId() {
		return subMerchantId;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getOrderReqNo() {
		return orderReqNo;
	}

	public String getChannel() {
		return channel;
	}

	public String getBusiType() {
		return busiType;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getOrderAmt() {
		return orderAmt;
	}

	public String getProductAmt() {
		return productAmt;
	}

	public String getAttachAmt() {
		return attachAmt;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getStoreId() {
		return storeId;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public String getLedgerDetail() {
		return ledgerDetail;
	}

	public String getAttach() {
		return attach;
	}

	public String getMac() {
		return mac;
	}

	public String getMchntTmNum() {
		return mchntTmNum;
	}

	public String getDeviceTmNum() {
		return deviceTmNum;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setOrderReqNo(String orderReqNo) {
		this.orderReqNo = orderReqNo;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderAmt(String orderAmt) {
		this.orderAmt = orderAmt;
	}

	public void setProductAmt(String productAmt) {
		this.productAmt = productAmt;
	}

	public void setAttachAmt(String attachAmt) {
		this.attachAmt = attachAmt;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public void setLedgerDetail(String ledgerDetail) {
		this.ledgerDetail = ledgerDetail;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setMchntTmNum(String mchntTmNum) {
		this.mchntTmNum = mchntTmNum;
	}

	public void setDeviceTmNum(String deviceTmNum) {
		this.deviceTmNum = deviceTmNum;
	}
	
	
}
