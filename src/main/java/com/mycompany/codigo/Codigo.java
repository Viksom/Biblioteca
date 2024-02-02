/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.codigo;
import java.sql.*;
/**
 *
 * @author jeova
 */
public class Codigo {
    
    public static void main(String[] args) throws SQLException {
        Implementacao teste = new Implementacao();
        System.out.println("Chegou!");
        ResultSet pegaID = teste.Listar_usuarios("");
        while(pegaID.next()) {
            System.out.println(pegaID.getString("Nome"));
            System.out.println(pegaID.getString("Email"));
            System.out.println(pegaID.getString("Endereco"));
            System.out.println(pegaID.getString("Telefone"));
        }
    }
}
