package user.dao;

import command.base.BaseDaoImpl;

import entity.Tbuser;

public class UserDaoImpl extends BaseDaoImpl<Tbuser> implements UserDao{

	@Override
	public Tbuser login(Tbuser user) {
		//from Tbuser u where u.username=:username and u.password=:password
		Tbuser u = new Tbuser();
		
		return u;
	}

}
