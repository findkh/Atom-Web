const clock = document.querySelector(".js-clock .clock")
// console.log(clock);
// clock.innerText = "lalal"

function getClock() {
    const date = new Date();
    // console.log(date);
    const hours = String(date.getHours()).padStart(2, "0");
    const minutes = String(date.getMinutes()).padStart(2, "0");
    const seconds = String(date.getSeconds()).padStart(2, "0");
    clock.innerText = `${hours}:${minutes}:${seconds}`;
}

getClock(); //현재시간 바로 출력되게 함수 호출
setInterval(getClock, 1000); //1초마다 함수 호출
