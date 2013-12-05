package cn.com.tiros.common.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @标题: 服务间调用工具类
 * @包名 cn.com.tiros.common.util
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class HttpClientCommon {

	// 日志
	private static final Log log = LogFactory.getLog("httpClientCommon");

	/**
	 * 调用其他服务[get]接口
	 * 
	 * @param url跳转地址
	 * @param value参数
	 * @return state说明：1.成功 2.对方程序错误 3.返回参数错误 4.连接错误
	 */
	public static Map<String, String> commonGet(String url, String value) {
		log.info("==========进入调用其他服务[get]接口==========");
		log.info("请求URL：" + url);
		log.info("请求参数：" + value);

		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "1");// 默认成功
		try {
			URL u = new URL(url + "?" + value);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setAllowUserInteraction(false);
			// huc.setAllowUserInteraction(true);
			huc.setConnectTimeout(8000); // 用不超时，除非服务端主动断开连接
			huc.setReadTimeout(10000); // 读取数据超时时间，用不超时，除非服务器主动断开连接
			// huc.setRequestMethod("POST");
			huc.setRequestMethod("GET");
			huc.setDoOutput(true);
			huc.setDoInput(true);
			huc.setUseCaches(false);
			huc.setRequestProperty("Accept", "text/html");
			huc.setRequestProperty("Content-type", "application/octest-stream");
			// huc.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded");
			// huc.setRequestProperty("Content-type","text/html;charset=UTF-8");
			huc.setRequestProperty("Connection", "close"); // 短连接，请求一处理完关闭连接
			huc.connect();// 会发生异常

			int responseCode = huc.getResponseCode();
			if (responseCode == 200) {
				log.info("请求成功:" + responseCode);
				StringBuilder sb = new StringBuilder();
				InputStream in = huc.getInputStream();
				int len = 0;
				byte[] data = new byte[1024];
				while ((len = in.read(data)) != -1) {
					sb.append(new String(data, 0, len, "UTF-8"));
				}

				String temp = sb.toString();
				if (null != temp && !"".equals(temp)) {
					map.put("result", sb.toString());// 返回参数
					log.info("请求成功，返回参数为: " + temp);
				} else {
					map.put("state", "3");// 连接正常，返回参数为空
					log.info("请求成功，返回参数为空: " + temp);
				}
				in.close();
			} else if (responseCode == 500) {
				log.info("对方程序错误: " + "HTTP Error 500!");
				map.put("state", "2");// 程序错误
			} else {
				log.info("对方程序错误: " + responseCode + ":Other Http Error!");
				map.put("state", "2");// 程序错误
			}
		} catch (Exception e) {
			log.error("连接错误", e);
			if (e.toString().contains("Read timed out")) {// 响应超时
				log.info("响应超时: Read timed out!");
			}
			if (e.toString().contains("connect timed out")) {// 连接超时
				log.info("连接超时: connect timed out!");
			}
			map.put("state", "4");// 连接错误
		}
		log.info("==========退出调用其他服务[get]接口==========");
		return map;
	}

	/**
	 * 调用其他服务[post]接口
	 * 
	 * @param url跳转地址
	 * @param value参数
	 * @return state说明：1.成功 2.对方程序错误 3.返回参数错误 4.连接错误
	 */
	public static Map<String, String> commonPostStream(String url, String value) {
		log.info("==========进入调用其他服务[post]接口==========");
		log.info("请求URL：" + url);
		log.info("请求参数：" + value);

		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "1");// 默认成功
		try {
			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setAllowUserInteraction(false);
			// huc.setAllowUserInteraction(true);
			huc.setConnectTimeout(8000); // 用不超时，除非服务端主动断开连接
			huc.setReadTimeout(10000); // 读取数据超时时间，用不超时，除非服务器主动断开连接
			huc.setRequestMethod("POST");
			// huc.setRequestMethod("Get");
			huc.setDoOutput(true);
			huc.setDoInput(true);
			huc.setUseCaches(false);
			huc.setRequestProperty("Accept", "text/html");
			// huc.setRequestProperty("Content-type",
			// "application/octest-stream");
			huc.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// huc.setRequestProperty("Content-type","text/html;charset=UTF-8");
			huc.setRequestProperty("Connection", "close"); // 短连接，请求一处理完关闭连接
			huc.connect();// 会发生异常

			// 写流
			PrintWriter out = new PrintWriter(huc.getOutputStream());
			out.print(value);
			out.flush();
			out.close();

			int responseCode = huc.getResponseCode();
			if (responseCode == 200) {
				log.info("请求成功:" + responseCode);
				StringBuilder sb = new StringBuilder();
				InputStream in = huc.getInputStream();
				int len = 0;
				byte[] data = new byte[1024];
				while ((len = in.read(data)) != -1) {
					sb.append(new String(data, 0, len, "UTF-8"));
				}

				String temp = sb.toString();
				if (null != temp && !"".equals(temp)) {
					map.put("result", sb.toString());// 返回参数
					log.info("请求成功，返回参数为: " + temp);
				} else {
					map.put("state", "3");// 连接正常，返回参数为空
					log.info("请求成功，返回参数为空: " + temp);
				}
				in.close();
			} else if (responseCode == 500) {
				log.info("对方程序错误: " + "HTTP Error 500!");
				map.put("state", "2");// 程序错误
			} else {
				log.info("对方程序错误: " + responseCode + ":Other Http Error!");
				map.put("state", "2");// 程序错误
			}
		} catch (Exception e) {
			log.error("连接错误", e);
			if (e.toString().contains("Read timed out")) {// 响应超时
				log.info("响应超时: Read timed out!");
			}
			if (e.toString().contains("connect timed out")) {// 连接超时
				log.info("连接超时: connect timed out!");
			}
			map.put("state", "4");// 连接错误
		}
		log.info("==========退出调用其他服务[post]接口==========");
		return map;
	}

}
