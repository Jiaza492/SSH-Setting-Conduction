package test;

import java.util.List;

import user.biz.UserBiz;
import user.dao.UserDaoImpl;

import command.factory.DaoBizFactory;

import entity.Tbuser;

public class udaotest {
	
	private UserBiz ubiz;
	
	public void add(){
		ubiz = (UserBiz) DaoBizFactory.getInstance("UserBiz");
		Tbuser user = new Tbuser();
		user.setUsername("xxoo");
		user.setGender("溺");
		user.setAuthentity("02");
		user.setAge(22);
		user.setPassword("1234");
		user.setUseraddress("込込込");
		user.setUserphone("124sdfdsf");
		ubiz.add(user);
		
	}
	
	public void queryByName(){
		ubiz = (UserBiz) DaoBizFactory.getInstance("UserBiz");
		Tbuser u = ubiz.queryByName("username", "jiaziang");
		System.out.print(u.getUsername()+"\t");
		System.out.print(u.getPassword()+"\t");
		System.out.print(u.getAuthentity()+"\n");
	}
	
	public void queryAll(){
		Tbuser u = new Tbuser();
		ubiz = (UserBiz) DaoBizFactory.getInstance("UserBiz");
		
		u.setUsername("a");
		List<Tbuser> list = ubiz.queryAll(u);
		for(Tbuser user:list){
			System.out.print(user.getUsername()+"\t");
			System.out.print(user.getPassword()+"\t");
			System.out.print(user.getAuthentity()+"\n");
		}
	}

	public void update(){
		ubiz = (UserBiz) DaoBizFactory.getInstance("UserBiz");
		Tbuser user = new Tbuser();
		user.setUserid(3);
		user.setUsername("jza");
		user.setGender("槻");
		user.setAuthentity("02");
		user.setAge(22);
		user.setPassword("12345");
		user.setUseraddress("込込込");
		user.setUserphone("124sdfdsf");
		ubiz.update(user);
	}
	public static void main(String[] args) {

		udaotest ut = new udaotest();
		ut.queryByName();
	}
}
