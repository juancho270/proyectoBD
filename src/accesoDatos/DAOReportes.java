/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author camilojosé
 */
public class DAOReportes {

    FachadaBD fachada;
    ResultSet respuesta;

    public DAOReportes(FachadaBD fachada) {
        this.fachada = fachada;
    }

    public DAOReportes() {
        fachada = new FachadaBD();
    }

    public ResultSet reporte1() {

        String consulta = "SELECT * FROM CLIENTE";
        System.out.println("Inicia consulta");

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }
        System.out.println("Termina consulta");
        return respuesta;

    }

    ;

    public ResultSet reporte2() {

        String consulta = "SELECT COUNT(vi.fecha) as \"pasajeros\", vi.fecha, bu.nombre_ruta FROM VIAJE as vi,BUS bu WHERE vi.placa_bus = bu.placa GROUP BY vi.fecha, bu.nombre_ruta";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }

    ;
    
    public ResultSet reporte3(String fecha) {

        String consulta = "SELECT COUNT(fecha)*3000 as \"TOTAL VENTAS\", fecha\n"
                + "FROM VENTA_TARJETAS\n"
                + "WHERE fecha = " + fecha + "\n"
                + "GROUP BY fecha";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }

    ;
    
    public ResultSet reporte4() {

        String consulta = "SELECT cli.nombre as \"Usuario\", recl.descripcion as \"Descripcion Reclamo\", emp.nombre as \"Nombre Director\", emp.apellido as \"Apellido Director\",recl.fecha\n"
                + "FROM RECLAMOS as recl, CLIENTE as cli,EMPLEADO as emp\n"
                + "WHERE recl.cedula_cliente = cli.cedula AND recl.director_id = emp.empleado_id \n"
                + "ORDER BY recl.fecha ";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }

    ;
    
    public ResultSet reporte5() {

        String consulta = "SELECT DISTINCT b.placa, conductor.nombre, conductor.apellido\n"
                + "FROM BUS b,MANEJO_BUSES man, EMPLEADO conductor\n"
                + "WHERE b.tipo = 1 AND b.placa = man.placa_bus AND man.conductor_id = conductor.empleado_id\n"
                + "ORDER BY b.placa;";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }

    ;
    
    
    public ResultSet reporte6() {

        String consulta = "SELECT nombre, descripcion\n"
                + "FROM RUTA;";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }

    ;
    
    
    public ResultSet reporte7() {

        String consulta = "SELECT num_tiquete, motivo, descripcion\n"
                + "FROM RECLAMOS";

        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            respuesta = sentencia.executeQuery(consulta);
            fachada.closeConnection(conn);

        } catch (SQLException sqle) {
            System.out.println("Error al consultar datos");
        }

        return respuesta;

    }
;
}
