window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
const form = document.forms[0];
const url = '/turno';

form.addEventListener('submit', function (event) {
    console.log("ejecutando evento submit");
    event.preventDefault();
    //creamos el cuerpo de la request
    const payload = {
        paciente:{
            id: document.querySelector('#paciente_id').value
        },
        odontologo:{
            id: document.querySelector('#odontologo_id').value
        },
        fecha: document.querySelector('#fecha').value
    };

    //configuramos la request del Fetch
    const settings = {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    //lanzamos la consulta de login a la API
    realizarRegister(settings);

    //limpio los campos del formulario
    form.reset();
});

function realizarRegister(settings) {
    console.log("Registro de turno en API");
    console.log(settings)

    fetch(url, settings)
        .then(response => {
            console.log(response);

            if (response.ok) {
                alert("Turno agregado con exito");
            } else{
                alert("Alguno de los datos es incorrecto.")
            }

            return response.json();
         })
        .then(data => {
            console.log("Promesa cumplida:");
            console.log(data);

        }).catch(err => {
            console.log("Promesa rechazada:");
            console.log(err);
        })
};

});
