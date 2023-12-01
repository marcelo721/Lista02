package controller;

import java.util.Random;

import planets.Planet;

import java.util.ArrayList;

public class Planetary {
	Random random = new Random();

	// creation of the stars of the javalar system
	private ArrayList<Planet> planets;
	private ArrayList<Bug> bugList;
	private ArrayList<Developer> devsList;

	// constructor
	public Planetary() {
		this.planets = new ArrayList<Planet>();
		this.bugList = new ArrayList<Bug>();
		this.devsList = new ArrayList<Developer>();
	}

	// will fill the ArrayLists with the stars of the system
	public void addPlanet(Planet planetas) {
		this.planets.add(planetas);
	}

	public void addBug(Bug bug) {
		this.bugList.add(bug);
	}

	public void addDev(Developer dev) {
		this.devsList.add(dev);
	}

	// getter methods
	public ArrayList<Planet> getPlanet() {
		return planets;
	}

	public ArrayList<Developer> getDevsList() {
		return devsList;
	}

	public ArrayList<Bug> getBugsList() {

		return bugList;
	}

	// methods that will be used in the javar system

	public void rotatePlanets(int instantes) {

		for (Planet planeta : planets) {
			planeta.rotacionar(instantes);
		}
	}

	public int[] createPositions() {
		int vet[] = new int[2];
		vet[0] = random.nextInt(16) + 1;
		vet[1] = random.nextInt(16) + 1;
		return vet;
	}

	public boolean checkOccupiedPositions(int vet[]) {

		for (Bug bug : bugList) {
			if (vet[0] == bug.getCoordenadaX() && vet[1] == bug.getCoordenadaY())
				return false;
		}
		for (Developer dev : devsList) {
			if (vet[0] == dev.getCoordenadaX() && vet[1] == dev.getCoordenadaY())
				return false;
		}
		return true;
	}

	public void createBugs(int quantity) {

		int[] positionvector = new int[2];
		for (int i = 0; i < quantity; i++) {
			do {
				positionvector = (createPositions());
			} while (!checkOccupiedPositions(positionvector));

			 if (positionvector[0] != 8 || positionvector[1] != 8)
			bugList.add(new Bug(positionvector[0], positionvector[1]));
		}
	}

	public void createDevs(int quantity) {

		int[] positionVector = new int[2];
		for (int i = 0; i < quantity; i++) {
			do {
				positionVector = (createPositions());
			} while (!checkOccupiedPositions(positionVector));

			if (positionVector[0] !=  8 || positionVector[1] != 8)
				devsList.add(new Developer(positionVector[0], positionVector[1]));
		}
	}

}