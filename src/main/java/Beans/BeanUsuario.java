package Beans;

import java.io.InputStream;

public class BeanUsuario {
    private String nombre_completo;
    private int edad;
    private int codigo_pucp;
    private String correo_pucp;
    private String especialidad;
    private String contrasenia;

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
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
