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