$('#deleteCommentModal').on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget);
    let id = button.data('id');
    $('#delete-button').attr("href", '/comment/' + id);
});

$('#addEditCommentModal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);
    const id = button.data('id');
    const addEditCommentModal = $("#addEditCommentModal");
    addEditCommentModal.find("h5").empty();

    //If id is found it's update request.
    if (id !== undefined) {
        const content = $("#comment-" + id + " p").text(); //Get content of comment
        const rating = $("#rating-" + id).data("value"); //Get comment value

        //Setting values of editCommentModal.
        addEditCommentModal.find("textarea").val(content);
        addEditCommentModal.find("select").val(rating);
        addEditCommentModal.find("h5").prepend("Edytuj komentarz");

    } else { //if not, it's add new comment request
        addEditCommentModal.find("h5").prepend("Dodaj komentarz");
    }
});