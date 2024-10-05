function getmessage() {var amount = Math.round(Math.random() * 100000);
  var message =
    "you won $" + amount + "!\n" +
    "to collect your winnings, send your credit card\n" +
    "and bank details to oil-minister@phisher.Com.";
  return(message);
}

function showwinnings1() {
  alert(getmessage());
}

function showwinnings2() {
  document.write("<h1>" + getmessage() + "</h1>");
}
