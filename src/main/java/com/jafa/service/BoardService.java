package com.jafa.service;

import java.util.List;

import com.jafa.model.BoardVO;

public interface BoardService {
	List<BoardVO> readAll(); 
	BoardVO read(Long bno); 
	void register(BoardVO vo);
	void remove(Long bno);
}
