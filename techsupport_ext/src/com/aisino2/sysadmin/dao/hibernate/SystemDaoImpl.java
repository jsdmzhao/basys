package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.ISystemDao;
import com.aisino2.sysadmin.domain.System;
@Component
public class SystemDaoImpl extends TechSupportBaseDaoImpl implements ISystemDao {

	public void insertSystem(System system) {
		this.getHibernateTemplate().save(system);
	}

	public void deleteSystem(System system) {
		this.getHibernateTemplate().delete(system);
	}

	public void updateSystem(System system) {
		this.getHibernateTemplate().merge(system);
	}

	public System getSystem(System system) {
		return (System) this.getHibernateTemplate().get(System.class,
				system.getSystemcode());
	}

	private Map<String, Object> get_para_and_hql(System para_entity,
			StringBuffer hql) {
		List<Object> para_list = new ArrayList<Object>();
		if (para_entity != null) {
			hql.append(" where 1=1");

			if (para_entity.getSystemcode() != null) {
				hql.append(" and t.systemcode = ?");
				para_list.add(para_entity.getSystemcode());
			}

			if (para_entity.getSystemname() != null) {
				hql.append(" and t.systemname like ?");
				para_list.add(para_entity.getSystemname() + "%");
			}

			if (para_entity.getParent() != null) {
				hql.append(" and t.parent = ?");
				para_list.add(para_entity.getParent());
			}

		}

		Map<String, Object> para_map = new HashMap<String, Object>();
		para_map.put("hql", hql);
		para_map.put("para", para_list);
		return para_map;
	}

	@SuppressWarnings("unchecked")
	public List getListForPage(final System system, final int pageNo,
			final int pageSize, String sort, String desc) {

		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<System>>() {

			public List<System> doInHibernate(Session sess)
					throws HibernateException, SQLException {
				
				List resultList = new ArrayList();
				Criteria q = sess.createCriteria(System.class, "t");
				Example ex = Example.create(System.class);
				ex.excludeZeroes();
				ex.ignoreCase();
				q.add(ex);
				
				//条件
				if(system.getSystemcode()!=null)
					q.add(Restrictions.eq("t.systemcode", system.getSystemcode()));
				
				//长度
				Integer count = 0;
				q.setProjection(Projections.rowCount());
				count = ((Long)q.uniqueResult()).intValue();
				resultList.add(count);
				q.setProjection(null);
				resultList.add(q.list());
				return resultList;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<System> getListSystem(final System system) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<System>>() {

			public List<System> doInHibernate(Session sess)
					throws HibernateException, SQLException {
				
				Criteria q = sess.createCriteria(System.class,"t");
				Example ex = Example.create(System.class);
				ex.excludeZeroes();
				ex.ignoreCase();
				q.add(ex);
				
				//条件
				if(system.getSystemcode()!=null)
					q.add(Restrictions.eq("t.systemcode", system.getSystemcode()));
				
				return q.list();
				
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<System> getChildSystem(System system) {
		this.getHibernateTemplate().setCacheQueries(true);
		String hql = "from System t where ";
		List<Object> paraList = new ArrayList<Object>();

		if(system == null || system.getSystemcode() == null){
			hql += " t.parent is null";
		}
		else{
			hql += " t.parent = ? ";
			paraList.add(system);
		}
		return this.getHibernateTemplate().find(hql,paraList.toArray());
	}

	public List getTheUserChildSystem(System system) {
		// TODO Auto-generated method stub
		return null;
	}

	public System getParentSystem(System system) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllChildSystem(System system) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isExit(Map condition) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkChild(System system) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getSystemByUserID(System system) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getNextNodeorder(final System system) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select max(nvl(t,0))+1 from System t" +
						"where 1=1";
				List<Object> paraList = new ArrayList<Object>();
				
				if(system.getParent()!=null){
					hql += " and t.parent = ?";
					paraList.add(system.getParent());
				}
				else
					hql += " and t.parent is null";
				Query q = session.createQuery(hql);
				for(int i=0;i<paraList.size();i++)
					q.setParameter(i, paraList.get(i));
				
				Integer nodeorder = (Integer) q.uniqueResult();
				
				return nodeorder;
			}
		});
	}

}
