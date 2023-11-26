package controller;

import java.util.ArrayList;

import planets.Planet;

public class Calculator {

	private int[] quantBugsQ = new int[4];
	private int[] quantDevsQ = new int[4];
	
	

	public int[] getQuantBugsQ() {
		return quantBugsQ;
	}

	public int[] getQuantDevsQ() {
		return quantDevsQ;
	}

	public void calcularArea(ArrayList<Planet> planetas) {

		for (int i = 0; i < planetas.size(); i++) {

			for (int j = i + 1; j < planetas.size(); j++) {

				int area = (Math.abs(planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY()) + 1)
						* (Math.abs(planetas.get(i).getCoordenadaX() - planetas.get(j).getCoordenadaX()) + 1);

				System.out.println("A ÁREA ENTRE " + planetas.get(i).getName() + " e " + planetas.get(j).getName()
						+ " = " + area + " UNIDADES DE ÁREA\n");
			}
		}

	}

	public void calcularDistanciaEuclidiana(ArrayList<Planet> planetas) {

		for (int i = 0; i < planetas.size(); i++) {

			for (int j = i + 1; j < planetas.size(); j++) {

				float distancia = (planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY())
						* (planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY())
						+ (planetas.get(i).getCoordenadaX() - planetas.get(j).getCoordenadaX())
								* (planetas.get(i).getCoordenadaX() - planetas.get(j).getCoordenadaX());

				distancia = (float) Math.sqrt(distancia);

				System.out.println("DISTÂNCIA ENTRE " + planetas.get(i).getName() + " E " + planetas.get(j).getName()
						+ " = " + distancia + " UNIDADES DE DISTÂNCIA \n");
			}

		}
	}

	// fórmula de shoelace
	public float cacularAreaTotal(ArrayList<Planet> planetas) {
		double soma1 = 0;
		double soma2 = 0;

		for (int i = 0; i < planetas.size() - 1; i++) {

			soma1 += planetas.get(i).getCoordenadaX() * planetas.get(i + 1).getCoordenadaY();

			soma2 += planetas.get(i).getCoordenadaY() * planetas.get(i + 1).getCoordenadaX();
		}

		soma1 += planetas.get(planetas.size() - 1).getCoordenadaX() * planetas.get(0).getCoordenadaY();
		soma2 += planetas.get(planetas.size() - 1).getCoordenadaY() * planetas.get(0).getCoordenadaX();

		float areaTotal = (float) Math.abs((soma1 - soma2) / 2);

		return areaTotal;
	}

	public void calcularQauntDevs(ArrayList<Developer> devs) {

		for (Developer dev : devs) {

			if (dev.getCoordenadaX() >= 8 && dev.getCoordenadaY() >= 8)
				quantDevsQ[0]++;

			if (dev.getCoordenadaX() <= 8 && dev.getCoordenadaY() >= 8)
				quantDevsQ[1]++;

			if (dev.getCoordenadaX() <= 8 && dev.getCoordenadaY() <= 8)
				quantDevsQ[2]++;

			if (dev.getCoordenadaX() >= 8 && dev.getCoordenadaY() <= 8)
				quantDevsQ[3]++;
		}

	}

	public void calcularQauntbugss(ArrayList<Bug> bugs) {

		for (Bug bug : bugs) {

			if (bug.getCoordenadaX() > 8 && bug.getCoordenadaY() > 8)
				quantBugsQ[0]++;

			if (bug.getCoordenadaX() < 8 && bug.getCoordenadaY() > 8)
				quantBugsQ[1]++;

			if (bug.getCoordenadaX() < 8 && bug.getCoordenadaY() < 8)
				quantBugsQ[2]++;

			if (bug.getCoordenadaX() > 8 && bug.getCoordenadaY() < 8)
				quantBugsQ[3]++;
		}
	}
}
