package command.support;

import command.factory.HibernateFactory;
import command.template.HibernateTemplate;

public class HibernateSupport {

	private HibernateTemplate ht;
	
	public HibernateSupport(){
		ht = HibernateFactory.getinstance(HibernateTemplate.class);
	}

	public HibernateTemplate getHt() {
		return ht;
	}

}
