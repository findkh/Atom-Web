package com.hyun.myproject2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//서블릿 컨테이너가 특정 상태에 놓을 때 수행할 작업이 있다면 리스너 클래스에 정의한다.
//
@WebListener //클라이언트의 요청이 들어오면 다음 클래스를 실행하라고 서블릿 컨테이너에게 알려준다.
public class Listener2 implements ServletContextListener { //요청, 응답 상태일 때

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 서버가 시작하면 호출됨
    System.out.println("Listener1.contextInitialized() 호출!");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 서버가 종료하면 호출됨
    System.out.println("Listener1.contextDestroyed() 호출!");
  }
}
