package user.biz;

import java.util.List;

import command.base.BaseBiz;

import entity.Tbuser;

public interface UserBiz extends BaseBiz<Tbuser>{
	
	public Tbuser login(Tbuser u);
	
}
