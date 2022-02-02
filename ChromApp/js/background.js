const IMG_NUM = 5;
const body = document.querySelector("body");
const randomNum = getRandom();

paintImage(randomNum);

function paintImage(imgNum) {
  const img = new Image();//이미지 객체 생성
  /*new Image()에 의해 생성된 Image 객체는 이미지를 로딩하여 
  저장해 두는 목적으로 사용된다.*/
  img.src = `img/${imgNum + 1}.jpg`; //이미지 로딩 <img src=주소>
  img.classList.add("bgImage"); //class 이름 부여
  body.prepend(img); //body 앞으로 img가 붙는다.
}

function getRandom() {
  const number = Math.floor(Math.random() * IMG_NUM);
  return number;
}