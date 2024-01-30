package com.mycompany.codigo;

import java.sql.*;
public class ConexaoBD {
    public static Connection conexao(String nome){
         Connection conexao = null;
         
         try{
          
              
         Class.forName("com.mysql.cj.jdbc.Driver");
         conexao =  DriverManager.getConnection("jdbc:mysql://localhost/"+nome,"root","");
        
             System.out.println("Conexao bem bucedida Com a Base de dados "+nome);
         }
         catch(Exception ex){
         System.out.println("Nao Houve Conexao Por causa do Erro: "+ex);
         }
         
         return conexao;
    
    }
}
