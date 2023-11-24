package controller;

import java.util.ArrayList;

import planetas.Planet;

public class Checker {

	private boolean alinhamento1(ArrayList<Planet> planetasLinguagens) {
		boolean verificador = false;

		for (Planet planeta : planetasLinguagens) {

			if (planeta.getCoordenadaX() == 8 && planeta.getCoordenadaY() > 8)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento2(ArrayList<Planet> planetasLinguagens) {
		boolean verificador = false;

		for (Planet planeta : planetasLinguagens) {

			if (planeta.getCoordenadaX() == 8 && planeta.getCoordenadaY() < 8)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento3(ArrayList<Planet> planetasLinguagens) {
		boolean verificador = false;
		
		for (Planet planeta : planetasLinguagens) {
			
			if (planeta.getCoordenadaY() == planeta.getMaximumLimitX() && planeta.getCoordenadaX() == planeta.getMinimumLimitY())
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento4(ArrayList<Planet> planetasLinguagens) {
		boolean verificador = false;
		for (Planet planeta : planetasLinguagens) {
			if (planeta.getCoordenadaY() == planeta.getMinimumLimitY() && planeta.getCoordenadaX() == planeta.getMinimumLimitX())
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento5(ArrayList<Planet> planetas) {
		boolean verificador = false;
		for (Planet planeta : planetas) {
			if (planeta.getCoordenadaY() == planeta.getMinimumLimitY() && planeta.getCoordenadaX() == planeta.getMaximumLimitX())
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento6(ArrayList<Planet> planetasLinguagens) {
		boolean verificador = false;
		for (Planet planeta : planetasLinguagens) {
			if (planeta.getCoordenadaY() == planeta.getMaximumLimitY() && planeta.getCoordenadaX() == planeta.getMaximumLimitX())
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	public boolean verificarAlinhamento(ArrayList<Planet> planetasLinguagens) {
		boolean v1 = alinhamento1(planetasLinguagens);
		boolean v2 = alinhamento2(planetasLinguagens);
		boolean v3 = alinhamento3(planetasLinguagens);
		boolean v4 = alinhamento4(planetasLinguagens);
		boolean v5 = alinhamento5(planetasLinguagens);
		boolean v6 = alinhamento6(planetasLinguagens);

		if (v1 == true || v2 == true || v3 == true || v4 == true || v5 == true || v6 == true)
			return true;
		else
			return false;
	}

	public void verificarLocalizacaoDoPlaneta(ArrayList<Planet> planetasLinguagens) {
		
		for (Planet planeta : planetasLinguagens) {

			if (planeta.getCoordenadaY() > 8 || planeta.getCoordenadaX() < 8)
				planeta.setLocation("NORTH");

			else if (planeta.getCoordenadaY() < 8 || planeta.getCoordenadaX() > 8)
				planeta.setLocation("SOUTH");
		}
	}

	public void VerificarColisaoComBug(ArrayList<Bug> BugList, ArrayList<Planet> PlanetasLinguagens) {
		for (Planet planeta : PlanetasLinguagens) {
			
			for (int i = 0 ; i < BugList.size() ; i ++) {

				if (planeta.getCoordenadaX() == BugList.get(i).getCoordenadaX()
						&& planeta.getCoordenadaY() == BugList.get(i).coordenadaY && planeta.getSpeed() > 0) {
					BugList.remove(i);
					planeta.setSpeed(planeta.getSpeed() - 1);
					planeta.setTotalCollisionsBugs(planeta.getTotalCollisionsBugs() + 1);
									}
			}
		}
	}

	public void VerificarColisaoComDevs(ArrayList<Developer> DevList, ArrayList<Planet> PlanetasLinguagens) {
		for (Planet planeta : PlanetasLinguagens) {
			for (int i = 0 ; i < DevList.size() ; i ++) {

				if (DevList.get(i).getCoordenadaX() == planeta.getCoordenadaX()
						&& DevList.get(i).getCoordenadaY() == planeta.getCoordenadaY() && planeta.getSpeed() > 0) {
					DevList.remove(i);
					planeta.setSpeed(planeta.getSpeed() + 1);
					planeta.setTotalCollisionsDevs(planeta.getTotalCollisionsDevs() + 1);
				}
			}
		}
	}

}
