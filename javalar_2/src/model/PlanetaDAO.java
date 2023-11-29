package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import planets.Planet;

public class PlanetaDAO {



	public void inserir(ArrayList<Planet> planetas, int[] bugsQ, int[] devsQ, String arquivo) {

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
			inserir.setString(3, arquivo);

			// inserir colisoes com bugs
			for (int i = 0; i < planetas.size(); i++)
				inserir.setInt(i + 4, planetas.get(i).getTotalCollisionsBugs());

			// inserir colisoes com devs
			for (int i = 0; i < planetas.size(); i++)
				inserir.setInt(i + 11, planetas.get(i).getTotalCollisionsDevs());

			// inserir a velocidade media de cada planeta
			for (int i = 0; i < planetas.size(); i++)
				inserir.setInt(i + 18, planetas.get(i).getSpeed());

			// inserir os dias passados de cada planeta
			for (int i = 0; i < planetas.size(); i++)
				inserir.setInt(i + 25, (int) Math.ceil(planetas.get(i).getHours()));

			// inserir a idade de cada planeta
			for (int i = 0; i < planetas.size(); i++)
				inserir.setInt(i + 32, planetas.get(i).getAge());

			// iserir quantidade de bugs nos quadrantes
			for (int i = 0; i < bugsQ.length; i++)
				inserir.setInt(i + 39, bugsQ[i]);

			// inserir quatidade de devs nos quadrantes
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

				String[] datas = new String[47];

				datas[0] = rs.getString("nome"); //2
				datas[1] = rs.getString("matricula");  //3
				datas[2] = rs.getString("nome_arquivo"); //4
 
				for (int i = 5; i <= 47; i++) {
					datas[i - 2] = String.valueOf(rs.getInt(i));
				}
		
			
				
				dados.add(datas);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return dados;
		
	}
}
