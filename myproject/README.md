#
# ⚙ MyProject
  - 팀 프로젝트에서 부족했던 부분을 따로 공부하기 위해 시작한 프로젝트입니다.
  - 프론트와 백엔드를 분리하여 개발하였습니다.
    - main index, myboard
      - 📅 시작 : 2022-05-09(월)
      - 📅 종료 : 2022-05-16(월)
      - 목표 : 팀프로젝트 때 제이쿼리를 사용하여 개발하였는데 가능하면 자바스크립트를 이용하여 개발하려 노력하였습니다.
      - 서버 기술 : SpringBoot, MyBatis, mariaDB
      - 화면 기술 : HTML, CSS, JavaScript, Bootstrap, handlebars, JQuery, js-cookie
      - 개발 도구 : Eclipse, VScode, Atom
      - [개발 과정 README.md 보기](https://github.com/findkh/WebProject/tree/main/myproject/app)
#
## 1차 myboard 📑
  - 🆗 회원 가입  
    > <span style="color:red">✔</span> 일반 회원 가입 구현  
  - 🆗 로그인 구현  
    > <span style="color:red">✔</span> 일반 회원 로그인 구현  
    > <span style="color:red">✔</span> facebook 로그인 구현   
    > <span style="color:red">✔</span> 일반 회원 로그인시 등록된 회원 사진이 Header에 출력되게 구현
    > - 파일 입출력 구현   
  - 🆗 bootstrap 적용(익숙해지기)
    > <span style="color:red">✔</span> 팀 프로젝트 때 form 양식을 테이블로 사용하였는데, 테이블이 아닌 input 태그로 구현함.  
    > <span style="color:red">✔</span> header와 footer 구현하기
  - 🆗 main index에서 header와 footer 분리하여 board에 적용
    > <span style="color:red">✔</span> 자바스크립트를 사용하여 적용하였다가 코드가 길어지고 유지보수의 어려움이 있을 것 같아서 제이쿼리로 페이지에 적용
  - 🆗 인터셉터와 log4j2 적용
    > <span style="color:red">✔</span> 인터셉터 기능 제대로 활용하기. 팀프로젝트 때 이해하지 못했던 것 제대로 이해함  
    > <span style="color:red">✔</span> 팀프로젝트때 logback을 사용했는데 log4j2로 변경
  - 🆗 페이지네이션 적용
    > <span style="color:red">✔</span> 페이징처리할 때 숫자 값 메서드 활용하여 코드를 줄임.