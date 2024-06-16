window.addEventListener('load', function () {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    const url = '/odontologos/guardar';

form.addEventListener('submit', function (event) {
    console.log("ejecutando script");
    event.preventDefault();
    //creamos el cuerpo de la request
    const payload = {
        matricula: document.querySelector('#matricula').value,
        nombre: document.querySelector('#nombre').value,
        apellido: document.querySelector('#apellido').value
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


//aswnd

function realizarRegister(settings) {
    console.log("Lanzando la consulta a la API");
    fetch(url, settings)
        .then(response => {
            console.log(response);

            if (response.ok==true) {
                alert("Odontologo agregado con exito");
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