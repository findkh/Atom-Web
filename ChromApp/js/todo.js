const toDoForm = document.getElementById("todo-form");
const toDoInput = document.querySelector("#todo-form input")
const toDoList = document.getElementById("todo-list");

const TODOS_KEY = "todos";

let toDos = []; //ToDoList를 담을 배열 준비
//배열에 담은 이전 리스트들을 저장할 수 있게 const에서 let으로 변경한다.(업데이트가 되도록)

//localStroage로 todolist를 저장함
function saveToDos() {
  localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
  //JSON.stringify(): JS의 Object나 Array 등을 string으로 변환시킬 수 있다.
}

//입력값 받아서 변수에 저장 후 input박스 비우는 function
function handleToDoSubmit(event) {
  event.preventDefault();
  const newTodo = toDoInput.value; //입력값을 newTodo 변수에 복사함
  // console.log(newTodo);
  toDoInput.value = ""; //enter 치면 input 박스 공백으로 처리함, newTodo의 값과는 관련 없음
  const newTodoObj = { //text형태였던 newTodo를 obj형태로 변경
    //ex [{"text:hello","id":123456}]으로 리스트 값을 변경함
    //각 todo마다 고유의 값을 갖게 하기 위해 date.now()를 활용함
    text: newTodo,
    id: Date.now()
  }
  toDos.push(newTodoObj); //생성된 todo를 배열에 저장
  paintToDo(newTodoObj);
  saveToDos(); //todo localStorage로 저장
}

//li와 span 태그, 삭제버튼 만드는 function
function paintToDo(newTodo) {
  const li = document.createElement("li");
  li.id = newTodo.id; //li에 id 값을 newTodo Obj의 id 값으로 설정
  const span = document.createElement("span");
  span.innerText = newTodo.text; //span에 newTodo의 text값 붙이기
  const button = document.createElement("button");
  button.innerText = "❌";
  button.addEventListener("click", deleteTodo);
  li.appendChild(span); //li 밑에 span 태그 붙이기
  li.appendChild(button); //li 밑에 button 붙이기
  // console.log(li);
  toDoList.appendChild(li); //화면에 출력
}

//todolist를 삭제하는 function
function deleteTodo(event) {
  const li = event.target.parentElement; //삭제할 li를 알아냄
  // console.log(li.id);
  // console.log(typeof li.id);
  li.remove();
  toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id)); //클릭했던 li의 id를 갖고 있는 toDo 삭제
  saveToDos(); //필터 적용한 array를 다시 저장함
/*
array에서 item을 삭제하는게 아니라 삭제하고 싶은 item을 제외하고 새 array를 만든다.
forEach와 유사한 역할을 하는 filter()
filter()는 반드시 true를 리턴해야 한다
만약 새 array에서 이 object를 유지하고 싶으면 filter() 반드시 true를 리턴해야 한다.
false를 리턴하면 그 item은 새로운 array에 포함되지 않는다.
*/
}

toDoForm.addEventListener("submit", handleToDoSubmit);

const savedToDos = localStorage.getItem(TODOS_KEY); //localstorage에 저장된 문자열을 가져옴
// console.log(savedToDos);

if (savedToDos !== null) { //localstorage에 아무것도 없다면 null, null이 아니라면
  const parsedToDos = JSON.parse(savedToDos); 
  //stringfy에서 변환한 ["a", "b"]를 String이 아닌 JS에서 사용 가능한 array로 만듦
  toDos = parsedToDos;
  parsedToDos.forEach((paintToDo)); //array에 들어 있는 항목을 화면에 출력함
  //forEach함수는 paintTodo를 parsedToDos 배열의 요소마다 실행한다.
}