function profileDishPagination(username, pageIdx) {
    const dishDisplay = $('#dish-display');
    const dishPagination = $('#dish-browser-pagination')

    $.ajax({
        url: 'http://localhost:8080/rest/getProfileDishes/' + username + '/' + pageIdx,
        method: 'get',
        dataType: 'json'
    })
        .done(function (dishPage) {
            //Generating pagination
            dishPagination.empty();
            if (dishPage.number !== 0) {
                dishPagination.append(
                    '<li class="page-item"><a onclick="profileDishPagination(\'' + username + '\',' +  0 + ')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="profileDishPagination(\'' + username + '\',' +  (dishPage.number - 1) + ')" class="page-link">' + dishPage.number + '</a></li>'
                );
            }
            dishPagination.append('<li class="page-item active"><a class="page-link">' + (dishPage.number + 1) + '</a></li>');

            if (dishPage.number < dishPage.totalPages - 1) {
                dishPagination.append(
                    '<li class="page-item"><a onclick="profileDishPagination(\'' + username + '\',' +  (dishPage.number + 1) + ')" class="page-link">' + (dishPage.number + 2) +'</a></li>' +
                    '<li class="page-item"><a onclick="profileDishPagination(\'' + username + '\',' +  (dishPage.totalPages - 1) + ')" class="page-link">&raquo;</a></li>');
            }
            //Generating divs with content
            dishDisplay.empty();
            let dishes = dishPage.content;

            for (let i = 0; i < 2; i++) {
                if (i < dishes.length) {
                    dishDisplay.append(
                        '<div class="card col-md-6 my-4 p-3 border shadow bg-light profile-dish-card-size">' +
                        '<img class="card-img-top img-fluid dish-profile-thumbnail" src="/dish/getImage/' + dishes[i].id + '">' +
                        '<div class="card-body pb-0">' +
                        '<h5>' + dishes[i].name + '</h5>' +
                        '<p class="card-text">' + dishes[i].description + '</p>' +
                        '</div>' +
                        '<div class="card-footer border-0 text-right bg-light">' +
                        '<form action="/dish/details/' + dishes[i].id + '">' +
                        '<button type="submit" class="btn btn-info btn-sm">Szczegóły</button>' +
                        '</form>' +
                        '</div>' +
                        '</div>')
                } else {
                    dishDisplay.append('<div class="col-md-6 my-4 p-3 hidden-block"></div>');
                }
            }
        })
    .fail(function () {
        console.log("Niepowiodło się")
    })
}


