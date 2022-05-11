# <center>📑My Project</center>

# 220509 - Mybatis 퍼시스턴스 프레임 워크 도입
## 프로젝트에 Mybatis 라이브러리를 추가한다.
  - Spring Boot 구성  
  - `implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2'`
  - 의존 라이브러리 블록에서 `mybatis`라이브러리를 등록한다.
  - `gradle eclipse`
#
# 220509 - Lombok 적용
## lombok 라이브러리를 프로젝트에 추가한다.
  - build.gradle에 lombok 라이브러리 추가
  - `id "io.freefair.lombok" version "6.4.1"` 플러그인 추가
  - `java -jar lombok.jar` 파일 실행하여 이클립스 IDE에 lombok 기능 추가
  - 도메인 클래스에 lombok을 적용한다.
#
# 220509 - 회원가입, 로그인, 로그아웃 적용
## 회원 테이블을 추가한다.
  - db에 my_member 테이블 추가
## 회원 데이터를 다룰 도메인 클래스, DAO 인터페이스를 정의한다.
  - domain.member 클래스 정의
  - insert, findAll, findByNo, get, update, delete 메서드 추가
  - DAO가 사용할 SQL Mapper 파일을 추가
  - 페이지 컨트롤러 추가
## 회원가입, 로그인 화면을 만든다.
  - /src/main/resources/static/member/signin.html
  - /src/main/resources/static/member/signup.html
## 로그인 기능을 추가한다.
  - `findByEmailAndPassword()` 메서드 추가
  - `get()` 메서드 추가
  - `signin()` 메서드 추가
## 상단 메뉴바를 추가한다.
  - /src/main/resources/static/index.html
## 로그인 사용자 정보를 조회한다.
  - com.myproject.controller.ResultMap 클래스 추가
    - JSON 형식의 데이터를 리턴할 때 사용할 클래스로 작업 성공 유무와 결과를 저장한다.
  - com.myproject.Membercontroller에 `getLoginUser()` 메서드 추가
    <img src="https://user-images.githubusercontent.com/89373222/167361427-a0908747-6c86-4e62-ad48-4066271cb109.png">
    <img src="https://user-images.githubusercontent.com/89373222/167362254-3e18ff24-da93-4c37-aceb-22a8cff81aaf.png">
## 로그아웃 기능을 추가한다.
  - com.myproject.Membercontroller에 `signout()` 메서드 추가
## 정리
  - 회원가입  
  <img src="https://user-images.githubusercontent.com/89373222/167368566-42836249-b61b-48f4-a0b1-0c307ba83d09.png">
  <img src="https://user-images.githubusercontent.com/89373222/167368698-b70a0ede-2e8a-477a-8dd5-d3e9a6a5a9a0.png">
  - 로그인 했을 때 상단 메뉴바  
  <img src="https://user-images.githubusercontent.com/89373222/167368932-96263ff8-25ba-43c5-926c-db9cae4729b9.png">
  - 로그인 안했을 때 상단 메뉴바  
  <img src="https://user-images.githubusercontent.com/89373222/167369137-5097dccb-81fa-4f23-84f5-cc43125dac0c.png">
#
# 220509 - 로그인과 세션을 활용하여 사용자를 구분하여 데이터 처리하기
  - 게시글 테이블에 작성자 정보를 추가한다.
    ```
    delete from my_board;

    alter table my_board
      add column writer int not null,
      add constraint my_board_fk foreign key (writer) references my_member(no);
    ```
   - 도메인 클래스 변경
   - 게시글 데이터를 다룰 때 작성자 번호도 함께 다룬다.(myBoardDao.xml 변경)
   - 게시글 입력할 때 로그인 사용자 번호를 추가한다.
    - com.myproject.myBoardcontroller `add(), update(), delete()` 메서드 변경
    - myBoardService, DefaultMyBoardService변경, myboardDao변경
   - 게시글 조회할 때 로그인 사용자의 이름을 함께 제공한다.
    - writer 필드의 타입을 int 대신에 Member 클래스로 교체한다.
    - com.myproject.myBoardcontroller 변경

  - 게시글 입력 화면 변경
    - myboard/form.html 변경
    - myboard/index.html 변경
    - myboard.view.html 변경
#
# 220510 - 파일 입출력
- 회원 가입할 때 프로필 사진과 게시판에 사진을 올릴 수 있게 만든다.
  - DB에 컬럼을 추가한다.
      ```
      alter table my_member
        add column photo varchar(255);
      alter table my_board
        add column photo varchar(255);
      ```
  - 도메인 클래스 수정한다.
  - SQL Mapper 파일 수정한다.
    - xml 파일 변경함
      - resultMap 태그에 컬럼 매핑 정보 추가하고 SQL문에도 추가한다.
  - 사진 파일 업로드 기능을 page Controller에 추가한다.
      - add(), update() 메서드에 파일 업로드 기능 추가
      - URL 경로에서 지정한 파일을 찾아 클라이언트에게 전송하는 photo() 메서드 추가
  - 프론트엔드 수정
    - input 태그 추가 후 POST 요청으로 파일을 업로드한다.
    - 게시판 파일 제대로 업로드 된 것 확인함!
      <img src="https://user-images.githubusercontent.com/89373222/167575129-86cd02cf-f826-4357-a640-8d2a19f7886c.png">
      <img src="https://user-images.githubusercontent.com/89373222/167575294-bdbd597f-e398-4001-a22a-55ba8005f84b.png">
      <img src="https://user-images.githubusercontent.com/89373222/167575472-e22748c7-c35d-4e44-9cb9-545f9d326b36.png">
  - 썸네일 이미지 적용해서 로그인 시 프로필 사진 보이게 하기 사진이 없을 경우 기본 이미지 나오게 한다.
    - https://github.com/coobird/thumbnailator
    - search.maven.org 가서 다운로드 받기 build script 파일에 라이브러리 추가한다.
    - 업로드 파일을 저장한 후 해당 파일의 썸네일 이미지 파일을 생성한다.
    - 프론트앤드 수정
    - update할 때 사진을 제외하고 update할 때를 대비하여 동적 SQL 기능 추가
      <img src="https://user-images.githubusercontent.com/89373222/167644513-b7f987a1-5150-45e0-9da8-16a93eeff6b5.png">  
      작성한 글 내의 사진 보기
      <img src="https://user-images.githubusercontent.com/89373222/167644770-6f8b29a7-b0c7-4568-91f3-10834a8700f6.png">  
      프로필 사진 썸네일 이미지 적용하기
#
# 220511 - Header와 Footer에 부트스트랩 적용
  - npm 적용하기
    - `npm init`을 실행하여 package.json 설정 파일을 준비한다.
    - .gitignore 수정
    - `npm install bootstrap` 실행하여 부트스트랩을 추가한다.
  - bootstrap을 적용하여 header와 footer를 만든다.
    - CSS 적용
  - 프로젝트 때 사용하지 않았던 bootstrap icons 적용
  - 결과
    <img src="https://user-images.githubusercontent.com/89373222/167767672-6029cb1a-9bec-476c-9ecc-b859fa3f52ff.png">


  
