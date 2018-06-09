/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_leonardomontoya;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Inspiron
 */
public class usuario {
    private String correo;
    private String contraseña;
    private String nacimiento;
    private ArrayList<String> peliculas = new ArrayList();
    private ArrayList<String> series = new ArrayList();
    private String tarjeta;

    public usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public usuario(String correo, String contraseña, String nacimiento, String tarjeta) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.nacimiento = nacimiento;
        this.tarjeta = tarjeta;
    }

    public usuario() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public ArrayList<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<String> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<String> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<String> series) {
        this.series = series;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return correo;
    }
    
    
    
}
