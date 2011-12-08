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

import com.aisino2.sysadmin.dao.IFunctionDao;
import com.aisino2.sysadmin.domain.Function;

@Component
public class FunctionDaoImpl extends TechSupportBaseDaoImpl implements
		IFunctionDao {

	public void insertFunction(Function function) {
		this.getHibernateTemplate().save(function);
	}

	public void deleteFunction(Function function) {
		this.getHibernateTemplate().delete(function);
	}

	public void updateFunction(Function function) {
		this.getHibernateTemplate().update(function);
	}

	public Function getFunction(Function function) {
		return this.getHibernateTemplate().get(Function.class, function.getFunccode());
	}

	public List getListForPage(final Function function, final int pageNo,
			final int pageSize,final String sort, final String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Long count = 0l;
				Criteria q = session.createCriteria(Function.class,"t");
				//condition
				Example ex = Example.create(function);
				ex.enableLike();
				q.add(ex);
				//count
				q.setProjection(Projections.count("t.funccode"));
				count = (Long) q.uniqueResult();
				//page
				q.setProjection(null);
				q.setFirstResult((pageNo-1) * pageSize);
				q.setMaxResults(pageSize);
				List lst = new ArrayList();
				lst.add(count);
				lst.add(q.list());
				return lst;
			}
		});
	}

	public List<Function> getListFunction(final Function function) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Function>>() {

			public List<Function> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria q = session.createCriteria(Function.class,"t");
				//condition
				Example ex = Example.create(function);
				ex.enableLike();
				q.add(ex);
				
				return q.list();
			}
		});
	}

	public boolean checkFunction(Function function) {
		List lst = this.getHibernateTemplate().find("from Function t where t.funccode=?",function.getFunccode());
		if(lst.size()>0)
			return true;
		else
			return false;
	}

	public boolean findFuncDefine(Function function) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Function> getOwnFunction(Function function) {
		// TODO Auto-generated method stub
		return null;
	}

}
