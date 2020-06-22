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
            for (var i in data.subCategories) {
                if (i == 0){
                    $("#header_category_list").append(
                        "<li class='nav-item nav_category'><span class='all_category'  onclick='openAllCategories()'>еще...</span>\n" +
                        "     <ul class='navbar-nav' id='moreCategories'></ul>" +
                        "</li>"
                    );
                }
                if (i < 5){
                    $("#header_category_list").prepend(
                        "<li class='nav-item '>\n" +
                        "     <a class='nav-link text-primary' href='#'>" + data.subCategories[i].name + "</a>\n" +
                        "</li>"
                    );
                }
                $("#moreCategories").append(
                    '<div>\n' +
                    '       <div class="top-rubricator-blockTitle">\n' +
                    '           <a href="">'+ data.subCategories[i].name +'</a>\n' +
                    '       </div>\n' +
                    '       <ul class="sub_categories navbar-nav"></ul>\n' +
                    '   </div>'
                );
                $("#findFromCategory").append(
                    '<option class="bgOption">' + data.subCategories[i].name + '</option>'
                );
                for (var r in data.subCategories[i].subCategories) {
                    var fsd = data.subCategories[i].subCategories[r].name;
                    $(".sub_categories:eq("+ i +")").append(
                        '<li class="nav-item"><a href="">'+ fsd +'</a></li>'
                    );
                    $("#findFromCategory").append(
                        '<option>' + fsd + '</option>'
                    );
                }
            }
        }
    });

});
function openAllCategories() {
    $("#moreCategories").toggleClass("on-off");
    $(".bg_black_header").toggleClass("on-off");
}
$(".bg_black_header").click(function () {
    $("#moreCategories").removeClass("on-off");
    $(".bg_black_header").removeClass("on-off");
    $(".search").removeClass("on_search");
});
$(".open_search").click(function () {
    $(".search").toggleClass("on_search");
    $(".bg_black_header").toggleClass("on-off");
});
$("#menuToggle").click(function () {
    $("header").toggleClass("open_header");
    $("#menuToggle").toggleClass("open_header");
});
