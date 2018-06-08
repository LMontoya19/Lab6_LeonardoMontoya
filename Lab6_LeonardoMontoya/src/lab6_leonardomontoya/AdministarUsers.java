/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_leonardomontoya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Inspiron
 */
public class AdministarUsers {

    private ArrayList<usuario> listaUsuari = new ArrayList();
    private File archivo = null;

    public AdministarUsers(String path) {
        archivo = new File(path);
    }

    public ArrayList<usuario> getListaUsuari() {
        return listaUsuari;
    }

    public void setListaUsuari(ArrayList<usuario> listaUsuari) {
        this.listaUsuari = listaUsuari;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setUser(usuario u) {
        this.listaUsuari.add(u);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (usuario t : listaUsuari) {
                bw.write(t.getCorreo() + ";");
                bw.write(t.getContraseña() + ";");
                bw.write(t.getNacimiento() + ";");
                for (int i = 0; i < t.getPeliculas().size(); i++) {
                    bw.write(t.getPeliculas().get(i) + ",");
                }
                bw.write(";");
                for (int i = 0; i < t.getSeries().size(); i++) {
                    bw.write(t.getSeries().get(i) + ",");
                }
                bw.write(";");
                bw.write(t.getTarjeta() + ";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaUsuari = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    String correo = sc.next();
                    String contraseña = sc.next();
                    String nacimiento = sc.next();
                    Scanner sc2 = new Scanner(sc.next());
                    sc2.useDelimiter(",");
                    ArrayList<String> peliculas = new ArrayList();
                    ArrayList<String> series = new ArrayList();
                    while (sc2.hasNext()) {
                        peliculas.add(sc.next());
                    }
                    Scanner sc3 = new Scanner(sc.next());
                    sc3.useDelimiter(",");
                    while (sc3.hasNext()) {
                        series.add(sc3.next());
                    }
                    String tarjeta = sc.next();
                    usuario u = new usuario(correo,contraseña,nacimiento,tarjeta);
                    u.setPeliculas(peliculas);
                    u.setSeries(series);
                    
                    listaUsuari.add(u);
                    
                }
            } catch (Exception e) {
            }
            sc.close();
        }

    }
}
