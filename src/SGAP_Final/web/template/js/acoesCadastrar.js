$(document).ready(function () {
    window.mapa = null;
    window.voce = null;

    setTimeout(function(){
        console.log('pegando PrimeFaces map');
        window.mapa = PF('geoMap').getMap();
        console.log(window.mapa);

        window.voce = new google.maps.Marker({
            position: window.mapa.getCenter(),
            draggable: true,
            animation: google.maps.Animation.DROP,
            map: window.mapa,
            title: "Arraste para marcar o local"
        });

        google.maps.event.addListener(window.voce, 'dragend', function (e) {
            console.log('Arrastou marker');
            window.mapa.setCenter(e.latLng);
            $(".hidLat").val(e.latLng.lat());
            $(".hidLon").val(e.latLng.lng());
        });
    },1000);

    $('.hidLat, .hidLon').hide();

    //mapa();

    $('.txtLocal').keyup(function (e) {
        // se dado enter
        if (e.keyCode == 13) {
            var _txt = $(this).val();
            buscarEndereco(_txt);
        }
        e.preventDefault();
        return false;
    });

    $('.txtLocal').blur(function (e) {
        var _txt = $(this).val();

        if (_txt.length > 2)
            buscarEndereco(_txt);

        e.preventDefault();
        return false;
    });
});

/*function mapa() {
    var mapOptions = {
        zoom: 3,
        scrollwheel: false,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    mapOptions.center = new google.maps.LatLng(-14.2392976, -53.1805017);
    $.map = new google.maps.Map(document.getElementById("mapa"), mapOptions);
    $(".hidLat").val(mapOptions.center.lat());
    $(".hidLon").val(mapOptions.center.lng());

    $.voce = new google.maps.Marker({
        position: $.map.getCenter(),
        draggable: true,
        animation: google.maps.Animation.DROP,
        map: $.map,
        title: "Arraste para marcar o local"
    });

    google.maps.event.addListener($.voce, 'dragend', function (e) {
        $.map.setCenter(e.latLng);
        $(".hidLat").val(e.latLng.lat());
        $(".hidLon").val(e.latLng.lng());
    });
}*/

function buscarEndereco(_txt) {
    var geocoder = new google.maps.Geocoder();

    geocoder.geocode({'address': _txt}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            window.mapa.panTo(results[0].geometry.location);
            window.voce.setPosition(results[0].geometry.location);
            $(".hidLat").val(results[0].geometry.location.lat());
            $(".hidLon").val(results[0].geometry.location.lng());
            window.mapa.setZoom(13);
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}
/*function buscarEndereco(_txt) {
    console.log('buscar endereco');
    PF('geoMap').geocode(_txt);
}*/