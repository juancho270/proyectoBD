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
public class Reclamos {
    int num_tiquete;
    String date;
    String motivo;
    String descripcion;

    public Reclamos(int num_tiquete, String date, String motivo, String descripcion) {
        this.num_tiquete = num_tiquete;
        this.date = date;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public Reclamos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_tiquete() {
        return num_tiquete;
    }

    public String getDate() {
        return date;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNum_tiquete(int num_tiquete) {
        this.num_tiquete = num_tiquete;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
