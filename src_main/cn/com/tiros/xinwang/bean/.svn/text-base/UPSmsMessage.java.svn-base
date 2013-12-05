package cn.com.tiros.xinwang.bean;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.thoughtworks.xstream.XStream;

/**
 * @标题: 新网互联上行内容
 * @包名 cn.com.tiros.xinwang.bean
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class UPSmsMessage {

	private String MessageID = "";// 上行短消息ID
	private String Mobile = "";// 上行手机号码
	private String Message = "";// 上行短信内容
	private String MobaddrName = "";// 信息名址
	private String MobaddrCode = "";// 上行短信访问的名址编号
	private String ReceiveDate = "";// 上行时间
	private String ServiceRequireType = "";// 共有SMS(默认),MMS两种
	private String ServiceRequireinfo = "";// 可不填
	private String SmsServiceCode = "";// 特服号（最长不超过14位）
	private String SmsSubServiceCode = "";// 子特服号（最长不超过5位）
	private String Telcom = "";// 短信接口所属运营商
	private String Protocolname = "";// 短信接口协议版本
	private String MobileAttachId = "";// 城市区号
	private String MobileAttach = "";// 城市名
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

	public String getMobaddrCode() {
		return MobaddrCode;
	}

	public void setMobaddrCode(String mobaddrCode) {
		MobaddrCode = mobaddrCode;
	}

	public String getReceiveDate() {
		return ReceiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		ReceiveDate = receiveDate;
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

	public String getSmsServiceCode() {
		return SmsServiceCode;
	}

	public void setSmsServiceCode(String smsServiceCode) {
		SmsServiceCode = smsServiceCode;
	}

	public String getSmsSubServiceCode() {
		return SmsSubServiceCode;
	}

	public void setSmsSubServiceCode(String smsSubServiceCode) {
		SmsSubServiceCode = smsSubServiceCode;
	}

	public String getTelcom() {
		return Telcom;
	}

	public void setTelcom(String telcom) {
		Telcom = telcom;
	}

	public String getProtocolname() {
		return Protocolname;
	}

	public void setProtocolname(String protocolname) {
		Protocolname = protocolname;
	}

	public String getMobileAttachId() {
		return MobileAttachId;
	}

	public void setMobileAttachId(String mobileAttachId) {
		MobileAttachId = mobileAttachId;
	}

	public String getMobileAttach() {
		return MobileAttach;
	}

	public void setMobileAttach(String mobileAttach) {
		MobileAttach = mobileAttach;
	}

	public String getLinkID() {
		return LinkID;
	}

	public void setLinkID(String linkID) {
		LinkID = linkID;
	}

	public static void main(String args[]) throws IllegalAccessException,
			InvocationTargetException {
		XStream xs = new XStream();
		xs.alias("SmsMessage", UPSmsMessage.class);
		UPSmsMessage obj1 = new UPSmsMessage();
		obj1.setMessage("aaaa");
		String xml = xs.toXML(obj1);
		UPSmsMessage obj = (UPSmsMessage) xs.fromXML(xml);
		DownSmsMessage ds = new DownSmsMessage();
		BeanUtils.copyProperties(ds, obj);
		ds.setMessage("导航犬测试短信中心接口");
		ds.setServiceAccessType("SMS");
		ds.setMessageFmt("15");
		xs.alias("SmsMessage", DownSmsMessage.class);
		String xml1 = xs.toXML(ds);
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		sb.append("\n");
		sb.append(xml1);
		System.out.println(sb.toString());
	}

}
