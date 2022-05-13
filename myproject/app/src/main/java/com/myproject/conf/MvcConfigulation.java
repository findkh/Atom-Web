package com.myproject.conf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.myproject.interceptor.AuthInterceptor;

//@Configuration  
//클래스가 설정에 관련된 일을 하는 클래스임을 선언한다. 
//스프링프레임워크는 이 에노테이션이 붙은 클래스에 대해 관련 메서드를 호출하여 내부 설정에 반영한다.

@Configuration 
public class MvcConfigulation implements WebMvcConfigurer {
  //WebMvcConfigurer 인터페이스에 따라 메서드를 작성하면 스프링부트는 해당 메서드를 호출하여 그 메서드가 요구하는대로 설정한다.

  private static final Logger log = LogManager.getLogger(MvcConfigulation.class);

  //인터셉터를 추가하고 싶다면 다음 메서드를 규칙에 따라 정의한다.
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //이 메서드가 정의 되어 있다면
    //스프링부트는 이 메서드를 호출하여 추가할 인터셉터의 정보를 InterceptorRegistry로 받는다.
    log.debug("MvcConfigulation.addInterceptors() 호출됨!");

    registry.addInterceptor(new AuthInterceptor())
    .addPathPatterns("/**/add*", "/**/update*", "/**/delete*");
  }
}
