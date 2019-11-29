import com.fasterxml.jackson.databind.ObjectMapper;
import encapsulacion.Controladora;
import encapsulacion.Estudiante;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.*;

import static spark.Spark.*;

public class Main {

    public static String renderFreemarker(Map<String, Object> model, String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static void main(String[] args) {
        port(1234);
        staticFiles.location("/publico");
        ObjectMapper mapper = new ObjectMapper();

        get("/", (request,response) -> {

            List<Estudiante> estudiantes = Unirest.get("http://localhost:4567/rest/estudiantes/")
                    .asObject(new GenericType<List<Estudiante>>(){})
                    .getBody();

            Map<String,Object> datos = new HashMap<>();
            datos.put("estudiantes",estudiantes);

            return new FreeMarkerEngine().render(new ModelAndView(datos,"list.ftl"));
        });

        get("/registrar/", (request, response) -> {
            return new FreeMarkerEngine().render(new ModelAndView(null,"registrarEstudiante.ftl"));
        });

        get("/actualizar/:index/", (request, response) -> {
            String index = request.params("index");

            Estudiante estudiante = Unirest.get("http://localhost:4567/rest/estudiantes/" + index)
                    .asObject(Estudiante.class)
                    .getBody();

            Map<String,Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            attributes.put("index", index);

            return new FreeMarkerEngine().render(new ModelAndView(attributes, "actualizarEstudiante.ftl"));
        });

        get("/vista/:index/",(request, response) -> {
            String matricula = request.params("index");

            Estudiante estudiante = Unirest.get("http://localhost:4567/rest/estudiantes/" + matricula)
                    .asObject(Estudiante.class)
                    .getBody();

            Map<String,Object> attributes = new HashMap<>();

            attributes.put("estudiante", estudiante);
            attributes.put("index", matricula);
            return new FreeMarkerEngine().render(new ModelAndView(attributes, "visualizarEstudiante.ftl"));
        });

        post("/registrarEstudiante/", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String correo = request.queryParams("correo");
            String carrera = request.queryParams("carrera");

            Estudiante estudiante = new Estudiante(matricula,nombre,correo,carrera);

            Unirest.post("http://localhost:4567/rest/estudiantes/")
                    .body(estudiante)
                    .asEmpty();

            response.redirect("/");
            return "";
        });
        post("/actualizarEstudiante/",(request, response) -> {
            String nombre = request.queryParams("nombre");
            String correo = request.queryParams("correo");
            String carrera = request.queryParams("carrera");

            int index = Integer.parseInt(request.queryParams("index"));

            Estudiante estudiante = new Estudiante(index, nombre, correo, carrera);

            Unirest.put("http://localhost:4567/rest/estudiantes/")
                    .body(estudiante)
                    .asEmpty();

            Map<String,Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            attributes.put("index", index);
            return new FreeMarkerEngine().render(new ModelAndView(attributes, "visualizarEstudiante.ftl"));
        });

        get("/eliminar/:index/", (request, response) -> {
            String index = request.params("index");

            Unirest.delete("http://localhost:4567/rest/estudiantes/" + index)
                    .asEmpty();

            response.redirect("/");
            return "";
        });

    }

}
