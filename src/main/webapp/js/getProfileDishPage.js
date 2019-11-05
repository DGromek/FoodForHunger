function getProfileDishPage (username, pageIdx) {
     const dishDisplay = $('#dish-display');

    $.ajax({
        url: 'http://localhost:8080/rest/getProfileDishes/' + username + '/' + pageIdx ,
        method: 'get',
        dataType: 'json'
    })
        .done(function (res) {
            console.log(res);
            res.content.forEach( dish => {
                dishDisplay.empty();
                dishDisplay.append(
                    '<div class="card col-md-6 my-4 p-3 border shadow bg-light profile-dish-card-size">' +
                        '<img class="card-img-top img-fluid dish-profile-thumbnail" src="/dish/getImage/' + dish.id + '">' +
                        '<div class="card-body pb-0">' +
                            '<h5>'+ dish.name + '</h5>' +
                            '<p class="card-text">' + dish.description + '</p>' +
                        '</div>' +
                        '<div class="card-footer border-0 text-right bg-light">' +
                            '<form action="/dish/details/' + dish.id + '">' +
                                '<button type="submit" class="btn btn-info btn-sm">Szczegóły</button>' +
                            '</form>' +
                        '</div>' +
                    '</div>')
            });
        })
        .fail(function () {
            console.log("Niepowiodło się")
        })
}


