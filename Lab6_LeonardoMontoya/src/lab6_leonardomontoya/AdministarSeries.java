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
public class AdministarSeries {

    private ArrayList<serie> listaSeries = new ArrayList();
    private File archivo = null;
    
    public AdministarSeries(String path) {
        archivo = new File(path);
    }
    
    public ArrayList<serie> getListaUsuari() {
        return listaSeries;
    }
    
    public void setListaUsuari(ArrayList<serie> listaseries) {
        this.listaSeries = listaseries;
    }
    
    public File getArchivo() {
        return archivo;
    }
    
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setSerie(serie s) {
        this.listaSeries.add(s);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (serie s : listaSeries) {
                bw.write(s.getId() + ";");
                bw.write(s.getNombre() + ";");
                bw.write(s.getTemporadas() + ";");
                bw.write(s.getCategoria() + ";");
                for (int i = 0; i < s.getIdiomas().size(); i++) {
                    bw.write(s.getIdiomas().get(i) + ",");
                }
                bw.write(";");
                for (int i = 0; i < s.getSubtitulos().size(); i++) {
                    bw.write(s.getSubtitulos() + ",");
                }
                bw.write(";");
                bw.write(s.getDuracion() + ";");
                bw.write(s.getRating() + ";");
                for (int i = 0; i < s.getComentarios().size(); i++) {
                    bw.write(s.getComentarios().get(i) + ",");
                }
                bw.write(";");
                bw.write(s.getProductora() + ";");
                bw.write(s.getDirector() + ";");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo() {
        Scanner sc = null;
        listaSeries = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    String id = sc.next();
                    String nombre = sc.next();
                    int temporadas = sc.nextInt();
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
                    serie s = new serie(id, nombre, temporadas, categoria, duracion, rating, productora, director);
                    s.setComentarios(comentarios);
                    s.setIdiomas(idiomas);
                    s.setSubtitulos(subtitulos);
                    listaSeries.add(s);
                    
                }
            } catch (Exception e) {
            }
            sc.close();
        }
        
    }
}
