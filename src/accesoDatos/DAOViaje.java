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
import logica.Viaje;

/**
 *
 * @author root
 */
public class DAOViaje {

    FachadaBD fachada;

    public DAOViaje(FachadaBD fachada) {
        this.fachada = fachada;
    }

    public DAOViaje() {
    }

    public int GuardarViaje(Viaje viaje) {
        String sql_guardar;
        sql_guardar = "INSERT INTO VIAJE VALUES ("
                + viaje.getFecha() + ", "
                + viaje.getHora() + ", '"
                + viaje.getTarjeta_id() + "', '"
                + viaje.getPlaca_bus() + "' )";
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

    public Viaje consultarViaje(int tarjeta_id) {

        Viaje viaje = null;
        String sql_select;
        sql_select = "SELECT * FROM VIAJE WHERE tarjeta_id = " + tarjeta_id;
        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {

                viaje = new Viaje(tabla.getString(1), tabla.getString(2), tabla.getInt(3), tabla.getString(4));
                System.out.println("ok");
            }

            // return emp;
        } catch (SQLException e) {
            System.out.println(e);
            viaje = null;
        } catch (Exception e) {
            System.out.println(e);
            viaje = null;
        }
        // 
        return viaje;
    }

    public ArrayList<Viaje> listarViaje() {
        Viaje viaje;
        ArrayList<Viaje> listaViajes = new ArrayList<>();
        String sql_select = "SELECT * FROM VIAJE";

        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {
                viaje = new Viaje(tabla.getString(1), tabla.getString(2), tabla.getInt(3), tabla.getString(4));
                listaViajes.add(viaje);

            }

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }

        return listaViajes;
    }

}
