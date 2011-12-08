package com.aisino2.sysadmin.dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class TechSupportBaseDaoImpl extends HibernateDaoSupport {
	
	@Resource(name="sessionFactory")
	public void setTechSupportSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
}
