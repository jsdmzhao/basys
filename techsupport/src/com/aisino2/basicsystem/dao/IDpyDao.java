package com.aisino2.basicsystem.dao;

import com.aisino2.basicsystem.domain.DoublePY;

public interface IDpyDao {
	/**
	 * 获得名字的双拼
	 * @return
	 */
	String getDoublepy(DoublePY doublePY);
}
