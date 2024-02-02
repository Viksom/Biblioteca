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
    
    public static void main(String[] args) {
        Implementacao teste = new Implementacao();
        System.out.println("Chegou!");
        int pegaID = teste.Retorna_id_livro("vgsfb", "g5rtdfb", "bgfbd", "brfdgb", 2001, "htyeh", 23, 23, "hyeth", 23, 23);
        System.out.println(pegaID);
    }
}
