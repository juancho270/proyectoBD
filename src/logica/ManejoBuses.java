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
public class ManejoBuses {
    int conductor_id;
    String placa_bus;
    String turno;

    public ManejoBuses(int conductor_id, String placa_bus, String turno){
      this.conductor_id = conductor_id;
      this.placa_bus = placa_bus;
      this.turno = turno;
    }

    public ManejoBuses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getConductor_id(){
      return conductor_id;
    }

    public String getPlaca_bus(){
      return placa_bus;
    }

    public String getTurno(){
      return turno;
    }
}
