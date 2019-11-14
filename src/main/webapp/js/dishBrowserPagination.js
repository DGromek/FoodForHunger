function dishBrowserPagination(pageIdx) {
    const $browserResults = $('#browser-results');
    const $browserPagination = $('#browser-pagination');
    const $browserCard = $('#browser-card-template')

    $.getJSON(window.location.origin + '/rest/getBrowserResults/' + pageIdx)
        .done(function (browserPage) {
            //Generating pagination
            $browserPagination.empty();
            if (browserPage.number !== 0) {
                $browserPagination.append(
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + 0 + ')" class="page-link">&laquo;</a></li>' +
                    '<li class="page-item"><a onclick="dishBrowserPagination(' +  (browserPage.number - 1) + ')" class="page-link">' + browserPage.number + '</a></li>'
                );
            }
            $browserPagination.append('<li class="page-item active"><a class="page-link">' + (browserPage.number + 1) + '</a></li>');

            if (browserPage.number < browserPage.totalPages - 1) {
                $browserPagination.append(
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + (browserPage.number + 1) + ')" class="page-link">' + (browserPage.number + 2) +'</a></li>' +
                    '<li class="page-item"><a onclick="dishBrowserPagination(' + (browserPage.totalPages - 1) + ')" class="page-link">&raquo;</a></li>');
            }
            //Generating divs with content
            $browserResults.empty();
            let dishes = browserPage.content;

            for (let i = 0; i < 9; i++) {
                if (i < dishes.length) {
                    let $browserCardCopy = $($browserCard).clone();
                    $browserCardCopy.find('img').attr('src', '/dish/getImage/' + dishes[i].id);
                    $browserCardCopy.find('h4').text(dishes[i].name);
                    $browserCardCopy.find('h6 a').text(dishes[i].user.username);
                    $browserCardCopy.find('h6 a').attr('href', '/user/profile/' + dishes[i].user.username);
                    $browserCardCopy.find('p').text(dishes[i].description);
                    $browserCardCopy.find('#dish-details').attr('href', '/dish/details/' + dishes[i].id);

                    $browserCardCopy.removeClass('d-none');
                    $browserResults.append($browserCardCopy);

                } else {
                    $browserResults.append('<div class="card p-4 mb-3 hidden-block"></div>');
                    if (i === 5) {
                        break;
                    }
                }

                if ((i + 1) % 2 === 0) {
                $browserResults.append(
                        '<div class="w-100 d-none d-sm-block d-md-block d-lg-none"><!-- wrap every 2 on sm and md--></div>');
                }

                if ((i + 1) % 3 === 0) {
                    $browserResults.append(
                        '<div class="w-100 d-none d-lg-block d-xl-block"><!-- wrap every 3 on lg and xl--></div>');
                }
            }
        })
}