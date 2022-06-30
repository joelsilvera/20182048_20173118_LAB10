package Beans;

import java.io.InputStream;

public class BeanUsuario {
    private String nombre;
    private String apellidos;
    private int edad;
    private int codigo_pucp;
    private String correo_pucp;
    private String especialidad;
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodigo_pucp() {
        return codigo_pucp;
    }

    public void setCodigo_pucp(int codigo_pucp) {
        this.codigo_pucp = codigo_pucp;
    }

    public String getCorreo_pucp() {
        return correo_pucp;
    }

    public void setCorreo_pucp(String correo_pucp) {
        this.correo_pucp = correo_pucp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
