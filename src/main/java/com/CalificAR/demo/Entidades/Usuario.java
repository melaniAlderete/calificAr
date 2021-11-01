package com.CalificAR.demo.Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

//@Entity
// Este inheritance no debe ir ya que no queremos que se cree la tabla usuario,
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected String id;
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String mail;
    protected String clave;

    protected LocalDate fechaNac;

    // Se movio la lista de materias de Alumno y Profesor a la entidad Usuario.
    @OneToMany
    private List<Materia> materias;

    @OneToOne
    protected Foto foto;

    public Usuario(String dni, String nombre, String apellido, String mail, String clave, LocalDate fechaNac, Foto foto,
            List<Materia> materias) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.clave = clave;
        this.fechaNac = fechaNac;
        this.foto = foto;
        this.materias = materias;
    }

    // Método para obtener un objeto Alumno a partir de un objeto Usuario
    public Alumno crearAlumno() {
        return new Alumno(materias, new ArrayList<>(), dni, nombre, apellido, mail, clave, fechaNac, foto);
    }

    // Método para obtener un objeto Profesor a partir de un objeto Usuario
    public Profesor crearProfesor() {
        return new Profesor(materias, dni, nombre, apellido, mail, clave, fechaNac, foto);
    }

    public Usuario() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMateria(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return ", id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
                + ", clave=" + clave + ", fechaNac=" + fechaNac + ", materias=" + materias + ", foto=" + foto + "]";
    }

}
