package command.factory;

import java.util.HashMap;
import java.util.Map;

import command.properties.DbProperties;


public class DaoBizFactory {

	private static Map<String, Object> map = new HashMap<String, Object>();
	
	public static Object getInstance(String className){
		Object db = null;
		
		if(map.containsKey(className)){
			db = map.get(className);
			System.out.println("取得了一个对象"+className);
		}else {
			try {
				db = Class.forName(DbProperties.getInstance().getProperty(className)).newInstance();
				map.put(className, db);
				System.out.println("生成了一个对象"+className);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return db;
	}
}
