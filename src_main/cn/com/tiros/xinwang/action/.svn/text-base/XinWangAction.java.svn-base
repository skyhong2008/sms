package cn.com.tiros.xinwang.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thoughtworks.xstream.XStream;

import cn.com.tiros.xinwang.bean.DownSmsMessage;
import cn.com.tiros.xinwang.bean.UPSmsMessage;
import cn.com.tiros.xinwang.service.IXinwangService;
import cn.com.tiros.xinwang.util.XmlUtil;

/**
 * @标题: 新网互联短信通道接口
 * @包名 cn.com.tiros.xinwang.action
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
@Controller
public class XinWangAction {

	// 日志记录
	private static Log log = LogFactory.getLog("xinwang");

	// 依赖注入新网服务模块
	@Resource(name = "xinwangService")
	private IXinwangService xinwangService;

	/**
	 * 新网互联接口
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/smsMessage.htm")
	public void smsMessage(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			log.info("smsMessage 请求开始。。。。。。。。。。。");
			Date date = new Date();// 收到请求时间

			byte[] content = XmlUtil.getReqDate(request);
			String xmlString = XmlUtil.getXmlstr(content, 0, "gb2312");
			log.info("上行xml内容：" + xmlString);

			// 解析上行数据
			XStream xs = new XStream();
			xs.alias("SmsMessage", UPSmsMessage.class);
			UPSmsMessage obj = (UPSmsMessage) xs.fromXML(xmlString);

			// 调用注册服务
			String message = xinwangService.smsRegist(obj.getMobile(),
					obj.getMessage());

			// 封装下行数据
			DownSmsMessage ds = new DownSmsMessage();
			BeanUtils.copyProperties(ds, obj);
			ds.setMessage(message);
			ds.setServiceCode(obj.getSmsServiceCode());
			xs.alias("SmsMessage", DownSmsMessage.class);
			String xml = xs.toXML(ds);

			// 拼接xml头部
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			sb.append("\n");
			sb.append(xml);
			log.info("下行xml内容:" + sb.toString());

			// 返回下行数据
			XmlUtil.sendResDate(sb.toString().getBytes("gb2312"), response);
			log.info("smsMessage 请求结束。。。。。。。。。。。");

			// 调用统计服务
			log.info("smsMessage 请求统计服务开始。。。。。。。。。。。");
			xinwangService.statistics(obj.getMobile(), date);
			log.info("smsMessage 请求统计服务结束。。。。。。。。。。。");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("smsMessage出现异常:", e);
		}
	}

}
