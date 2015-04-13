package command.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import command.util.Util;

public class DbProperties extends Properties {

	private static DbProperties instance;
	
	public static synchronized void makeInstance(){
		if(instance==null){
			instance = new DbProperties();
		}
	}
	public static DbProperties getInstance(){
		if(instance!=null){
			return instance;
		}else{
			makeInstance();
			return instance;
		}
		
		
	}
	private DbProperties(){
		InputStream is = getClass().getResourceAsStream(Util.dbFileName);
		
		try {
			this.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
