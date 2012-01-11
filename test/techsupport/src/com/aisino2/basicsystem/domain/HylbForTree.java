package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class HylbForTree  {

    /** @ --行业类别编码-- */
    private String hylbbm;

    /** @ --行业类别名称- */
    private String hylbmc;
    
    public String getHylbbm() {
        return hylbbm;
    }

    public void setHylbbm(String hylbbm) {
        this.hylbbm = hylbbm;
    }

    public String getHylbmc() {
        return hylbmc;
    }

    public void setHylbmc(String hylbmc) {
        this.hylbmc = hylbmc;
    }
   
    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return hylbbm.equals(((HylbForTree) obj).getHylbbm());
    }

}
