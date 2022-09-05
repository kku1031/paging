package com.jafa.mapper;

import java.util.List;

import com.jafa.model.BoardVO;

public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO get(Long bno); 
	void insert(BoardVO vo);	
	void delete(Long bno);
}
