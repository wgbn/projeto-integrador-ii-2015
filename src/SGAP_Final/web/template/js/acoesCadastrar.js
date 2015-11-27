$(document).ready(function(){
    $.map;
    $.voce;

    $('.hidLat, .hidLon').hide();

    mapa();

    $('.txtLocal').keyup(function(e){
        // se dado enter
        if (e.keyCode == 13){
            var _txt = $(this).val();
            buscarEndereco(_txt);
        }
        e.preventDefault();
        return false;
    });

    $('.txtLocal').blur(function(e){
        var _txt = $(this).val();

        if (_txt.length > 2)
            buscarEndereco(_txt);

        e.preventDefault();
        return false;
    });
});

function mapa(){
    var mapOptions = {
        //center: new google.maps.LatLng(-34.397, 150.644),
        zoom: 3,
        scrollwheel: false,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    mapOptions.center = new google.maps.LatLng(-14.2392976,-53.1805017);
    $.map = new google.maps.Map(document.getElementById("mapa"), mapOptions);
    $(".hidLat").val(mapOptions.center.lat());
    $(".hidLon").val(mapOptions.center.lng());

    $.voce = new google.maps.Marker({
        position: $.map.getCenter(), //new google.maps.LatLng(p.coords.latitude, p.coords.longitude),
        draggable: true,
        animation: google.maps.Animation.DROP,
        map: $.map,
        title: "Arraste para marcar o local"
    });

    google.maps.event.addListener($.voce, 'dragend', function(e){
        $.map.setCenter(e.latLng);
        $(".hidLat").val(e.latLng.lat());
        $(".hidLon").val(e.latLng.lng());
    });
}

function buscarEndereco(_txt){
    var geocoder = new google.maps.Geocoder();

    geocoder.geocode({'address': _txt}, function(results, status){
        if (status == google.maps.GeocoderStatus.OK) {
            $.map.panTo(results[0].geometry.location);
            $.voce.setPosition(results[0].geometry.location);
            $(".hidLat").val(results[0].geometry.location.lat());
            $(".hidLon").val(results[0].geometry.location.lng());
            $.map.setZoom(13);
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}