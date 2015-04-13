package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import supplier.biz.SupplierBiz;
import supplier.biz.SupplierBizImpl;
import entity.Tbbill;
import entity.Tbsupplier;

public class SupTest {

	private SupplierBiz sbiz;

	public void queryToX() {
		sbiz = new SupplierBizImpl();
		List<Tbsupplier> list = this.sbiz.queryToX();
		for (Tbsupplier sup : list) {
			System.out.println(sup.getSuppliername() + "\t");
			Set<Tbbill> bills = sup.getBills();
			Iterator<Tbbill> bit = bills.iterator();
			while (bit.hasNext()) {
				Tbbill bil = bit.next();
				System.out.print(bil.getBillid() + "\t");
				System.out.print(bil.getCommname() + "\t");
				System.out.print(bil.getSupplier().getSuppliername());
				System.out.println();
			}
		}

	}

	public void queryAll() {
		sbiz = new SupplierBizImpl();
		Tbsupplier t = new Tbsupplier();
		t.setSuppliername("×÷·»");
		t.setSupplierdiscribe("");
		List<Tbsupplier> list = this.sbiz.queryAll(t);
		for(Tbsupplier obj : list){
			System.out.println(obj.getSuppliername()+"\t");
			Set<Tbbill> bills = obj.getBills();
			Iterator<Tbbill> bit = bills.iterator();
			while (bit.hasNext()) {
				Tbbill bil = bit.next();
				System.out.print(bil.getBillid() + "\t");
				System.out.print(bil.getCommname() + "\t");
				System.out.print(bil.getSupplier().getSuppliername());
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		SupTest st = new SupTest();
		st.queryAll();
	}
}
