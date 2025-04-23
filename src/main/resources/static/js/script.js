// Custom JavaScript for Customer Management System

document.addEventListener('DOMContentLoaded', function() {
    // Auto-dismiss alerts after 5 seconds
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(function(alert) {
        setTimeout(function() {
            const bsAlert = new bootstrap.Alert(alert);
            bsAlert.close();
        }, 5000);
    });

    // Add confirmation before deletion
    const deleteLinks = document.querySelectorAll('a[href*="/delete"]');
    deleteLinks.forEach(function(link) {
        link.addEventListener('click', function(event) {
            const confirmDelete = confirm('Are you sure you want to delete this item? This action cannot be undone.');
            if (!confirmDelete) {
                event.preventDefault();
            }
        });
    });

    // Highlight table row on hover
    const tableRows = document.querySelectorAll('tbody tr');
    tableRows.forEach(function(row) {
        row.addEventListener('mouseenter', function() {
            this.classList.add('table-active');
        });
        row.addEventListener('mouseleave', function() {
            this.classList.remove('table-active');
        });
    });

    // Add "active" class to current page link
    const currentLocation = window.location.pathname;
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    navLinks.forEach(function(link) {
        const href = link.getAttribute('href');
        if (currentLocation.includes(href) && href !== '/') {
            link.classList.add('active');
        }
    });

    // Format date inputs to show today's date as default if empty
    const dateInputs = document.querySelectorAll('input[type="date"]');
    dateInputs.forEach(function(input) {
        if (!input.value) {
            const today = new Date();
            const year = today.getFullYear();
            let month = today.getMonth() + 1;
            let day = today.getDate();
            
            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;
            
            input.value = `${year}-${month}-${day}`;
        }
    });
});
