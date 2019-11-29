<!DOCTYPE html>
<html>
<head>
    <title>Perfil del Estudiante</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
</head>
<body>
<h1 style="text-align: center;">Perfil de ${estudiante.nombre}</h1>
</br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="card" style="padding: 20px; background-color: lightgray">

                <h4>Datos del estudiante:</h4>

                <p>Matricula: ${estudiante.matricula}</p>
                <p>Direccion: ${estudiante.correo}</p>
                <p>Direccion: ${estudiante.carrera}</p>

            </div>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <button onclick="location.href = '/actualizar/${index}/';" type="button" class="btn btn-primary" style="margin-top: 10px; margin-right: 5px;">Editar</button>
        <button onclick="location.href = '/';" type="button" class="btn btn-primary" style="margin-top: 10px;">Inicio</button>
    </div>
</div>


</body>
</html>