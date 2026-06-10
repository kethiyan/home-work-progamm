let promise=new Promise((resolve, reject) => {
    let ticketAvailable = true;

    if(ticketAvailable){
             
        resolve("Ticket Booked");
    } else {
        reject("House Full");
    }

    }
    
);

promise
      .then((result)=>{console.log(result);})
      .catch((error)=>{console.log(error);});


let promise1=new Promise((resolve, reject) => {
    let balance =500 ;
    let amount=500;


    if(balance>=amount){
             
        resolve("withdrawn");
    } else {
        reject("Insufficient Balance");
    }

    }
    
);

promise1
      .then((result)=>{console.log(result);})
      .catch((error)=>{console.log(error);});



let promise2 = new Promise((resolve, reject) => {
    let paymentSuccess = true;

    if (paymentSuccess) {
        resolve("Recharge Successful");
    } else {
        reject("Recharge Failed");
    }
});

promise2
    .then((result) => {
        console.log(result);
    })
    .catch((error) => {
        console.log(error);
    });



    let promise3 =new Promise((resolve, reject) => {
    let correctPassword = true;

    if (correctPassword) {
        resolve("Login Successful");
    } else {
        reject("Invalid Password");
    }
})
.then(result => console.log("Login:", result))
.catch(error => console.log("Login:", error));

