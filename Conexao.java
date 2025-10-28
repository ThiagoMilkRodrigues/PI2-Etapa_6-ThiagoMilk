package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/BitBook_DB?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "milk1967";

    public static Connection conectar() {
        Connection conn = null;
        try {
            System.out.println("🔍 Tentando carregar driver MySQL...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver carregado!");
            
            System.out.println("🔍 Tentando conectar: " + URL);
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conectado com sucesso ao MySQL!");
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver não encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Erro SQL: " + e.getMessage());
            System.err.println("❌ SQL State: " + e.getSQLState());
            System.err.println("❌ Error Code: " + e.getErrorCode());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
        
        if (conn == null) {
            System.err.println("❌❌❌ CONEXÃO É NULL! ❌❌❌");
        }
        
        return conn;
    }
}