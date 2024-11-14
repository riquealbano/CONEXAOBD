package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoDB.conectar();
		if (conexao != null) {
			String sql = "DELETE FROM alunos WHERE id = ?";
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.print("Digite o Id do aluno que deseja deletar: ");
				int id = scanner.nextInt();
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, id);
				
				int rowsDeleted = stmt.executeUpdate();
				
				if (rowsDeleted > 0) {
					System.out.println("Registro deleteado com sucesso");
				} else {
					System.out.println("Nenhum resgistro encontrado com o ID específicado.");
				}
			} catch (SQLException e) {
				System.err.println("Erro ao deletar dados: " + e.getMessage());
			} finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e) {
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
				scanner.close();
			}
		}
	}
}
