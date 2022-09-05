package com.jafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jafa.mapper.BoardMapper;
import com.jafa.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper; 
	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}	

	@Override
	public BoardVO read(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> readAll() {
		return mapper.getList();
	}

}
