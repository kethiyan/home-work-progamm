// Get JWT token from storage
function getToken() {
    return localStorage.getItem('token');
}

// Auth guard - redirect to login if no token
function requireAuth() {
    if (!getToken()) {
        window.location.href = 'index.html';
        return false;
    }
    return true;
}

// Authenticated fetch wrapper
async function authFetch(url, options = {}) {
    const token = getToken();
    return fetch(url, {
        ...options,
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
            ...(options.headers || {})
        }
    });
}

// Logout
function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    window.location.href = 'index.html';
}
