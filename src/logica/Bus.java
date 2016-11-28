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
public class Bus {
    String placa;
    int tipo;
    String nombreRuta;

    public Bus(String placa, int tipo, String nombreRuta) {
        this.placa = placa;
        this.tipo = tipo;
        this.nombreRuta = nombreRuta;
    }

    public String getPlaca() {
        return placa;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }
    
    
}
