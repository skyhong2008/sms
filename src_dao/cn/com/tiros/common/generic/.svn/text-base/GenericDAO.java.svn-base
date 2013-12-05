package cn.com.tiros.common.generic;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @标题: sping的jdbc
 * @包名 cn.com.tiros.common.generic
 * @描述: TODO
 * @编写人：管月秋
 * @创建日期： 2012-7-17 下午1:30:21
 * @修改人：
 * @修改日期： 2012-7-17 下午1:30:21
 * @版本：
 */
// @Repository("genericDAO")
public class GenericDAO {

	// spring的jdbc模板
	// @Resource
	private JdbcTemplate jdbcTemp;

	/**
	 * 增删改操作
	 * 
	 * @param sql语句
	 * @return
	 * @throws DataAccessException
	 */
	public int execute(String sql) throws DataAccessException {
		return jdbcTemp.update(sql);
	}

	/**
	 * 增删改操作
	 * 
	 * @param sql语句
	 * @param params参数
	 * @return
	 * @throws DataAccessException
	 */
	public int execute(String sql, Object[] params) throws DataAccessException {
		return jdbcTemp.update(sql, params);
	}

	/**
	 * 获得查询的总数
	 * 
	 * @param sql语句
	 * @return
	 * @throws DataAccessException
	 */
	public int queryGetCount(String sql) throws DataAccessException {
		try {
			return jdbcTemp.queryForInt(sql);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 获得查询的总数
	 * 
	 * @param sql语句
	 * @param params参数
	 * @return
	 * @throws DataAccessException
	 */
	public int queryGetCount(String sql, Object[] params)
			throws DataAccessException {
		return jdbcTemp.queryForInt(sql, params);
	}

	/**
	 * 获得查询的结果集 返回List<Map<String, Object>>
	 * 
	 * @param sql语句
	 * @param params参数
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryGetList(String sql, Object[] params)
			throws DataAccessException {
		return jdbcTemp.queryForList(sql, params);
	}

	/**
	 * 获得查询的结果集 返回List<Map<String, Object>>
	 * 
	 * @param sql语句
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryGetList(String sql)
			throws DataAccessException {
		return jdbcTemp.queryForList(sql);
	}

	/**
	 * 获得一行的值 返回 MAP
	 * 
	 * @param sql语句
	 * @param params参数
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> queryForMap(String sql, Object[] params)
			throws DataAccessException {
		List<Map<String, Object>> list = jdbcTemp.queryForList(sql, params);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 获得一行的值 返回 MAP
	 * 
	 * @param sql语句
	 * @param params参数
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> queryForMap(String sql)
			throws DataAccessException {
		List<Map<String, Object>> list = jdbcTemp.queryForList(sql);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 批量更新(小批量)
	 * 
	 * @param sql语句
	 * @return
	 * @throws DataAccessException
	 */
	public int[] batchUpdate(String[] sql) throws DataAccessException {
		return jdbcTemp.batchUpdate(sql);
	}

	/**
	 * 批量更新(小批量)
	 * 
	 * @param sql语句
	 * @"call testpro('p1','p2')";
	 * @return
	 * @throws DataAccessException
	 */
	public void call(String call) throws DataAccessException {
	}

}
