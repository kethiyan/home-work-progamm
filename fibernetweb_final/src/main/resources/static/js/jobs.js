if (!requireAuth()) {}

document.getElementById('logoutBtn').addEventListener('click', logout);

async function loadJobs() {
    const res = await authFetch('/api/jobs');
    const jobs = await res.json();

    const container = document.getElementById('jobsList');
    if (!jobs.length) {
        container.innerHTML = '<p style="color:#a0aec0;margin-top:15px;">No active jobs pending.</p>';
        return;
    }

    container.innerHTML = jobs.map(job => `
        <div style="background:#121824;padding:15px;border-radius:8px;margin-bottom:10px;border-left:3px solid #78b910;">
            <strong>${job.type || 'Job'}</strong> — ${job.customerName || job.issue || ''}<br>
            <small style="color:#a0aec0;">${job.address || ''} | Status: <span style="color:#FFA500;">${job.status}</span></small>
        </div>
    `).join('');
}

loadJobs();
