function dishBrowserPagination(pageIdx) {
    const browserResults = $('#browser-results');
    const browserPagination = $('#browser-pagination')

    $.ajax({
        url: 'http://localhost:8080/rest/getBrowserResults/' + pageIdx,
        method: 'get',
        dataType: 'json'
    })
        .done(function (browserPage) {
            //Generating pagination
            browserPagination.empty();
            if (browserPage.number !== 0) {
                browserPagination.append(
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + 0 + ')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="dishBrowserPagination(' +  (browserPage.number - 1) + ')" class="page-link">' + browserPage.number + '</a></li>'
                );
            }
            browserPagination.append('<li class="page-item active"><a class="page-link">' + (browserPage.number + 1) + '</a></li>');

            if (browserPage.number < browserPage.totalPages - 1) {
                browserPagination.append(
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + (browserPage.number + 1) + ')" class="page-link">' + (browserPage.number + 2) +'</a></li>' +
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + (browserPage.totalPages - 1) + ')" class="page-link">&raquo;</a></li>');
            }
            //Generating divs with content
            browserResults.empty();
            let dishes = browserPage.content;

            for (let i = 0; i < 9; i++) {
                if (i < dishes.length) {
                    browserResults.append(
                        '<div class="card p-4 mb-3 border-0 shadow">' +
                        '   <img class="card-img-top img-fluid dish-browser-thumbnail" src="/dish/getImage/' + dishes[i].id + '">' +
                        '   <div class="card-body px-1">' +
                        '       <h4 class="card-title">' + dishes[i].name + '</h4>' +
                        '       <h6 class="card-subtitle mb-2 text-muted">By <a href="/user/profile/' + dishes[i].user.username + '">' + dishes[i].user.username + '</a></h6>' +
                        '       <p class="card-text">' + dishes[i].description + '</p>' +
                        '   </div>' +
                        '   <div class="card-footer bg-transparent border-0 px-1 pb-3">' +
                        '       <a href="/dish/details/' + dishes[i].id + '" class="btn btn-info">Zobacz więcej!</a>' +
                        '   </div>' +
                        '</div>');
                } else {
                    browserResults.append('<div class="card p-4 mb-3 hidden-block"></div>');
                    if (i === 5) {
                        break;
                    }
                }

                if ((i + 1) % 2 === 0) {
                browserResults.append(
                        '<div class="w-100 d-none d-sm-block d-md-block d-lg-none"><!-- wrap every 2 on sm and md--></div>');
                }

                if ((i + 1) % 3 === 0) {
                    browserResults.append(
                        '<div class="w-100 d-none d-lg-block d-xl-block"><!-- wrap every 3 on lg and xl--></div>');
                }
            }
        })
        .fail(function () {
            console.log("Niepowiodło się")
        })
}