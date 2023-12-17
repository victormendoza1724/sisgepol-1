
$(document).on("click", "#btn_registrar", function(){
    registrar();
});

function registrar(){
    let contrasena = $("#txt_contrasena").val();
    let repit = $("#txt_repit_contrasena").val();
    let correo = $("#txt_correo").val();
    let nombres = $("#txt_nombres").val();
    let apellidos = $("#txt_apellidos").val();
    let rol = "Usuario";
    let placa = "";
    let estado = "";
    let estacion = "";
    let grado = "";
    
    
    if (contrasena === repit){
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegistro",
            data: $.param({
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
                  alert('Se registro el usuario correctamente!');
                }else{
                    alert("No se registro el usuario, intente con otro correo!");

                }
            }
        });
     }else{
      alert("Las contraseñas no son iguales!");
    }
}
