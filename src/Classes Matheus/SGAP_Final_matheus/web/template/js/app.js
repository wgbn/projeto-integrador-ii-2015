$(document).ready(function(){

    // remove css do primefaces
    /*$.each($('head').find('link'), function(_key,_val){
        if ($(this).attr('href').search(new RegExp("primefaces.css.xhtml","g")) > -1)
            $(this).remove();
        if ($(this).attr('href').search(new RegExp("layout.css.xhtml","g")) > -1)
            $(this).remove();
    });
    // remove js do primefaces
    $.each($('head').find('script'), function(_key,_val){
        if ($(this).attr('src')) {
            if ($(this).attr('src').search(new RegExp("primefaces.js.xhtml", "g")) > -1)
                $(this).remove();
            if ($(this).attr('src').search(new RegExp("layout.js.xhtml", "g")) > -1)
                $(this).remove();
            if ($(this).attr('src').search(new RegExp("jquery.js.xhtml","g")) > -1)
                $(this).remove();
            if ($(this).attr('src').search(new RegExp("jquery-plugins.js.xhtml","g")) > -1)
                $(this).remove();
        }
    });

    // remove todas as classes do primefaces
    $.each($('.app').find('*'), function(){
        if ($(this).attr('class')){
            var arr = $(this).attr('class').split(' ');
            var cls = '';
            arr.forEach(function(_val){
                if (_val.substr(0,2) != 'ui')
                    cls += _val+' ';
            });
            cls = cls.trim();

            if (cls.length > 0)
                $(this).attr('class', cls);
            else
                $(this).removeAttr('class');
        }
    });*/

    // posições absolutas
    $('.esquerda').height($(window).height());
    $('.topo').width($(window).width() - $('.esquerda').width());

    // acoes menu esquerda
    $('.esquerda .menu .opcoes ul li a.sup').click(function(e){
        e.preventDefault();
        var _id = $(this).attr('id');
        $('#sub'+_id).slideToggle(150);
        if ($('#'+_id+' img')[0].classList.length > 1)
            $('#'+_id+' img').removeClass('seta-baixo');
        else
            $('#'+_id+' img').addClass('seta-baixo');
    });

    $(".btnDelCliente").click(function(e){
        e.preventDefault();
        UIkit.modal.confirm("Tem certeza que deseja excluir este cliente?", function(){
            $('.btnDelClienteOculto').click();
        });
    });

    $(".btnDelUsuario").click(function(e){
        e.preventDefault();
        UIkit.modal.confirm("Tem certeza que deseja excluir este usuário?", function(){
            $('.btnDelUsuarioOculto').click();
        });
    });
});