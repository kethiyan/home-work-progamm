if (!requireAuth()) {}

document.getElementById('logoutBtn').addEventListener('click', logout);

document.getElementById('fiberForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    const customerName = document.getElementById('customerName').value;
    const address = document.getElementById('address').value;

    const res = await authFetch('/api/jobs', {
        method: 'POST',
        body: JSON.stringify({ type: 'INSTALLATION', customerName, address })
    });

    const data = await res.json();
    if (res.ok) {
        alert(`✅ Fiber Installation submitted for ${customerName}!\nJob ID: ${data.job.id}`);
        this.reset();
    } else {
        alert('Failed to submit. Please try again.');
    }
});
