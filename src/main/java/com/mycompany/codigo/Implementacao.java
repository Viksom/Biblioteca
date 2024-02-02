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
    static ResultSet rs = null;
    static Connection connection = ConexaoBD.conexao("biblioteca");

    @Override
    public boolean Adicionar_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna) {
        sqlCode = "INSERT INTO Livros (Titulo, Genero,ISBN,Editora,Autor,AnoPublicacao,QuantidadeDisponivel,Numero_paginas,Nome_Prateleira,linha,coluna) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        sqlCode = "delete from livros where LivroID=" + id;
        try {
            pmt = connection.prepareStatement(sqlCode);
            pmt.executeUpdate();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }

    @Override
    public int Retorna_id_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas, String nome_pratileira, int linha, int coluna) {
        sqlCode = "SELECT LivroID from livros where Titulo = ? and Genero = ? and ISBN = ? and Editora = ? and Autor = ? and AnoPublicacao = ? and QuantidadeDisponivel = ? and Numero_paginas = ? and Nome_Prateleira = ? and linha = ? and coluna = ?";
        try {
            pmt = connection.prepareStatement(sqlCode);
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
            ResultSet rs = pmt.executeQuery();
            rs.next();
            return rs.getRow();
        } catch (SQLException ex) {
            return 0;
        }
        
    }

    @Override
    public boolean Atualizar_livro(int id, String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas, String nome_pratileira, int linha, int coluna) {
        sqlCode = "update livros set Titulo=" + titulo + ", Genero=" + genero + ",ISBN="+ isb + ",Editora=" + editora + ",Autor=" + autor + ",AnoPublicacao=" + ano + ",QuantidadeDisponivel=" + quantidade + ",Numero_paginas=" +numero_paginas+ ",Nome_Prateleira=" + nome_pratileira + ",linha=" + linha + ",coluna" + coluna + "where LivroID=" + id;
        try {
            pmt = connection.prepareStatement(sqlCode);
            pmt.executeUpdate();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean Adicionar_usuario(String nome, String endereco, String email, String telefone) {
        sqlCode = "INSERT INTO usuarios (Nome, Email,Endereco,Telefone) VALUES (?,?,?,?)";
        try { // Bloco responsavel por tentar enviar uma info na BD
            pmt = connection.prepareStatement(sqlCode);

            //(coluna, Dados_informacao)
            pmt.setString(1, nome);
            pmt.setString(2, email);
            pmt.setString(3, endereco);
            pmt.setString(4, telefone);
            
            pmt.executeUpdate();
            pmt.close();
            return true;

        } catch (SQLException ex) { // Se n funcionar recebe uma mensangem de erro dizendo que...
            return false;
        }
    }

    @Override
    public boolean Atualizar_usuario(int id, String nome, String endereco, String email, String telefone) {
        sqlCode = "update usuarios set Nome=" + nome + ", Email=" + email + ",Endereco="+ endereco + ",Telefone=" + telefone + "where UsuarioID=" + id;
        try {
            pmt = connection.prepareStatement(sqlCode);
            pmt.executeUpdate();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }

    @Override
    public int Retorna_id_usuario(String nome, String endereco, String email, String telefone) {
        sqlCode = "SELECT UsuarioID from usuarios where Nome = ? and Email = ? and Endereco = ? and Telefone = ?";
        try {
            pmt = connection.prepareStatement(sqlCode);
            pmt.setString(1, nome);
            pmt.setString(2, email);
            pmt.setString(3, endereco);
            pmt.setString(4, telefone);
            ResultSet rs = pmt.executeQuery();
            rs.next();
            return rs.getInt("UsuarioID");
        } catch (SQLException ex) {
            return 0;
        }
    }

    @Override
    public boolean Remover_usuario(int id) {
        sqlCode = "delete from usuarios where UsuarioID=" + id;
        try {
            pmt = connection.prepareStatement(sqlCode);
            pmt.executeUpdate();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }

    @Override
    public ResultSet Listar_livros(String word) {
        if("".equals(word)){
            sqlCode = "select Titulo, Genero, ISBN, Editora, Autor, AnoPublicacao, QuantidadeDisponivel, Numero_paginas, Nome_Prateleira, linha, coluna from livros";
        }
        else{
            sqlCode = "select Titulo, Genero, ISBN, Editora, Autor, AnoPublicacao, QuantidadeDisponivel, Numero_paginas, Nome_Prateleira, linha, coluna from livros where Titulo like '" +word+"%' or Autor like '" +word+"%' or Editora like '" +word+ "%'";
        }
        try {
            pmt = connection.prepareStatement(sqlCode);
            //pmt.setString(1, word);
            //pmt.setString(2, word);
            //pmt.setString(3, word);
            System.out.println("Po");
            rs = pmt.executeQuery();
            System.out.println("Po");
            return rs;
        } catch (SQLException ex) {
            return rs;
        }
    }

    @Override
    public ResultSet Listar_usuarios(String word) {
        if("".equals(word)){
            sqlCode = "select Nome, Email, Endereco, Telefone from usuarios";
        }
        else{
            sqlCode = "select Nome, Email, Endereco, Telefone from usuarios where Nome like '" +word+ "%'";
        }
        try {
            pmt = connection.prepareStatement(sqlCode);
            //pmt.setString(1, word);
            rs = pmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            return rs;
        }
    }
    
}
