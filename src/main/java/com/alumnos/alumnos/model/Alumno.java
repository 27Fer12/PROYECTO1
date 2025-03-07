package com.alumnos.alumnos.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String numc;


    public Alumno(){super();}

    public Alumno (Integer id, String nombre, String numc){
        super();
        this.id = id;
        this.nombre = nombre;
        this.numc =numc;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumc() {
        return this.numc;
    }

    public void setNumc(String numc) {
        this.numc = numc;
    }





}
