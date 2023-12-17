var correo = new URL(location.href).searchParams.get("correo");
var user;

function eliminarUsuario(id){
   var id_tabla = id;
   
   $.ajax({
      type: "GET",
      dataType: "html",
      url: "./ServletUsuarioEliminar",
      data: $.param({
         id_tabla: id_tabla
      }),
      success: function (result) {
         let parseResult = JSON.parse(result);
         if (parseResult != false) {
            alert("Se elimino correctamente el usuario!!!");
            getUsuarios(false, "");
         } else {
            console.log("Error eliminando usuario");
         }
      }
   });
}

function editarUsuario(id){
   var id_tabla = id;
   document.location.href = "register_Funcionario.html?id=" + id_tabla;

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
      getUsuarios(false, "");
   });

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

$(document).ready(function () {
   $("#frm_buscar").submit(function (event) {
      event.preventDefault();

      let filtro = $("#txt_buscar").val();

      getVestidos(true, filtro);
   });
});

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
              '<td><button onclick = "eliminarUsuario(' + usuario.id_Tabla + ');" class="btn btn-success";>Eliminar</button><button onclick = "editarUsuario(' + usuario.id_Tabla + ');" class="btn btn-danger";>Editar</button></td>' +
              '</tr>';
   });

   $("#usuarios-tbody").html(contenido);
}