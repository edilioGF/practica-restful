<!DOCTYPE html>
<html>
<head>
    <title>Registrar Estudiante</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
</head>
<body>
<h1 style="text-align: center;">Ingrese los datos del estudiante:</h1>
</br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="card" style="padding: 20px; background-color: lightgray">
                <form action="/registrarEstudiante/" method="post"  enctype="application/x-www-form-urlencoded">
                    <div class="form-group">
                        <label for="matricula">Matricula:</label>
                        <input type="text" class="form-control" id="matricula" name="matricula">
                    </div>

                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre">
                    </div>

                    <div class="form-group">
                        <label for="correo">Correo:</label>
                        <input type="text" class="form-control" id="correo" name="correo">
                    </div>

                    <div class="form-group">
                        <label for="carrera">Carrera:</label>
                        <input type="text" class="form-control" id="carrera" name="carrera">
                    </div>

                    <button type="submit" class="btn btn-primary">Registrar</button>
                    <button onclick="location.href = '/';" type="button" class="btn btn-primary">Inicio</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>