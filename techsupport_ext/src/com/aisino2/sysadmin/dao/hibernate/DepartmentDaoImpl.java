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
						
						//计数
						q.setProjection(Projections.rowCount());
						count = ((Long)q.uniqueResult()).intValue();
						lst.add(count);
						
						if(count>0){
							q.setProjection(null);
							// page
							q.setFirstResult((pageNo - 1) * pageSize);
							q.setMaxResults(pageSize);
							// para
							lst.add(q.list());
						}
						else
							lst.add(null);
						
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
				StringBuffer hqlbuf = new StringBuffer("from Department t");
				Map<String, Object> para_map = get_where(department, hqlbuf);

				hqlbuf = (StringBuffer) para_map.get("hql");
				List<Object> para_list = (List<Object>) para_map.get("para");

				Query q = sess.createQuery(hqlbuf.toString());
				q.setCacheable(true);
				// para
				for (int i = 0; i < para_list.size(); i++)
					q.setParameter(i, para_list.get(i));
				return q.list();
			}
		});
	}

	public List getChildDepart(Department depart, Integer departlevel) {
		String hql = "from Department t where t.departlevel <= ?  ";
		List<Object> para_list = new ArrayList<Object>();

		para_list.add(departlevel == null ? 9999 : departlevel);
		if (depart == null || depart.getDepartid() == null) {
			hql += " and t.parentdepartid is null";
		} else {
			hql += " and t.parentdepartid = ?";
			para_list.add(depart.getDepartid());
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

	public boolean checkChild(Department depart) {
		// TODO Auto-generated method stub
		return false;
	}

	public Department getNextNodeorder(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListAllDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> get_where(Department department,
			StringBuffer hql) {
		List<Object> para_list = new ArrayList<Object>();
		if (department != null) {
			hql.append(" where 1=1");

			if (department.getDepartid() != null) {
				hql.append(" and t.departid = ?");
				para_list.add(department.getDepartid());
			}

			if (department.getDepartcode() != null) {
				hql.append(" and t.departcode = ?");
				para_list.add(department.getDepartcode());
			}

			if (department.getDepartname() != null) {
				hql.append(" and t.departname like ?");
				para_list.add(department.getDepartname() + "%");
			}

			if (department.getParentdepartid() != null
					|| (department.getParent() != null && department
							.getParent().getDepartid() != null)) {
				hql.append(" and t.parentdepartid like ?");
				if (department.getParentdepartid() != null)
					para_list.add(department.getParentdepartid() + "%");
				else
					para_list.add(department.getParent().getDepartid() + "%");
			}

			if (department.getDepartlevel() != null) {
				hql.append(" and t.departlevel <= ?");
				para_list.add(department.getDepartlevel());
			}

		}

		Map<String, Object> para_map = new HashMap<String, Object>();
		para_map.put("hql", hql);
		para_map.put("para", para_list);
		return para_map;
	}
}
