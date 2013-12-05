package cn.com.tiros.xinwang.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cn.com.tiros.common.util.Constants;
import cn.com.tiros.common.util.HttpClientCommon;
import cn.com.tiros.common.util.MD5;
import cn.com.tiros.xinwang.service.IXinwangService;

/**
 * @标题: 新网互联服务实现类
 * @包名 cn.com.tiros.xinwang.service.impl
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
@Service("xinwangService")
public class XinwangServiceImpl implements IXinwangService {

	// 日志记录
	private static Log log = LogFactory.getLog("xinwang");

	/**
	 * 调用短信注册接口
	 * 
	 * @param mobile手机号码
	 * @param message短信内容
	 * @return下行短信内容
	 */
	public String smsRegist(String mobile, String message) {
		log.info("原始参数:[mobile:" + mobile + ",message:" + message + "]");
		if (null != mobile && !"".equals(mobile)) {
			if (mobile.length() > 11) {
				mobile = mobile.substring(mobile.length() - 11);
			}
		}
		if (null != message) {
			message = message.trim();
		}
		log.info("调整参数:[mobile:" + mobile + ",message:" + message + "]");
		boolean flag = false;
		String smsRegistURL = "";
		String type = "0";

		if (null != message && !"".equals(message)) {
			if ("导航犬".equals(message)) {
				type = "8";// 发短信“导航犬”到12114
			} else {
				ResourceBundle bundle = ResourceBundle.getBundle("config");
				if (message.startsWith("@$Test#")) {
					smsRegistURL = bundle.getString("smsRegistURL_ceshi");// 调用测试服务器
					message = message.substring(9);
				} else {
					smsRegistURL = bundle.getString("smsRegistURL_zhengshi");// 调用正式服务器
				}

				// 验证格式
				String check = "^[0-9a-zA-Z]{6,32}$";
				Pattern regex = Pattern.compile(check);
				Matcher matcher = regex.matcher(message);
				if (matcher.matches()) {
					flag = true;
					log.info("格式正确！");
				} else {
					log.info("格式错误！");
				}
			}
		}

		if (flag) {
			String parameters = "phone="
					+ mobile
					+ "&pwd="
					+ message
					+ "&key="
					+ MD5.compute(mobile + message
							+ Constants.REGISTER_PHONE_KEY);
			Map<String, String> map = HttpClientCommon.commonGet(smsRegistURL,
					parameters);
			String state = map.get("state");
			if ("1".equals(state)) {
				JSONObject jsonObject = JSONObject
						.fromObject(map.get("result"));
				type = jsonObject.get("result").toString();
			}
		}
		return this.getMessage(type);
	}

	/**
	 * 获取下行短信内容
	 * 
	 * @param result下行短信内容
	 * @return
	 */
	private String getMessage(String type) {
		ResourceBundle bundle = ResourceBundle.getBundle("content_zhongwen");
		String message = bundle.getString("content");
		if ("3".equals(type)) {
			message = bundle.getString("content_3");
		} else if ("7".equals(type)) {
			message = bundle.getString("content_7");
		} else if ("8".equals(type)) {
			message = bundle.getString("content_8");
		}
		return message;
	}

	/**
	 * 调用统计服务接口
	 * 
	 * @param mobile手机号
	 * @param date收到请求时间
	 */
	public void statistics(String mobile, Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		String time = simpleDateFormat.format(date);
		log.info("原始参数:[mobile:" + mobile + ",date:" + time + "]");
		if (null != mobile && !"".equals(mobile)) {
			if (mobile.length() > 11) {
				mobile = mobile.substring(mobile.length() - 11);
			}
		}
		log.info("调整参数:[mobile:" + mobile + ",date:" + time + "]");

		ResourceBundle bundle = ResourceBundle.getBundle("config");
		String parameters = "date=" + time + "&telephonenum=" + mobile;
		Map<String, String> map = HttpClientCommon.commonGet(
				bundle.getString("statisticsURL_zhengshi"), parameters);
		String state = map.get("state");
		if ("1".equals(state) || "3".equals(state)) {
			log.info("请求统计服务成功");
			log.info("返回内容：" + map.get("result"));
		} else {
			log.info("请求统计服务失败");
		}
	}
}
