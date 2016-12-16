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
public class Tarjeta {
    int tarjeta_id;
    int saldo;
    boolean estado;

    public Tarjeta(int tarjeta_id, int saldo, boolean estado){
      this.tarjeta_id = tarjeta_id;
      this.saldo = saldo;
      this.estado = estado;
    }

    public Tarjeta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTarjeta_id(){
      return tarjeta_id;
    }

    public int getSaldo(){
      return saldo;
    }

    public boolean getEstado(){
      return estado;
    }

    public void setTarjeta_id(int id){
      this.tarjeta_id = id;
    }

    public void setSaldo(int saldo){
      this.saldo = saldo;
    }

    public void setEstado(boolean est){
      this.estado = est;
    }
}
