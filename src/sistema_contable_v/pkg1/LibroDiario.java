/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_contable_v.pkg1;

import interfaz.VentanaPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mateo
 */
public class LibroDiario {
    private int partida;
    private String fecha;
    private int[] codigo;
    private double[] cargo;
    private double[] abono;
    private String concepto;
    
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    String sql = "";
    
    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int[] getCodigo() {
        return codigo;
    }

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }

    public double[] getCargo() {
        return cargo;
    }

    public void setCargo(double[] cargo) {
        this.cargo = cargo;
    }

    public double[] getAbono() {
        return abono;
    }

    public void setAbono(double[] abono) {
        this.abono = abono;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
     
    public LibroDiario(int partida, String fecha,int[] codigo, double[] cargo, double[] abono, String concepto){
        this.partida = partida;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cargo = cargo;
        this.abono = abono;
        this.concepto = concepto;
    }
    
    public LibroDiario(){
        
    }
    
    public int obtenerPartida(){
        sql = "SELECT MAX(partida) FROM Libro_Diario";
        rs = null;
        rs = conexion.getValores(sql);
        
        try {
            while(rs.next()){
                setPartida(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDiario.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        conexion.desconectar();
        return getPartida() + 1;
    }
    
    public String buscar(String busqueda, String parametro){
        String resultado = ""; 
        //la variable busqueda servira para definir si se buscara el codigo o nombre de la cuenta
        //la variable parametro contendra el nombre o el codigo de la cuenta a buscar
        switch(busqueda){
            case "cuenta":
                sql = "SELECT nombre FROM Cuenta WHERE codigo = '"+parametro+"'"; 
                break;
            case "codigo":
                sql = "SELECT codigo FROM Cuenta WHERE nombre = '"+parametro+"'"; 
        }
        
        rs = null;
        rs = conexion.getValores(sql);
        
        try {
            while(rs.next()){
                resultado = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return resultado;
    }
    
    public void registarPartida(){
        //se registra la partida
        sql = "INSERT INTO Libro_Diario(partida, fecha, descripcion) VALUES('"+getPartida()+"', '"+getFecha()+"','"+getConcepto()+"')";
        conexion.UID(sql);
        conexion.desconectar();
        
        //registra detalle de la partida
        for (int i = 0; i < getCargo().length; i++) {
            sql = "INSERT INTO Detalle_Libro_Diario(partida, codigo, cargo, abono) VALUES('"+getPartida()+"','"+getCodigo()[i]+"', '"+getCargo()[i]+"', '"+getAbono()[i]+"')"; 
            conexion.UID(sql);
            conexion.desconectar();
        }
    }
    
}
