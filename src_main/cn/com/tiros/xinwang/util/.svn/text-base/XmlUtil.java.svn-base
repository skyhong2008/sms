package cn.com.tiros.xinwang.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @标题: Xml工具类
 * @包名 cn.com.tiros.xinwang.util
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class XmlUtil {

	// 日志记录
	private static Log log = LogFactory.getLog("xinwang");

	/**
	 * 数据流转换成字符串
	 * 
	 * @param readByte字节数组
	 * @param index开始位置
	 * @param charsetName编码格式
	 * @return
	 */
	public static String getXmlstr(byte[] readByte, int index,
			String charsetName) {
		try {
			return new String(readByte, index, readByte.length, charsetName);
		} catch (UnsupportedEncodingException e) {
			log.error("getXmlstr ", e);
		}
		return null;
	}

	/**
	 * 读取客户端请求的数据流
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static byte[] getReqDate(ServletRequest request) throws IOException {
		InputStream in = null;
		byte[] content = null;
		ByteArrayOutputStream out = null;
		try {
			in = request.getInputStream();
			out = new ByteArrayOutputStream();
			byte[] temp = new byte[1024];
			int size = 0;
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
			content = out.toByteArray();
		} catch (IOException e1) {
			log.error("getReqDate", e1);
			throw e1;
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e1) {
				;
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					;
				} finally {
					in = null;
				}
			}
		}
		return content;
	}

	/**
	 * 下行客户端的数据流
	 * 
	 * @param date字节数组
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public static boolean sendResDate(byte[] date, HttpServletResponse response)
			throws IOException {
		DataOutputStream dos = null;
		boolean bool = false;
		try {
			dos = new DataOutputStream(response.getOutputStream());
			response.setContentLength(date.length); // 向客户端发送下行数据
			response.setContentType("application/octest-stream");
			dos.write(date); // 输出下行数据
			bool = true;
		} catch (IOException e) {
			log.error("sendResDate", e);
			throw e;
		} finally {
			try {
				if (dos != null) {
					dos.flush();
					dos.close();
				}
			} catch (IOException e) {
				log.error(e);
			} finally {
				dos = null;
			}
		}
		return bool;
	}

}
