/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author root
 */
public class DAOEmpleado {

    FachadaBD fachada;
    ResultSet respuesta;

    public DAOEmpleado() {
        fachada = new FachadaBD();
    }

    public int GuardarEmpleado(Empleado emp) {
        String sql_guardar;
        sql_guardar = "INSERT INTO EMPLEADO VALUES ("
                + emp.getEmpleado_id() + ", "
                + emp.getCedula() + ", '"
                + emp.getNombre() + "', '"
                + emp.getApellido() + "' , "
                + emp.getTelefono() + " , '"
                + emp.getTipo_empleado() + "' )";
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

    public Empleado consultarEmpleado(int id_emp) {
        Empleado emp = new Empleado();
        String sql_select;
        sql_select = "SELECT empleado_id, cedula, nombre, apellido, telefono, tipo_empleado FROM EMPELADO WHERE empleado_id = " + id_emp;
        try {
            Connection conn = fachada.getConnection();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);

            while (tabla.next()) {

                emp.setEmpleado_id(tabla.getInt(1));
                emp.setCedula(tabla.getInt(2));
                emp.setNombre(tabla.getString(3));
                emp.setApellido(tabla.getString(4));
                emp.setTelefono(tabla.getInt(5));
                emp.setTipo_empleado(tabla.getString(6));

                System.out.println("ok");
            }

            // return emp;
        } catch (SQLException e) {
            System.out.println(e);
            emp = null;
        } catch (Exception e) {
            System.out.println(e);
            emp = null;
        }
        // 
        return emp;
    }

    public ArrayList<Empleado> listarEmpleados() {
        Empleado unEmpleado;
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        String sql_select = "SELECT * FROM EMPLEADO;";

        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            while (tabla.next()) {
                unEmpleado = new Empleado();
                unEmpleado.setEmpleado_id(tabla.getInt(1));
                unEmpleado.setCedula(tabla.getInt(2));
                unEmpleado.setNombre(tabla.getString(3));
                unEmpleado.setApellido(tabla.getString(4));
                unEmpleado.setTelefono(tabla.getInt(5));
                unEmpleado.setTipo_empleado(tabla.getString(6));
                listaEmpleados.add(unEmpleado);

            }

            fachada.closeConnection(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "         Ha ocurrido un problema, \n consulta con la base de datos fallida", "SIT", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema!!", "SIT", JOptionPane.ERROR_MESSAGE);
        }

        return listaEmpleados;
    }

//    public int cambiarCedula(Empleado emp){
//        String update_statement = "UPDATE EMPLEADO SET cedula = " + emp.getCedula()+ " WHERE empleado_id = " + emp.getEmpleado_id();
//        int numFilas = -1;
//        try {
//            Connection conn = fachada.getConnection();
//            Statement sentencia = conn.createStatement();
//            numFilas = sentencia.executeUpdate(update_statement);
//            conn.close();
//            fachada.closeConnection(conn);
//            return numFilas;
//        } catch (SQLException ex) {
//            return -2;
//        } catch (Exception ex) {
//            return -3;
//        }
//    }
    public int cambiarNombre(Empleado emp) {
        String update_statement = "UPDATE EMPLEADO SET nombre = '" + emp.getNombre() + "' WHERE empleado_id = " + emp.getEmpleado_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }

    public int cambiarApellido(Empleado emp) {
        String update_statement = "UPDATE EMPLEADO SET apellido = '" + emp.getApellido() + "' WHERE empleado_id = " + emp.getEmpleado_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }

    public int cambiarTelefono(Empleado emp) {
        String update_statement = "UPDATE EMPLEADO SET telefono = " + emp.getTelefono() + " WHERE empleado_id = " + emp.getEmpleado_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }

    public int cambiarTipo(Empleado emp) {
        String update_statement = "UPDATE EMPLEADO SET tipo_empleado = '" + emp.getTipo_empleado() + "' WHERE empleado_id = " + emp.getEmpleado_id();
        int numFilas = -1;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(update_statement);
            conn.close();
            fachada.closeConnection(conn);
            return numFilas;
        } catch (SQLException ex) {
            return -2;
        } catch (Exception ex) {
            return -3;
        }
    }

    public void cerrarConexionBD() {
        fachada.closeConnection(fachada.getConnection());
    }

    public int eliminarEmpleado(String id) {
        String sql_guardar;
        int numFilas = 0;
        sql_guardar = "DELETE FROM EMPLEADO WHERE empleado_id = '" + id + "';";

        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);
            System.out.println("up " + numFilas);
            return numFilas;

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public boolean esEmpleado(String cedula) {
        boolean bool = false;
        String consulta = "SELECT cedula FROM EMPLEADO WHERE cedula = " + cedula;
        try {
            Connection conn = fachada.getConnection();
            Statement sentencia = conn.createStatement();

            respuesta = sentencia.executeQuery(consulta);

            if (respuesta.next()) {
                bool = true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        return bool;
    }

    public ResultSet turnos(String ced) {

        String consulta = "SELECT man.*\n"
                + "FROM MANEJO_BUSES man, EMPLEADO emp\n"
                + "WHERE man.conductor_id = emp.empleado_id AND emp.cedula = " + ced;

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

//fin guardar
}
