package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IMenuDao;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.User;

@Component
public class MenuDaoImpl extends TechSupportBaseDaoImpl implements IMenuDao {

	public void insertMenu(Menu menu) {
		this.getHibernateTemplate().save(menu);
	}

	public void deleteMenu(Menu menu) {
		this.getHibernateTemplate().delete(menu);
	}

	public void updateMenu(Menu menu) {
		this.getHibernateTemplate().update(menu);
	}

	public Menu getMenu(Menu menu) {
		return (Menu) this.getHibernateTemplate().get(Menu.class,
				menu.getMenucode());
	}

	public List<Menu> getListForPage(final Menu menu, int pageNo, int pageSize,
			String sort, String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<Department> doInHibernate(Session sess)
					throws HibernateException, SQLException {
				StringBuffer hqlbuf = new StringBuffer("from Department t");
				Map<String, Object> para_map = get_para_and_hql(menu, hqlbuf);

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

	public List<Menu> getListMenu(Menu menu) {

		return null;
	}

	public boolean checkMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getOwnMenu(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Menu getParentMenu(Menu menu) {
		String hql = "select t from Menu t where t.menucode = ?";
		List<Menu> list = this.getHibernateTemplate().find(hql,
				new Object[] { menu.getParent().getMenucode() });
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List getAllChildren(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getMenuBySystem(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkChild(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public Menu getNextNodeorder(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getTheUserChildMenu(final Menu menu, final User user) {
		final String sql = "select distinct t.* from t_menu t,t_user_role ur, t_role_menu rm"
				+ " where t.menucode = rm.menucode and ur.roleid = rm.roleid and ur.userid = ?";
		final List<Object> para_list = new ArrayList();
		para_list.add(user.getUserid());
		// if(menu.getMenucode() == null){
		// hql += " and t.parent is null";
		// }
		// else{
		// hql += " and t.parent = ?";
		// para_list.add(menu);
		// }
		// List lst = this.getHibernateTemplate().find(hql,
		// para_list.toArray());
		// return lst;

		

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Menu>>() {

					public List<Menu> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select distinct t from Menu t , User_role ur, Role_menu rm "
							+ "where t.menucode = rm.menucode and ur.roleid = rm.roleid and ur.userid = ?";
						String sql = "select distinct t.* from t_menu t,t_user_role ur, t_role_menu rm"
								+ " where t.menucode = rm.menucode and ur.roleid = rm.roleid and ur.userid = ?";
						
						List<Object> para_list = new ArrayList();
						para_list.add(user.getUserid());
						
						if (menu.getMenucode() == null) {
							hql += " and t.parent is null";
						} else {
							hql += " and t.parent = ?";
							para_list.add(menu.getParent());
						}
						
						Query q = session.createQuery(hql);
//						q.addEntity(Menu.class);
						for (int i = 0; i < para_list.size(); i++)
							q.setParameter(i, para_list.get(i));

						return q.list();
					}
				});

	}

	public List<Menu> getChildMenu(Menu menu) {
		String hql = "select t from Menu t where t.parentmenucode = ? ";
		return this.getHibernateTemplate().find(hql,
				new Object[] { menu.getMenucode() });
	}

	public List<Menu> getRoleCheckedMenuList(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> get_para_and_hql(Menu para_entity,
			StringBuffer hql) {
		List<Object> para_list = new ArrayList<Object>();
		if (para_entity != null) {
			hql.append(" where 1=1");

			if (para_entity.getSystem() != null) {
				hql.append(" and t.system = ?");
				para_list.add(para_entity.getSystem());
			}

			if (para_entity.getMenuname() != null) {
				hql.append(" and t.menuname like ?");
				para_list.add(para_entity.getMenuname() + "%");
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
}
