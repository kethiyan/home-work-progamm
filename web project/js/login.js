document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const empId = document.getElementById('employeeId').value;
    const password = document.getElementById('password').value;

    // Simple Demo authentication checks
    if(empId === "TCH-001" && password === "1234") {
        localStorage.setItem('loggedIn', 'true');
        window.location.href = 'dashboard.html';
    } else {
        alert('Invalid Employee ID or Password! Use Demo: TCH-001 / 1234');
    }
});