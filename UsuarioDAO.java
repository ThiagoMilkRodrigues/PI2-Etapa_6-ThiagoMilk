package dao;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    
    public boolean autenticar(String nome, String senha) {
        String sql = "SELECT * FROM Usuarios WHERE Nome = ? AND Senha = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se encontrou usuário
            
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (Nome, Senha) VALUES (?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
}