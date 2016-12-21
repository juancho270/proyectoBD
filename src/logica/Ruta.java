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
public class Ruta {

   String nombre;
   String Descripcion;
   String fecha_inicio;
   String fecha_final;
   String franja_horaria;

    public Ruta(String nombre, String Descripcion, String fecha_inicio, String fecha_final, String franja_horaria) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.franja_horaria = franja_horaria;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public void setFranja_horaria(String franja_horaria) {
        this.franja_horaria = franja_horaria;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public String getFranja_horaria() {
        return franja_horaria;
    }

    public Ruta() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }


}
