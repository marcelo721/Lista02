package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivos {

	String[] dados;

	protected ArrayList<Integer> numberInstants = new ArrayList<Integer>();
	protected ArrayList<Integer> numberBugs = new ArrayList<Integer>();
	protected ArrayList<Integer> numberDevs = new ArrayList<Integer>();

	public ArrayList<Integer> getNumberOfBugs() {
		return numberBugs;
	}

	public ArrayList<Integer> getNumberOfDevs() {
		return numberDevs;
	}

	public ArrayList<Integer> getNumberOfInstants() {
		return numberInstants;
	}

	public void readArquives(String pathEnter) {

		try (BufferedReader br = new BufferedReader(new FileReader(pathEnter))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				dados = line.split(",");

				for (int i = 1; i < 7; i++) {
					
					Integer instants = Integer.parseInt(dados[i]);
					numberInstants.add(instants);
				}
				
				Integer QuantBugs = Integer.parseInt(dados[8]);
				numberBugs.add(QuantBugs);

				Integer QuantDevs = Integer.parseInt(dados[9]);
				numberDevs.add(QuantDevs);

				line = br.readLine();
			}

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
