package com.aisino2.basicsystem.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.basicsystem.dao.IDtcxpxDao;
import com.aisino2.basicsystem.dao.IDtcxtjDao;
import com.aisino2.basicsystem.dao.IGjcxfaDao;
import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.basicsystem.service.IGjcxfaService;

public class AdvancedQueryTest extends
		AbstractTransactionalDataSourceSpringContextTests {

	public IDtcxtjDao getDtcxtjDao() {
		return dtcxtjDao;
	}

	public void setDtcxtjDao(IDtcxtjDao dtcxtjDao) {
		this.dtcxtjDao = dtcxtjDao;
	}

	public IDtcxpxDao getDtcxpxDao() {
		return dtcxpxDao;
	}

	public void setDtcxpxDao(IDtcxpxDao dtcxpxDao) {
		this.dtcxpxDao = dtcxpxDao;
	}

	protected String[] getConfigLocations() {
		String[] paths = new String[] {
				"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml"};
		return paths;
	}

	private IGjcxfaService gjcxfaService;

	private IDtcxtjDao dtcxtjDao;
	private IGjcxfaDao gjcxfaDao;
	private IDtcxpxDao dtcxpxDao;
	private int sjbjgid;

	public IGjcxfaDao getGjcxfaDao() {
		return gjcxfaDao;
	}

	public void setGjcxfaDao(IGjcxfaDao gjcxfaDao) {
		this.gjcxfaDao = gjcxfaDao;
	}

	public IGjcxfaService getGjcxfaService() {
		return gjcxfaService;
	}

	public void setGjcxfaService(IGjcxfaService gjcxfaService) {
		this.gjcxfaService = gjcxfaService;
	}

	protected void onSetUpBeforeTransaction() throws Exception {
		sjbjgid = 310;
	}

	// public void testFullDtcxtj()
	// {
	// Dtcxtj dtcxtj = new Dtcxtj();
	// dtcxtj.setSjbjgid(new Integer(sjbjgid));
	// dtcxtj = gjcxfaService.fullBean(dtcxtj);
	// assertNotNull(dtcxtj.getZdm());
	// assertNotNull(dtcxtj.getZdlx());
	// assertNotNull(dtcxtj.getSjbm());
	// assertEquals("ssyhzh", dtcxtj.getZdm());
	// assertEquals("VARCHAR2", dtcxtj.getZdlx());
	// assertEquals("t_gjcxfa", dtcxtj.getSjbm());
	// }

	public void testInsertGjcx() {
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfamc("方案1");
		gjcxfa.setGjcxlx("动态");
		List tj = new ArrayList();
		Dtcxtj dtcxtj = new Dtcxtj();
		Dtcxtj dtcxtj1 = new Dtcxtj();
		dtcxtj.setSjbjgid(new Integer(310));
		dtcxtj.setKskh("(");
		dtcxtj.setZdz("1");
		dtcxtj.setPpf(">=");
		dtcxtj.setGxf("and");
		tj.add(dtcxtj);
		dtcxtj1.setSjbjgid(new Integer(311));

		dtcxtj1.setZdz("2");
		dtcxtj1.setPpf("<=");
		dtcxtj1.setJskh(")");
		dtcxtj1.setGxf("or");
		tj.add(dtcxtj1);
		gjcxfa.setLPptj_table(tj);
		
		
		List px = new ArrayList();
		Dtcxpx dtcxpx = new Dtcxpx();
		Dtcxpx dtcxpx1 = new Dtcxpx();
		dtcxpx.setSjbjgid(new Integer(310));
		dtcxpx.setPxfs("desc");
		px.add(dtcxpx);
		dtcxpx1.setSjbjgid(new Integer(311));
		dtcxpx1.setPxfs("asc");
		px.add(dtcxpx1);
		gjcxfa.setLPxgz_table(px);
		gjcxfa = gjcxfaService.insertGjcxfa(gjcxfa);
		 setComplete();
		// assertEquals(expected, actual)
	}
	public void testInsertGjcx_ZdySql(){
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfamc("方案1");
		gjcxfa.setGjcxlx("SQL");
		Zdycxtj zydcxtj = new Zdycxtj();
		zydcxtj.setCxtj("a.p='1' and 12<=14 or a.ttt like '%jjj%'");
		zydcxtj.setCxpx("order by a.ttt");
		gjcxfa.setZdycxtj(zydcxtj);
		gjcxfaService.insertGjcxfa(gjcxfa);
		 setComplete();
	}

	public void testUpdateGjcx() {
		String sql = "select nextid from sequence where name='Gjcxfaid'";
		int nextid = jdbcTemplate.queryForInt(sql);
		Gjcxfa gjcxfa = new Gjcxfa();

		gjcxfa.setGjcxfaid(new Integer(nextid - 1));
		gjcxfa = gjcxfaService.getGjcxfa(gjcxfa);
		if (gjcxfa != null) {
			gjcxfa.setGjcxfamc("方案1");
//			List tj = new ArrayList();
//			Dtcxtj dtcxtj = new Dtcxtj();
//			Dtcxtj dtcxtj1 = new Dtcxtj();
//			dtcxtj.setSjbjgid(new Integer(344));
//			dtcxtj.setGxf("或");
//			tj.add(dtcxtj);
//			dtcxtj1.setSjbjgid(new Integer(345));
//			dtcxtj1.setGxf("和");
//			tj.add(dtcxtj1);
//			gjcxfa.setLPptj_table(tj);
			Zdycxtj zydcxtj = new Zdycxtj();
			zydcxtj.setCxtj("a.p='2' and a.ttttt<=14 or a.ttt like '%pppp%'");
			zydcxtj.setCxpx("order by a.gggg");
			gjcxfa.setZdycxtj(zydcxtj);
			gjcxfaService.updateGjcxfa(gjcxfa);
			 setComplete();
		}
	}

	public void testDeleteGjcx() {
		String sql = "select nextid from sequence where name='Gjcxfaid'";
		int nextid = jdbcTemplate.queryForInt(sql);
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfaid(new Integer(17));
		gjcxfa = gjcxfaService.getGjcxfa(gjcxfa);
		gjcxfaService.deleteGjcxfa(gjcxfa);
		 setComplete();
	}

	public void testGetGjcx() {
		String sql = "select nextid from sequence where name='Gjcxfaid'";
		int nextid = jdbcTemplate.queryForInt(sql);
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfaid(new Integer(nextid - 1));
		gjcxfa = gjcxfaService.getGjcxfa(gjcxfa);
		//if(gjcxfa.getGjcxlx()!=null)
		//System.out.println(gjcxfa.getGjcxlx());
		assertNotNull("gjcxfa must not  null", gjcxfa);
	}

	public void testGetAllGjcx() {
		String sql = "select count(1) from t_gjcxfa";
		int count = jdbcTemplate.queryForInt(sql);
		List list = gjcxfaService.getAllGjcxfa();
		System.out.println(list.size());
		assertEquals(list.size(), count);
	}
	
	public void testGetSQL()
	{
		String sql = "select nextid from sequence where name='Gjcxfaid'";
		int nextid = jdbcTemplate.queryForInt(sql);
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfaid(new Integer(nextid - 1));
		gjcxfa = gjcxfaService.getGjcxfa(gjcxfa);
		String result = gjcxfaService.getQueryCondition(gjcxfa);
		System.out.println(result);
		String result1 = gjcxfaService.getQueryCondition(gjcxfa,null);
		System.out.println(result1);
	}
	
	public void testGetSQLNotInDataBase()
	{
		Gjcxfa gjcxfa = new Gjcxfa();
		//gjcxfa.setGjcxfaid(new Integer(100));
		gjcxfa.setGjcxfamc("方案1");
		gjcxfa.setGjcxlx("动态");
		List tj = new ArrayList();
		Dtcxtj dtcxtj = new Dtcxtj();
		Dtcxtj dtcxtj1 = new Dtcxtj();
		dtcxtj.setSjbjgid(new Integer(310));
		dtcxtj.setKskh("(");
		dtcxtj.setZdz("100");
		dtcxtj.setPpf(">=");
		dtcxtj.setGxf("and");
		tj.add(dtcxtj);
		dtcxtj1.setSjbjgid(new Integer(311));

		dtcxtj1.setZdz("200");
		dtcxtj1.setPpf("<=");
		dtcxtj1.setJskh(")");
		dtcxtj1.setGxf("or");
		tj.add(dtcxtj1);
		gjcxfa.setLPptj_table(tj);
		
		
		List px = new ArrayList();
		Dtcxpx dtcxpx = new Dtcxpx();
		Dtcxpx dtcxpx1 = new Dtcxpx();
		dtcxpx.setSjbjgid(new Integer(310));
		dtcxpx.setPxfs("desc");
		px.add(dtcxpx);
		dtcxpx1.setSjbjgid(new Integer(311));
		dtcxpx1.setPxfs("asc");
		px.add(dtcxpx1);
		gjcxfa.setLPxgz_table(px);
		String result = gjcxfaService.getQueryCondition(gjcxfa);
		System.out.println(result);
		String result1 = gjcxfaService.getQueryCondition(gjcxfa,"b");
		System.out.println(result1);
	}
	
	public void testGetSQLConditions_dynamicQuery()
	{
		Gjcxfa gjcxfa = new Gjcxfa();
		//gjcxfa.setGjcxfaid(new Integer(100));
		gjcxfa.setGjcxfamc("方案1");
		gjcxfa.setGjcxlx("动态");
		List tj = new ArrayList();
		Dtcxtj dtcxtj = new Dtcxtj();
		Dtcxtj dtcxtj1 = new Dtcxtj();
		dtcxtj.setSjbjgid(new Integer(310));
		dtcxtj.setKskh("(");
		dtcxtj.setZdz("100");
		dtcxtj.setPpf(">=");
		dtcxtj.setGxf("and");
		tj.add(dtcxtj);
		dtcxtj1.setSjbjgid(new Integer(311));

		dtcxtj1.setZdz("200");
		dtcxtj1.setPpf("<=");
		dtcxtj1.setJskh(")");
		dtcxtj1.setGxf("or");
		tj.add(dtcxtj1);
		gjcxfa.setLPptj_table(tj);
		
		
		List px = new ArrayList();
		Dtcxpx dtcxpx = new Dtcxpx();
		Dtcxpx dtcxpx1 = new Dtcxpx();
		dtcxpx.setSjbjgid(new Integer(310));
		dtcxpx.setPxfs("desc");
		px.add(dtcxpx);
		dtcxpx1.setSjbjgid(new Integer(311));
		dtcxpx1.setPxfs("asc");
		px.add(dtcxpx1);
		gjcxfa.setLPxgz_table(px);
		String []result = gjcxfaService.getQueryConditions(gjcxfa);
		System.out.println("..."+result[0]+"...."+result[1]);
		String []result1 = gjcxfaService.getQueryConditions(gjcxfa,"b");
		System.out.println("..."+result1[0]+"...."+result1[1]);
	}
	public void testGetSQLConditions_customizeQuery()
	{
		Gjcxfa gjcxfa = new Gjcxfa();
		gjcxfa.setGjcxfamc("方案1");
		gjcxfa.setGjcxlx("SQL");
		Zdycxtj zydcxtj = new Zdycxtj();
		zydcxtj.setCxtj("a.p='1' and 12<=14 or a.ttt like '%jjj%'");
		zydcxtj.setCxpx("order by a.ttt");
		gjcxfa.setZdycxtj(zydcxtj);
		String []result = gjcxfaService.getQueryConditions(gjcxfa);
		System.out.println("..."+result[0]+"...."+result[1]);
		String []result1 = gjcxfaService.getQueryConditions(gjcxfa,"b");
		System.out.println("..."+result1[0]+"...."+result1[1]);
		System.out.println((("              ").trim()).equals(""));
	}
}
