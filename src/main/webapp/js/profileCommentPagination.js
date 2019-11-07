function profileCommentPagination(username, pageIdx, loggedUser) {
    const commentDisplay = $('#comment-display');
    const commentPagination = $('#comment-display-pagination');

    $.ajax({
        url: 'http://localhost:8080/rest/getProfileComments/' + username + '/' + pageIdx,
        method: 'get',
        dataType: 'json'
    })
        .done(function (commentPage) {

            console.log(loggedUser);

            //Generating pagination
            commentPagination.empty();
            if (commentPage.number !== 0) {
                commentPagination.append(
                    '<li class="page-item"><a onclick="profileCommentPagination(\'' + username + '\',' + 0 + ',' + '\'' + loggedUser + '\')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="profileCommentPagination(\'' + username + '\',' + (commentPage.number - 1) + ',' + '\'' + loggedUser + '\')" class="page-link">' + commentPage.number + '</a></li>'
                );
            }
            commentPagination.append('<li class="page-item active"><a class="page-link">' + (commentPage.number + 1) + '</a></li>');

            if (commentPage.number < commentPage.totalPages - 1) {
                commentPagination.append(
                    '<li class="page-item"><a onclick="profileCommentPagination(\'' + username + '\',' + (commentPage.number + 1) + ',' + '\'' + loggedUser + '\')" class="page-link">' + (commentPage.number + 2) + '</a></li>' +
                    '<li class="page-item"><a onclick="profileCommentPagination(\'' + username + '\',' + (commentPage.totalPages - 1) + ',' + '\'' + loggedUser + '\')" class="page-link">&raquo;</a></li>');
            }

            //Generating divs with content
            commentDisplay.empty();
            let comments = commentPage.content;

            for (let i = 0; i < 4; i++) {
                if ( i < comments.length) {
                    commentDisplay.append(
                        '<div class="card my-3 border shadow bg-light rounded p-0">' +
                        '   <div class="card-header">' +
                        '       <div class="row">' +
                        '           <div class="px-2">' +
                        '               <img src="/user/getImage/' + comments[i].author.id + '" class="pr-1 rounded-circle img-fluid user-avatar-thumbnail">' +
                        '           </div>' +
                        '           <div class="col m-auto p-0">' +
                        '               <a href="/user/profile/' + comments[i].author.username +'">' + comments[i].author.username + '</a>' +
                        '           </div>' +
                        '           <div class="col m-auto text-right" id="rating-' + i + '">' +
                        '           </div>' +
                        '       </div>' +
                        '   </div>' +
                        '   <div class="card-body pb-0">' +
                        '       <div class="card-text">' +
                        '           <p>' + comments[i].content + '</p>' +
                        '       </div>' +
                        '   </div>' +
                        '   <div class="card-footer border-0 bg-light pt-0">' +
                        '       <div class="row">' +
                        '           <div class="col">' +
                        '               <small>Dodano: ' + comments[i].created + '</small>' +
                        '           </div>' +
                        '           <div class="col text-right" id="comment-footer-' + i + '">' +
                        '               <small><a href="">Edytuj</a>  <a href="" data-toggle="modal" data-target="#deleteCommentModal" data-id="' + comments[i].id + '">Usuń</a></small>' +
                        '           </div>' +
                        '       </div>' +
                        '   </div>' +
                        '</div>');

                    let rating = $('#rating-' + i);
                    for (let j = 0; j < 5; j++) {
                        if (j < comments[i].rating) {
                            rating.append('<i class="fa fa-star"></i>');
                        } else {
                            rating.append('<i class="fa fa-star-o"></i>');
                        }
                    }

                    let commentFooter = $('#comment-footer-' + i);
                    if (comments[i].author.username !== loggedUser) {
                        commentFooter.css("display", "none")
                    }
                } else {
                    commentDisplay.append('<div class="col-md-6 my-3 p-0 hidden-block"></div>')
                    if (comments.length < 3) {
                        break;
                    }
                }
                if ( i === 1) {
                    commentDisplay.append(
                        '<div class="w-100 d-block"><!-- wrap every 2 to make responsive--></div>');
                }
            }
        })
        .fail(function () {
            console.log("Niepowiodło się")
        })
}