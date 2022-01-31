const quotes = [
  {
    quote: "When I think it's late, it's really late.",
    author: "Park Myeongsu",
  },
  {
    quote: "It is better to fail in originality than to succeed in imitation.",
    author: "Herman Melville",
  },
  {
    quote: "I naver dreamed about success, I worked for it.",
    author: "Estee Lauder",
  },
  {
    quote: "Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.",
    author: "Thmoas Edison",
  },
  {
    quote: "The way to get started is to quit talking and begin doing.",
    author: "Walt Disney",
  },
  {
    quote: "In order to succeed, we must first believe that we can.",
    author: "Nikos Kazantzakis",
  },
  {
    quote: "This too shall pass away",
    author: "Abraham Lincoln",
  },
  {
    quote: "Life is unfair, get used to it",
    author: "Bill Gates",
  },
  {
    quote: "Live positive",
    author: "unknown",
  },
  {
    quote: "He can do, she can do, why not me?",
    author: "unknown",
  },
  {
    quote: "If not now, then when?",
    author: "unknown"
  }
];

const quote = document.querySelector("#quote span:first-child");
const author = document.querySelector("#quote span:last-child");
const todaysQuotes = quotes[Math.floor((Math.random() * quotes.length))];

quote.innerText = todaysQuotes.quote;
author.innerText = todaysQuotes.author;

