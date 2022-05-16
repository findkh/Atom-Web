package com.myproject.interceptor;

import static com.myproject.controller.ResultMap.FAIL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.controller.ResultMap;
import com.myproject.domain.Member;

public class AuthInterceptor implements HandlerInterceptor {

  private static final Logger log = LogManager.getLogger(AuthInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("preHandler() 호출됨");
    //로그인 여부 검사

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      //로그인을 하지 않았으면 오류 메세지를 JSON 형식으로 직접 응답한다.
      String json = new ObjectMapper().writeValueAsString(new ResultMap()
          .setStatus(FAIL)
          .setData("로그인 하지 않았습니다!"));
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(json);
      return false; //페이지 컨트롤러를 실행하지 말고 즉시 응답한다.
    } 
    return true; //로그인 된 상태라면 계속 진행한다.(요청한 페이지 컨트롤러의 메서드를 호출한다)
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.trace("postHandler() 호출됨");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}
