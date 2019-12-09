package com.care.board_dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.board_dto.boardDTO;

@Repository
public class boardDAO {
	private static final String namespace = "com.care.mybatis.myMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Object> board_list() {
		return sqlSession.selectList(namespace + ".boardListAll"); //여러개의 데이터를 가져올떄
	}

	public int boardWriteSave(boardDTO Bdto) {
		return sqlSession.insert(namespace+".saveBoarddata", Bdto);
	}
	
	public boardDTO boardInfo(String id) {
		return sqlSession.selectOne(namespace + ".boardlist",id); //하나의 데이터만 가져올때
	}
	
	public int boardModifySave(boardDTO dto) {
		return sqlSession.update(namespace+".boardUpdatedata", dto);
	}
	
	public int boardCnt(boardDTO dto) {
		return sqlSession.update(namespace+".boardCnt", dto);
	}
	
	public void boardDelete(int id) {
		sqlSession.delete(namespace+".boardDelete", id);
	}
	
	public boardDTO boardReplyView(String id) {
		return sqlSession.selectOne(namespace+".boardlistReplyView", id);
	}
	
	public int boardReplyViewReply(boardDTO Bdto) {
		return sqlSession.insert(namespace+".saveBoarddataReply", Bdto);
	}

}
