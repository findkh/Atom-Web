# 😀 설맞이 개인 프로젝트 - 바닐라 JS로 크롬 app 만들기

## 🗨 계획
    - 설 연휴 동안 학원 초반부에 배웠던 JS를 복습할 겸 각자 만들어서 수업 전에 서로 코딩한 것을 보여주기로 학원 동기들과 약속함! 😳
    강제적으로 약속을 잡아야 의무감에 매일 코딩할 것 같아서 이번 계획을 세웠다.

## 🆗 220130(일) : JS 이론 정리🤣
    - Basic data type
    - Variables
    - const and let
    - Boolean
    - Array
    - Object
    - Function

## 🆗 220131(월) : JS 이론 정리, CSS 적용하여 Login 기능 추가😤
    - return
    - 반복문
    - Object
    - HTML element
    - Event 처리
    - querySelector 사용
    - Login 기능
    - localStorage 활용 - 사용자 이름 기억하기
    학원에서 배운 이론이 반복되어 처음엔 흥미가 좀 떨어졌지만,
    복습이라 생각하고 열심히 따라 했다.
    잊고 있던 부분, 헷갈렸던 부분을 확실히 잡을 수 있었다.
    자바 스크립트 함수와 이벤트 처리 부분을 좀 더 집중해서 들었다.😁
    특히 localStorage 부분은 3개월 전에 언급만 하고 넘어갔던 부분이라 좋았다.

## 🆗 220201(화) : 시계 기능 추가, 명언 랜덤 추가, 랜덤 배경 적용, Todo-List 기능 추가 Todo-List 기능 추가 계속, Weather 기능 추가, CSS 적용😊
    - innterval, timeout
    - Date()
    - padStart()
    - Math.random()
    - Math.floor()
        -> Math.round()는 반올림이고, floor()는 버림인데,
        random() 사용할 때 round()를 주로 사용하다보니(전에 코딩할 때),
        반올림 되서 중간에 화면에 안뿌려지는 경우가 있었다.
        혹시나 해서 round에서 floor로 고쳐봤더니 오류가 잡혔다.
        (생각해보면 quotes.length인데 11.234가 나왔을 때 반올림을 하면 12가 되어서.. 오류발생...
        다음엔 이런 실 수 안해야지..)
        random() 사용할 때 round()말고 floor() 사용해야겠다. 🤨
    - createElement()
    - appendChild()
        <리스트 생성>
    - input box 생성 후 값 받아 저장하기
    - JS파일에서 HTML 태그 생성해서 body에 붙이기
    <리스트 삭제>
    - button 생성
    - button에 eventListner 등록
    - event.target.parentElement 
    - remove()
    <리스트 저장 후 가져오기>
    - LocalStorage 사용
    - LocalStorage 배열로 저장하기
    - stringify() 사용하여 문자열로 변환
    - JSON.parse() 사용하여 배열로 변환
        Uncaught SyntaxError: Unexpected token , in JSON at position 1 
        at JSON.parse (<anonymous>)
        at todo.js:51:27
        -> 30분 정도 오류 찾아서 수정함
         JSON.stringify를 적용하지 않아서 JSON 모양의 String으로 localstorage에 저장되지 않았다. 정확한 이유는 모르겠으나, 이부분 수정하니까 오류가 해결되었다.
         검색해보니 이 에러코드는 JSON 형식의 문자열이 맞지 않을 때 나오는 오류이다.😅
        -> localStoreage 삭제 하고 디버깅 중 오류 하나 더 발견
        로그인 화면에서 로그인이 안되어 있으면 로그인 화면이 떠야 하는데 안뜸..
        -> 개발자도구에서 확인해보니 hidden 뜨고 없어지는거 제대로 되는게 확인됨
        배경이미지 사이즈가 커서 가려진 것으로 확인 됨.
        우선 그대로 진행 하고 후에 css 적용 후 확인하기로 함.
        나중에 확인해보니 위에 로그인창 떠 있었음(live server가 늦게 반영된 것으로 추정됨. 정확한 이유는 알 수 없음.)
    - forEach()
    - 화살표 함수
    - LocalStroage에서 항목 삭제하기
    - filter() 적용
    - typeof
    Weather 기능
    - navigator.geolocation
    - 위도 경도 값 얻기
    - oepnweathermap.org의 API 얻기
    - fetch 사용
    CSS 적용해서 화면 꾸미기




