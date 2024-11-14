package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                // Inserir primeiro registro
                stmt.setString(1, "Yuri Alberto");
                stmt.setInt(2, 23);
                stmt.executeUpdate();

                // Inserir segundo registro
                stmt.setString(1, "Hugo Neneca");
                stmt.setInt(2, 22);
                stmt.executeUpdate();

                // Inserir terceiro registro
                stmt.setString(1, "Memphis Depay");
                stmt.setInt(2, 32);
                stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            } finally {
                try {
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}
