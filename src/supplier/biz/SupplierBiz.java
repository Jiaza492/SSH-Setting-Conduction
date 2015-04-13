package supplier.biz;

import java.util.List;

import command.base.BaseBiz;

import entity.Tbsupplier;

public interface SupplierBiz extends BaseBiz<Tbsupplier> {

	public List<Tbsupplier> queryToX();
}
