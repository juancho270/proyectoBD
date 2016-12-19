/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.util.ArrayList;
import logica.RutaEstacion;

/**
 *
 * @author root
 */
public class DAORutaEstacion {
    FachadaBD fachada;

    public DAORutaEstacion() {
        fachada = new FachadaBD();
    }
    public int GuardarRutaEstacion(RutaEstacion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RutaEstacion consultarRutaEstacion(String id_r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<RutaEstacion> listarRutaEstacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
