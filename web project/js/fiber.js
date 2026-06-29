// Import common dashboard protection
if(localStorage.getItem('loggedIn') !== 'true') {
    window.location.href = 'index.html';
}

document.getElementById('logoutBtn').addEventListener('click', function() {
    localStorage.removeItem('loggedIn');
    window.location.href = 'index.html';
});

// Fiber Form Submission handling
document.getElementById('fiberForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('customerName').value;
    const address = document.getElementById('address').value;
    
    alert(`Fiber Installation submitted successfully for ${name}!`);
    this.reset();
});