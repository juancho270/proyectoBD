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
public class ReclamosRealizados {
    int num_tiquete;
    int auxiliar_id;
    int tarjeta_id;

    public ReclamosRealizados(int num_tiquete, int auxiliar_id, int tarjeta_id) {
        this.num_tiquete = num_tiquete;
        this.auxiliar_id = auxiliar_id;
        this.tarjeta_id = tarjeta_id;
    }

    public ReclamosRealizados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_tiquete() {
        return num_tiquete;
    }

    public int getAuxiliar_id() {
        return auxiliar_id;
    }

    public int getTarjeta_id() {
        return tarjeta_id;
    }

    public void setNum_tiquete(int num_tiquete) {
        this.num_tiquete = num_tiquete;
    }

    public void setAuxiliar_id(int auxiliar_id) {
        this.auxiliar_id = auxiliar_id;
    }

    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }
    
    
}
