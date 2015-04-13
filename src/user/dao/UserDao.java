package user.dao;

import command.base.BaseDao;

import entity.Tbuser;

public interface UserDao extends BaseDao<Tbuser> {

	public Tbuser login(Tbuser user);
	
}
