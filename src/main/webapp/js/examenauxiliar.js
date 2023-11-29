$(document).ready(function () {
    let table;
    $("#fechaInicio").val(moment().format('YYYY-MM-DD'));
    $("#fechaFin").val(moment().format('YYYY-MM-DD'));
    let tokeValue = getCookie("token");
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
                ajax: {
                    url: 'listaexamenauxiliarresultados',
                    type: 'POST',
                    data: function (d) {
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
                    {data: 'historia'},
                    {data: 'paciente'},
                    {data: 'tipoPlan'},
                    {data: 'examen'},
                    {data: 'feccreApr',
                        render: function (data, type, row, meta) {
                            if (data === undefined)
                                return "";
                            else
                                return moment(data).format("DD/MM/yyyy");
                        }
                    },

                    {data: 'usecodApr',
                        render: function (data, type, row, meta) {                                                                                    
                            if (data === undefined) {
                                let objselec = {invnum: row.secuencia, numitm: row.numitm, exacod: row.exacod, resexahtml: row.resexahtml, medcod: row.medcod, historia: row.historia, exahtml: row.exahtml};
                                let myJSON = JSON.stringify(objselec);                                                                    
                                return "<button class='btn btn-primary btn-user' data-toggle='tooltip' title='Registrar / Modificar ' onclick='editar(" + myJSON + ")'><i class='fas fa-edit'></i></button><button class='btn btn-primary btn-user' data-toggle='tooltip' title='Aprobar Resultado' onclick='aprobar(" + myJSON + ")'><i class='fas fa-check'></i></button>";
                            } else {
                                let objselecPdf = {invnum: row.secuencia, numitm: row.numitm, medcod: row.medcod, historia: row.historia, namfile: row.namfile};
                                let myJSONPdf = JSON.stringify(objselecPdf);
                                return "<button  class='btn btn-primary btn-user' data-toggle='tooltip' title='Descargar Resultado' onclick='descargar(" + myJSONPdf + ")'><i class='fas fa-file-pdf'></i></button>";
                            }

                            /*if (data === undefined) {
                             let objselec = null;
                             if (row.resexahml === undefined) {
                             objselec = {invnum: row.secuencia, numitm: row.numitm, tarcod: row.tarcod, resexahml: row.resexa};
                             } else {
                             objselec = {invnum: row.secuencia, numitm: row.numitm, tarcod: row.tarcod, resexahml: row.resexahml};
                             }
                             let myJSON = JSON.stringify(objselec);
                             return "<button class='btn btn-primary btn-user' data-toggle='tooltip' title='Registrar / Modificar ' onclick='editar(" + myJSON + ")'><i class='fas fa-edit'></i></button><button class='btn btn-primary btn-user' data-toggle='tooltip' title='Aprobar Resultado' onclick='aprobar(" + myJSON + ")'><i class='fas fa-check'></i></button>";
                             
                             } else {
                             let objselecPdf = {invnum: row.secuencia, numitm: row.numitm, medcod: row.medcod};
                             let myJSONPdf = JSON.stringify(objselecPdf);
                             return "<button  class='btn btn-primary btn-user' data-toggle='tooltip' title='Descargar Resultado' onclick='descargar(" + myJSONPdf + ")'><i class='fas fa-file-pdf'></i></button>";
                             
                             }*/


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
                code: false
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
    $("#btnGrabarAprobacion").click(function () {       
        let invnum = $("#secunciaAprob").val();
        let numitm = $("#itemAprob").val();
        let medcod = $("#medcod").val();
        let pachis = $("#pachis").val();
        let resexahml = $("#resexahml").val();
        let htmlToRtfLocal = new window.htmlToRtf();
        let rtfContent = htmlToRtfLocal.convertHtmlToRtf(resexahml);

        let parametro = {invnum: invnum, numitm: numitm, medcod: medcod, pachis: pachis, rtfContent: rtfContent};
        $.getJSON("grabaraprobea", parametro, function (data) {
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

    $("#btnBuscar").click(function () {
        table.ajax.reload( );
    });

    $("#salir").click(function () {
        $.getJSON("cerrarsesion", function (data) {});
        $(location).attr('href', "index.html");
    });



    $("#btnGrabarRTF").click(function () {        

        let htmlContent = $('.contenido').val();
        let invnum = $("#txtInvnum").val();
        let numitm = $("#txtNumitm").val();
        let exacod = $("#txtTarcod").val();

        
        let parametro = {invnum: invnum, numitm: numitm, exacod: exacod, htmlContent: encodeURIComponent(htmlContent)};
        $.getJSON("grabarresultadoexamenauxiliar", parametro, function (data) {
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
    $("#pachis").val(id.historia);
    $("#resexahml").val(id.resexahml);
    $("#aprobarModal").modal("show");
}
function editar(id) {       
    
    $("#txtInvnum").val(id.invnum);
    $("#txtNumitm").val(id.numitm);
    $("#txtTarcod").val(id.exacod);
    $("#txtTarhtml").val(id.exahtml);

    let resexahtml=decodeURIComponent(id.resexahtml);
    if (resexahtml === undefined) {
        $('.richText-editor').trigger('setContent', id.exahtml);
    } else if (resexahtml.trim() === '') {
        $('.richText-editor').trigger('setContent', id.exahtml);
    } else if (resexahtml.trim() === '<br>') {
        $('.richText-editor').trigger('setContent', id.exahtml);
    } else if (resexahtml.trim() === '<div><br></div>') {
        $('.richText-editor').trigger('setContent', id.exahtml);
    } else {        
        $('.richText-editor').html(resexahtml);
    }
    $("#RichText").modal("show");

}
function descargar(id) {
    window.open("reporteresultadoea?invnum=" + id.invnum + "&numitm=" + id.numitm + "&medcod=" + id.medcod, "_blank");
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
function parseSpecial(rtf) {
    // Encontrar todas las secuencias \'xx
    let matches = rtf.match(/\\'[a-f0-9]{2}/g);
    // Eliminar duplicados en el arreglo
    let special = [... new Set(matches)];
    // Recorrer para remplazar
    special.forEach(hex => {
        // Convertir de hexadecimal a decimal, eliminando primero la marca \'
        let dec = parseInt(hex.replace("\\'", ''), 16);
        // Remplazar secuencia por caracter correspondiente
        rtf = rtf.replaceAll(hex, String.fromCharCode(dec));
    });
    return rtf;
}
function convertToPlain(rtf) {
    // Interpretar contenido original

    rtf = rtf.replace(/\\par[d]?/g, "");
    rtf = rtf.replace(/\{\*?\\[^{}]+}|[{}]|\\\n?[A-Za-z]+\n?(?:-?\d+)?[ ]?/g, "").trim();
    // Buscar secuencias de caracteres especiales y devolver
    return parseSpecial(rtf);
}
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2)
        return parts.pop().split(';').shift();
}

