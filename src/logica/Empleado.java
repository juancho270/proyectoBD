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
public class Empleado {
    int empleado_id;
    int cedula;
    String nombre;
    String apellido;
    int telefono;
    String tipo_empleado;

    public void Empleado(){

    }
    public  int getEmpleado_id(){
      return empleado_id;
    }

    public int getCedula(){
      retunr cedula;
    }

    public String getNombre(){
      return nombre;
    }

    public String getApellido(){
      return apellido;
    }

    public int getTelefono(){
      return telefono;
    }

    public String getTipo_empleado(){
      return tipo_empleado;
    }

    public void setNombre(String nombre){
      this.nombre = nombre;
    }

    public void setApellido(String apellido){
      this.apellido = apellido;
    }
}
