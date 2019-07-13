$(document).ready(function () {

    $("#buttonGoBack").on("click", function () {
        window.history.back()
    });

    var mymap = L.map('mapid').setView([53.931837, 21.706238], 9);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        maxZoom: 18,
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
            '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        id: 'mapbox.streets'
    }).addTo(mymap);

    var myIcon = L.icon({
        iconUrl: 'https://image.flaticon.com/icons/svg/8/8176.svg',
        iconSize: [38, 95],
        iconAnchor: [22, 94],
        popupAnchor: [-3, -76],
        shadowSize: [68, 95],
        shadowAnchor: [22, 94]

    });

    $(".reservationHref").on('click', function () {
        var newUrl =  $(this).attr("href") +  $("#reservedDate").val();
        $(this).attr("href", newUrl)
    });


    function customClearLayers() {
        mymap.eachLayer(function (marker) {
            if (marker instanceof L.Marker || marker instanceof L.CircleMarker) {
                mymap.removeLayer(marker);
            }
        });
    }

    $("tr.map").each(function () {
        var marker = L.marker([$(this).find("#markerPositionLat").html(), $(this).find("#markerPositionLng").html()], {icon: myIcon})
            .addTo(mymap)
            .bindPopup($(this).find("#portName").html());
    });

    function filter() {
        customClearLayers();
        $("tr.map").each(function () {
            if ($('#selectLake option:selected').html() === "Show All") {
                $(this).find("#lakeName").parent().show()
                var marker = L.marker([$(this).find("#markerPositionLat").html(), $(this).find("#markerPositionLng").html()], {icon: myIcon})
                    .addTo(mymap)
                    .bindPopup($(this).find("#portName").html());
                return;
            }
            if ($(this).find("#lakeName").html().toUpperCase() !== $('#selectLake option:selected').html()) {
                $(this).find("#lakeName").parent().hide();
            } else {
                $(this).find("#lakeName").parent().show();
                var marker = L.marker([$(this).find("#markerPositionLat").html(), $(this).find("#markerPositionLng").html()], {icon: myIcon})
                    .addTo(mymap)
                    .bindPopup($(this).find("#portName").html());
            }
        });
    }

    $('#selectLake').on('change', function () {
        filter();
    });

});
