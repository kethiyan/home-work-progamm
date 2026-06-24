const routerToggle = document.getElementById('routerToggle');
const fibernetContainer = document.getElementById('fibernetContainer');

// Router box or power button click pannunga connection activate aagum
routerToggle.addEventListener('click', () => {
    fibernetContainer.classList.toggle('connected');
});