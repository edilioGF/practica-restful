package encapsulacion;
import java.util.ArrayList;

public class Controladora {
    private static Controladora instance;
    private ArrayList<Estudiante> estudiantes;

    private Controladora(){
        super();
        this.estudiantes = new ArrayList<>();
    }

    public static Controladora getInstance() {
        if(instance == null) {
            instance = new Controladora();
        }
        return instance;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
