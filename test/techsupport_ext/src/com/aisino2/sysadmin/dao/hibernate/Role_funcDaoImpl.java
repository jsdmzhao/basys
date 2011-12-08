package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;

@Component
public class Role_funcDaoImpl extends TechSupportBaseDaoImpl implements
		IRole_funcDao {

	public void insertRole_func(Role_func role_func) {
		this.getHibernateTemplate().save(role_func);
	}

	public void deleteRole_func(Role_func role_func) {
		this.getHibernateTemplate().delete(role_func);
	}

	public void updateRole_func(Role_func role_func) {
		this.getHibernateTemplate().update(role_func);
	}

	@SuppressWarnings("unchecked")
	public Role_func getRole_func(Role_func role_func) {
		List<Role_func> lst = this.getHibernateTemplate().find(
				"from Role_func t where t.roleid=? and t.funccode=?",
				role_func.getRoleid(), role_func.getFunccode());
		if (lst.size() > 0)
			return lst.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role_func> getListForPage(final Role_func map,
			final int pageNo, final int pageSize, String sort, String desc) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_func>>() {

					public List<Role_func> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role_func.class,
								"t");
						// 分页
						q.setFirstResult((pageNo - 1) * pageSize);
						q.setMaxResults(pageSize);

						// 条件
						if (map.getRoleid() != null)
							q.add(Restrictions.eq("t.roleid", map.getRoleid()));
						if (map.getFunccode() != null)
							q.add(Restrictions.eq("t.funccode",
									map.getFunccode()));

						return q.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<Role_func> getListRole_func(final Role_func role_func) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_func>>() {

					public List<Role_func> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(
								role_func.getClass(), "t");

						if (role_func.getFunccode() != null)
							q.add(Restrictions.eq("t.funccode",
									role_func.getFunccode()));
						if (role_func.getRoleid() != null)
							q.add(Restrictions.eq("t.roleid",
									role_func.getRoleid()));

						return q.list();
					}
				});
	}

	public List<Role_func> getParam(Role_func role_func) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role_func> getRoleFunctionList(Role_func map, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteRoleFunctionByRole(Role role) {
		this.getHibernateTemplate().bulkUpdate(
				"delete from Role_role where roleid=?", role.getRoleid());
	}

	public void deleteRoleFunctionByFunction(Function function) {
		this.getHibernateTemplate().bulkUpdate(
				"delete from Role_role where funccode = ?",
				function.getFunccode());
	}

	public void updateRoleFunctionParam(Role_func role_func) {
		// TODO Auto-generated method stub

	}

	public List<Role_func> getFunctionListNotInRole(Role_func role_func) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role_func> getRoleFunctionForPage(Role_func condition,
			int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
