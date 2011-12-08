package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_menuDao;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_menu;

@Component
public class Role_menuDaoImpl extends TechSupportBaseDaoImpl implements
		IRole_menuDao {

	public void insertRole_menu(Role_menu role_menu) {
		this.getHibernateTemplate().save(role_menu);
	}

	public void deleteRole_menu(Role_menu role_menu) {
		this.getHibernateTemplate().delete(role_menu);
	}

	public void updateRole_menu(Role_menu role_menu) {
		this.getHibernateTemplate().update(role_menu);
	}

	@SuppressWarnings("unchecked")
	public Role_menu getRole_menu(Role_menu role_menu) {
		String hql = "select t from Role_menu t where roleid = ? and menucode=?";
		List<Role_menu> list = this.getHibernateTemplate().find(hql,
				role_menu.getRoleid(), role_menu.getMenucode());
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role_menu> getListForPage(final Role_menu role_menu,
			final int pageNo, final int pageSize, String sort, String desc) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_menu>>() {

					public List<Role_menu> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role_menu.class);

						if (role_menu.getMenucode() != null)
							q.add(Restrictions.eq("menucode",
									role_menu.getMenucode()));
						if (role_menu.getRoleid() != null)
							q.add(Restrictions.eq("roleid",
									role_menu.getRoleid()));
						// 分页
						q.setFirstResult((pageNo - 1) * pageSize);
						q.setMaxResults(pageSize);

						return q.list();
					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<Role_menu> getListRole_menu(final Role_menu role_menu) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Role_menu>>() {

					public List<Role_menu> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria q = session.createCriteria(Role_menu.class);

						if (role_menu.getMenucode() != null)
							q.add(Restrictions.eq("menucode",
									role_menu.getMenucode()));
						if (role_menu.getRoleid() != null)
							q.add(Restrictions.eq("roleid",
									role_menu.getRoleid()));

						return q.list();
					}
				});
	}

	public List<Role_menu> getRolesystemListNoPage(Role_menu role_menu) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role_menu> getRolesystemenuListNoPage(Role_menu role_menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role_menu> getRoleMenusByRoleidAndSystemcode(Role_menu role_menu) {
		return null;
	}

	public void deleteRoleMenuByRole(Role role) {
		this.getHibernateTemplate().bulkUpdate(
				"delete from Role_menu t where t.roleid = ?", role.getRoleid());
	}

	public void deleteRoleMenuByMenu(Menu menu) {
		this.getHibernateTemplate().bulkUpdate(
				"delete from Role_menu t where t.menucode = ?",
				menu.getMenucode());
	}

	@SuppressWarnings("unchecked")
	public List<Role_menu> getRoleMenus(Role role) {
		String hql = "select t from Role_menu t where t.roleid = ?";
		return this.getHibernateTemplate().find(hql, role.getRoleid());
	}

}
