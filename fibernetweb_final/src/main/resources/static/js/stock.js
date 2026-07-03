if (!requireAuth()) {}

document.getElementById('logoutBtn').addEventListener('click', logout);

async function loadStock() {
    const res = await authFetch('/api/stock');
    const items = await res.json();

    const container = document.getElementById('stockTable');
    if (!items.length) {
        container.innerHTML = '<p style="color:#a0aec0;margin-top:15px;">No stock items found.</p>';
        return;
    }

    container.innerHTML = `
        <table style="width:100%;border-collapse:collapse;margin-top:15px;">
            <thead>
                <tr style="border-bottom:1px solid #232d42;color:#10b981;">
                    <th style="padding:10px;text-align:left;">Item</th>
                    <th style="padding:10px;text-align:center;">Quantity</th>
                    <th style="padding:10px;text-align:center;">Unit</th>
                </tr>
            </thead>
            <tbody>
                ${items.map(item => `
                    <tr style="border-bottom:1px solid #232d42;">
                        <td style="padding:10px;">${item.name}</td>
                        <td style="padding:10px;text-align:center;">${item.quantity}</td>
                        <td style="padding:10px;text-align:center;color:#a0aec0;">${item.unit}</td>
                    </tr>
                `).join('')}
            </tbody>
        </table>
    `;
}

loadStock();
