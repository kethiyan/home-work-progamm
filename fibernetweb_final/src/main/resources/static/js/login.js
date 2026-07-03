document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const username = document.getElementById('employeeId').value;
    const password = document.getElementById('password').value;

    try {
        const res = await fetch('/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        const data = await res.json();
        console.log('Login response:', res.status, data);

        if (res.ok && data.token) {
            localStorage.setItem('token', data.token);
            localStorage.setItem('username', data.username);
            window.location.href = 'dashboard.html';
        } else {
            alert(data.error || 'Login failed. Check your credentials.');
        }
    } catch (err) {
        console.error('Login error:', err);
        alert('Server error: ' + err.message);
    }
});
