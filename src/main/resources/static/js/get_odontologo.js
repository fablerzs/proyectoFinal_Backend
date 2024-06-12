window.addEventListener('load', function(){
    console.log("iniciando funcion")
        

    const api = '/odontologos/listartodos';
    const settings = {
        method: 'GET'
      }
    


    
        fetch(api,settings)
        .then(response => response.json())
        .then(data =>{
            for(odontologo of data){
                console.log("iniciando for")
                var table = document.getElementById("odontologoTable");
                var odontologoRow = table.insertRow();
                let id = odontologo.id;
                odontologoRow.id = id;

                //boton de eliminar
                let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

                //boton de actualizar
                let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      odontologo.id +
                                      '</button>';

                //insertar datos
                odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>';
            } // termina iteracion

        })

    
    
    
    
})