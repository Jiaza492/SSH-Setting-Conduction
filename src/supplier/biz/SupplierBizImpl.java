package supplier.biz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import supplier.dao.SupplierDao;

import command.factory.DaoBizFactory;

import entity.Tbsupplier;

public class SupplierBizImpl implements SupplierBiz {
	
	private SupplierDao sdao;
	
	public SupplierBizImpl(){
		this.sdao = (SupplierDao)DaoBizFactory.getInstance("SupplierDao");
	}
	
	@Override
	public void add(Tbsupplier t) {
		this.sdao.add(t);

	}

	@Override
	public void delete(Serializable id, Tbsupplier t) {
		this.sdao.delete(id, t);

	}

	@Override
	public List<Tbsupplier> queryAll(Tbsupplier t) {
		StringBuffer sb = new StringBuffer("from Tbsupplier obj where 1=1");
		Map<String, Object> map = new HashMap<String, Object>();
		if(t.getSuppliername()!=null && !t.getSuppliername().equals("")){
			sb.append(" and obj.suppliername like :suppliername");
			map.put("suppliername", "%"+t.getSuppliername()+"%");
		}
		if(t.getSupplierdiscribe()!=null && !t.getSupplierdiscribe().equals("")){
			sb.append(" and obj.supplierdiscribe like :supplierdiscribe");
			map.put("supplierdiscribe", "%"+t.getSupplierdiscribe()+"%");
		}
		
		String hql = sb.toString();
		System.out.println(hql);
		return this.sdao.queryAll(hql, map, t);
	}

	@Override
	public Tbsupplier queryById(Serializable id, Tbsupplier t) {
		
		return this.sdao.queryById(id, t);
	}

	@Override
	public Tbsupplier queryByName(String restriction, String name) {
		
		return this.sdao.queryByName(restriction, name, new Tbsupplier());
	}

	@Override
	public long queryCount(Tbsupplier t) {
		String hql = "select count(*) from Tbsupplier obj";
		return this.sdao.queryCount(hql, t);
	}

	@Override
	public void update(Tbsupplier t) {
		StringBuffer sb = new StringBuffer("update Tbsupplier obj ");
		Map<String, Object> map = new HashMap<String, Object>();
		if(t.getSuppliername()!=null && !t.getSuppliername().equals("")){
			sb.append("set obj.suppliername=:supname");
			map.put("supname", t.getSuppliername());
		}
		if(t.getSupplierdiscribe()!=null && !t.getSupplierdiscribe().equals("")){
			sb.append(",set obj.supplierdiscribe=:supdesc");
			map.put("supdesc", t.getSupplierdiscribe());
		}
		sb.append(" where obj.supplierid=:supplierid");
		String hql = sb.toString();
		System.out.println(hql);

		this.sdao.update(hql, map);
	}

	@Override
	public List<Tbsupplier> queryToX() {
		String hql = "from Tbsupplier obj";
		return this.sdao.queryToX(hql, new Tbsupplier());
	}

}
