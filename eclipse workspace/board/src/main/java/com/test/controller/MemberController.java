package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@Controller
public class MemberController {
	
	@Autowired
	BoardMapper mapper;
	/*public MemberController(BoardMapper mapper) {//매개변수 형태로 인자로 클래스 mapper 주입, 안정성 ? stack 영역에 만들어진다 ?
		this.mapper = mapper;*/						// = @Autowired
	@GetMapping("/member/memberList")//url 주소
	public void listMember(Model model) {
		model.addAttribute("list", mapper.selectMemberList()); //list라는 값에다 mapper클래스 내의 selectMemberList()의 결과 값? 을 보낸다.
																//이후 list는 memberList.html에서 쓴다
	}
	@GetMapping("/member/memberRegistry")
	public void getMemberRegistry() {}
	
	@PostMapping("/member/memberRegistry")
	public String postMemberRegistry(Member member) {
		mapper.insertMember(member.getUserid(), member.getUsername(), member.getAge());
		return "redirect:/member/memberList"; //다음 url 주소로 바로 이동
	}
}
