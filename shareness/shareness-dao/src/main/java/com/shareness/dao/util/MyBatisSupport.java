package com.shareness.dao.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 通用DAO实现
 * @param <DAO>
 * @param <T>
 */
@Repository
public abstract class MyBatisSupport<DAO,T> extends SqlSessionDaoSupport implements IMyBatisSupport<T> {

	private DAO dao;
	private Class<DAO> mapperClass;
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public MyBatisSupport() {
		Type[] types = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments();
		mapperClass = (Class<DAO>)types[0];
	}
	
	protected DAO getMapper() {
		dao = getSqlSession().getMapper(mapperClass);
		return dao;
	}
	
	protected String getMybatisNamespace(){
		return mapperClass.getName();
	}
	
	/**
     * 执行SQL语句
     * @param 	sql
     * 				要执行的SQL语句
     * @return
     * 				是否执行成功
     */
//    public boolean execuateSQL(String sql) {
//    	Integer i = (Integer)getSqlMapClientTemplate().queryForObject("systemComm.execuateSQL", sql);
//    	i = i==null?0:i;
//    	return i != -1;
//    }
    
    /**
     * 执行任意的查询的SQL语句
     * @param sql
     * 				要执行的SQL语句
     * @return
     * 				 返回查询后的结果集
     */
//    public List<Map<String, Object>> execuateSelectSQL(String sql){
//    	return getSqlMapClientTemplate().queryForList("systemComm.execuateSelectSQL",sql);
//	}
    
    /**
     * 根据多条件查询，返回一个page对象
     * @param	ibatisSqlId
     * 				查询时使用的SQL ID
     * @param	parameterObject
     * 				查询时的动态参数对象
     * @param 	currentPageNo
     * 				当前页数
     * @param	limit
     * 				每页显示的记录数
     * @return
     * 				返回分页对象
     */
//    protected Page<List<Map<String, Object>>> pageList(String ibatisSqlId,Object parameterObject,int currentPageNo, int limit){
//    	//以下获取运行期的SQL语句
//		SqlMapExecutorDelegate delegate = ((ExtendedSqlMapClient)getSqlMapClientTemplate().getSqlMapClient()).getDelegate();
//    	MappedStatement ms = delegate.getMappedStatement(ibatisSqlId); 
//    	Sql ibaSql = ms.getSql();
//    	SessionScope sessionScope = new SessionScope();     
//        sessionScope.incrementRequestStackDepth();     
//        StatementScope statementScope = new StatementScope(sessionScope);     
//        ms.initRequest(statementScope);
//        //获取运行时的SQL语句
//        String sql = ibaSql.getSql(statementScope, parameterObject);
//        //获取统计记录总数的SQL语句
//        String totalSql = Dialect.getTotalSql(sql);
//        //统计记录总数
//        long totalCount = (Long)getSqlMapClientTemplate().queryForObject("systemComm.execuateSQL", totalSql);
//        //获取开始索引
//		long startIndex = Page.getStartOfPage(currentPageNo, limit, totalCount);
//        //获取分页查询的SQL语句
//        String pageSQl = Dialect.getLimitStringByMySQL(sql, startIndex, limit);
//        List<Map<String,Object>> resultList = getSqlMapClientTemplate().queryForList("systemComm.execuateSelectSQL", pageSQl);
//    	return new Page<List<Map<String, Object>>>(currentPageNo, totalCount, limit, resultList);
//    }
    
    /**
     * 根据多条件查询，返回一个page对象
     * @param ibatisSqlId
     * 				查询时使用的SQL ID
     * @param parameterObject
     * 				查询时的动态参数对象
     * @return
     * 				返回分页对象
     */
//    protected Page<List> pageList(String ibatisSqlId,Map<String,Object> parameterObject){
//    	//获取当前页数
//    	int currentPageNo = (Integer)parameterObject.get("currentPageNo");
//    	//获取每页显示的记录数
//    	int limit = (Integer)parameterObject.get("limit");
//    	//获取开始索引
//    	long startIndex = Page.getStartOfPage(currentPageNo, limit);
//    	parameterObject.put("startIndex", startIndex);
//    	List resultList = getSqlMapClientTemplate().queryForList(ibatisSqlId, parameterObject);
//    	long totalCount = (Long)getSqlMapClientTemplate().queryForObject("systemComm.selectCount");
//    	return new Page<List>(currentPageNo, totalCount, limit, resultList);
//    }
}
