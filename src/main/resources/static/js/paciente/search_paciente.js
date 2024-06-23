window.addEventListener('load', function(){
    const form = document.querySelector('#find_paciente');
    var table = document.getElementById("pacienteTable");

    form.addEventListener('submit', function(e){
        e.preventDefault();
        console.log(e);
        let id = document.querySelector('#id').value
        const url = '/paciente/id/'+id;
        const settings = {
            method: 'GET'
        }

        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            let paciente = data;


            var pacienteRow = table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

                //boton de eliminar
                let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

                //boton de actualizar
                let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';

                //insertar datos
                pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_cedula\">' + paciente.dni.toUpperCase() + '</td>' +
                    '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso.toUpperCase() + '</td>' +
                    '<td class=\"td_calle\">' + paciente.calle.toUpperCase() + '</td>' +
                    '<td class=\"td_numero\">' + paciente.numero + '</td>' +
                    '<td class=\"td_localidad\">' + paciente.localidad.toUpperCase() + '</td>' +
                    '<td class=\"td_provincia\">' + paciente.provincia.toUpperCase() + '</td>' +
                    '<td class=\"td_email\">' + paciente.email.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>';

            document.querySelector('#div_paciente_table').style.display = 'flex';

        })
        .catch(err => {
            alert("Paciente no encontrado")
        })


    })

})