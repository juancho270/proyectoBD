/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import accesoDatos.DAOReportes;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camilojosé
 */
public class ControladorReportes {

    DAOReportes daoReportes;
    
    public ControladorReportes() {
        daoReportes = new DAOReportes();
    }
    
    public void reporteF(DefaultTableModel modelo, String fecha){
        try {
            
            System.out.println("Entro");
            ResultSet rs = daoReportes.reporte3(fecha);
            
            ResultSetMetaData metadatos = rs.getMetaData();

            //limpiar valores del modelo si existen
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            
            int numCol = metadatos.getColumnCount();
            Object[] nombCol = new Object[numCol];

            //nombres de las etiquetas de las columnas de la consulta
            for (int i = 0; i < nombCol.length; i++) {
                nombCol[i] = metadatos.getColumnName(i + 1);
            }

            //coloca los datos del Resulset en el DefaultTableModel
            modelo.setColumnIdentifiers(nombCol);
            while (rs.next()) {
                Object[] datosFila = new Object[numCol];
                //se sacan los datos de cada fila del rs
                for (int i = 0; i < datosFila.length; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                //se añade la fila al modelo del table
                modelo.addRow(datosFila);
            }            
        } catch (SQLException ex) {
            System.out.println("error al saar la información del resultset");
            
        }
    
    }
    
    public void reportes(DefaultTableModel modelo, int numR) {
        try {
            
            System.out.println("Entro");
            ResultSet rs = null;
            if (numR == 1) {
                rs = daoReportes.reporte1();
            } else if (numR == 2) {
                rs = daoReportes.reporte2();
            } else if (numR == 4) {
                rs = daoReportes.reporte4();
            } else if (numR == 5) {
                rs = daoReportes.reporte5();
            } else if (numR == 6) {
                rs = daoReportes.reporte6();
            } else if (numR == 7) {
                rs = daoReportes.reporte7();
            }
            
            ResultSetMetaData metadatos = rs.getMetaData();

            //limpiar valores del modelo si existen
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            
            int numCol = metadatos.getColumnCount();
            Object[] nombCol = new Object[numCol];

            //nombres de las etiquetas de las columnas de la consulta
            for (int i = 0; i < nombCol.length; i++) {
                nombCol[i] = metadatos.getColumnName(i + 1);
            }

            //coloca los datos del Resulset en el DefaultTableModel
            modelo.setColumnIdentifiers(nombCol);
            while (rs.next()) {
                Object[] datosFila = new Object[numCol];
                //se sacan los datos de cada fila del rs
                for (int i = 0; i < datosFila.length; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                //se añade la fila al modelo del table
                modelo.addRow(datosFila);
            }            
        } catch (SQLException ex) {
            System.out.println("error al saar la información del resultset");
            
        }
    }
}
