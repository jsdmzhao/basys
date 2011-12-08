package com.aisino2.sysadmin.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;

@Component
public class Dict_itemDaoImpl extends TechSupportBaseDaoImpl implements
		IDict_itemDao {

	public Dict_item insertDict_item(Dict_item dict_item) {
		this.getHibernateTemplate().save(dict_item);
		return dict_item;
	}

	public Dict_item insertCacheDict_item(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteDict_item(Dict_item dict_item) {
		this.getHibernateTemplate().delete(dict_item);
		return 0;
	}

	public int deleteCacheDict_item(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDict_item(Dict_item dict_item) {
		this.getHibernateTemplate().update(dict_item);
		return 0;
	}

	public int updateCacheDict_item(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Dict_item getDict_item(Dict_item dict_item) {
		return this.getHibernateTemplate().get(Dict_item.class, dict_item.getItem_id());
	}

	public List getListForPage(final Dict_item map, final int pageNo, final int pageSize,
			final String sort, final String desc) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Long count = 0l;
				Example ex = Example.create(map).ignoreCase().excludeZeroes();
				Criteria q = session.createCriteria(Dict_item.class,"t");
				q.add(ex);
				//count
				q.setProjection(Projections.rowCount());
				count = (Long)q.uniqueResult();
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

	public List getDropdownListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dict_item> getListDict_item(final Dict_item dict_item) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<Dict_item>>() {

			public List<Dict_item> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Example ex = Example.create(dict_item).ignoreCase().excludeZeroes();
				Criteria q = session.createCriteria(Dict_item.class,"t");
				q.add(ex);
				//page
				return q.list();
			}
		});
	}

	public List<Dict_item> getOfflineDict_item(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dict_item> getChildDict_itemListByItemIDAndDictCode(
			Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dict_item getDictionaryItemByDictCodeAndFactValue(Dict_item dict_item) {
		List<Dict_item> lst = this.getHibernateTemplate().find("from Dict_item t where t.dict_code=? and t.fact_value=?",
				dict_item.getDict_code(),dict_item.getFact_value());
		if(lst.size()>0)
			return lst.get(0);
		return null; 
	}

	public Dict_item getParentDictionaryItemBySuperItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getParentDictionaryItemListByDictCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getChildDictionaryItemListByItemID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDictItemNameByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDictItemCode(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDictionaryItemListByDictID(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDictItemNameListByDcFv(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dict_item getDictionaryItemByDcAndFvAndSuperII(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dict_item getNextNodeorder(Dict_item dict_item) {
		// TODO Auto-generated method stub
		return null;
	}

}
