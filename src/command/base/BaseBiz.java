package command.base;

import java.io.Serializable;
import java.util.List;

public interface BaseBiz<T> {

	public T queryByName(String restriction, String name);
	
	public T queryById(Serializable id, T t);
	
	public List<T> queryAll(T t);
	
	public void add(T t);
	
	public void delete(Serializable id, T t);
	
	public void update(T t);
	
	public long queryCount(T t);
}
