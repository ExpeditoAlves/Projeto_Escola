package JDBC;

import java.sql.*;

public class Acesso_Banco {
    public Connection conecta(){
        
        try {        
           return DriverManager.getConnection("jdbc:mariadb://localhost:3306/Projeto_BD?user=root&password=123");
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro de conexão" +e);
        }
    }    
}
