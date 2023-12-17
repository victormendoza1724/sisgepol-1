var id = new URL(location.href).searchParams.get("id");

$(document).ready(function () {
   let id_tabla = id;
   if (id != "" && id != null) {
         $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioListar",
            data: $.param({
               filtrar: true,
               filtro: id_tabla
            }),
            success: function (result) {
               let parseResult = JSON.parse(result);
               if (parseResult != false) {
                  
                  $.each(parseResult, function (index, usuario) {
                     usuario = JSON.parse(usuario);
                     $("#txt_id").val(usuario.id_Tabla);
                     $("#p_titulo").text("Evaluación: " + usuario.nombres + " " +usuario.apellidos );
                  });

               } else {
                  console.log("Error recuperando los datos de usuario");
               }
            }
         });
      }
});

$(document).on("click", "#btn_filtrar", function(){
    var FK_Usuario = $("#txt_id").val();
    var fecha_inicio = $('#fecha_inicio').val();
    var fecha_fin = $('#fecha_fin').val();
    
    var Nm_Usuario = $("#p_titulo").text();
    var total_p1 = 0;
    var total_p2 = 0;
    var total_p3 = 0;
    var total_p4 = 0;
    var total_p5 = 0;
    var conteo = 0;
    /*
    var fecha_inicio = new Date($('#fecha_inicio').val());
    fecha_inicio.setDate(fecha_inicio.getDate() - 1);
    fecha_inicio.toISOString();
    fecha_inicio = new Date(fecha_inicio);
    fecha_inicio = fecha_inicio.toISOString().substr(0, 10);
    
    var fecha_fin = new Date($('#fecha_fin').val());
    fecha_fin.setDate(fecha_fin.getDate() + 1);
    fecha_fin.toISOString();
    fecha_fin = new Date(fecha_fin);
    fecha_fin = fecha_fin.toISOString().substr(0, 10);
    */
    $.ajax({
      type: "GET",
      dataType: "html",
      url: "./ServletEncuestaListar",
      data: $.param({
          FK_Usuario: FK_Usuario,
          fecha_inicio: fecha_inicio,
          fecha_fin: fecha_fin
      }),
      success: function (result) {
         let parseResult = JSON.parse(result);
         if (parseResult != false) {

            $.each(parseResult, function (index, encuestas) {
               encuesta = JSON.parse(encuestas);
               conteo = conteo + 1;
               total_p1 = parseInt(total_p1)+parseInt(encuesta.pregunta_1);
               total_p2 = parseInt(total_p2)+parseInt(encuesta.pregunta_2);
               total_p3 = parseInt(total_p3)+parseInt(encuesta.pregunta_3);
               total_p4 = parseInt(total_p4)+parseInt(encuesta.pregunta_4);
               total_p5 = parseInt(total_p5)+parseInt(encuesta.pregunta_5);
            });
            document.location.href = "grafica.html?Nm=" + Nm_Usuario+"&t1="+ total_p1 +"&t2="+ total_p2 +"&t3="+ total_p3 +"&t4="+ total_p4 +"&t5="+ total_p5 +"&fi=" + fecha_inicio+"&ff="+fecha_fin+"&conteo=" + conteo;
         } else {
            console.log("Error recuperando los datos de usuario");
         }
      }
      
  });
});


