/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_contable_v.pkg1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class CatalogoDeCuentas {    
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    String sql = "";
    
    private int codigo;
    private int tipo;
    private String nombre;
    private String descripcion;
    private int balance;
    private double saldo;
    private int tipo_saldo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public int getTipo_saldo() {
        return tipo_saldo;
    }

    public void setTipoSaldo(int tipo_saldo) {
        this.tipo_saldo = tipo_saldo;
    }
    
    public CatalogoDeCuentas(){
        
    }
    
    public CatalogoDeCuentas(int codigo, int tipo, String nombre, int balance, String descripcion){
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.balance = balance;
        this.descripcion = descripcion;
        this.saldo = 0;
    }
    
    public void tiposDeSaldo(int tipoCuenta){
        if((tipoCuenta==1)||(tipoCuenta==6)||(tipoCuenta==7)){
            setTipoSaldo(0);
        }else{
            setTipoSaldo(1);
        }
    }
    
    public void agregarCuenta(){
        sql = "INSERT INTO Cuenta(codigo, id_tipo, nombre, balance, descripcion, saldo, tipo_saldo) VALUES('"+getCodigo()+"','"+getTipo()+"','"+getNombre()+"', '"+getBalance()+"','"+getDescripcion()+"','"+getSaldo()+"','"+getTipo_saldo()+"')";
        conexion.UID(sql);
        conexion.desconectar();
    }
    
    public int contarRegistro(String sql){
        int count = 0;
        rs = null;
        rs = conexion.getValores(sql);
        
        try {
            while(rs.next()){
               count = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CatalogoDeCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return count;
    }
    
    public Object[][] mostrarCuentas() {
        sql = "SELECT COUNT(codigo) FROM Cuenta";
        int f = contarRegistro(sql);
        
        sql = "SELECT c.codigo, t.nombre_tipo, c.nombre, b.balance, c.descripcion FROM Cuenta c INNER JOIN Tipo_Cuenta t ON c.id_tipo = t.id_tipo INNER JOIN Tipo_Balance b on c.balance = b.tipo";
        rs = null;
        rs = conexion.getValores(sql);
        Object datos[][] = new Object[f][5];
        int i = 0;
        
        try {
            while(rs.next()){
                for (int j = 0; j < 5; j++) {
                    datos[i][j] = rs.getObject(j+1);
                }
                
                i++;
            }
        } catch (SQLException ex) {            
            Logger.getLogger(CatalogoDeCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return datos;
    }
    
    public Object[] tiposCuenta(){
        sql = "SELECT COUNT(id_tipo) FROM Tipo_Cuenta";
        int f = contarRegistro(sql);
        
        sql = "SELECT nombre_tipo FROM Tipo_Cuenta";
        rs = null;
        rs = conexion.getValores(sql);
        Object tipos[] = new Object[f+1];
        tipos[0] = "---Seleccion---";
        int i = 1;
        
        try {
            while(rs.next()){
                tipos[i] = rs.getObject(1);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogoDeCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.desconectar();
        return tipos;
    }
    
    public void eliminarCuenta(int codigo){
        sql = "DELETE FROM Cuenta WHERE codigo = '"+codigo+"'";
        conexion.UID(sql);
        conexion.desconectar();
    }
    
    public void modificarCuenta(int codigo, String nombre, int balance, String descripcion){
        sql = "UPDATE Cuenta SET nombre = '"+nombre+"', balance = '"+balance+"', descripcion = '"+descripcion+"'";
        conexion.UID(sql);
        conexion.desconectar();
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
