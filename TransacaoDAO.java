package dao;

import model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    
    public boolean salvar(Transacao transacao) {
        String sql = "INSERT INTO Transacoes (Usuario, Tipo, Data_registro, Moeda, " +
                    "ValorInvestido, ValorNaCompra, ValorNaVenda, DataCompra, DataVenda) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, transacao.getUsuario());
            stmt.setString(2, transacao.getTipo());
            stmt.setTimestamp(3, new Timestamp(transacao.getDataRegistro().getTime()));
            stmt.setString(4, transacao.getMoeda());
            stmt.setDouble(5, transacao.getValorInvestido());
            stmt.setDouble(6, transacao.getValorNaCompra());
            stmt.setDouble(7, transacao.getValorNaVenda());
            
            if (transacao.getDataCompra() != null) {
                stmt.setTimestamp(8, new Timestamp(transacao.getDataCompra().getTime()));
            } else {
                stmt.setNull(8, Types.TIMESTAMP);
            }
            
            if (transacao.getDataVenda() != null) {
                stmt.setTimestamp(9, new Timestamp(transacao.getDataVenda().getTime()));
            } else {
                stmt.setNull(9, Types.TIMESTAMP);
            }
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar transação: " + e.getMessage());
            return false;
        }
    }
    
    public List<Transacao> listarTodas() {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM Transacoes ORDER BY Data_registro DESC";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Transacao t = new Transacao();
                t.setId(rs.getInt("ID"));
                t.setUsuario(rs.getString("Usuario"));
                t.setTipo(rs.getString("Tipo"));
                t.setDataRegistro(rs.getTimestamp("Data_registro"));
                t.setMoeda(rs.getString("Moeda"));
                t.setValorInvestido(rs.getDouble("ValorInvestido"));
                t.setValorNaCompra(rs.getDouble("ValorNaCompra"));
                t.setValorNaVenda(rs.getDouble("ValorNaVenda"));
                t.setDataCompra(rs.getTimestamp("DataCompra"));
                t.setDataVenda(rs.getTimestamp("DataVenda"));
                
                transacoes.add(t);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar transações: " + e.getMessage());
        }
        
        return transacoes;
    }
}