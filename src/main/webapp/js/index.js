

$(document).ready(function(){
    $("#form-login").submit(function(event){
        event.preventDefault();
        autenticarUsuario();
    });
    
});

function autenticarUsuario(){
    let correo = $("#correo").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            correo: correo,
            contrasena: contrasena

        }),
        success: function(result){
            let parseResult = JSON.parse(result);
            if (parseResult != false){
                let rol = parseResult['rol'];
                if (rol == "Administrador") {
                   document.location.href = "gestionar_usuario.html?rol=" + rol;
                }else{
                   document.location.href = "evaluar_funcionario.html?rol=" + rol;
                }
                
            }else{

               alert('correo o contraseña Incorrectos!');


            }
        }
    });
    
}

