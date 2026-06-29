if(localStorage.getItem('loggedIn') !== 'true') window.location.href = 'index.html';

document.getElementById('logoutBtn').addEventListener('click', function() {
    localStorage.removeItem('loggedIn');
    window.location.href = 'index.html';
});