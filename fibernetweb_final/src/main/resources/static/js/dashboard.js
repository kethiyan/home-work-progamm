if (!requireAuth()) {}  // auth.js handles redirect

document.getElementById('logoutBtn').addEventListener('click', logout);
