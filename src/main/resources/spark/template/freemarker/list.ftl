<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
    <title>Listado de estudiantes</title>
</head>
<body>
<h1>Listado de Estudiantes</h1>
</br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-12">
            <table class="table table-striped">
                <tr>
                    <th>Matricula</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Carrera</th>
                    <th>Acciones</th>
                </tr>
                <#list estudiantes as estudiante>
                    <tr>
                        <td>${estudiante.matricula}</td>
                        <td>${estudiante.nombre}</td>
                        <td>${estudiante.correo}</td>
                        <td>${estudiante.carrera}</td>
                        <td>
                            <a href="/actualizar/${estudiante.matricula}/">Editar</a>
                            <a href="/eliminar/${estudiante.matricula}/">Eliminar</a>
                            <a href="/vista/${estudiante.matricula}/">Ver</a>
                        </td>
                    </tr>
                </#list>
            </table>
            <br/><br/>

            <form action="/registrar/" method="get">
                <button type="submit" class="btn btn-primary">Registrar Estudiante</button>
            </form>
        </div>
    </div>
</div>

</div>


</body>
</html>