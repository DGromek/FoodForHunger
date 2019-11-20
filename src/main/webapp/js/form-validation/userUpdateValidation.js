$('#user-update-form').validate({
    rules: {
        email: {
            required: true,
            email: true
        },
        avatar: {
            extension: "jpg|jpeg|png",
            filesize: 16 * 1024 * 1024
        },
        oldPassword: {
            required: function () {
                return $("#newPassword").val().length > 0;
            }
        },
        newPassword: {
            required: function () {
                return $("#oldPassword").val().length > 0;
            },
            minlength: 8
        },
        newPasswordRepeated: {
            equalTo: "#newPassword"
        }
    },
    messages: {
        oldPassword: {
            required: "Aby zmienić hasło musisz podać swoje stare hasło!"
        },
        newPassword: {
            required: "Podaj nowe hasło.",
            minlength: "Hasło musi mieć minimum 8 znaków!",
        },
        newPasswordRepeated: {
            equalTo: "Hasła różnią się."
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