package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;

@Component
public class UserRoleDaoImpl extends TechSupportBaseDaoImpl implements
		IUser_roleDao {

	public void insertUser_role(User_role user_role) {
		this.getHibernateTemplate().save(user_role);
	}

	public void deleteUser_role(User_role user_role) {
		this.getHibernateTemplate().delete(user_role);
	}

	public void updateUser_role(User_role user_role) {
		this.getHibernateTemplate().update(user_role);
	}

	public User_role getUser_role(User_role user_role) {
		List<User_role> list = this.getHibernateTemplate().find(
				"select t from User_role t"
						+ " where t.userid = ? and t.roleid = ? ",
				new Object[] { user_role.getUserid(), user_role.getRoleid() });
		if (list.size() > 0)
			return list.get(0);
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<User_role> getListForPage(final User_role user_role, final int pageNo,
			final int pageSize, String sort, String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<User_role>>() {

			public List<User_role> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Criteria q = session.createCriteria(User_role.class);
				//设置分页
				q.setFirstResult((pageNo-1) * pageSize);
				q.setMaxResults(pageSize);
				//条件
				if(user_role.getUserid()!=null)
					q.add(Restrictions.eq("userid", user_role.getUserid()));
				if(user_role.getRoleid()!=null)
					q.add(Restrictions.eq("roleid", user_role.getRoleid()));
				
				return q.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<User_role> getListUser_role(final User_role user_role) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<User_role>>() {

			public List<User_role> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Criteria q = session.createCriteria(User_role.class);
				//条件
				if(user_role.getUserid()!=null)
					q.add(Restrictions.eq("userid", user_role.getUserid()));
				if(user_role.getRoleid()!=null)
					q.add(Restrictions.eq("roleid", user_role.getRoleid()));
				
				return q.list();
			}
		});
	}

	public List<User_role> getUser_roleListByUserid(User_role user_role) {
		return null;
	}

	public void deleteRoleUserByUser(User user) {
		String hql = "delete from User_role where userid = ?";
		
		this.getHibernateTemplate().bulkUpdate(hql, user.getUserid());
	}

	public void deleteRoleUserByRole(Role role) {
		String hql = "delete from User_role where roleid = ?";
		this.getHibernateTemplate().bulkUpdate(hql, role.getRoleid());
	}

}
