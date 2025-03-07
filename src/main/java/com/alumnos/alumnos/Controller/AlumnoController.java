package com.alumnos.alumnos.Controller;
import com.alumnos.alumnos.model.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alumnos.alumnos.services.AlumnoServices;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/bienvenidos")
public class AlumnoController {

    @Autowired
    private AlumnoServices alumnoServices;

    @GetMapping("/traer_alumnos")
    public List<Alumno> listarAlumnos(){
           return alumnoServices.listarAlumnos();

    }

    }
    



