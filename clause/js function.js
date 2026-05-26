const prompt = require("prompt-sync")();

const add = (a, b) => a + b;

function display(result) {
    console.log("Sum =", result);
}


const checkEvenOdd = function(num) {
    if (num % 2 === 0)
        console.log(num + " is Even");
    else
        console.log(num + " is Odd");
};


const multiply = (a, b) => a * b;

function checkResult(result, callback) {
    callback(result);
}

while (true) {

    console.log("\nMenu");
    console.log("1. Add Two Numbers");
    console.log("2. Check Even or Odd");
    console.log("3. Multiply Two Numbers and Check Result");
    console.log("4. Exit");

    let choice = Number(prompt("Enter your choice: "));

    switch(choice) {

        case 1:
            let n1 = Number(prompt("Enter first number: "));
            let n2 = Number(prompt("Enter second number: "));

            let sum = add(n1, n2);
            display(sum);
            break;

        case 2:
            let num = Number(prompt("Enter a number: "));
            checkEvenOdd(num);
            break;

        case 3:
            let a = Number(prompt("Enter first number: "));
            let b = Number(prompt("Enter second number: "));

            let result = multiply(a, b);

            checkResult(result, function(res) {
                console.log("Multiplication Result =", res);

                if (res > 100)
                    console.log("Result is greater than 100");
                else
                    console.log("Result is NOT greater than 100");
            });

            break;

        case 4:
            console.log("Program Exited");
            process.exit();

        default:
            console.log("Invalid Choice");
    }
}

