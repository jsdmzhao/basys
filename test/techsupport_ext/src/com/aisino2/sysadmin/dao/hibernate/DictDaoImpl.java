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

import com.aisino2.sysadmin.dao.IDictDao;
import com.aisino2.sysadmin.domain.Dict;

@Component
public class DictDaoImpl extends TechSupportBaseDaoImpl implements IDictDao {

	public Dict insertDict(Dict dict) {
		this.getHibernateTemplate().save(dict);
		return dict;
	}

	public Dict insertCacheDict(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteDict(Dict dict) {
		this.getHibernateTemplate().delete(dict);
		return 0;
	}

	public int deleteCacheDict(Dict dict) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDict(Dict dict) {
		this.getHibernateTemplate().update(dict);
		return 0;
	}

	public int updateCacheDict(Dict dict) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Dict getDict(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getListForPage(final Dict map,final int pageNo, final int pageSize, final String sort,
final			String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Long count = 0l;
				Criteria q = session.createCriteria(Dict.class,"t");
				//condition
				Example ex = Example.create(map).enableLike().ignoreCase().excludeZeroes();
				q.add(ex);
				//count
				q.setProjection(Projections.rowCount());
				count = (Long) q.uniqueResult();
				//page
				q.setProjection(null);
				q.setFirstResult((pageNo - 1) * pageSize);
				q.setMaxResults(pageSize);
				
				List lst = new ArrayList();
				lst.add(count);
				lst.add(q.list());
				return lst;
			}
		});
	}

	public List<Dict> getListDict(Dict dict) {
		Example ex = Example.create(dict).enableLike().excludeZeroes().ignoreCase();
		return this.getHibernateTemplate().findByExample(ex);
	}

	public List<Dict> getChildrenDictionary(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dict> getDictionaryAll(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteDictionaryItemByDictionary(Dict dict) {
		this.getHibernateTemplate().bulkUpdate("delete from Dict_item where dict_code=?",dict.getDict_code());
		return 0;
	}

}
