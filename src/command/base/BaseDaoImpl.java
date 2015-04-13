package command.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.support.HibernateSupport;

public class BaseDaoImpl<T> extends HibernateSupport implements BaseDao<T> {

	@SuppressWarnings("unchecked")
	public T queryByName(String restriction,String name, T t) {
		return (T)this.getHt().queryByName(restriction, name, t.getClass());
	}

	@SuppressWarnings("unchecked")
	public T queryById(Serializable id, T t) {
		return (T) this.getHt().queryById(id, t.getClass());
	}

	@SuppressWarnings("unchecked")
	public List<T> queryAll(String hql, Map<String, Object> map, T t) {
		return (List<T>) this.getHt().queryAll(hql,map, t.getClass());
	}

	public void add(T t) {
		this.getHt().executeAdd(t);
	}

	public void delete(Serializable id, T t) {
		this.getHt().executeDelete(id, t.getClass());
	}

	public void update(String hql, Map<String, Object> map) {
		int rows = this.getHt().executeUpdate(hql,map);
		System.out.println(rows);
	}

	public long queryCount(String hql,T t) {
		
		return this.getHt().executeCount(hql,t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryToX(String hql, T t) {
		return (List<T>)this.getHt().queryAll(hql,t.getClass());
	}

	@Override
	public T login(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
