$(document).ready(function () {
    let table, rutafirmas, directoriopdf;
    $("#fechaInicio").val(moment().format('YYYY-MM-DD'));
    $("#fechaFin").val(moment().format('YYYY-MM-DD'));
    $.getJSON("validarsesion", function (data) {
        if (data.resultado === "ok") {
            $('#topbar').load('topbar.html');
            $('#sidebar').load('sidebar.html');
            $('#footer').load('footer.html');

            //console.log('antes de llamar al config');
            $.getJSON("config", function (data) {    
                console.log('Despues ede llamar al config');
                 $("#txtRutaPM").val(data.rutapdfPM);
                 $("#txtRutaLA").val(data.rutapdfLA);
                 $("#txtRutaEA").val(data.rutapdfEA);

                rutafirmas = data.directoriofirmas;
                 console.log(rutafirmas);
                 //valida si existe imagen
                 $.getJSON("validari", function (data) {                     
                    //var rutaImagen = "firmas/" + data.ferma;
                    var rutaImagen = rutafirmas + data.ferma;
                    if (data.resultado === "ok") {
                    $("#previewImage").attr("src", rutaImagen);
                    //$("#previewImage").attr("alt", "Falta Firma");
                    } else {
                    $("#previewImage").attr("alt", "NO EXISTE FIRMA");
                    }
                 });
            });


        } else {
            $(location).attr('href', "index.html");
        }
    });

    $("#ajaxfile").on("change", function () {
        var fileInput = this; // Referencia al input de archivo
        var previewImage = $("#previewImage")[0]; // Referencia a la imagen

        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                previewImage.src = e.target.result;
                previewImage.alt = ""; // Limpiar el atributo alt si se selecciona un archivo
            };
            reader.readAsDataURL(fileInput.files[0]);
        } else {
            previewImage.src = ""; // Si no se selecciona ningún archivo, vaciar la imagen
            previewImage.alt = "NO SE SELECCIONÓ UNA IMAGEN"; // Establecer el atributo alt
        }
    });


    $("#btnBuscar").click(function () {
        table.ajax.reload( );
    });

    $("#salir").click(function () {
        $.getJSON("cerrarsesion", function (data) {});
        $(location).attr('href', "index.html");
    });

    $("#btnGrabarCambios").click(function () {
        //alert("Grabar cambios");
        var ruta = $("#ajaxfile").val().replace(/C:\\fakepath\\/i, '');

        uploadFile();

    });

});
function editar(id) {
    console.log(id.resexahml);
    $("#txtInvnum").val(id.invnum);
    $("#txtNumitm").val(id.numitm);
    $("#txtTarcod").val(id.tarcod);

    if (id.resexahml !== undefined) {
        $('.richText-editor').trigger('setContent', id.resexahml);
        console.log("con contenido");
    } else {
        $('.richText-editor').trigger('setContent', '');
        console.log("sin contenido");
    }
    $("#RichText").modal("show");

}
function format(d) {
    let resultado = '';
    let data = $.parseJSON(d.detalle);
    /* if(data.invnum===284)
     console.log(data);*/
    //console.log(data);
    resultado += "<tr><th>Orden</th><th>Origen</th><th>Secuencia</th><th>Descripcion</th><th>Fecha Cita/Muestra</th><th>Atendido</th></tr>";
    $.each(data.datos, function (i, item) {


        if (item.atendido === 1)
            atendido = "SI";
        else
            atendido = "NO";

        let fecha;
        if (item.fechaCitaOToma === "1900-01-01T00:00:00")
            fecha = "";
        else
            fecha = moment(item.fechaCitaOToma).format("DD/MM/yyyy hh:mm:ss A");

        resultado += "<tr><td>" + item.orden + "</td><td>" + item.oricod + "</td><td>" + item.invnum_o + "</td><td>" + item.tardes + "</td><td>" + fecha + "</td><td>" + atendido + "</td></tr>";
    });
    resultado = "<table class='table table-striped table-bordered'>" + resultado + "</table>";
    return (resultado);
}

async function uploadFile() {
    let formData = new FormData();
    formData.append("file", ajaxfile.files[0]);
    const response = await fetch('fileupload', {
        method: "POST",
        body: formData
    });
    if (!response.ok) {
        var x = document.getElementById("alertError");
        x.style.display = "block";
        setTimeout(function () {
            $("#alertError").fadeOut(2000);
        }, 2000);


    } else {
        var x = document.getElementById("alertOk");
        x.style.display = "block";
        setTimeout(function () {
            $("#alertOk").fadeOut(2000);
        }, 2000);
    }
}
/*function mostrarDetalle(invnum) {
 $(document).ready(function () {
 $("#invnumseleccionado").val(invnum);
 table1.ajax.reload( );
 $("#detalleModal").modal("show");
 });
 
 }*/