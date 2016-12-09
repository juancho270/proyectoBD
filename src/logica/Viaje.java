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
public class Viaje {
    String fecha;
    String hora;
    int tarjeta_id;
    String placa_bus;

  public void Viaje(String fecha, String hora, int tarjeta_id, String placa_bus){
    this.fecha = fecha;
    this.hora = hora;
    this.tarjeta_id = tarjeta_id;
    this.placa_bus = placa_bus;
  }

  public String getFecha(){
    return fecha;
  }

  public String getHora(){
    return hora;
  }

  public int getTarjeta_id(){
    return tarjeta_id;
  }

  public String getPlaca_bus(){
    return placa_bus;
  }
}
