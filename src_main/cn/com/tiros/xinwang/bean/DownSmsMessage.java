package cn.com.tiros.xinwang.bean;

/**
 * @标题: 新网互联下行内容
 * @包名 cn.com.tiros.xinwang.bean
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class DownSmsMessage {

	private String MessageID = "";// 下行短信ID，必须与上行短信ID一致
	private String Mobile = "";// 下行手机号码，与上行手机号一致
	private String Message = "";// 下行短信内容
	private String MobaddrName = "";// 信息名址
	private String ServiceType = "";// 可不填
	private String ServiceLevel = "";// 可不填
	private String ServiceRequireType = "";// 可不填
	private String ServiceRequireinfo = "";// 可不填
	private String ServiceAccessType = "SMS";// 共有SMS,WAPPUSH两种 默认SMS
	private String ServiceAccessInfo = "";// 可不填
	private String MessageFmt = "15";// 下行信息格式，4（WAPPUSH），15为短信
	private String ServiceCode = "";// 特服号（最长不超过14位） 必须与上行短信一致
	private String SmsSubServiceCode = "";// 子特服号（最长不超过5位）
	private String WAPPUSHURL = "";// wappush的url
	private String LinkID = "";// 业务鉴权ID

	public String getMessageID() {
		return MessageID;
	}

	public void setMessageID(String messageID) {
		MessageID = messageID;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getMobaddrName() {
		return MobaddrName;
	}

	public void setMobaddrName(String mobaddrName) {
		MobaddrName = mobaddrName;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public String getServiceLevel() {
		return ServiceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		ServiceLevel = serviceLevel;
	}

	public String getServiceRequireType() {
		return ServiceRequireType;
	}

	public void setServiceRequireType(String serviceRequireType) {
		ServiceRequireType = serviceRequireType;
	}

	public String getServiceRequireinfo() {
		return ServiceRequireinfo;
	}

	public void setServiceRequireinfo(String serviceRequireinfo) {
		ServiceRequireinfo = serviceRequireinfo;
	}

	public String getServiceAccessType() {
		return ServiceAccessType;
	}

	public void setServiceAccessType(String serviceAccessType) {
		ServiceAccessType = serviceAccessType;
	}

	public String getServiceAccessInfo() {
		return ServiceAccessInfo;
	}

	public void setServiceAccessInfo(String serviceAccessInfo) {
		ServiceAccessInfo = serviceAccessInfo;
	}

	public String getMessageFmt() {
		return MessageFmt;
	}

	public void setMessageFmt(String messageFmt) {
		MessageFmt = messageFmt;
	}

	public String getServiceCode() {
		return ServiceCode;
	}

	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}

	public String getSmsSubServiceCode() {
		return SmsSubServiceCode;
	}

	public void setSmsSubServiceCode(String smsSubServiceCode) {
		SmsSubServiceCode = smsSubServiceCode;
	}

	public String getWAPPUSHURL() {
		return WAPPUSHURL;
	}

	public void setWAPPUSHURL(String wAPPUSHURL) {
		WAPPUSHURL = wAPPUSHURL;
	}

	public String getLinkID() {
		return LinkID;
	}

	public void setLinkID(String linkID) {
		LinkID = linkID;
	}

}
