const form = document.getElementById('form');
const id = document.getElementById('id');
const password = document.getElementById('password');
const login_btn = document.getElementById('login');

// Show input error message
function showError(input) {
    const formControl = input.parentElement;
    formControl.className = 'form-control error';
}

// Check required fields
function checkRequired(inputArr) {
    let isOk = true;
    inputArr.forEach(function(input) {
        if (input.value.trim() === '') {
            showError(input);
            isOk = false;
        } else {
            isOk = isOk && true;
        }
    });

    return isOk;
}

// Get fieldname
function getFieldName(input) {
    return input.id.charAt(0).toUpperCase() + input.id.slice(1);
}

// Event listeners
function login(e) {
    e.preventDefault();

    if(checkRequired([id, password])){
        form.submit();
    }
};

login_btn.addEventListener('click', (e) => login(e))