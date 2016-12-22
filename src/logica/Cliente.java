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
public class Cliente {
    int cedula;
    String nombre;
    int telefono;
    int tarjeta_id;

    public Cliente(int ced, String nom, int telf, int tarjeta_id){
      this.cedula = ced;
      this.nombre = nom;
      this.telefono = telf;
      this.tarjeta_id = tarjeta_id;
    }

    public Cliente() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCedula(){
      return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }

    public String getNombre(){
      return nombre;
    }

    public int getTelefono(){
      return telefono;
    }

    public int getTarjeta_id(){
      return tarjeta_id;
    }

    public void setNombre(String nom){
      this.nombre = nom;
    }
}
