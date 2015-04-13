package command.template;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import command.callback.JDBCCallback;
import command.factory.HibernateSessionFactory;

public class HibernateTemplate {

	private Session session;
	private Transaction trnscn;

	// ����
	public <T> int executeAdd(final T t) {
		return this.executeDo(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				session.save(t);
				return null;
			}
		});
	}

	// �޸�
	// update Tbuser u set u.username=:username where u.userid=userid:
	public <T> int executeUpdate(final String hql, final Map<String, Object> map) {
		return this.executeDo(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				Query query = session.createQuery(hql);
				query.setProperties(map).executeUpdate();
				return null;
			}
		});
	}

	// ɾ��
	public <T> int executeDelete(final Serializable srlzb, final Class<T> clazz) {
		return this.executeDo(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				session.delete(session.get(clazz, srlzb));
				return null;
			}
		});
	}

	// ��������
	public <T> int executeCount(final String hql, final T t) {
		return this.executeDo(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				Query query = session.createQuery(hql);
				long rows = (Long) query.uniqueResult();
				return rows;
			}
		});
	}

	// ��Ψһ������ѯ
	@SuppressWarnings("unchecked")
	public <T> T queryById(final Serializable srlzb, final Class<T> clazz) {
		return (T) this.executeQuery(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				Object obj = null;
				obj = session.get(clazz, srlzb);
				return obj;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public <T> T queryByName(final String restriction,
			final Serializable srlzb, final Class<T> clazz) {
		return (T) this.executeQuery(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				StringBuffer sb = new StringBuffer("from ");
				sb.append(clazz.getSimpleName()).append(" obj where ");
				sb.append("obj.").append(restriction).append("=:").append(
						restriction);
				String hql = sb.toString();
				System.out.println(hql);
				Query query = session.createQuery(hql);
				return query.setParameter(restriction, srlzb).uniqueResult();
			}
		});
	}

	// ��ѯȫ��
	@SuppressWarnings("unchecked")
	public <T> List<T> queryAll(final String hql,
			final Map<String, Object> map, final Class<T> clazz) {

		Object o = this.executeQuery(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				List<T> list = null;
				// �����ѯ����
				Query query = session.createQuery(hql);
				list = query.setProperties(map).list();
				return list;
			}
		});
		// ���������Ƿ�Ϊ�ղ�����
		if (o != null) {
			return (List<T>) o;
		} else {
			System.out.println("���Ϊ��");
			return null;
		}
	}

	// ����
	@SuppressWarnings("unchecked")
	public <T> List<T> queryAll(final String hql, final Class<T> clazz) {
		Object o = this.executeQuery(new JDBCCallback() {

			@Override
			public Object doInJDBC(Session session) {
				List<T> list = null;
				// �����ѯ����
				Query query = session.createQuery(hql);
				list = query.list();
				return list;
			}
		});
		// ���������Ƿ�Ϊ�ղ�����
		if (o != null) {
			return (List<T>) o;
		} else {
			System.out.println("���Ϊ��");
			return null;
		}
	}

	// ��ѯ�ĸ�����
	private Object executeQuery(JDBCCallback jcb) {

		this.session = HibernateSessionFactory.getSession();

		Object obj = null;

		obj = jcb.doInJDBC(session);

		this.session.close();

		return obj;
	}

	// ��ɾ�ĸ�����
	private int executeDo(JDBCCallback jcb) {
		this.session = HibernateSessionFactory.getSession();
		this.trnscn = session.beginTransaction();
		int rows = 0;

		try {
			jcb.doInJDBC(session);
			this.trnscn.commit();
			rows = 1;
		} catch (HibernateException e) {
			rows = 0;
			this.trnscn.rollback();
		} finally {
			this.session.close();
		}

		return rows;
	}

	// ƴ�ӷ�����
	private String getMethodName(String verb, String column) {
		String methodName = null;
		StringBuffer sb = new StringBuffer();
		methodName = sb.append(verb).append(
				Character.toUpperCase(column.charAt(0))).append(
				column.substring(1)).toString();
		return methodName;

	}

}
