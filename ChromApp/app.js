const loginForm = document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const greeting = document.querySelector("#greeting");
// const link = document.querySelector("a");
const HIDDEN_CLASSNAME = "hidden"; //변수 이름을 대문자로 쓴느 이유 : String만 포함된 변수는 대문자로 표기, String을 저장하고 싶을 때 사용
const USERNAME_KEY = "username";

const savedUsername = localStorage.getItem(USERNAME_KEY); //username이 없으면 null을 리턴함

if(savedUsername === null) { //username이 null이라면
    //show the form 
    loginForm.classList.remove(HIDDEN_CLASSNAME); //loginForm 화면에 보이게 함
    loginForm.addEventListener("submit", onLoginSubmit);
} else { //localStorage에 이름이 저장되어 있다면
    // show the greetings
    // onLoginSubmit();
    paintGreetings(savedUsername); //인사말을 출력한다.
}

//username을 기억하는 funciton
function onLoginSubmit(event) {
    event.preventDefault(); //브라우저의 동작을 막음 (새로 고침)
    loginForm.classList.add(HIDDEN_CLASSNAME); //Form을 숨겨줌
    const username = loginInput.value; //input value를 username에 저장함
    // console.log(username);
    localStorage.setItem(USERNAME_KEY, username); //localStorage에 key-value값으로 저장함
    paintGreetings(username); //인사말을 출력하는 function 호출
}

//인사말하는 function
function paintGreetings (username) {
    greeting.innerText = `"Hello ${username}`; //Hello 이름 출력
    greeting.classList.remove(HIDDEN_CLASSNAME); //h1의 hidden 클래스명 제거함
}

// link.addEventListener("click", handleLinkClick)

// function handleLinkClick(event) {
    //     event.preventDefault();
    //     console.dir(event);
    //     alert("clicked!")
    // }