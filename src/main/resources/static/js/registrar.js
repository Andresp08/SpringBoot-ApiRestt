// Call the dataTables jQuery plugin
$(document).ready(function() {
  //on ready
});

async function registrarUsuario(){
  let datos = {};
  datos.nombre = document.getElementById('nombre').value;
  datos.apellido = document.getElementById('apellido').value;
  datos.email = document.getElementById('email').value;
  datos.password = document.getElementById('password').value;

  let repetirPassword = document.getElementById('repeatPassword').value;

  if(repetirPassword !== datos.password){
    alert('las contraseñas que escribiste no coinciden');
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const usuarios = await request.json();
}
