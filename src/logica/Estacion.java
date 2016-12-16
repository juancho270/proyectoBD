/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author root
 */
public class Estacion {
    String nombre_estacion;
    int director_id;

    public Estacion(String nombre, int director_id){
      this.nombre_estacion = nombre;
      this.director_id = director_id;
    }

    public Estacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre_estacion(){
      return nombre_estacion;
    }

    public int getDirector_id(){
      return director_id;
    }

    public void setNombre_estacion(String nombre){
      this.nombre_estacion = nombre;
    }

    public void setDirector_id(int id){
      this.director_id = id;
    }
  }
