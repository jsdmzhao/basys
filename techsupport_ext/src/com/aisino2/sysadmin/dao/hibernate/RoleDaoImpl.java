package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRoleDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;

@Component
public class RoleDaoImpl extends TechSupportBaseDaoImpl implements IRoleDao {

	public void insertRole(Role role) {
		this.getHibernateTemplate().save(role);
	}

	public void deleteRole(Role role) {
		this.getHibernateTemplate().delete(role);
	}

	public void updateRole(Role role) {
		this.getHibernateTemplate().update(role);
	}

	public Role getRole(Role role) {
		return this.getHibernateTemplate().get(role.getClass(),
				role.getRoleid());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getListForPage(final Role map, final int pageNo,
			final int pageSize, final String sort, final String desc) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role>>() {

					public List<Role> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role.class, "t");

						// condition
						Example example = Example.create(map);
						example.ignoreCase();

						q.add(example);

						// page
						q.setFirstResult((pageNo - 1) * pageSize);
						q.setMaxResults(pageSize);

						return q.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<Role> getListRole(final Role role) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role>>() {

					public List<Role> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role.class, "t");

						Example ex = Example.create(role);
						ex.ignoreCase();

						q.add(ex);

						return q.list();
					}

				});
	}

	@SuppressWarnings("unchecked")
	public List<Role> getRolesByUser(User user) {

		return this
				.getHibernateTemplate()
				.find("select new Role(t.roleid,t.departid,t.rolename,t.roledescription,t.roletype) from Role t,User_role ur whre t.roleid = ur.roleid and ur.userid = ?",
						user.getUserid());
	}

	public List<Role> getOptionRolesForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getloginUserRoleOutDeptList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> getDeptRoleList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
