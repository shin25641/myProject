package com.care.member_dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.care.board_dto.boardDTO;
import com.care.log_dto.logDTO;
import com.care.member_dto.memberDTO;
import com.care.template.Constant;

@Repository
public class memberDAO {
	private static final String namespace = "com.care.mybatis.myMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Object> list() {
		return sqlSession.selectList(namespace + ".listAll"); //여러개의 데이터를 가져올떄

	}
	
	public memberDTO modify(String id) {
		return sqlSession.selectOne(namespace + ".list",id); //하나의 데이터만 가져올때
	}
	
	public void modifySave(memberDTO dto) {
		int result = sqlSession.update(namespace+".updatedata", dto);
		System.out.println("결과 확인 : "+result);
	}
	
	public void delete(String id) {
		int result = sqlSession.delete(namespace+".delete", id);
		System.out.println("결과 확인 : "+result);
	}
	
	public int userCheck(String id, String pwd) {
		int chk=-1;
		memberDTO dto = new memberDTO();
		dto = sqlSession.selectOne(namespace + ".list",id); //하나의 데이터만 가져올때
		if(pwd.equals(dto.getPw())) {
			return chk=0;
		}else {
			return chk=1;
		}
	}
	
	public memberDTO info(String id) {
		return sqlSession.selectOne(namespace + ".list",id); //하나의 데이터만 가져올때
	}
	
	public int insert(memberDTO dto) {
		return sqlSession.insert(namespace+".savedata", dto);
	}
	


	
	public int logInsert(logDTO Ldto) {
		return sqlSession.insert(namespace+".saveLogData", Ldto);
	}
	
	public int logUpdate(logDTO Ldto) {
		return sqlSession.update(namespace+".updateLogData", Ldto);
	}
}
