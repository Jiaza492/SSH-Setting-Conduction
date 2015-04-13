package user.biz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.factory.DaoBizFactory;

import user.dao.UserDao;
import entity.Tbuser;

public class UserBizImpl implements UserBiz {

	private UserDao udao;
	
	public UserBizImpl(){
		this.udao = (UserDao)DaoBizFactory.getInstance("UserDao");
	}
	
	@Override
	public void add(Tbuser t) {
		this.udao.add(t);

	}

	@Override
	//delete Tbuser users where users.userid=:userid
	public void delete(Serializable id, Tbuser t) {
		this.udao.delete(id, t);

	}

	@Override
	//from Tbuser
	public List<Tbuser> queryAll(Tbuser t) {
		StringBuffer sb = new StringBuffer("from Tbuser obj where 1=1 ");
		Map<String, Object> map = new HashMap<String, Object>();
		if(t.getUsername()!=null && !t.getUsername().equals("")){
			sb.append("and obj.username like :username");
			map.put("username", "%"+t.getUsername()+"%");
		}
		if(t.getAuthentity()!=null && !t.getAuthentity().equals("")){
			sb.append("and obj.authentity=:authentity");
			map.put("authentity", t.getAuthentity());
		}
		String hql = sb.toString();
		System.out.println(hql);
		return this.udao.queryAll(hql, map, t);
	}

	@Override
	public Tbuser queryById(Serializable id, Tbuser t) {
		return this.udao.queryById(id, t);
	}

	@Override
	//from Tbuser users where users.username=:username
	public Tbuser queryByName(String restriction, String name) {
		return this.udao.queryByName(restriction,name,new Tbuser());
	}

	@Override
	//select count(*) from Tbuser
	public long queryCount(Tbuser t) {
		String hql = "select count(*) from Tbuser obj";
		return this.udao.queryCount(hql, t);
	}

	@Override
	//update Tbuser users set users.username=:username where users.userid=:userid
	public void update(Tbuser t) {
		String hql = "update Tbuser obj set obj.username=:username,obj.password=:password where userid=:userid";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", t.getUsername());
		map.put("password", t.getPassword());
		map.put("userid", t.getUserid());
		this.udao.update(hql, map);
	}

	@Override
	//from Tbuser u where u.username=:zhangqiang and u.password=:weilonglong
	public Tbuser login(Tbuser u) {
		// TODO Auto-generated method stub
		return null;
	}

}
