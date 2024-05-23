/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class conexao {
    public static Statement statement = null ;

    // String com o caminho onde está o banco de dados
    //  String URL = "jdbc:mysql://carmine:3306/2dsa_kelvin_ramalho_mercado";
        String URL = "jdbc:mysql://localhost:3306/2dsa_kelvinc_mercado";
    //Login
    //String usuario = "aluno";
        String usuario = "root";
    //Senha
  //  String senha = "etec@147";
    String senha = "root";
    // Variavel para o comando SQL
    private Statement stm = null;
    // Variavel para a conexão
    private Connection conexao = null;
  
    public void conectar() throws ClassNotFoundException, SQLException {
       
        // Carga do driver de conexão
        Class.forName("com.mysql.jdbc.Driver");
        // Fazendo a conexão
        conexao = DriverManager.getConnection(URL, usuario, senha);
        statement = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void desconectar() throws SQLException{
           
        // Fechando a conexão
        conexao.close();
    }
        public static int runSQL(String sql)
    {
     int qtdreg=0;
     try{
         qtdreg = statement.executeUpdate(sql);
         // JOptionPane.showMessageDialog(null, "Registro Processado");
     }catch(SQLException sqlex){
         System.out.println("Erro acesso ao BD" + sqlex);
         // JOptionPane.showMessageDialog(null, "Erro");
     }
        return qtdreg;    
    }
    
    public ResultSet selectSQL(String sql){
        ResultSet rs=null;
        try{
            rs = statement.executeQuery(sql);
        }catch (SQLException sqlex){
         System.out.println("Erro acesso ao BD" + sqlex);
         // JOptionPane.showMessageDialog(null, "Erro");
        }
          return rs;
    }
}
