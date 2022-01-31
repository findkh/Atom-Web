const images = ["0.jpg", "1.jpg", "2.jpg", "3.jpg", "4.jpg"];

const chosenImage = images[Math.floor((Math.random() * images.length))];
// console.log(images);

const bgImage = document.createElement("img"); //html 요소 생성

bgImage.src = `img/${chosenImage}`;
// console.log(bgImage);

document.body.appendChild(bgImage);
