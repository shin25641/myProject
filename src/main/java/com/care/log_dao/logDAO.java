package com.care.log_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class logDAO {
	private static final String namespace = "com.care.mybatis.myMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Object> log_list() {
		return sqlSession.selectList(namespace + ".logListAll"); //여러개의 데이터를 가져올떄
	}
	
}
