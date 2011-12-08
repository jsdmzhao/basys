package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_param;

@Component
public class Role_paramDaoImpl extends TechSupportBaseDaoImpl implements
		IRole_paramDao {

	public void insertRole_param(Role_param role_param) {
		this.getHibernateTemplate().save(role_param);
	}

	public void deleteRole_param(Role_param role_param) {
		this.getHibernateTemplate().delete(role_param);
	}

	public void updateRole_param(Role_param role_param) {
		this.getHibernateTemplate().update(role_param);
	}

	@SuppressWarnings("unchecked")
	public Role_param getRole_param(Role_param role_param) {
		List<Role_param> lst = this.getHibernateTemplate().find(
				"from Role_param t where t.roleid=? and t.paramcode = ?",
				role_param.getRoleid(), role_param.getParamcode());

		if (lst.size() > 0)
			return lst.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role_param> getListForPage(final Role_param map,
			final int pageNo, final int pageSize, String sort, String desc) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_param>>() {

					public List<Role_param> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role_param.class,
								"t");
						// 分页
						q.setFirstResult((pageNo - 1) * pageSize);
						q.setMaxResults(pageSize);

						if (map.getParamcode() != null)
							q.add(Restrictions.eq("t.paramcode",
									map.getParamcode()));
						if (map.getRoleid() != null)
							q.add(Restrictions.eq("t.roleid", map.getRoleid()));

						return q.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<Role_param> getListRole_param(final Role_param role_param) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_param>>() {

					public List<Role_param> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role_param.class,
								"t");

						if (role_param.getParamcode() != null)
							q.add(Restrictions.eq("t.paramcode",
									role_param.getParamcode()));
						if (role_param.getRoleid() != null)
							q.add(Restrictions.eq("t.roleid",
									role_param.getRoleid()));

						return q.list();
					}
				});
	}

	public void deleteRoleParamByRole(Role role) {
		this.getHibernateTemplate().bulkUpdate(
				"delete from Role_param where roleid = ?", role.getRoleid());
	}

}
