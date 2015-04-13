package command.callback;

import org.hibernate.Session;

public interface JDBCCallback {

	public Object doInJDBC(Session session);
}
