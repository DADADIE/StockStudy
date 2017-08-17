package com.supersoft.stockStudy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.support.DaoSupport;

public abstract class BaseDao<Entity> extends DaoSupport {

	private SqlSession sqlSession;

}
