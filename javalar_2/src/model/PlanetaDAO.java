package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import planetas.Planet;

public class PlanetaDAO {
	
	public void inserir(ArrayList<Planet> planetas) {
		
		try {
			
			Connection conexao = new Conexao().getConexao();
			
			PreparedStatement inserir = conexao.prepareStatement("insert into javalar "
					+ "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, "
					+ "bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,"
					+ "dev_cmais, dev_c)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
		inserir.setString(1, "Marcelo Henrique De Sousa");
		inserir.setInt(2, 553668);
		inserir.setString(3, "AE_1000.csv");
		
		
		for (int i = 0; i < planetas.size(); i++) {
			
			inserir.setInt( i + 4, planetas.get(i).getTotalCollisionsBugs());
		}
		
		for (int i = 0; i < planetas.size(); i++) {
			
			inserir.setInt(i + 11, planetas.get(i).getTotalCollisionsDevs());
		}
		
		inserir.executeUpdate();
			
			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<String[]> selecionarPlaneta(){
		
		ArrayList<String[]> dados = new ArrayList<String[]>();

		Connection conexao = new Conexao().getConexao();

		try {
			
			PreparedStatement stmt = conexao.prepareStatement("select * from javalar");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("nome");
				System.out.println(name);
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return dados;
	}	
}
