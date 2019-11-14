function profileDishPagination(pageIdx) {
    const $dishDisplay = $('#dish-display');
    const $dishCard = $('#dish-card-template');
    const $dishPagination = $('#dish-display-pagination');

    const username = $('h2').text();

    $.getJSON(window.location.origin + '/rest/getProfileDishes/' + username + '/' + pageIdx)
        .done(function (dishPage) {
            //Generating pagination
            $dishPagination.empty();
            if (dishPage.number !== 0) {
                $dishPagination.append(
                    '<li class="page-item"><a onclick="profileDishPagination(' + 0 + ')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="profileDishPagination(' + (dishPage.number - 1) + ')" class="page-link">' + dishPage.number + '</a></li>'
                );
            }
            $dishPagination.append('<li class="page-item active"><a class="page-link">' + (dishPage.number + 1) + '</a></li>');

            if (dishPage.number < dishPage.totalPages - 1) {
                $dishPagination.append(
                    '<li class="page-item"><a onclick="profileDishPagination(' + (dishPage.number + 1) + ')" class="page-link">' + (dishPage.number + 2) + '</a></li>' +
                    '<li class="page-item"><a onclick="profileDishPagination(' + (dishPage.totalPages - 1) + ')" class="page-link">&raquo;</a></li>');
            }
            //Generating divs with content
            $dishDisplay.empty();
            let dishes = dishPage.content;

            for (let i = 0; i < 2; i++) {
                if (i < dishes.length) {
                    //Cloning card and replacing her properties.
                    let $dishCardCopy = $($dishCard).clone();
                    $dishCardCopy.find('img').attr('src', '/dish/getImage/' + dishes[i].id);
                    $dishCardCopy.find('h5').text(dishes[i].name);
                    $dishCardCopy.find('p').text(dishes[i].description);
                    $dishCardCopy.find('a').attr('href', '/dish/details/' + dishes[i].id);

                    $dishCardCopy.removeClass('d-none');
                    $dishDisplay.append($dishCardCopy);
                } else {
                    //If there is only 1 dish in page we create invisible div that allows our card to scale better.
                    $dishDisplay.append('<div class="col-md-6 my-4 p-3 hidden-block"></div>');
                }
            }
        })
}


