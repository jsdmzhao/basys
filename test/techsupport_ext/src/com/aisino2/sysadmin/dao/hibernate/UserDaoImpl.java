package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IUserDao;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.module.sitemesh.Page;

/**
 * 
 * 用户数据
 * 
 */
@Component
public class UserDaoImpl extends TechSupportBaseDaoImpl implements IUserDao {

	public void insertUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void deleteUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	public void updateUkeyUser(User user) {
		// TODO Auto-generated method stub

	}

	public User getUser(User user) {
		return (User) this.getHibernateTemplate().get(User.class,
				user.getUserid());
	}

	public User getPasswordByUseraccount(User user) {
		if (user == null || user.getUseraccount() == null
				|| user.getPassword() == null)
			throw new RuntimeException("用户名或者密码为空");
		List<User> lst = getListUser(user);
		if (lst.size() > 0)
			return lst.get(0);
		return null;
	}

	public List<User> getListForPage(final User user, final int pageNo,
			final int pageSize, String sort, String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<User> doInHibernate(Session sess)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer(
						"select select new User(t.userid,t.departid,t.useraccount,t.username,t.password," +
				"t.userorder,t.isvalid,t.usertype,t.idnum,t.mobilephone," +
				"t.jzlbdm,t.jzlbmc) from User t");
				
				Map<String, Object> para_map = get_para_and_hql(user, hql);
				hql = (StringBuffer) para_map.get("hql");
				List<Object> para_list = (List<Object>) para_map.get("para");

				Query q = sess.createQuery(hql.toString());
				q.setCacheable(true);
				
				// page
				q.setFirstResult((pageNo - 1) * pageSize);
				q.setMaxResults(pageSize);

				// para
				for (int i = 0; i < para_list.size(); i++)
					q.setParameter(i, para_list.get(i));

				return q.list();
			}
		});
	}

	public List<User> getListUser(User user) {
		this.getHibernateTemplate().setCacheQueries(true);

		StringBuffer hql = new StringBuffer("select new User(t.userid,t.departid,t.useraccount,t.username,t.password," +
				"t.userorder,t.isvalid,t.usertype,t.idnum,t.mobilephone," +
				"t.jzlbdm,t.jzlbmc) from User t");
		Map<String, Object> para_map = get_para_and_hql(user, hql);
		hql = (StringBuffer) para_map.get("hql");
		List<Object> para_list = (List<Object>) para_map.get("para");

		return this.getHibernateTemplate().find(hql.toString(),
				para_list.toArray());
	}

	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User checkCAUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePwd(User user) {
		// TODO Auto-generated method stub

	}

	public User getNextNodeorder(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getQybmByCyrybh(String sqlStmt) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQymcByQybm(String qybm) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getListForPageQyOrGa(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> get_para_and_hql(User para_entity,
			StringBuffer hql) {
		List<Object> para_list = new ArrayList<Object>();
		if (para_entity != null) {
			hql.append(" where 1=1");

			if (para_entity.getUserid() != null) {
				hql.append(" and t.userid = ? ");
				para_list.add(para_entity.getUserid());
			}

			if (para_entity.getUsername() != null) {
				hql.append(" and t.username like ?");
				para_list.add(para_entity.getUsername() + "%");
			}
			if (para_entity.getUseraccount() != null) {
				hql.append(" and t.useraccount = ?");
				para_list.add(para_entity.getUseraccount());
			}
			if (para_entity.getPassword() != null) {
				hql.append(" and t.password = ?");
				para_list.add(para_entity.getPassword());
			}

			if (para_entity.getIsvalid() != null) {
				hql.append(" and t.isvalid = ?");
				para_list.add(para_entity.getIsvalid());
			}

			if (para_entity.getIdnum() != null) {
				hql.append(" and t.idnum = ?");
				para_list.add(para_entity.getIdnum());
			}

			if (para_entity.getDepartid() != null
					|| para_entity.getDepartment() != null) {
				hql.append(" and t.departid = ?");
				if (para_entity.getDepartid() != null)
					para_list.add(para_entity.getDepartid());
				else if (para_entity.getDepartment().getDepartid() != null)
					para_list.add(para_entity.getDepartment().getDepartid());
			}
		}

		Map<String, Object> para_map = new HashMap<String, Object>();
		para_map.put("hql", hql);
		para_map.put("para", para_list);
		return para_map;
	}

}
