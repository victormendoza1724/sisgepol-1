var rol = new URL(location.href).searchParams.get("rol");

function evaluarFuncionario(id){
   var id_tabla = id;
   document.location.href = "evaluacion.html?id=" + id_tabla;
}

function revisarEvaluaciones(id){
   var id_tabla = id;
   document.location.href = "reportes.html?id=" + id_tabla;
}

function seleccionarFuncionario(id){
   var id_tabla = id;
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
               $("#txt_nombres").val(usuario.nombres) ;
               $("#txt_apellidos").val(usuario.apellidos);
               $("#txt_correo").val(usuario.correo);
               $("#txt_rol").val(usuario.rol);
               $("#txt_placa").val(usuario.placa); 
               $("#txt_estado").val(usuario.estado);
               $("#txt_estacion").val(usuario.estacion);
               $("#txt_grado").val(usuario.grado);
               $("#btn_registrar").text("Actualizar");
               $("#p_titulo").text(usuario.nombres + " " + usuario.apellidos);
               $("#btn_evaluar").click(function(){ evaluarFuncionario(usuario.id_Tabla); });
               $("#btn_revisar").click(function(){ revisarEvaluaciones(usuario.id_Tabla); });
            });

         } else {
            console.log("Error recuperando los datos de usuario");
         }
      }
   });

}

// Toggle Animation by Class
$(window).scroll(function(){
  if($(document).scrollTop() > 100){
    $('nav').addClass('animate');
  }else{
    $('nav').removeClass('animate');
  }
});

$(document).ready(function () {
      if (rol == "Usuario"){
         $('#menu').hide();
         $('#btn_revisar').hide();
      }
      
      if (rol == "Funcionario"){
         $('#menu').hide();
      } 
      getUsuarios(false, "");
   });


//obtiene los funcionarios
function getUsuarios(filtrar, filtro) {
   if (filtro === "" || filtro === null) {
      filtro = 0;
   }
   $.ajax({
      type: "GET",
      dataType: "html",
      url: "./ServletUsuarioListar",
      data: $.param({
         filtrar: filtrar,
         filtro: filtro
      }),
      success: function (result) {
         let parseResult = JSON.parse(result);
         if (parseResult != false) {
            mostrarUsuarios(parseResult);
         } else {
            mostrarUsuarios(parseResult);
         }
      }
   });
}

function mostrarUsuarios(usuarios) {
   let contenido = "";

   $.each(usuarios, function (index, usuario) {

      usuario = JSON.parse(usuario);

      contenido += '<tr>\n\
                  <th scope="row">' + usuario.id_Tabla + '</th>' +
              '<td>' + usuario.nombres + " " + usuario.apellidos + '</td>' +
              '<td>' + usuario.correo + '</td>' +
              '<td>' + usuario.placa + '</td>' +
              '<td>' + usuario.estado + '</td>' +
              '<td>' + usuario.estacion + '</td>' +
              '<td>' + usuario.grado + '</td>' +
              '<td><button onclick = "seleccionarFuncionario(' + usuario.id_Tabla + ');" class="btn btn-success";>Gestionar Evaluaciones</button></td>' +
              '</tr>';
   });

   $("#usuarios-tbody").html(contenido);
}