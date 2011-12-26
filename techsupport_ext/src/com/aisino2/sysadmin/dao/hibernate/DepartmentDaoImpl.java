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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;

@Component
public class DepartmentDaoImpl extends TechSupportBaseDaoImpl implements
		IDepartmentDao {

	public void insertDepartment(Department department) {
		this.getHibernateTemplate().save(department);

	}

	public void insertCacheDepartment(Department department) {

	}

	public void deleteDepartment(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	public void deleteCacheDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	public void updateDepartment(Department department) {
		this.getHibernateTemplate().merge(department);
	}

	public void updateCacheDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	public Department getDepartment(Department department) {
		return (Department) this.getHibernateTemplate().get(Department.class,
				department.getDepartid());
	}

	@SuppressWarnings("rawtypes")
	public List getListForPage(final Department department, final int pageNo,
			final int pageSize, String sort, String desc) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List>() {

					public List doInHibernate(Session sess)
							throws HibernateException, SQLException {
						Integer count = 0;
						List lst = new ArrayList();
						Criteria q = sess.createCriteria(Department.class,"t");
						q.setCacheable(true);
						//条件
						Example ex = Example.create(department);
						ex.enableLike();
						ex.excludeZeroes();
						ex.ignoreCase();
						q.add(ex);
						if(department.getParent()!=null && department.getParent().getDepartid()==0)
							q.add(Restrictions.isNull("t.parent"));
						if(department.getParent()!=null && department.getParent().getDepartid()>0)
							q.add(Restrictions.eq("t.parent", department.getParent()));
						if(department.getDepartid()!=null)
							q.add(Restrictions.eq("t.departid", department.getDepartid()));
						//计数
						q.setProjection(Projections.rowCount());
						count = ((Long)q.uniqueResult()).intValue();
						lst.add(count);
						
						q.setProjection(null);
						// page
						q.setFirstResult(pageNo);
						q.setMaxResults(pageSize);
						// para
						lst.add(q.list());
						
						return lst;
					}
				});
	}

	public List getDicListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListDepartmentForCache(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListDepartment(Department department, String onlyGa) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListDepartment(final Department department) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<Department> doInHibernate(Session sess)
					throws HibernateException, SQLException {
				Integer count = 0;
				Criteria q = sess.createCriteria(Department.class,"t");
				q.setCacheable(true);
				//条件
				Example ex = Example.create(department);
				ex.enableLike();
				ex.excludeZeroes();
				ex.ignoreCase();
				q.add(ex);
				if(department.getParent()!=null && department.getParent().getDepartid()==0)
					q.add(Restrictions.isNull("t.parent"));
				if(department.getParent()!=null && department.getParent().getDepartid()>0)
					q.add(Restrictions.eq("t.parent", department.getParent()));
				if(department.getDepartid()!=null)
					q.add(Restrictions.eq("t.departid", department.getDepartid()));
				return q.list();
			}
		});
	}

	public List getChildDepart(Department depart, Integer departlevel) {
		String hql = "from Department t where t.departlevel <= ?  ";
		List<Object> para_list = new ArrayList<Object>();

		para_list.add(departlevel == null ? 9999 : departlevel);
		if (depart == null || depart.getDepartid() == null) {
			hql += " and t.parent is null";
		} else {
			hql += " and t.parent = ?";
			para_list.add(depart);
		}
		hql += " order by t.nodeorder";
		this.getHibernateTemplate().setCacheQueries(true);
		return this.getHibernateTemplate().find(hql, para_list.toArray());
	}

	public Department getParentDepart(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDepartInfo(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllChildDepart(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllChildDepartByFullCode(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getChildDepartCs(Department depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkChild(final Department depart) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria q = session.createCriteria(Department.class,"t");
				if(depart == null || depart.getDepartid()==null)
					q.add(Restrictions.isNull("t.parent"));
				else
					q.add(Restrictions.eq("t.parent", depart));
				q.setProjection(Projections.rowCount());
				
				Long count = (Long) q.uniqueResult();
				if(count > 0)
					return true;
				else
					return false;
			}
		});
		
	}

	public Integer getNextNodeorder(Department department) {
		String hql = "select max(nvl(t.nodeorder,0))+1 from Department t where t.parent = ?";
		List lst = this.getHibernateTemplate().find(hql, department.getParent());
		return (Integer)lst.get(0);
	}

	public List getListAllDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean check_departcode(Department department) {
		String hql = "select count(t) from Department t where t.departcode = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,department.getDepartcode());
		if(list.size()>0 && list.get(0)>0)
			return false;
		return true;
	}

}
