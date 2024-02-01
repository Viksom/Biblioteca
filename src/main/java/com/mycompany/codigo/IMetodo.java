/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.codigo;

/**
 *
 * @author josev
 */
public interface IMetodo {
    boolean Adicionar_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna);
    boolean Remover_livro(int id);
    int Retorna_id_livro(String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna);
    boolean Atualizar_livro(int id, String titulo, String genero, String isb, String editora, int ano, String autor, int quantidade, int numero_paginas,String nome_pratileira, int linha, int coluna);
    
    boolean Adicionar_usuario(String nome, String endereco, String email, int telefone);
    boolean Atualizar_usuario(int id, String nome, String endereco, String email, int telefone);
    int Retorna_id_usuario(String nome, String endereco, String email, int telefone);
    boolean Remover_usuario(int id);
}
