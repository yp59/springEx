package com.kh.home.Controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.home.entity.MemberDto;
import com.kh.home.repository.MemberDao;

@Controller
//공용 주소 설정, 주의사항을 GetMapping,PostMapping 사용 불가
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberDao memberDao;
	
	//회원 가입 관련 요청 처리
	@GetMapping("/regist")
	public String regist() {
		
		//return "/WEB-INF/views/member/regist.jsp";
		return "/member/regist";
		
	}

	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		
		return "redirect:regist_success";//root로 이동 context.path생략
	}
	
	@GetMapping("/regist_success")
	public String registSuccess() {
		return "member/registSuccess";
	}
	
//	로그인 요청 처리
	@GetMapping("/login")
	public String login() {
		//return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}

// 세션이 필요할 경우 컨트롤러 메소드의 매개변수에 작성하면 자동으로 할당	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto,
			HttpSession session) {
		MemberDto find = memberDao.login(memberDto);
		if(find != null) {//성공
			//세션에 memberNo라는 이름으로 회원번호를 추가
			session.setAttribute("memberNo", find.getMemberNo());
			return "redirect:/";
		}
		else {//실패
			return "redirect:login?error";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("memberNo");
		//session.invalidate();세션만료 사라짐
		return "redirect:/";
	}
	//내정보
		//@GetMapping("/myinfo")
		@RequestMapping("/myinfo")
		public String myinfo(HttpSession session, Model model) {
			int memberNo = (int)session.getAttribute("memberNo");
			
			MemberDto memberDto = memberDao.get(memberNo);
			
			model.addAttribute("memberDto", memberDto);
			//return "/WEB-INF/views/member/myinfo.jsp";
			return "member/myinfo";
		}
		

		//회원 탈퇴
		//@GetMapping("/exit")
		@RequestMapping("/exit")
		public String exit(HttpSession session) {
			int memberNo = (int)session.getAttribute("memberNo");
			
			memberDao.delete(memberNo);
			session.removeAttribute("memberNo");
			
			return "redirect:goodbye";
		}
		
		@GetMapping("/goodbye")
		public String goodbye() {
			return "member/goodbye";
		}
		
		//비밀번호 변경
		@GetMapping("/change_pw")
		public String changePw() {
			//return "/WEB-INF/views/member/changePw.jsp";
			return "member/changePw";
		}
		
		@PostMapping("/change_pw")
		public String changePw(
					HttpSession session,
					@RequestParam(value = "curPw") String curPassword,
					@RequestParam(value = "newPw") String newPassword
				) {
			int memberNo = (int)session.getAttribute("memberNo");
			boolean result = memberDao.changePassword(memberNo, curPassword, newPassword);
			if(result) {
				return "redirect:change_pw_success";
			}
			else {
				return "redirect:change_pw?error";
			}
		}
		
		@GetMapping("/change_pw_success")
		public String changePwSuccess() {
			//return "/WEB-INF/views/member/changePwSuccess.jsp";
			return "member/changePwSuccess";
		}
		
		//회원 정보 변경
		@GetMapping("/change_info")
		public String changeInfo(HttpSession session, Model model) {
			int memberNo = (int)session.getAttribute("memberNo");
			MemberDto memberDto = memberDao.get(memberNo);
			
			model.addAttribute("memberDto", memberDto);
			
			//return "/WEB-INF/views/member/changeInfo.jsp";
			return "member/changeInfo";
		}
		
		
		@PostMapping("/change_info")
		public String changeInfo(
				HttpSession session, @ModelAttribute MemberDto memberDto) {
			int memberNo = (int)session.getAttribute("memberNo");
			memberDto.setMemberNo(memberNo);
			
			boolean result = memberDao.changeInformation(memberDto);
			if(result) {
				//return "redirect:myinfo";
				return "redirect:change_info_success";
			}
			else {
				return "redirect:change_info?error";
			}
		}
		
		@GetMapping("/change_info_success")
		public String changeInfoSuccess() {
			//return "/WEB-INF/views/member/changeInfoSuccess.jsp";
			return "member/changeInfoSuccess";
		}
}
