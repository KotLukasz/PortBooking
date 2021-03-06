$(document).ready(function () {


    $("#buttonGoBack").on("click", function () {
        window.history.back()
    });

    $("#priceNoCommas").focusout(function(){
        $(this).val($(this).val().toString().replace(',', '.'));
    });


    var mymap = L.map('mapid').setView([53.931837, 21.706238], 9);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        maxZoom: 18,
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
            '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        id: 'mapbox.streets'
    }).addTo(mymap);


    var popup = L.popup();
    function onMapClick(e) {
        popup
            .setLatLng(e.latlng)
            .setContent("This is your Port localisation")
            .openOn(mymap);

        var markerPositionLat = $("#markerPositionLat");
        markerPositionLat.attr("value",e.latlng.lat);
        var markerPositionLng = $("#markerPositionLng");
        markerPositionLng.attr("value", e.latlng.lng);
    }
    mymap.on('click', onMapClick)

});
