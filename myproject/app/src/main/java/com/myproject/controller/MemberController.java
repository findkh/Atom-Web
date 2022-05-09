package com.myproject.controller;

import static com.myproject.controller.ResultMap.FAIL;
import static com.myproject.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.domain.Member;
import com.myproject.service.MemberService;

@RestController 
public class MemberController {

  @Autowired
  MemberService memberSerivce;

  @RequestMapping("/member/signup") 
  public Object singUp(Member member) {
    if (memberSerivce.add(member) == 1) {
      return "success";
    } else {
      return "fail";
    }
  }

  @RequestMapping("/member/signin") 
  public Object singIn(String email, String password, HttpSession session) {
    Member loginUser = memberSerivce.get(email, password);
    if (loginUser == null) {
      return "fail";
    }
    //로그인이 성공하면, 
    //로그인 회원의 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);
    return "success";
  }

  @RequestMapping("/member/getLoginUser") 
  public Object getLoginUser(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if (member != null) {
      return new ResultMap().setStatus(SUCCESS).setData(member);
    } else {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }
  }

  @RequestMapping("/member/signout") 
  public Object singOut(HttpSession session) {
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }

}


