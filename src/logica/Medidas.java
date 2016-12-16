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
public class Medidas {
    int num_tiquete;
    String medidas;

    public Medidas(int num_tiquete, String medidas) {
        this.num_tiquete = num_tiquete;
        this.medidas = medidas;
    }

    public Medidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_tiquete() {
        return num_tiquete;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setNum_tiquete(int num_tiquete) {
        this.num_tiquete = num_tiquete;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }
    
    
}
