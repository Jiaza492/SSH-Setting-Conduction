package command.factory;

import java.util.HashMap;
import java.util.Map;

import command.template.HibernateTemplate;

public class HibernateFactory {

	private static Map<String, HibernateTemplate> map = new HashMap<String, HibernateTemplate>();
	
	public static HibernateTemplate getinstance(Class<HibernateTemplate> clazz){
		HibernateTemplate ht = null;
		if(map.containsKey(clazz.getSimpleName())){
			ht = map.get(clazz.getSimpleName());
		}else{
			try {
				ht = clazz.newInstance();
				map.put(clazz.getSimpleName(), ht);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ht;
	}
}
