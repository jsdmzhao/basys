package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class GxdwForTree  {

    /** @ --管辖单位编码-- */
    private String gxdwbm;

    /** @ --管辖单位名称- */
    private String gxdwmc;
    
    private String qybm;
    private String qymc;
    private String qybms;
    
    private String hylbbm;
    private String hylbmc;
    
    public String getHylbmc() {
        return hylbmc;
    }

    public void setHylbmc(String hylbmc) {
        this.hylbmc = hylbmc;
    }

    public String getHylbbm() {
        return hylbbm;
    }

    public void setHylbbm(String hylbbm) {
        this.hylbbm = hylbbm;
    }
    
    public String getQybms() {
        return qybms;
    }

    public void setQybms(String qybms) {
        this.qybms = qybms;
    }

    public String getQybm() {
        return qybm;
    }
    
    public void setQybm(String qybm) {
        this.qybm = qybm;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getGxdwbm() {
        return gxdwbm;
    }
    
    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm;
    }
    
    public String getGxdwmc() {
        return gxdwmc;
    }

    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc;
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return gxdwbm.equals(((GxdwForTree) obj).getGxdwbm());
    }

}
