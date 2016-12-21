/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.VentaTarjetas;

/**
 *
 * @author root
 */
public class DAOVentaTarjeta {

    FachadaBD fachada;

    public DAOVentaTarjeta(FachadaBD fachada) {
        this.fachada = fachada;
    }

    public int GuardarVentaTarjeta(VentaTarjetas p) {
        String sql_guardar;
        sql_guardar = "INSERT INTO VENTA_TARJETAS  VALUES ("
                + p.getAuxiliar_id() + ", "
                + p.getNombre_estacion() + ", '"
                + p.getTarjeta_id() + "' )";
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException e) {
            return -2;
        } catch (Exception e) {
            return -3;
        }

    }

    public VentaTarjetas consultarVentaTarjeta(int aux) {

        VentaTarjetas venta = new VentaTarjetas();
        String sql_select;
        sql_select = "SELECT * FROM VENTA_TARJETAS WHERE auxiliar_id  = " + aux;
        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {

                venta.setAuxiliar_id(tabla.getInt(1));
                venta.setNombre_estacion(tabla.getString(2));
                venta.setTarjeta_id(tabla.getInt(3));
                System.out.println("ok");
            }

            // return emp;
        } catch (SQLException e) {
            System.out.println(e);
            venta = null;
        } catch (Exception e) {
            System.out.println(e);
            venta = null;
        }
        // 
        return venta;
    }

    public ArrayList<VentaTarjetas> listarVentaTarjeta() {
    
        VentaTarjetas venta;
        ArrayList<VentaTarjetas> listaVentas = new ArrayList<>();
        String sql_select = "SELECT * FROM VENTA_TARJETAS";
        
         try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
                venta = new VentaTarjetas(tabla.getInt(1), tabla.getString(2), tabla.getInt(3));
                listaVentas.add(venta);
            
            }
            

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaVentas;
    }

}
