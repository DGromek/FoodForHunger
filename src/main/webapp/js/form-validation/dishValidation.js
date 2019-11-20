$('#dish-form').validate({
    rules: {
        name: {
            required: true
        },
        description: {
            required: true
        },
        dishPhoto: {
            extension: "jpg|jpeg|png",
            filesize: 16 * 1024 * 1024
        },
        price: {
            required: true,
            min: 0
        },
        portionSize: {
            required: true,
            min: 1
        },
        city: {
            required: true
        },
        street: {
            required: true
        },
        houseNr: {
            required: true,
            pattern: "\\d\\d?[a-zA-Z]?"
        }
    },

    messages: {
        price: {
            min: "Cena nie może być ujemna!"
        },
        portionSize: {
            min: "Porcja nie może ważyć mniej niz 1g!"
        },
        houseNr: {
            pattern: "Podaj prawidłowy numer domu!"
        },
    },

    errorPlacement: function (label, element) {
        label.addClass('error-message d-block form-text');
        let hintLabel = $('#' + element.attr("id") + '-hint');

        if (hintLabel.length === 0) { //If length of dom object equals 0 element doesn't exists
            label.insertAfter(element);
        } else {
            label.insertAfter(hintLabel);
        }
    },
    wrapper: 'small'

});
