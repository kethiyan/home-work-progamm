// Check Login Authentication
if(localStorage.getItem('loggedIn') !== 'true') {
    window.location.href = 'index.html';
}

// Logout handler
document.getElementById('logoutBtn').addEventListener('click', function() {
    localStorage.removeItem('loggedIn');
    window.location.href = 'index.html';
});