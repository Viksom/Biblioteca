/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codigo;

/**
 *
 * @author jeova
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class CRUD {

    static PreparedStatement pmtn = null;
    static String sqlCode = null;
    static Statement stmnt = null;
    static Connection connection = ConexaoBD.conexao("biblioteca");

    // Campo para inserir Dados.
    // Dados do livro
    public static void InserirdadosLivro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna ) {
        sqlCode = "INSERT INTO Livros (Titulo, Genero,ISBN,Editora,Autor,AnoPublicacao,QuantidadeDisponivel,Numero_paginas,Nome_Prateleira,linha,coluna) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try { // Bloco responsavel por tentar enviar uma info na BD
            PreparedStatement pmt = connection.prepareStatement(sqlCode);

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
            JOptionPane.showMessageDialog(null, "Dados enviado com sucesso...");

        } catch (SQLException ex) { // Se n funcionar recebe uma mensangem de erro dizendo que...
            JOptionPane.showMessageDialog(null, "Dados não enviado. Erro no: " + ex);
        }
        
    } // End dado Livro
    
    // Dados do Usuario
     public static void InserirdadosUsuario(String nome, String endereco, String email, int telefone) {
        sqlCode = "INSERT INTO usuarios (Nome,Email,Endereco, Telefone) VALUES (?,?,?,?)";

        try { // Bloco responsavel por tentar enviar uma info na BD
            PreparedStatement pmt = connection.prepareStatement(sqlCode);

            //(coluna, Dados_informacao)
            pmt.setString(1,nome);
            pmt.setString(2, endereco);
            pmt.setString(3, email);
            pmt.setInt(4, telefone);
            
            pmt.executeUpdate();
            pmt.close();
            JOptionPane.showMessageDialog(null, "Dados enviado com sucesso.");

        } catch (SQLException ex) { // Se n funcionar recebe uma mensangem de erro dizendo que...
            JOptionPane.showMessageDialog(null, "Dados não enviado. Erro no: " + ex);
        }
        
    } // End dado usuario

     
      // Dados do Emprestimo
     public static void InserirdadosEmprestimo(String DataEmprestimo, String DataDevolucao) {
        sqlCode = "INSERT INTO transacoes_emprestimo (DataEmprestimo,DataDevolucao) VALUES (?,?)";

        try { // Bloco responsavel por tentar enviar uma info na BD
            PreparedStatement pmt = connection.prepareStatement(sqlCode);

            //(coluna, Dados_informacao)
            pmt.setString(1,DataEmprestimo);
            pmt.setString(2, DataDevolucao);
            
            pmt.executeUpdate();
            pmt.close();
            JOptionPane.showMessageDialog(null, "Dados enviado com sucesso.");

        } catch (SQLException ex) { // Se n funcionar recebe uma mensangem de erro dizendo que...
            JOptionPane.showMessageDialog(null, "Dados não enviado. Erro no: " + ex);
        }
        
    } // End dado Emprestimos
     
}