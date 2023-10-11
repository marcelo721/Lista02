package JavalarProject;

import java.util.ArrayList;

public class Relatorio {
	
	Verificador verificador = new Verificador();
	Calculador distanciaseEAreas = new Calculador();
	Caracteristicas caracteristicas = new Caracteristicas();

	// método que será chamado enquanto o código estiver em execução
	public void imprimirDados(ArrayList<Planeta> planetas, ArrayList<Bug> bugList, ArrayList<Desenvolvedor> devsList) {

		// verificar e imprimir a localizacao dos planetas linguagens
		verificador.verificarLocalizacaoDoPlaneta(planetas);

		// vai verificar se os planetas estao alinhados e imprimir o resultado
		boolean teste = verificador.verificarAlinhamento(planetas);
		System.out.println("--------------------------------");
		if (teste == true)
			System.out.println(" os planetas estao alinhados ");

		else
			System.out.println(" os planetas nao estao alinhados");
		System.out.println("--------------------------------\n");

		// vai exibir os planetas atingidos por bugs
		System.out.println("\nPLANETAS ATINGIDOS POR BUGS : \n");
		verificador.VerificarColisaoComBug(bugList, planetas);

		// vai exibir os planetas atingidos por desenvolvedores
		System.out.println("\nPLANETAS ATINGIDOS POR DESENVOLVEDORES :\n");
		verificador.VerificarColisaoComDevs(devsList, planetas);

		// relatorio que sera imprimido enquando o aloritmo estiver em execução
		System.out.println("\n\n***********************************");
		System.out.println("RELATÓRIO PARCIAL DOS PLANETAS ");
		System.out.println("***********************************");

		// relatório final dos planetas
		for (Planeta planeta : planetas) {

			if (planeta.velocidade > 0) {

				System.out.println("\n--------------" + planeta.getNome() + "----------------");
				System.out.println("POSIÇÃO : ( " + planeta.getCordenadaX() + " , " + planeta.getCoordenadaY() + " )");
				System.out.println("velocidade de translação : " + planeta.getVelocidade() + " Unidades/instantes");
				System.out.println("Horas passadas : " + planeta.getHoras());
				System.out.println("Dias passados : " + planeta.getHoras() / 24);
				System.out.println("Anos passados : " + planeta.getIdade());
				System.out.println("localização : " + planeta.getLocalizacao());

			} else if (planeta.velocidade <= 0)
				System.out.println("\no planeta " + planeta.getNome() + " foi morto pelos bugs \n");
		}

		System.out.println("\n----------------------------------");
		System.out.println("didstância parcial entre os planetas");
		System.out.println("------------------------------------\n");

		distanciaseEAreas.calcularDistanciaEuclidiana(planetas);
		
		System.out.println("\n-------------------------------");
		System.out.println("Área parcial entre os planetas");
		System.out.println("-------------------------------\n");
		
		distanciaseEAreas.calcularArea(planetas);

	}

	// metodo que será chamado após o usuário encerar o progama
	public void imprimirRelatorioFinal(ArrayList<Planeta> planetas, int totalInstantes) {
		
		System.out.println("NUMERO DE INSTANTES SOLICITADOS :" + totalInstantes);
	
		System.out.println("\nRELATÓRIO FINAL DOS PLANETAS :\n");

		for (Planeta planeta : planetas) {
			System.out.println("=============" + planeta.getNome() + "==============");
			System.out.println("POSIÇÃO FINAL : (" + planeta.getCordenadaX() + " , " + planeta.getCoordenadaY() + " )");
			System.out.println("VELOCIDADE DE TRANSLAÇÃO FINAL : " + planeta.getVelocidade() + " Unidades/instantes");
			System.out.println("TOTAL DE HORAS PASSADAS : " + planeta.getHoras());
			System.out.println("TOTAL DE DIAS PASSADOS : " + planeta.getHoras() / 24);
			System.out.println("TOTAL DE ANOS PASSADOS : " + planeta.getIdade());
			System.out.println("LOCALIZAÇÃO FINAL :" + planeta.getLocalizacao());
			System.out.println("TOTAL DE BUGS COLIDIDOS :" + planeta.getTotalColisaoBugs());
			System.out.println("TOTAL DE DESENVOLVEDORES COLIDIDOS :" + planeta.getTotalColisaoDevs() + "\n");
		}

		// irá printar a distancia final entre os planetas
		System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
		System.out.println("\n DISTÂNCIA FINAL ENTRE OS PLANETAS  \n");
		System.out.println("\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");	
		distanciaseEAreas.calcularDistanciaEuclidiana(planetas);
		
		// irá printar a area total  formada pela posicao dos planetas 
		System.out.println("\nÁREA TOTAL FORMADA PELOS PLANETAS = ");
		System.out.println(distanciaseEAreas.cacularAreaTotal(planetas) + " UNIDADES DE ÁREA \n");
		
		// irá printar a área formada entre cada planeta 
		System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
		System.out.println("\n ÁREA FINAL ENTRE OS PLANETAS  \n");
		System.out.println("\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
		distanciaseEAreas.calcularArea(planetas);

		System.out.println("\nCURIOSIDADES SOBRE OS PLANETAS LINGUAGENS :\n");
		caracteristicas.imprimirCaracteristicas();

	}
}
