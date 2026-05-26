function printHello() {
    console.log("Hello World");
}

setInterval(printHello, 2000);

let num = 1;

function displayNumbers() {

    console.log(num);

    num++;

    if (num > 10) {
        clearInterval(interval);
    }
}

let interval = setInterval(displayNumbers, 1000);

function showTime() {

    let time = new Date();

    console.log(time.toLocaleTimeString());
}

setInterval(showTime, 1000);

let even = 2;

function printEven() {

    console.log(even);

    even += 2;
}

setInterval(printEven, 2000);

let count = 10;

function countdown() {

    console.log(count);

    count--;

    if (count < 0) {
        clearInterval(timer);
        console.log("Countdown Finished");
    }
}

let timer = setInterval(countdown, 1000);