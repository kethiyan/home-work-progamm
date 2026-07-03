if (!requireAuth()) {}

document.getElementById('logoutBtn').addEventListener('click', logout);

document.getElementById('repairForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    const issue = document.getElementById('ticketId').value;

    const res = await authFetch('/api/repair', {
        method: 'POST',
        body: JSON.stringify({ issue })
    });

    const data = await res.json();
    if (res.ok) {
        alert(`✅ Repair ticket registered!\nTicket ID: ${data.ticket.id}`);
        this.reset();
    } else {
        alert('Failed to submit repair ticket.');
    }
});
