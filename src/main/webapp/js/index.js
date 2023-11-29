$(document).ready(function () {
    $("#btnIngresar").click(function () {
        $("#btnIngresar").css("display", "none");
        $("#loading").css("display", "block");
        let logi = $("#txtUsuario").val();
        let pass = $("#txtClave").val();        
        let parametro = {logi: logi, pass: pass};
        $.getJSON("validar", parametro, function (data) {
            if (data.resultado === "ok") {                
                parametro = {logi: data.user, nombre: data.name, nivel: data.nivel, codi: data.codi, medcod: data.medcod};
                $.getJSON("iniciarsesion", parametro, function (data) {
                });
                document.cookie = "token=" + data.token;
                document.cookie = "logi=" + data.logi;
                $(location).attr('href', "principal.html");
            } else {
                $("#btnIngresar").css("display", "block");
                $("#loading").css("display", "none");
                $("#alerta").css("display", "block");
                setTimeout(function () {
                    $("#alerta").fadeOut(2000);
                }, 2000);
            }
        });
    });
    $('#txtClave').keypress(function (e) {
        if (e.which === 13) {
            $("#btnIngresar").trigger("click");
        }
    });
});
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2)
        return parts.pop().split(';').shift();
}