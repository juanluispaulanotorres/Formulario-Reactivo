window.onload = function() {
    fetch("/listadoPersonas", {
        method: "GET",
    /*	headers: {
            "Content-Type": "application/json",
            "ejemplo": "ejemplo"
        },
        body: {
            JSON.stringify({
                nombre: "Juanluis",
                edad: 26
            })
        }
    */
    }).then(response => response.json())
       .then(function(data) {
            formulario(data);
       })
};

function formulario(respuesta) {
    let usuario = document.getElementById("txtUsuario");
    let apellido = document.getElementById("txtApellido");
    let passwd = document.getElementById("txtPasswd");
    let nombre = document.getElementById("txtNombre");
    let correoEmpresa = document.getElementById("txtCorreoEmpresa");
    let correoPersonal = document.getElementById("txtCorreoPersonal");
    let ciudad = document.getElementById("txtCiudad");
    let activo = document.getElementById("txtActivo");
    let fechaCreacion = document.getElementById("txtFCreacion");
    let imagenUrl = document.getElementById("txtImagen");
    let fechaFinalizacion = document.getElementById("txtFFinalizacion");

    if (respuesta.length > 0) {
        usuario.value = respuesta[0].usuario;
        apellido.value = respuesta[0].surname;
        passwd.value = respuesta[0].password;
        nombre.value = respuesta[0].name;
        correoEmpresa.value = respuesta[0].company_email;
        correoPersonal.value = respuesta[0].personal_email;
        ciudad.value = respuesta[0].city;
        respuesta[0].active == true ? activo.checked = true : activo.checked = false;
        fechaCreacion.value = respuesta[0].created_date.slice(0,10);
        imagenUrl.value = respuesta[0].imagen_url;
        fechaFinalizacion.value = respuesta[0].termination_date.slice(0,10);
    }
}
