function profileCommentPagination(pageIdx) {
    const $commentDisplay = $('#comment-display');
    const $commentCard = $('#comment-card-template');
    const $commentPagination = $('#comment-display-pagination');

    const loggedUser = $('#logged-user-username').text();
    const username = $('h2').text();

    $.getJSON(window.location.origin + '/rest/getProfileComments/' + username + '/' + pageIdx)
        .done(function (commentPage) {
            //Generating pagination
            $commentPagination.empty();
            if (commentPage.number !== 0) {
                $commentPagination.append(
                    '<li class="page-item"><a onclick="profileCommentPagination(' + 0 + ')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="profileCommentPagination(' + (commentPage.number - 1) + ')" class="page-link">' + commentPage.number + '</a></li>'
                );
            }
            $commentPagination.append('<li class="page-item active"><a class="page-link" id="current-page">' + (commentPage.number + 1) + '</a></li>');

            if (commentPage.number < commentPage.totalPages - 1) {
                $commentPagination.append(
                    '<li class="page-item"><a onclick="profileCommentPagination(' + (commentPage.number + 1) + ')" class="page-link">' + (commentPage.number + 2) + '</a></li>' +
                    '<li class="page-item"><a onclick="profileCommentPagination(' + (commentPage.totalPages - 1) + ')" class="page-link">&raquo;</a></li>');
            }

            //Generating divs with content
            $commentDisplay.empty();
            let comments = commentPage.content;

            for (let i = 0; i < 4; i++) {
                if ( i < comments.length) {
                    let $commentCardCopy = $($commentCard).clone();

                    $commentCardCopy.attr('id', 'comment-' + comments[i].id);
                    $commentCardCopy.find('img').attr('src', '/user/getImage/' + comments[i].author.id);
                    $commentCardCopy.find('#author-name').text(comments[i].author.username).attr('href', '/user/profile/' + comments[i].author.username);
                    $commentCardCopy.find('p').text(comments[i].content);
                    let created = comments[i].created.split('-');
                    created[2] = created[2].substring(0, 2);
                    $commentCardCopy.find('#added-date').text('Dodano: ' + created[2] + "-" + created[1] + "-" + created[0]);
                    let $rating = $commentCardCopy.find('#rating').attr('id', 'rating-' + comments[i].id).attr('data-value', comments[i].rating);
                    let $commentFooter = $commentCardCopy.find('#comment-footer');

                    //Generating rating in stars
                    for (let j = 0; j < 5; j++) {
                        if (j < comments[i].rating) {
                            $rating.append('<i class="fa fa-star"></i>');
                        } else {
                            $rating.append('<i class="fa fa-star-o"></i>');
                        }
                    }

                    if (comments[i].author.username !== loggedUser) {
                        $commentFooter.css("display", "none")
                    }

                    $commentCardCopy.find('#edit-comment-button').attr('data-id', comments[i].id);
                    $commentCardCopy.find('#delete-comment-button').attr('data-id', comments[i].id);

                    $commentCardCopy.removeClass('d-none');
                    $commentDisplay.append($commentCardCopy);


                } else {
                    $commentDisplay.append('<div class="col-md-6 my-3 p-0 hidden-block"></div>'); //Added to have better scaling cards
                    if (comments.length < 3) {
                        break;
                    }
                }
                if ( (i % 2) === 1) {
                    $commentDisplay.append(
                        '<div class="w-100 d-block"><!-- wrap every 2 to make card-deck responsive--></div>');
                }
            }
        })
}