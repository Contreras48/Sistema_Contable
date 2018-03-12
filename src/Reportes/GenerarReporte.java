/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import interfaz.VentanaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistema_contable_v.pkg1.Conexion;

/**
 *
 * @author mateo
 */
public class GenerarReporte {
    Conexion con = new Conexion();
    
    public void reporteLibroDiario(){
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile("src/Reportes/libro_diario.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.conectar());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Libro Diario");
            jv.setVisible(true);
            
            con.desconectar();
        } catch (JRException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
