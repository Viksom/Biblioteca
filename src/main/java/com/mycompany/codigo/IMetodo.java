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
    boolean Atualizar_livro(int id);
}
