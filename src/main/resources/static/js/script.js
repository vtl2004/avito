$(window).scroll(function () {
    if ($(this).scrollTop() > 1) {
        $("header").addClass("active");
    } else {
        $("header").removeClass("active");
    }
});


$(document).ready(function () {
    $.ajax({
        url: '/avitoNavigation',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            $("#avitoNavigation").empty();
            for (var i in data) {
                $("#avitoNavigation").append(
                    ' <li class="nav-item">\n' +
                    '     <a class="nav-link" href="/">' + data[i] + '</a>\n' +
                    ' </li>'
                );
            }
        }
    });
    $.ajax({
        url: '/getListCategory',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            $("#header_category_list").empty();
            var inx = 0;
            for (var i in data) {
                var r = data[i];
                if (inx < 5){
                    $("#header_category_list").append(
                        "<li class='nav-item '>\n" +
                        "     <a class='nav-link text-primary' href='#'>" + i + "</a>\n" +
                        "</li>"
                    );
                }
                inx++;
            }
            $("#header_category_list").append(
                "<li class='nav-item nav_category'><span class='all_category'  onclick='openAllCategories()'>еще...</span>\n" +
                "     <ul class='navbar-nav' id='moreCategories'></ul>" +
                "</li>"
            );
            for (var i in data) {
                $("#moreCategories").append(
                    '<div>\n' +
                    '       <div class="top-rubricator-blockTitle">\n' +
                    '           <a href="">'+ i +'</a>\n' +
                    '       </div>\n' +
                    '       <ul class="sub_categories navbar-nav"></ul>\n' +
                    '   </div>'
                );
            }
            for (var i in data) {
                var q = data[i];
                for (var r in data[i]) {
                    $(".sub_categories:eq("+ r +")").append(
                        '<li class="nav-item"><a href="">'+ data[i][r] +'</a></li>'
                    );
                }
            }
            for (var i in data) {
                var q = data[i];
                $("#findFromCategory").append(
                    '<option class="bgOption">' + i + '</option>'
                );
                for (var r in q) {
                    $("#findFromCategory").append(
                        '<option>' + q[r] + '</option>'
                    );
                }
            }
        }
    });

});
function openAllCategories() {
    $("#moreCategories").toggleClass("on-off");
}
