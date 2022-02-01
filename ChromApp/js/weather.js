//user 위치 알아내기

const API_KEY="a978cfd0f2829729c2b66024e5270b1c"

navigator.geolocation.getCurrentPosition(onGeoSuccess, onGeofail)
//getCurrentPosition은 성공했을 때의 함수, 실패 했을 때의 함수 두 개의 함수가 필요하다

function onGeoSuccess(position) {
  const lat = position.coords.latitude;
  const log = position.coords.longitude;
  // console.log("You live it", lat, log);
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${log}&appid=${API_KEY}&units=metric`
  // console.log(url);
  fetch(url).then(response => response.json()).then(data => {
    const weather = document.querySelector("#weather span:first-child")
    const city = document.querySelector("#weather span:last-child")
    city.innerText = data.name;
    weather.innerText = `${data.weather[0].main} / ${data.main.temp}`;
  });
}

function onGeofail() {
  alert("Can't find you. No weather for you!")
}