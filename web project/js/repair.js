if(localStorage.getItem('loggedIn') !== 'true') window.location.href = 'index.html';

document.getElementById('logoutBtn').addEventListener('click', function() {
    localStorage.removeItem('loggedIn');
    window.location.href = 'index.html';
});

document.getElementById('repairForm').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Repair ticket registered!');
    this.reset();
});