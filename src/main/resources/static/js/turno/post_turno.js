window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    const url = '/turno';


form.addEventListener('submit', function (event) {
    console.log("ejecutando script");
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

    console.log(payload)

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


//aswnd

function realizarRegister(settings) {
    console.log("Lanzando la consulta a la API");
    fetch(url, settings)
        .then(response => {
            console.log(response);

            if (response.ok==true) {
                alert("Turno agregado con exito");
            } else {
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