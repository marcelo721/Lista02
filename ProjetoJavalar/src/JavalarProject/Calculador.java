package JavalarProject;

import java.util.ArrayList;

public class Calculador {

	public void calcularArea(ArrayList<Planeta> planetas) {

		for (int i = 0; i < planetas.size(); i++) {

			for (int j = i + 1; j < planetas.size(); j++) {

				int area = (Math.abs(planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY()) + 1)
						* (Math.abs(planetas.get(i).getCordenadaX() - planetas.get(j).getCordenadaX()) + 1);

				System.out.println("A ÁREA ENTRE " + planetas.get(i).getNome() + " e " + planetas.get(j).getNome()
						+ " = " + area + " UNIDADES DE ÁREA\n");
			}
		}

	}

	public void calcularDistanciaEuclidiana(ArrayList<Planeta> planetas) {

		for (int i = 0; i < planetas.size(); i++) {

			for (int j = i + 1; j < planetas.size(); j++) {

				float distancia = (planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY())
						* (planetas.get(i).getCoordenadaY() - planetas.get(j).getCoordenadaY())
						+ (planetas.get(i).getCordenadaX() - planetas.get(j).getCordenadaX())
								* (planetas.get(i).getCordenadaX() - planetas.get(j).getCordenadaX());

				distancia = (float) Math.sqrt(distancia);

				System.out.println("DISTÂNCIA ENTRE " + planetas.get(i).getNome() + " E " + planetas.get(j).getNome()
						+ " = " + distancia + " UNIDADES DE DISTÂNCIA \n");
			}

		}
	}

	// fórmula de shoelace
	public float cacularAreaTotal(ArrayList<Planeta> planetas) {
		double soma1 = 0;
		double soma2 = 0;

		for (int i = 0; i < planetas.size() - 1; i++) {

			soma1 += planetas.get(i).getCordenadaX() * planetas.get(i + 1).coordenadaY;

			soma2 += planetas.get(i).getCoordenadaY() * planetas.get(i + 1).coordenadaX;
		}
		
		soma1 += planetas.get(planetas.size() - 1).coordenadaX * planetas.get(0).getCoordenadaY();
		soma2 += planetas.get(planetas.size() - 1).coordenadaY * planetas.get(0).getCordenadaX();

		float areaTotal = (float) Math.abs((soma1 - soma2) / 2);
		
		return areaTotal;
	}
}
