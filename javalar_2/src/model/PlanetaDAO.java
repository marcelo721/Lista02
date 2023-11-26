package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import planets.Planet;

public class PlanetaDAO {

	public void inserir(ArrayList<Planet> planetas, int[] bugsQ, int []devsQ) {

		try {

			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into javalar "
					+ "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, "
					+ "bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,"
					+ "dev_cmais, dev_c, v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			inserir.setString(1, "Marcelo Henrique De Sousa");
			inserir.setInt(2, 553668);
			inserir.setString(3, "AE_50.csv");

			for (int i = 0; i < planetas.size(); i++) 
				inserir.setInt(i + 4, planetas.get(i).getTotalCollisionsBugs());
			

			for (int i = 0; i < planetas.size(); i++) 
				inserir.setInt(i + 11, planetas.get(i).getTotalCollisionsDevs());
			
			
			for (int i = 0; i < planetas.size(); i++) 			
				inserir.setInt(i + 18, planetas.get(i).getSpeed());
			
			
			for (int i = 0; i < planetas.size(); i++) 
				inserir.setFloat(i + 25, planetas.get(i).getHours()/24);
			
			
			for (int i = 0; i < planetas.size(); i++) 
				inserir.setInt(i + 32, planetas.get(i).getAge());
			
			for (int i = 0; i < bugsQ.length; i++) 
				inserir.setInt(i + 39, bugsQ[i]);
			
			for (int i = 0; i < devsQ.length; i++)
				inserir.setInt(i + 43, devsQ[i]);

			
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<String[]> selecionarPlaneta() {

		ArrayList<String[]> dados = new ArrayList<String[]>();

		Connection conexao = new Conexao().getConexao();

		try {

			PreparedStatement stmt = conexao.prepareStatement("select * from javalar");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString("nome");
				System.out.println(name);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dados;
	}
}
