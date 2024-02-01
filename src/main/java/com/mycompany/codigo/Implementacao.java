/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codigo;

import java.sql.*;
/**
 *
 * @author josev
 */
public class Implementacao implements IMetodo {
    
    static PreparedStatement pmt = null;
    static String sqlCode = null;
    static Statement smtnt = null;
    static Connection connection = ConexaoBD.conexao("biblioteca");

    @Override
    public boolean Adicionar_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna) {
        try { // Bloco responsavel por tentar enviar uma info na BD
            pmt = connection.prepareStatement(sqlCode);

            //(coluna, Dados_informacao)
            pmt.setString(1, titulo);
            pmt.setString(2, genero);
            pmt.setString(3, isb);
            pmt.setString(4, editora);
            pmt.setString(5, autor);
            pmt.setInt(6,ano);
            pmt.setInt(7,quantidade);
            pmt.setInt(8,numero_paginas);
            pmt.setString(9,nome_pratileira);
            pmt.setInt(10, linha);
            pmt.setInt(11, coluna);
            
            pmt.executeUpdate();
            pmt.close();
            return true;

        } catch (SQLException ex) { // Se n funcionar recebe uma mensangem de erro dizendo que...
            return false;
        }
    }
    
    @Override
    public boolean Remover_livro(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Retorna_id_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas, String nome_pratileira, int linha, int coluna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Atualizar_livro(int id, String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas, String nome_pratileira, int linha, int coluna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Adicionar_usuario(String nome, String endereco, String email, int telefone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Atualizar_usuario(int id, String nome, String endereco, String email, int telefone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Retorna_id_usuario(String nome, String endereco, String email, int telefone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Remover_usuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
