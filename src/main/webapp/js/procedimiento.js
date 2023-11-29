$(document).ready(function () {
    let table;
    $("#fechaInicio").val(moment().format('YYYY-MM-DD'));
    $("#fechaFin").val(moment().format('YYYY-MM-DD'));
    //let tokeValue = getCookie("token");
    ///console.log(tokeValue);
    let iniDate = moment().format('YYYY-MM-DD');
    let maxDate = moment().add(31, 'days').format('YYYY-MM-DD');
    $("#fechaFin").attr('min', iniDate);
    $("#fechaFin").attr('max', maxDate);
    
    $.getJSON("validarsesion", function (data) {
        if (data.resultado === "ok") {
            $('#topbar').load('topbar.html');
            $('#sidebar').load('sidebar.html');
            $('#footer').load('footer.html');
            table = $('#example').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'excel', 'print'
                ],
                fixedHeader: true,
                paging: false,
                language: {
                    decimal: "",
                    emptyTable: "No hay datos",
                    info: "Mostrando desde el _START_ al _END_ del total de _TOTAL_ registros",
                    infoEmpty: "Mostrando desde el 0 al 0 del total de  0 registros",
                    infoFiltered: "(Filtrados del total de _MAX_ registros)",
                    infoPostFix: "",
                    thousands: ",",
                    lengthMenu: "Mostrar _MENU_ registros por página",
                    loadingRecords: "Cargando...",
                    processing: "Procesando...",
                    search: "Buscar:",
                    zeroRecords: "No se ha encontrado nada  atraves de ese filtrado.",
                    paginate: {
                        first: "Primero",
                        last: "Última",
                        next: "Siguiente",
                        previous: "Anterior"
                    },
                    aria: {
                        sortAscending: ": activate to sort column ascending",
                        sortDescending: ": activate to sort column descending"
                    }
                },
                ajax: {
                    url: 'listaprocedimientosresultados',
                    type: 'POST',
                    data: function (d) {
                       /* d.token=tokeValue,
                        d.logi=getCookie("logi"),                                */
                        d.fechaInicio = $("#fechaInicio").val(), //$("#fechaInicio").val(),
                                d.fechaFin = $("#fechaFin").val();
                    },
                    beforeSend: function () {
                        $("#btnBuscar").css("display", "none");
                        $("#loading").css("display", "block");
                    }, complete: function () {
                        $("#btnBuscar").css("display", "block");
                        $("#loading").css("display", "none");
                    }
                },
                columns: [
                    {data: 'secuencia'},
                    {data: 'numitm'},
                    {data: 'prfnum'},
                    {data: 'fechaFiltro',
                        render: function (data, type, row, meta) {
                            if (data === undefined)
                                return "";
                            else
                                return moment(data).format("DD/MM/yyyy");
                        }
                    },
                    {data: 'fechaOrden',
                        render: function (data, type, row, meta) {
                            if (data === undefined)
                                return "";
                            else
                                return moment(data).format("DD/MM/yyyy");
                        }
                    },
                    {data: 'pachis'},
                    {data: 'paciente'},
                    {data: 'tipoPlan'},
                    {data: 'tardes'},
                    {data: 'feccreApr',
                        render: function (data, type, row, meta) {
                            if (data === undefined)
                                return "";
                            else
                                return moment(data).format("DD/MM/yyyy");
                        }
                    },
                    {data: 'usecodApr', render: function (data, type, row, meta) {
                            if (data === undefined) {
                                let objselec = {invnum: row.secuencia, numitm: row.numitm, tarcod: row.tarcod, resexahml: row.resexahml, medcod: row.medcod, pachis: row.pachis, tarhtml: row.tarhtml};
                                let myJSON = JSON.stringify(objselec);
                                return "<button class='btn btn-primary btn-user' data-toggle='tooltip' title='Registrar / Modificar ' onclick='editar(" + myJSON + ")'><i class='fas fa-edit'></i></button><button class='btn btn-primary btn-user' data-toggle='tooltip' title='Aprobar Resultado' onclick='aprobar(" + myJSON + ")'><i class='fas fa-check'></i></button>";
                            } else {
                                let objselecPdf = {invnum: row.secuencia, numitm: row.numitm, medcod: row.medcod, pachis: row.pachis, namfile: row.namfile};
                                let myJSONPdf = JSON.stringify(objselecPdf);
                                return "<button  class='btn btn-primary btn-user' data-toggle='tooltip' title='Descargar Resultado' onclick='descargar(" + myJSONPdf + ")'><i class='fas fa-file-pdf'></i></button>";
                            }
                        }
                    }
                ]
            });
            let parametro = {accion: 1};
            $('.contenido').richText({
                table: false,
                fileUpload: false,
                imageUpload: false,
                urls: false,
                videoEmbed: false,
                fontColor: false,
                backgroundColor: false,
                fontSize: false,
                heading: false,
                code: false,
                leftAlign: false,
                centerAlign: false,
                rightAlign: false,
                justify: false
            });
        } else {
            $(location).attr('href', "index.html");
        }
    });
    $('#fechaInicio').change(function () {
        let fechaFin = $("#fechaInicio").val();
        $("#fechaFin").val(fechaFin);
        let iniDate = moment(fechaFin, 'YYYY-MM-DD');
        let maxDate = moment(iniDate).add(31, 'days').format('YYYY-MM-DD');
        $("#fechaFin").attr('min', iniDate);
        $("#fechaFin").attr('max', maxDate);
    });
    $("#btnBuscar").click(function () {
        table.ajax.reload( );
    });
    $("#salir").click(function () {
        $.getJSON("cerrarsesion", function (data) {});
        $(location).attr('href', "index.html");
    });
    $("#btnGrabarAprobacion").click(function () {
        let invnum = $("#secunciaAprob").val();
        let numitm = $("#itemAprob").val();
        let medcod = $("#medcod").val();
        let pachis = $("#pachis").val();
        let resexahml = $("#resexahml").val();
        let htmlToRtfLocal = new window.htmlToRtf();
        let rtfContent = htmlToRtfLocal.convertHtmlToRtf(resexahml);

        let parametro = {invnum: invnum, numitm: numitm, medcod: medcod, pachis: pachis, rtfContent: rtfContent};
        $.getJSON("grabaraprobprocedimiento", parametro, function (data) {
            if (data.resultado === "ok") {
                table.ajax.reload( );
                $("#aprobarModal").modal("hide");
            } else {
                $("#alertAprobar").css("display", "block");
                setTimeout(function () {
                    $("#alertAprobar").fadeOut(2000);
                }, 2000);
            }
        });
    });

    $("#btnGrabarRTF").click(function () {
        let htmlContent = $('.contenido').val();
        let invnum = $("#txtInvnum").val();
        let numitm = $("#txtNumitm").val();
        let tarcod = $("#txtTarcod").val();

        let parametro = {invnum: invnum, numitm: numitm, tarcod: tarcod, htmlContent: encodeURIComponent(htmlContent)};
        $.getJSON("grabarresultadoprocedimiento", parametro, function (data) {
            if (data.resultado === "ok") {
                table.ajax.reload( );
                $("#RichText").modal("hide");
            } else {
                $("#alertError").css("display", "block");
                setTimeout(function () {
                    $("#alertError").fadeOut(2000);
                }, 2000);
            }
        });
    });
});
function aprobar(id) {
    $("#secunciaAprob").val(id.invnum);
    $("#itemAprob").val(id.numitm);
    $("#medcod").val(id.medcod);
    $("#pachis").val(id.pachis);
    $("#resexahml").val(id.resexahml);
    $("#aprobarModal").modal("show");
}
function editar(id) {
    console.log("resexahml:" + id.resexahml);
    console.log("tarhtml:" + id.tarhtml);
    $("#txtInvnum").val(id.invnum);
    $("#txtNumitm").val(id.numitm);
    $("#txtTarcod").val(id.tarcod);
    $("#txtTarhtml").val(id.tarhtml);

    if (id.resexahml === undefined) {
        $('.richText-editor').trigger('setContent', id.tarhtml);
    } else if (id.resexahml.trim() === '') {
        $('.richText-editor').trigger('setContent', id.tarhtml);
    } else if (id.resexahml.trim() === '<br>') {
        $('.richText-editor').trigger('setContent', id.tarhtml);
    } else if (id.resexahml.trim() === '<div><br></div>') {
        $('.richText-editor').trigger('setContent', id.tarhtml);
    } else {
        $('.richText-editor').html(decodeURIComponent(id.resexahml));
    }
    $("#RichText").modal("show");

}
function descargar(id) {
    let parametro = {medcod: id.medcod};
    $.getJSON("validarf", parametro, function (data) {
        if (data.resultado === "ok") {
            window.open("reporteresultadoprocePDF?invnum=" + id.invnum + "&numitm=" + id.numitm + "&medcod=" + id.medcod, "_blank");
        } else {
            alert("Debe ingresar una firma. Vaya a CONFIGURACIÓN - Parametros del Sistema");
        }
    });
}
function format(d) {
    let resultado = '';
    let data = $.parseJSON(d.detalle);
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
function getCookie(nombreCookie) {
    // Divide todas las cookies en un array
    var cookies = document.cookie.split(';');

    // Itera sobre cada cookie
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].trim(); // Elimina espacios en blanco al principio y al final

        // Verifica si la cookie comienza con el nombre deseado
        if (cookie.indexOf(nombreCookie + '=') === 0) {
            // Devuelve el valor de la cookie
            return cookie.substring(nombreCookie.length + 1, cookie.length);
        }
    }

    // Si la cookie no se encuentra, devuelve null
    return null;
}
/*function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2)
        return parts.pop().split(';').shift();
}*/

