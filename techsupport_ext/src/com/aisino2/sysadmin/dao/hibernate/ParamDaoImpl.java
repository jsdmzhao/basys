package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IParamDao;
import com.aisino2.sysadmin.domain.Param;

@Component
public class ParamDaoImpl extends TechSupportBaseDaoImpl implements IParamDao {

	public void insertParam(Param param) {
		this.getHibernateTemplate().save(param);
	}

	public void deleteParam(Param param) {
		this.getHibernateTemplate().delete(param);
	}

	public void updateParam(Param param) {
		this.getHibernateTemplate().update(param);
	}

	public Param getParam(Param param) {
		return this.getHibernateTemplate().get(Param.class, param.getParamcode());
	}

	public List getListForPage(final Param param,final int pageNo,final int pageSize,
			final String sort,final String desc) {
		
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Long count = 0l;
				Criteria q = session.createCriteria(Param.class,"t");
				//condition
				Example ex = Example.create(param);
				ex.enableLike();
				ex.ignoreCase();
				q.add(ex);
				//count
				q.setProjection(Projections.rowCount());
				count = (Long) q.uniqueResult();
				q.setProjection(null);
				//page
				q.setFirstResult((pageNo - 1) * pageSize);
				q.setMaxResults(pageSize);
				
				List lst = new ArrayList();
				lst.add(count);
				lst.addAll(q.list());
				return lst;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Param> getListParam(final Param param) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Param>>() {

			public List<Param> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria q = session.createCriteria(Param.class,"t");
				//condition
				Example ex = Example.create(param);
				ex.enableLike();
				ex.ignoreCase();
				q.add(ex);
				return q.list();
			}
		});
	}

}
