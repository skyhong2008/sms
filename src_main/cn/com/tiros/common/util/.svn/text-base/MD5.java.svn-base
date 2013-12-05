package cn.com.tiros.common.util;

import java.security.MessageDigest;

/**
 * @标题: MD5
 * @包名 cn.com.tiros.common.util
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class MD5 {

	/**
	 * 构造方法
	 */
	public MD5() {
	}

	/**
	 * 加密方法
	 * 
	 * @param inStr需要加密的数据
	 * @return
	 */
	public static String compute(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * 主方法测试
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(compute("123456"));
	}

}
