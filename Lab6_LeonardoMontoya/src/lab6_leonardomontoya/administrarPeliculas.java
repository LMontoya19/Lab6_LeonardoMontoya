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
import java.util.Scanner;

/**
 *
 * @author Inspiron
 */
public class administrarPeliculas {
     private ArrayList<pelicula> listapeliculas = new ArrayList();
    private File archivo = null;
    
    public administrarPeliculas(String path) {
        archivo = new File(path);
    }
    
    public ArrayList<pelicula> getListaUsuari() {
        return listapeliculas;
    }
    
    public void setListaUsuari(ArrayList<pelicula> listapeliculas) {
        this.listapeliculas = listapeliculas;
    }
    
    public File getArchivo() {
        return archivo;
    }
    
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setSerie(pelicula p) {
        this.listapeliculas.add(p);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (pelicula p : listapeliculas) {
                bw.write(p.getId() + ";");
                bw.write(p.getNombre() + ";");
                bw.write(p.getCategoria() + ";");
                for (int i = 0; i < p.getIdiomas().size(); i++) {
                    bw.write(p.getIdiomas().get(i) + ",");
                }
                bw.write(";");
                for (int i = 0; i < p.getSubtitulos().size(); i++) {
                    bw.write(p.getSubtitulos() + ",");
                }
                bw.write(";");
                bw.write(p.getDuracion() + ";");
                bw.write(p.getRating() + ";");
                for (int i = 0; i < p.getComentarios().size(); i++) {
                    bw.write(p.getComentarios().get(i) + ",");
                }
                bw.write(";");
                bw.write(p.getProductora() + ";");
                bw.write(p.getDirector() + ";");
                for (int i = 0; i < p.getActores().size(); i++) {
                    bw.write(p.getActores().get(i)+",");
                }
                bw.write(";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo() {
        Scanner sc = null;
        listapeliculas = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    String id = sc.next();
                    String nombre = sc.next();
                    String categoria = sc.next();
                    Scanner sc2 = new Scanner(sc.next());
                    sc2.useDelimiter(",");
                    ArrayList<String> idiomas = new ArrayList();
                    ArrayList<String> subtitulos = new ArrayList();
                    while (sc2.hasNext()) {
                        idiomas.add(sc2.next());
                    }
                    Scanner sc3 = new Scanner(sc.next());
                    sc3.useDelimiter(",");
                    while (sc3.hasNext()) {
                        subtitulos.add(sc3.next());
                    }
                    String duracion = sc.next();
                    int rating = sc.nextInt();
                    ArrayList<String> comentarios = new ArrayList();
                    Scanner sc4 = new Scanner(sc.next());
                    sc4.useDelimiter(",");
                    while (sc4.hasNext()) {
                        comentarios.add(sc4.next());
                    }
                    String productora = sc.next();
                    String director = sc.next();
                    Scanner sc5 = new Scanner(sc.next());
                    sc5.useDelimiter(",");
                    ArrayList<String>actores = new ArrayList<>();
                    while(sc5.hasNext()){
                    actores.add(sc5.next());
                    }
                    pelicula p = new pelicula(id, nombre, categoria, duracion, rating, productora, director);
                    p.setComentarios(comentarios);
                    p.setIdiomas(idiomas);
                    p.setSubtitulos(subtitulos);
                    p.setActores(actores);
                    listapeliculas.add(p);
                    
                }
            } catch (Exception e) {
            }
            sc.close();
        }
        
    }
}
