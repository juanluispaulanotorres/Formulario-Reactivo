window.onload = function() {
    // Obtención de los datos de la primera persona y mostrarlos en el formulario

    fetch("/listadoPersonas", {
        method: "GET"
    })
    .then(response => response.json())
    .then(function(data) {
        formulario(data);

        // Modificar datos de la persona

        let form = document.getElementById("form");
        form.addEventListener("submit", function(ev) {
            ev.preventDefault();

            let id = data[0].id_persona;

            fetch ("http://localhost:8080/modificar/" + id, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                 body: JSON.stringify({
                    usuario: document.getElementById("txtUsuario").value,
                    surname: document.getElementById("txtApellido").value,
                    password: document.getElementById("txtPasswd").value,
                    name: document.getElementById("txtNombre").value,
                    company_email: document.getElementById("txtCorreoEmpresa").value,
                    personal_email: document.getElementById("txtCorreoPersonal").value,
                    city: document.getElementById("txtCiudad").value,
                    active: document.getElementById("txtActivo").checked,
                    created_date: document.getElementById("txtFCreacion").value,
                    imagen_url: document.getElementById("txtImagen").value,
                    termination_date: document.getElementById("txtFFinalizacion").value
                })
            })
        })
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
        activo.checked = respuesta[0].active;
        fechaCreacion.value = respuesta[0].created_date.slice(0,10);
        imagenUrl.value = respuesta[0].imagen_url;
        fechaFinalizacion.value = respuesta[0].termination_date.slice(0,10);
    }
}
