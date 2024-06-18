window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.querySelector("#add_new_turno")
       


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



});

function realizarRegister(settings) {
    console.log("Lanzando la consulta a la API");
    const url = '/turno';
    fetch(url, settings)
        .then(data => {
            alert("Turno agregado con exito")
            console.log("Promesa cumplida:");
            console.log(data);

        }).catch(err => {
            alert("Algunos de los datos son incorrectos")
            console.log("Promesa rechazada:");
            console.log(err);
        })
};