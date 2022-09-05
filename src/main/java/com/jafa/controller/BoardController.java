package com.jafa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.model.BoardVO;
import com.jafa.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService service;
	
	@Autowired
	public void setService(BoardService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public String getList(Model model) {
		List<BoardVO> readAll = service.readAll();
		model.addAttribute("list", readAll);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		BoardVO read = service.read(bno); 
		model.addAttribute("board", service.read(bno));
		return "board/get";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		service.register(vo);
		System.out.println(vo);
		rttr.addFlashAttribute("result", "register");
		rttr.addFlashAttribute("bno",vo.getBno());
		return "redirect:list";
	}
	

	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		BoardVO read = service.read(bno);
		model.addAttribute("board", read);
		return "board/modify";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("result", "remove")
			.addFlashAttribute("bno",bno);
		return "redirect:list";
	}	
}
