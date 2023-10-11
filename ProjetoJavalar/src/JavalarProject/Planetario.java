package JavalarProject;

import java.util.Random;
import java.util.ArrayList;

public class Planetario {
	Random random = new Random();

	// criação dos astros do sistema javalar
	private ArrayList<Planeta> planetasLinguagens;
	private ArrayList<Bug> bugList;
	private ArrayList<Desenvolvedor> devsList;

	// construtor
	public Planetario() {
		this.planetasLinguagens = new ArrayList<Planeta>();
		this.bugList = new ArrayList<Bug>();
		this.devsList = new ArrayList<Desenvolvedor>();
	}

	// vai preencher os ArrayLists com os astros do sistema
	public void adicionarplanetas(Planeta planetas) {
		this.planetasLinguagens.add(planetas);
	}

	public void adicionarBug(Bug bug) {
		this.bugList.add(bug);
	}

	public void adicionarDevs(Desenvolvedor dev) {
		this.devsList.add(dev);
	}

	// métodos geters
	public ArrayList<Planeta> getPlanetasLinguagens() {
		return planetasLinguagens;
	}

	public ArrayList<Desenvolvedor> getDevsList() {
		return devsList;
	}

	public ArrayList<Bug> getBugsList() {

		return bugList;
	}

	
	// métodos que serão usados no sistema javalar
	public void moverplanetas(int instantes) {
		
		for (Planeta planeta : planetasLinguagens) {
			planeta.transladar(instantes);
		}
	}

	public void rotacionarPlanetas(int instantes) {
		
		for (Planeta planeta : planetasLinguagens) {
			planeta.rotacionar(instantes);
		}
	}

	public int[] gerarPosicoes() {
		int vet[] = new int[2];
		vet[0] = random.nextInt(17);
		vet[1] = random.nextInt(17);
		return vet;
	}

	public boolean verificarPosicoesOculpadas(int vet[]) {
		
		for (Bug bug : bugList) {
			if (vet[0] == bug.getCoordenadaX() && vet[1] == bug.getCoordenadaY())
				return false;
		}
		for (Desenvolvedor dev : devsList) {
			if (vet[0] == dev.getCoordenadaX() && vet[1] == dev.getCoordenadaY())
				return false;
		}
		return true;
	}

	public void criarBugs(int quantidades) {

		int[] vetPosicoes = new int[2];
		for (int i = 0; i < quantidades; i++) {
			do {
				vetPosicoes = (gerarPosicoes());
			} while (!verificarPosicoesOculpadas(vetPosicoes));

			bugList.add(new Bug(vetPosicoes[0], vetPosicoes[1]));
		}
	}

	public void criarDevs(int quantidades) {

		int[] vetPosicoes = new int[2];
		for (int i = 0; i < quantidades; i++) {
			do {
				vetPosicoes = (gerarPosicoes());
			} while (!verificarPosicoesOculpadas(vetPosicoes));

			devsList.add(new Desenvolvedor(vetPosicoes[0], vetPosicoes[1]));
		}
	}

}