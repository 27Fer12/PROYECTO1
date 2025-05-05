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
     private String apellidoP;
    private String apellidoM;
    private String numc;
    private String direccion;
    private String Carrera;


    public Alumno(){super();}

    public Alumno (Integer id, String nombre, String apellidoP, String apellidoM, String numc, String direccion, String Carrera){
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numc = numc;
        this.direccion = direccion;
        this.Carrera = Carrera;

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
    public String getapellidoP(){
        return this.apellidoP;
    }
    public void setapellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getapellidoM(){
        return this.apellidoM;
    }
    public void setapellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNumc() {
        return this.numc;
    }
     
    public void setNumc(String numc) {
        this.numc = numc;
    }
   
    public String getdireccion(){
        return this.direccion;
    }
    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

        public String getCarrera() {
            return this.Carrera;
        }
    
        public void setCarrera(String Carrera) {
            this.Carrera = Carrera;
        }
    }
    


