package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivos {

	String[] dados;

	protected ArrayList<Integer> numberOfInstants = new ArrayList<Integer>();
	protected ArrayList<Integer> numberOfBugs = new ArrayList<Integer>();
	protected ArrayList<Integer> numberOfDevs = new ArrayList<Integer>();

	public ArrayList<Integer> getDados() {
		return numberOfInstants;
	}

	public ArrayList<Integer> getNumberOfBugs() {
		return numberOfBugs;
	}

	public ArrayList<Integer> getNumberOfDevs() {
		return numberOfDevs;
	}

	public ArrayList<Integer> getNumberOfInstants() {
		return numberOfInstants;
	}

	public void readArquives(String pathEnter) {

		try (BufferedReader br = new BufferedReader(new FileReader(pathEnter))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				dados = line.split(",");

				Integer InstPython = Integer.parseInt(dados[1]);
				numberOfInstants.add(InstPython);

				Integer InstJavaScript = Integer.parseInt(dados[2]);
				numberOfInstants.add(InstJavaScript);

				Integer InstRuby = Integer.parseInt(dados[3]);
				numberOfInstants.add(InstRuby);

				Integer InstPhp = Integer.parseInt(dados[4]);
				numberOfInstants.add(InstPhp);

				Integer InstCsharp = Integer.parseInt(dados[5]);
				numberOfInstants.add(InstCsharp);

				Integer InstCplus = Integer.parseInt(dados[6]);
				numberOfInstants.add(InstCplus);

				Integer InstC = Integer.parseInt(dados[7]);
				numberOfInstants.add(InstC);

				Integer QuantBugs = Integer.parseInt(dados[8]);
				numberOfBugs.add(QuantBugs);

				Integer QuantDevs = Integer.parseInt(dados[9]);
				numberOfDevs.add(QuantDevs);

				line = br.readLine();

			}

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
