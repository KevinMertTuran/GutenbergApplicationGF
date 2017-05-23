$(document).ready(function () {

    fetchAllBooks();
    fetchAllAuthors();
    fetchAllLocations();
});




function fetchAllBooks() {
    $.ajax({
        url: "../GutenbergApplicationGF/api/book/",
        type: "GET",
        dataType: 'json',
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus);
        }
    }).done(function (books) {
        var options = "";
        books.forEach(function (book) {
            options += "<option id=" + book.UID + ">" + book.title + ", " + book.text + "</option>";
        });
        $("#books").html(options);
        clearDetails();
    });
}

function fetchAllAuthors() {
    $.ajax({
        url: "../GutenbergApplicationGF/api/author/",
        type: "GET",
        dataType: 'json',
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus);
        }
    }).done(function (authors) {
        var options = "";
        authors.forEach(function (author) {
            options += "<option id=" + author.UID + ">" + author.name + "</option>";
        });
        $("#authors").html(options);
        clearDetails();
    });
}

function fetchAllLocations() {
    $.ajax({
        url: "../GutenbergApplicationGF/api/location/",
        type: "GET",
        dataType: 'json',
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus);
        }
    }).done(function (locations) {
        var options = "";
        locations.forEach(function (location) {
            options += "<option id=" + location.UID + ">" + location.latitude + ", " + location.longitude + ", " + location.name + "</option>";
        });
        $("#locations").html(options);
        clearDetails();
    });
}