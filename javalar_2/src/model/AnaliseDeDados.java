package model;

import java.util.ArrayList;

public class AnaliseDeDados {

	public AnaliseDeDados(ArrayList<String[]> dados) {

		AnalisarQuantBugs(dados);
		AnalisarQuantBugs(dados);
		verificarMenorSobrevivente(dados);
		analisarQuantInserts(dados);
		verificarPlanetaMaisMortes(new int[7]);
		AlunoComMaisInserts(dados);
		verificarPlanetaMenosMortes(new int[7]);
		VerificarMaiorSobrevivente(dados);
		calcularMediaVelocidade(dados);
		calcularTotalBugs(dados);
		calcularTotalDevs(dados);
		calcularTotalHoras(dados);
		calcularTotalAnos(dados);
	}

	private String[] nameplanetas = { "python", "javascript", "ruby", "php", "cSharp", "cPlusPlus", "C" };

	public void AnalisarQuantBugs(ArrayList<String[]> dados) {

		int[] bugsPorQuadrantes = new int[4];

		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 38] != null)
					bugsPorQuadrantes[j] += Integer.parseInt(vetorAux[38 + j]);
			}
		}
	}

	public void AnalisarQuantDevs(ArrayList<String[]> dados) {

		int[] devsPorQuadrantes = new int[4];

		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 42] != null)
					devsPorQuadrantes[j] += Integer.parseInt(vetorAux[42 + j]);
			}
		}
	}

	public String verificarMenorSobrevivente(ArrayList<String[]> dados) {

		int[] quantidadeMortes = new int[7];
		for (int i = 0; i < dados.size(); i++) {

			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (Integer.parseInt(vetAux[j + 17]) == 0)
					quantidadeMortes[j]++;
			}
		}

		int indice = verificarPlanetaMaisMortes(quantidadeMortes);

		return nameplanetas[indice];
	}

	public String analisarQuantInserts(ArrayList<String[]> dados) {

		String totalDeInserts = String.valueOf(dados.size());
		System.out.println(totalDeInserts);
		return totalDeInserts;
	}

	public int verificarPlanetaMaisMortes(int[] planetas) {

		int posicaoMaior = 0;

		// Iterar sobre o vetor para encontrar a posição do maior número
		for (int i = 1; i < planetas.length; i++) {
			if (planetas[i] > planetas[posicaoMaior]) {
				posicaoMaior = i;
			}
		}

		return posicaoMaior;
	}

	public String[] AlunoComMaisInserts(ArrayList<String[]> dados) {
		ArrayList<Integer> matricula = new ArrayList<>();

		for (int i = 0; i < dados.size(); i++) {
			String[] vetorAux = dados.get(i);
			
			if(vetorAux[1] != null) {
			matricula.add(Integer.parseInt(vetorAux[1]));
			}
		}

		int maxFrequencia = 0;
		int matriculaMaisFrequente = 0;

		for (int i = 0; i < matricula.size(); i++) {
			int matriculaAtual = matricula.get(i);
			int frequenciaAtual = 1;

			for (int j = i + 1; j < matricula.size(); j++) {
				if (matriculaAtual == matricula.get(j)) {
					frequenciaAtual++;
				}
			}

			if (frequenciaAtual > maxFrequencia) {
				maxFrequencia = frequenciaAtual;
				matriculaMaisFrequente = matriculaAtual;
			}
		}

		for (int i = 0; i < dados.size(); i++) {

			String[] vetAux = dados.get(i);

			if (Integer.parseInt(vetAux[1]) == matriculaMaisFrequente) {
				String[] nomeAndMatricula = { vetAux[0], vetAux[1] };
				return nomeAndMatricula;
			}
		}
		return null;
	}

	public int verificarPlanetaMenosMortes(int[] planetas) {

		int posicaoMenor = 0;

		// Iterar sobre o vetor para encontrar a posição do maior número
		for (int i = 1; i < planetas.length; i++) {
			if (planetas[i] < planetas[posicaoMenor]) {
				posicaoMenor = i;
			}
		}

		return posicaoMenor;
	}

	public String VerificarMaiorSobrevivente(ArrayList<String[]> dados) {

		int[] quantidadeMortes = new int[7];
		for (int i = 0; i < dados.size(); i++) {

			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (Integer.parseInt(vetAux[j + 17]) == 0)
					quantidadeMortes[j]++;
			}
		}

		int indice = verificarPlanetaMenosMortes(quantidadeMortes);

		return nameplanetas[indice];

	}

	public float[] calcularMediaVelocidade(ArrayList<String[]> dados) {

		float[] planetas = new float[7];
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 18] != null)
					planetas[j] += Integer.parseInt(vetAux[38 + j]);
				;
			}
		}

		for (int i = 0; i < planetas.length; i++) {

			planetas[i] = planetas[i] / dados.size();

			System.out.println(nameplanetas[i] + " - " + planetas[i]);
		}

		return planetas;
	}

	public int calcularTotalBugs(ArrayList<String[]> dados) {

		int totalBugs = 0;
		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 38] != null)
					totalBugs += Integer.parseInt(vetorAux[38 + j]);
			}
		}
		return totalBugs;
	}

	public int calcularTotalDevs(ArrayList<String[]> dados) {

		int totalDevs = 0;
		for (int i = 0; i < dados.size(); i++) {

			String[] vetorAux = dados.get(i);

			for (int j = 0; j < 4; j++) {

				if (vetorAux[j + 42] != null)
					totalDevs += Integer.parseInt(vetorAux[42 + j]);
			}
		}

		return totalDevs;
	}

	public long calcularTotalHoras(ArrayList<String[]> dados) {

		long totalHoras = 0;
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 25] != null)
					totalHoras += Integer.parseInt(vetAux[25 + j]);

			}
		}
		System.out.println(totalHoras);
		return 0;
	}

	public long calcularTotalAnos(ArrayList<String[]> dados) {

		long totalAnos = 0;
		for (int i = 0; i < dados.size(); i++) {
			String[] vetAux = dados.get(i);

			for (int j = 0; j < 7; j++) {

				if (vetAux[j + 32] != null)
					totalAnos += Integer.parseInt(vetAux[32 + j]);

			}
		}
		System.out.println(totalAnos);
		return 0;
	}
}
