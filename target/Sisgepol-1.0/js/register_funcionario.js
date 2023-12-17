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

                     $("#txt_id").val(usuario.id_Tabla) ;
                     $("#txt_contrasena").val(usuario.contrasena);
                     $("#txt_repit_contrasena").val(usuario.contrasena);
                     $("#txt_nombres").val(usuario.nombres) ;
                     $("#txt_apellidos").val(usuario.apellidos);
                     $("#txt_correo").val(usuario.correo);
                     $("#txt_rol").val(usuario.rol);
                     $("#txt_placa").val(usuario.placa); 
                     $("#txt_estado").val(usuario.estado);
                     $("#txt_estacion").val(usuario.estacion);
                     $("#txt_grado").val(usuario.grado);
                     $("#btn_registrar").text("Actualizar");
                     $("#p_titulo").text("Actualizar Datos");
                  });

               } else {
                  console.log("Error recuperando los datos de usuario");
               }
            }
         });
      }
});

// Toggle Animation by Class
$(window).scroll(function(){
  if($(document).scrollTop() > 100){
    $('nav').addClass('animate');
  }else{
    $('nav').removeClass('animate');
  }
})

$(document).on("click", "#btn_registrar", function(){
    registrar();
});

function registrar(){
    let id_tabla = $("#txt_id").val();
    
    let contrasena = $("#txt_contrasena").val();
    let repit = $("#txt_repit_contrasena").val();
    let correo = $("#txt_correo").val();
    let nombres = $("#txt_nombres").val();
    let apellidos = $("#txt_apellidos").val();
    let rol = $("#txt_rol").val();
    let placa = $("#txt_placa").val();
    let estado = $("#txt_estado").val();
    let estacion = $("#txt_estacion").val();
    let grado = $("#txt_grado").val();
    
    if (contrasena === repit){
      if (id_tabla === "" || id_tabla === null) {
          //Registro
          if (id_tabla === "" || id_tabla === null) {
            id_tabla = 0;
          }
          var servlet = "ServletUsuarioRegistro";
       }else{
          //editar usuario
          var servlet = "ServletUsuarioActualizar";
       }
       
       $.ajax({
              type: "GET",
              dataType: "html",
              url: "./" + servlet,
              data: $.param({
                  id_tabla: id_tabla,
                  nombres: nombres,
                  apellidos: apellidos,
                  correo: correo,
                  contrasena: contrasena,
                  placa: placa,
                  rol: rol,                
                  estado: estado,
                  estacion: estacion,
                  grado: grado

              }),
              success: function(result){
                  let parseResult = JSON.parse(result);
                  if (parseResult != false){
                    alert('Su cambio ha sido exitoso!');
                  }else{
                    alert("No se realizo la accion, intente con otro correo!");
                  }
              }
          });
    }else{
         alert("Las contraseñas no son iguales!");
    }
}
