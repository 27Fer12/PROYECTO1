package com.alumnos.alumnos.Controller;
import com.alumnos.alumnos.model.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alumnos.alumnos.services.AlumnoServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/bienvenidos")
public class AlumnoController {

    @Autowired
    private AlumnoServices alumnoServices;

    @GetMapping("/traer_alumnos")
    public List<Alumno> listarAlumnos(){
           return alumnoServices.listarAlumnos();
    }
    
    @PostMapping("/insertar_alumnos")
    public ResponseEntity<String> guardarAlumno(@RequestBody Alumno alumno) {
        try {
            alumnoServices.guardarAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body("Alumno creado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error al crear el alumno: " + e.getMessage());
        }
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarAlumno(@RequestBody Alumno alumno, @PathVariable Integer id) {
        try {
            Alumno alumnoExiste = alumnoServices.obtenerAlumno(id);
            if (alumnoExiste == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID: " + id);
            }

            alumnoExiste.setNombre(alumno.getNombre());
            alumnoExiste.setapellidoP(alumno.getapellidoP());
            alumnoExiste.setapellidoM(alumno.getapellidoM());
            alumnoExiste.setNumc(alumno.getNumc());
            alumnoExiste.setdireccion(alumno.getdireccion());
            alumnoExiste.setCarrera(alumno.getCarrera());

            alumnoServices.guardarAlumno(alumnoExiste);

            return ResponseEntity.status(HttpStatus.OK).body("Alumno editado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable Integer id) {
        try {
            Alumno alumnoExiste = alumnoServices.obtenerAlumno(id);
            if (alumnoExiste == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alumno no encontrado con ID: " + id);
            }
            
            alumnoServices.eliminarAlumno(id);
            return ResponseEntity.status(HttpStatus.OK).body("Alumno eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el alumno: " + e.getMessage());
        }
    }
}
