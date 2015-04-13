package command.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	public T queryByName(String restriction, String name,T t);
	
	public T queryById(Serializable id, T t);
	
	public List<T> queryAll(String hql, Map<String, Object> map, T t);
	
	public List<T> queryToX(String hqp, T t);
	
	public void add(T t);
	
	public void delete(Serializable id, T t);
	
	public void update(String hql, Map<String, Object> map);
	
	public long queryCount(String hql, T t);
	
	public T login(T t);
	
	
}
