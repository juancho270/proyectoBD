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
public class TPersonalizada extends Tarjeta{
    int tarjeta_id;
    int saldo;
    int avances_disponibles;

    public TPersonalizada(int tarjeta_id, int saldo, int avances_disponibles){
      this.tarjeta_id = tarjeta_id;
      this.saldo = saldo;
      this.avances_disponibles = avances_disponibles;
    }

    public TPersonalizada() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTarjeta_id(){
      return tarjeta_id;
    }

    @Override
    public int getSaldo(){
      return saldo;
    }

    public int avancesDisponibles(){
      return avances_disponibles;
    }

    @Override
    public void setTarjeta_id(int tarjeta_id){
      this.tarjeta_id = tarjeta_id;
    }

    @Override
    public void setSaldo(int saldo){
      this.saldo = saldo;
    }

    public void setAvances_disponibles(int avances){
      this.avances_disponibles = avances;
    }
}
