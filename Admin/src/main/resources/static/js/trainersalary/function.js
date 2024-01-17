////////////////////////////////
$(document).ready(function() {
    $('#trainerSalaryForm').on('submit', function(e) {
        e.preventDefault();
        $.ajax({
            url: '/trainer-salary/save',
            type: 'post',
            data: $(this).serialize(),
            success: function(response) {
               if(response.status === 'success') {
                    Swal.fire({
                        title: 'Success',
                        text: response.message,
                        icon: 'success'
                    }).then(function() {
                        // This function runs after the SweetAlert2 dialog is closed
                        window.location.reload(); // Reload the page
                    });
                }  else {
                    Swal.fire('Error', response.message, 'error');
                }
            },
            error: function(xhr, status, error) {
                console.error('AJAX Error:', xhr.status, xhr.responseText);
                Swal.fire('Error', 'An unexpected error occurred: ' + xhr.responseText, 'error');
            }
        });
    });
});

////////////////////////////////////////////////////////////////
function confirmDelete(trainerSalaryId) {
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: '/trainer-salary/delete/' + trainerSalaryId,
                        type: 'delete',
                        success: function(response) {
                            Swal.fire('Deleted!', response.message, 'success').then(function() {
                                window.location.reload();
                            });
                        },
                        error: function(xhr, status, error) {
                            console.error('AJAX Error:', xhr.status, xhr.responseText);
                            Swal.fire('Error', 'An unexpected error occurred: ' + xhr.responseText, 'error');
                        }
                    });
                }
            });
        }
////////////////////////////////////////////////////////////////
function editSalary(salaryId) {
    // Fetch salary data (example URL, adjust as needed)
    salaryId = Number(salaryId);
    fetch('/trainer-salary/get/' + salaryId)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Assuming 'data' contains the salary details
            // Populate modal form fields
            document.getElementById('salaryId').value = data.id;
            document.getElementById('trainerId').value = data.trainerId;
            document.getElementById('paymentDate').value = data.paymentDate;
            document.getElementById('amount').value = data.amount;
            document.getElementById('amountNumeric').value = data.amount;
            document.getElementById('trainerFirstName').value = data.trainerFirstName;
            document.getElementById('trainerLastName').value = data.trainerLastName;
            document.getElementById('description').value = data.description;
            document.getElementById('creditDebit').value = data.creditDebit;
            document.getElementById('trainerId').classList.add('hidden');
            document.getElementById('labeltrainerId').classList.add('hidden');

            // Show the modal
            $('#trainerSalaryModal').modal('show');
        })
        .catch(error => console.error('Error:', error));
}
////////////////////////////////////////////////////////////////
    function resetForm() {
    // Select the form and reset its values
    document.getElementById('trainerSalaryForm').reset();
}

////////////////////////////////////////////////////////////////

    function updateTrainerInfo() {
    var select = document.getElementById('trainerId');
    var selectedOption = select.options[select.selectedIndex];

    // Extract data attributes from the selected option
    var firstName = selectedOption.getAttribute('data-firstname');
    var lastName = selectedOption.getAttribute('data-lastname');

    // Update input fields
    document.getElementById('trainerFirstName').value = firstName;
    document.getElementById('trainerLastName').value = lastName;
}
////////////////////////////////////////////////////////////////////////
function prepareCreateNew() {
    // Show the trainerId field for creating new entry
    document.getElementById('trainerId').classList.remove('hidden');
    document.getElementById('labeltrainerId').classList.remove('hidden');

    // Reset the form
    resetForm();

    // Show the modal
    $('#trainerSalaryModal').modal('show');
}
////////////////////////////////////////////////////////////////
document.addEventListener('DOMContentLoaded', function () {
        const rowsPerPage = 5; // Số hàng trên mỗi trang
        let currentPage = 1; // Bắt đầu từ trang đầu tiên
        const table = document.querySelector('.table tbody'); // Chọn phần body của bảng
        const rows = table.querySelectorAll('tr'); // Lấy tất cả hàng của bảng
        const pageCount = Math.ceil(rows.length / rowsPerPage); // Tính tổng số trang

        function displayRows() {
            rows.forEach(row => row.style.display = 'none');
            const start = (currentPage - 1) * rowsPerPage;
            const end = start + rowsPerPage;
            rows.forEach((row, index) => {
                if (index >= start && index < end) row.style.display = '';
            });
        }

        function updatePagination() {
            const pagination = document.getElementById('pagination');
            pagination.innerHTML = ''; // Xóa các nút cũ
            for (let i = 1; i <= pageCount; i++) {
                const pageBtn = document.createElement('button');
                pageBtn.textContent = i;
                pageBtn.className = currentPage === i ? 'btn btn-primary' : 'btn btn-secondary';

                // Thêm margin-right cho mỗi nút, trừ nút cuối cùng
                if (i < pageCount) {
                    pageBtn.style.marginRight = '10px';
                }

                pageBtn.addEventListener('click', () => {
                    currentPage = i;
                    displayRows();
                    updatePagination();
                });
                pagination.appendChild(pageBtn);
            }
        }


        displayRows();
        updatePagination();
    });
////////////////////////////////
document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');

    searchInput.addEventListener('input', function () {
        const searchText = this.value.toLowerCase();
        const table = document.querySelector('.table tbody');
        const rows = table.querySelectorAll('tr');

        rows.forEach(row => {
            // Giả sử first name ở cột 2 và last name ở cột 3
            const firstNameCell = row.cells[1].textContent.toLowerCase();
            const lastNameCell = row.cells[2].textContent.toLowerCase();

            const matches = firstNameCell.includes(searchText) || lastNameCell.includes(searchText);
            row.style.display = matches ? '' : 'none';
        });
    });
});
////////////////////////////////
////////////////////////////////
document.addEventListener('DOMContentLoaded', function() {
    const amountInput = document.getElementById('amount');
    const amountNumeric = document.getElementById('amountNumeric');

    amountInput.addEventListener('input', function(event) {
        let value = event.target.value;

        // Remove non-numeric characters for numeric value
        let numericValue = value.replace(/,/g, '').replace(/[^\d]/g, '');

        // Update hidden input with numeric value
        amountNumeric.value = numericValue;

        // Format with commas for display
        let formattedValue = numericValue.replace(/\B(?=(\d{3})+(?!\d))/g, ",");

        // Set the formatted value back to the display input field
        event.target.value = formattedValue;
    });
});


////////////////////////////////