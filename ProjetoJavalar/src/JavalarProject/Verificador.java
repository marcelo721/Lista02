package JavalarProject;

import java.util.ArrayList;

public class Verificador {

	private boolean alinhamento1(ArrayList<Planeta> planetasLinguagens) {
		boolean verificador = false;

		for (Planeta planeta : planetasLinguagens) {

			if (planeta.getCordenadaX() == 8 && planeta.getCoordenadaY() > 8)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento2(ArrayList<Planeta> planetasLinguagens) {
		boolean verificador = false;

		for (Planeta planeta : planetasLinguagens) {

			if (planeta.getCordenadaX() == 8 && planeta.getCoordenadaY() < 8)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento3(ArrayList<Planeta> planetasLinguagens) {
		boolean verificador = false;
		
		for (Planeta planeta : planetasLinguagens) {
			
			if (planeta.getCoordenadaY() == planeta.limiteMaxY && planeta.getCordenadaX() == planeta.limiteMinX)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento4(ArrayList<Planeta> planetasLinguagens) {
		boolean verificador = false;
		for (Planeta planeta : planetasLinguagens) {
			if (planeta.getCoordenadaY() == planeta.limiteMinY && planeta.getCordenadaX() == planeta.limiteMinX)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento5(ArrayList<Planeta> planetas) {
		boolean verificador = false;
		for (Planeta planeta : planetas) {
			if (planeta.getCoordenadaY() == planeta.limiteMinY && planeta.getCordenadaX() == planeta.limiteMaxX)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	private boolean alinhamento6(ArrayList<Planeta> planetasLinguagens) {
		boolean verificador = false;
		for (Planeta planeta : planetasLinguagens) {
			if (planeta.getCoordenadaY() == planeta.limiteMaxY && planeta.getCordenadaX() == planeta.limiteMaxX)
				verificador = true;
			else
				return false;
		}
		return verificador;
	}

	public boolean verificarAlinhamento(ArrayList<Planeta> planetasLinguagens) {
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

	public void verificarLocalizacaoDoPlaneta(ArrayList<Planeta> planetasLinguagens) {
		
		for (Planeta planeta : planetasLinguagens) {

			if (planeta.getCoordenadaY() > 8 || planeta.getCordenadaX() < 8)
				planeta.localizacao = "NORTE";

			else if (planeta.getCoordenadaY() < 8 || planeta.getCordenadaX() > 8)
				planeta.localizacao = "SUL";
		}
	}

	public void VerificarColisaoComBug(ArrayList<Bug> BugList, ArrayList<Planeta> PlanetasLinguagens) {
		for (Planeta planeta : PlanetasLinguagens) {
			
			for (int i = 0 ; i < BugList.size() ; i ++) {

				if (planeta.getCordenadaX() == BugList.get(i).getCoordenadaX()
						&& planeta.getCoordenadaY() == BugList.get(i).coordenadaY && planeta.velocidade > 0) {
					BugList.remove(i);
					planeta.velocidade--;
					planeta.totalColisaoBugs ++;
					
					System.out.println("O PLANETA " + planeta.getNome() + " foi atingido por um bug");
				}
			}
		}
	}

	public void VerificarColisaoComDevs(ArrayList<Desenvolvedor> DevList, ArrayList<Planeta> PlanetasLinguagens) {
		for (Planeta planeta : PlanetasLinguagens) {
			for (int i = 0 ; i < DevList.size() ; i ++) {

				if (DevList.get(i).getCoordenadaX() == planeta.getCordenadaX()
						&& DevList.get(i).getCoordenadaY() == planeta.getCoordenadaY() && planeta.velocidade > 0) {
					DevList.remove(i);
					planeta.velocidade++;
					planeta.totalColisaoDevs ++;
					System.out.println("O PLANETA " + planeta.getNome() + " foi atingido por um dev");
				}
			}
		}
	}

}
