$('#user-register-form').validate({
    rules: {
        username: {
            required: true,
            minlength: 5,
            maxlength: 15
        },
        email: {
            required: true,
            email: true
        },
        password: {
            required: true,
            minlength: 8
        },
        repeatedPassword: {
            equalTo: "#password-1"
        },
        accepted: {
            required: true
        }
    },

    messages: {
        username: {
            minlength: "Login nie może być krótszy niz 5 znaków!",
            maxlength: "Login nie może być dłuższy niz 15 znaków!",
        },
        password: {
            minlength: "Hasło musi mieć minimum 8 znaków!"
        },
        repeatedPassword: {
            equalTo: "Hasła różnią się."
        },
        accepted: {
            required: "Musisz zaackeptować warunki użytkowania serwisu."
        }
    },

    errorPlacement: function (label, element) {
        label.addClass('error-message d-block form-text');
        if (element.attr('id') === 'accepted') {
            label.insertAfter(element.parent("div"));
        } else {
            label.insertAfter(element);
        }
    },
    wrapper: 'small'
});
