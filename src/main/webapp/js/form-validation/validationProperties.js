$.validator.addMethod('filesize', function (value, element, param) {
    return this.optional(element) || (element.files[0].size <= param)
}, 'Plik jest za duży!');

jQuery.extend(jQuery.validator.messages, {
    required: "To pole jest wymagane!",
    email: "Podaj prawidłowy adres email.",
    extension: "Niepoprawne rozszerzenie pliku.",
    filesize: "Plik jest zbyt duży!"
});