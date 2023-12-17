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
                     $("#btn_registrar").text("Guardar");
                     $("#p_titulo").text("Evaluación: " + usuario.nombres + " " +usuario.apellidos );
                  });

               } else {
                  console.log("Error recuperando los datos de usuario");
               }
            }
         });
      }
});

$(document).on("click", "#btn_registrar", function(){
    let FK_Usuario = $("#txt_id").val();
    
    var pregunta_1 = $("input[name='RP1']:checked").map(function () {
      return this.value;
    }).get();
    var pregunta_2 = $("input[name='RP2']:checked").map(function () {
      return this.value;
    }).get();
    var pregunta_3 = $("input[name='RP3']:checked").map(function () {
      return this.value;
    }).get();
    var pregunta_4 = $("input[name='RP4']:checked").map(function () {
      return this.value;
    }).get();
    var pregunta_5 = $("input[name='RP5']:checked").map(function () {
      return this.value;
    }).get();
    
    if (pregunta_1['length'] === 0 || pregunta_2['length'] === 0 || pregunta_3['length'] === 0 || pregunta_4['length'] === 0 || pregunta_5['length'] === 0){
      alert("Por favor responda todas las preguntas");
    }else{
      var pregunta_1 = parseInt(pregunta_1[0]);
      var pregunta_2 = parseInt(pregunta_2[0]);
      var pregunta_3 = parseInt(pregunta_3[0]);
      var pregunta_4 = parseInt(pregunta_4[0]);
      var pregunta_5 = parseInt(pregunta_5[0]);

     $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletEncuestaRegistro",
            data: $.param({
                FK_Usuario: FK_Usuario,
                pregunta_1: pregunta_1,
                pregunta_2: pregunta_2,
                pregunta_3: pregunta_3,
                pregunta_4: pregunta_4,
                pregunta_5: pregunta_5
            }),
            success: function(result){
                let parseResult = JSON.parse(result);
                if (parseResult != false){
                  alert('Su cambio ha sido exitoso!');
                  document.location.href = "evaluar_funcionario.html";
                }else{
                  alert("No se realizo la accion, intente mas tarde!");
                }
            }
        });
    }
    
    
});