window.addEventListener('load', function(){
    console.log("iniciando funcion")
    const form = document.querySelector('#find_odontologo');
    var table = document.getElementById("odontologoTable");
    
    


    form.addEventListener('submit', function(e){
        e.preventDefault();
        console.log(e);
        let id = document.querySelector('#id').value
        const url = '/odontologos/buscarid/'+id;
        const settings = {
            method: 'GET'

        }

        fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            let odontologo = data;
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
            
            
            
            
            document.querySelector('#div_odontologo_table').style.display = 'flex';
            

            alert("Odontologo encontrado con exito")
        })
        .catch(err => {
            alert("Odontologo no encontrado")
            console.log("promesa incumplida")
        })
        
    
    })
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/odontologoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
      })
   
   
   
    
})