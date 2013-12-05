package cn.com.tiros.common.ioc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @标题: 替换字符过滤器
 * @包名 cn.com.tiros.common.ioc
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
public class Sqlinject implements Filter {

	/**
	 * 过滤器
	 * 
	 * @param req
	 * @param response
	 * @param chain过滤器链
	 * @return
	 */
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String param = "";
		Enumeration<?> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			param = (String) params.nextElement();

			// 获得每个参数的value
			String[] values = req.getParameterValues(param);

			for (int i = 0; i < values.length; i++) {
				values[i] = Sqlinject.UrnHtml(values[i]);
			}
			req.setAttribute(param, values);
		}
		chain.doFilter(req, response);
	}

	/**
	 * 替换字符
	 * 
	 * @param strHtml需要检查替换的内容
	 * @return
	 */
	public static String UrnHtml(String strHtml) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("'", "‘");
		map.put("%", "％");
		map.put("!", "！");
		map.put(">", "＞");
		map.put("<", "＜");
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		String temp;
		while (iterator.hasNext()) {
			temp = iterator.next();
			strHtml = strHtml.replace(temp, map.get(temp));
		}
		map = null;
		return strHtml;
	}

	/**
	 * 销毁方法
	 */
	public void destroy() {
	}

	/**
	 * 初始化方法
	 */
	public void init(FilterConfig arg0) throws ServletException {
	}

}
