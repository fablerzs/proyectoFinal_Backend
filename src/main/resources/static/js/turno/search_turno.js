window.addEventListener('load', function(){
    const form = document.querySelector('#find_turno');
    var table = document.getElementById("turnoTable");

    form.addEventListener('submit', function(e){
        e.preventDefault();
        console.log(e);
        let id = document.querySelector('#id').value
        const url = '/turno/'+id;
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            let turno = data;

            var turnoRow = table.insertRow();
            let tr_id = 'tr_' + turno.id;
            turnoRow.id = tr_id;

                //boton de eliminar
                let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                      ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

                //boton de actualizar
                let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                      ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id">' +
                                      turno.id +
                                      '</button>';

                //insertar datos
                turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_id_paciente\">' + turno.paciente.nombre + ' ' + turno.paciente.apellido + '</td>' +
                    '<td class=\"td_id_odontologo\">' + turno.odontologo.nombre + ' ' + turno.odontologo.apellido + '</td>' +
                    '<td class=\"td_fecha\">' + turno.fecha + '</td>' +
                    '<td>' + deleteButton + '</td>';

            document.querySelector('#div_turno_table').style.display = 'flex';

        })
        .catch(err => {
            alert("Turno no encontrado")
        })


    })

})