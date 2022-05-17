package com.hyun.myproject2;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//서블릿 컨테이너가 특정 상태에 놓을 때 수행할 작업이 있다면 리스너 클래스에 정의한다.
//
@WebListener //서블릿 컨테이너에 리스너 등록
public class Listener1 implements ServletRequestListener { //서블릿 컨테이너가 시작, 종료할 때

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    //요청이 들어오면 필터를 수행하기 전에 호출된다.
    System.out.println("Listener1.requestInitialized() 호출");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    //응답을 완료할 때 필터 실행 후에 호출된다.
    System.out.println("Listener1.requestDestroyed() 호출");
  }
}
