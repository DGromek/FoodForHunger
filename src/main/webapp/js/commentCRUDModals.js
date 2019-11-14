//CRUD modals
const $addEditCommentModal = $('#addEditCommentModal');
const $deleteCommentModal = $('#deleteCommentModal');

//Inputs in add-edit modal.
const $ratingInput = $('#add-edit-rating');
const $contentInput = $('#add-edit-content');

//Errors in add-edit modal
const $ratingError = $('#rating-error');
const $contentError = $('#content-error');

$deleteCommentModal.on('show.bs.modal', function (event) {
    let $button = $(event.relatedTarget);
    let id = $button.data('id');
    $('#delete-button').click(function () {
        deleteComment(id);
    });
});

$($addEditCommentModal).on('show.bs.modal', function (event) {
    const $button = $(event.relatedTarget);
    const id = $button.data('id');

    //If id is found it's update request.
    if (id !== undefined) {
        const content = $('#comment-' + id + ' p').text(); //Get content of comment
        const rating = $('#rating-' + id).data('value'); //Get comment value

        //Setting values of editCommentModal.
        $addEditCommentModal.find('textarea').val(content);
        $addEditCommentModal.find('select').val(rating);
        $addEditCommentModal.find('h5').text('Edytuj komentarz');
        $addEditCommentModal.find('#update-button').removeClass('d-none');
        $addEditCommentModal.find('#add-button').addClass('d-none');
        $addEditCommentModal.find('#update-button').click(function () {
            saveComment('PUT', id);
        });
    } else { //if not, it's add new comment request
        $addEditCommentModal.find('textarea').val('');
        $addEditCommentModal.find('select').val('');
        $addEditCommentModal.find('h5').text('Dodaj komentarz');
        $addEditCommentModal.find('#add-button').removeClass('d-none');
        $addEditCommentModal.find('#update-button').addClass('d-none');
    }
});

$($addEditCommentModal).on('hidden.bs.modal', function () {
    $ratingError.text('');
    $contentError.text('');
});

//Comments CRUD
//Method used to add and update comments
function saveComment(method, id) {
    const $usernameHeader = $('h2');
    const pageNumber = $('#current-page').text() - 1;
    let url = window.location.origin + '/comment';

    const commentDTO = {
        rating: $ratingInput.val(),
        content: $contentInput.val(),
        receiverUsername: $usernameHeader.text(),
    };

    if (id != null && method.toUpperCase() === 'PUT') {
        url = url + '/' + id;
    }

    $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: JSON.stringify(commentDTO),
        dataType: 'json'
    })
        .done( () => {
            //Pagination refresh
            //We must add a little timeout to comment section refresh to give enough time to save new comment to DB.
            setTimeout(function () {
                profileCommentPagination(pageNumber);
            }, 500);
            $addEditCommentModal.modal('hide');
        })
        .fail ( (res) => {
            console.log(res);
            const contentError = res.responseJSON.content;
            const ratingError = res.responseJSON.rating;

            if (contentError !== undefined) {
                $contentError.text(contentError);
            } else {
                $contentError.text('');
            }
            if (ratingError !== undefined) {
                $ratingError.text(ratingError);
            } else {
                $ratingError.text('');
            }
        });
}

function deleteComment(id) {
    const pageNumber = $('#current-page').text() - 1;

    $.ajax({
        url: window.location.origin + '/comment/' + id,
        method: 'delete',
        contentType: 'application/json',
        dataType: 'json'
    })
        .done( (res) => {
            console.log(res)
        })
        .fail ( (res) => {
            console.log(res);
        });
    setTimeout(function () {
        profileCommentPagination(pageNumber);
    }, 500);
    $deleteCommentModal.modal('hide');
}