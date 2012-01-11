declare v_rows number;
v_qgztjxid number;
v_qgztjxid_rows number;
v_rowid varchar2(100);
cursor c_qgztjx_lsb1 is select count(qgztjxid), t.qgztjxid
                  from t_qgztjx_lsb1 t
                 group by t.qgztjxid
                having count(t.qgztjxid) > 1;
begin
	select count(*) into v_rows from t_qgztjx_lsb1;
	if v_rows>=250000 then
		dbms_utility.exec_ddl_statement('truncate table t_qgztjx_lsb');
		open c_qgztjx_lsb1;
  loop 
  fetch c_qgztjx_lsb1 into v_qgztjxid_rows,v_qgztjxid;
  exit when c_qgztjx_lsb1%notfound;
  select max(rowid)  into v_rowid from t_qgztjx_lsb1 where qgztjxid =v_qgztjxid;
  delete from t_qgztjx_lsb1 where qgztjxid=v_qgztjxid and  rowid<>v_rowid;
  commit;
  end loop ;
		insert /*+ APPEND */ into t_Qgztjx_Lsb
select QGZTJXID,
       TBBH,
       XZQHBM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_xzqh' and a.fact_value=t.XZQHBM)  XZQH,
       XMPY,
       XM,
       BM,
       XBDM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_xb' and a.fact_value=t.xbdm) XB,
       CSRQ,
       GMSFHM,
       HJDBM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_xzqh' and a.fact_value=t.HJDBM) HJD,
       HJXXDZ,
       XZDQBM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_xzqh' and a.fact_value=t.HJDBM)  XZDQ,
       XZDXXDZ,
       QTZJLX,
       QTZJHM,
       AJJBBM,
       AJJB,
       AJLBBM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_ajlb(gb)' and a.fact_value=t.AJLBBM)  AJLB,
       JYAQ,
       DJRQ,
       DJR,
       LADQBM,
       (select a.display_name from t_dict_item a where a.dict_code='dm_xzqh' and a.fact_value=t.LADQBM)  LADQ,
       BADWBM,
       BADW,
       TBR,
       LXR,
       LXFS,
       SHENGAO
  from t_qgztjx_lsb1 t order by qgztjxid;
		dbms_utility.exec_ddl_statement('alter table T_QGZTJX exchange partition T_QGZTJX with table T_QGZTJX_LSB including indexes without validation');
		dbms_utility.exec_ddl_statement('truncate table t_qgztjx_lsb');
		dbms_utility.exec_ddl_statement('truncate table t_qgztjx_lsb1');
	end if;
end;
/
exit;