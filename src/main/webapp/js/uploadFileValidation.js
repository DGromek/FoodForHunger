$('form').submit(function(event) {
    const $fileUploadError = $('.upload-file-error');
    let areErrors = false;

    $fileUploadError.text('');

    alert("TEST");

    //this.files[0].size gets the size of your file.
    if (this.files[0].size > 16 * 1024 * 1024) { //if size of the uploaded file is bigger than 16MB
        $fileUploadError.append('Rozmiar pliku nie może być większy niż 16MB!');
        areErrors = true;
    }

    const filenameSplitted = this.files[0].name.split('.');

    if (filenameSplitted[1] !== '.jpg' || filenameSplitted[1] !== '.jpeg' || filenameSplitted[1] !== '.png') {
        $fileUploadError.append('</br>Rozmiar pliku nie może być większy niż 16MB!');
        areErrors = true;
    }

    if (areErrors) {
        event.preventDefault();
    }
});

