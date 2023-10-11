package JavalarProject;

import java.util.Scanner;

public class SistemaJavalar {

	public SistemaJavalar() {
		Scanner scanner = new Scanner(System.in);
		Planetario sistemajavalar = new Planetario();
		Relatorio imprimir = new Relatorio();

		InstaciarPlanetas(sistemajavalar);
		IniciarMenu(scanner, sistemajavalar, imprimir);
		scanner.close();
	}

	private void InstaciarPlanetas(Planetario sistemajavalar) {
		
		sistemajavalar.adicionarplanetas(new Python("python"));
		sistemajavalar.adicionarplanetas(new JavaScript("javascript"));
		sistemajavalar.adicionarplanetas(new Php("php"));
		sistemajavalar.adicionarplanetas(new RubyOnRails("ruby on rails"));
		sistemajavalar.adicionarplanetas(new Cplus_plus("c++"));
		sistemajavalar.adicionarplanetas(new Csharp("c#"));
		sistemajavalar.adicionarplanetas(new C("C"));
	}

	private void IniciarMenu(Scanner scanner, Planetario sistemajavalar, Relatorio imprimir) {
		int choose;
		int resp;
		int instantes;
		int maxEntidades = 0;
		int totalInstantes = 0;
		
		do {
			System.out.println("olá, seja bem vindo ao sistema javalar ");
			System.out.println("1 - iniciar \n2 - sair ");
			choose = scanner.nextInt();

		} while (choose != 1 && choose != 2);

		do {
			
			maxEntidades = inserirQuantDeBugseDevs(scanner, sistemajavalar, maxEntidades);

			System.out.println("nos informe a quantidade de instantes :");
			instantes = scanner.nextInt();
			totalInstantes = totalInstantes+ instantes;

			chamarMetodos(sistemajavalar, imprimir, instantes);
			imprimiResultados(sistemajavalar, imprimir);
			
			System.out.println("\n deseja ir mais uma rodada ? \n 1 - Sim \n2 - Não ");
			resp = scanner.nextInt();

		} while (resp == 1);
			
		imprimir.imprimirRelatorioFinal(sistemajavalar.getPlanetasLinguagens(),totalInstantes);
	
	}

	private int inserirQuantDeBugseDevs(Scanner scanner, Planetario sistemajavalar, int maxEntidades) {
		int QuantidaDebugs;
		int QuantidadeDedevs;
		
		System.out.println("digite a quantidade de bugs que deseja ter :");

		QuantidaDebugs = scanner.nextInt();
		maxEntidades = maxEntidades + QuantidaDebugs;

		if (maxEntidades < 256) {
			sistemajavalar.criarBugs(QuantidaDebugs);
			// criando a lista de devs
			
			System.out.println("nos informe a quantidade de desenvolvedores :");
			QuantidadeDedevs = scanner.nextInt();
			
			maxEntidades = maxEntidades + QuantidadeDedevs;
			
			if (maxEntidades < 256)
				sistemajavalar.criarDevs(QuantidadeDedevs);
			else 
			System.out.println("número máximo de entidades criadas\n\n");
			
		} else
			System.out.println("número máximo de entidades criadas\n\n");
		return maxEntidades;
	}
	
	private void chamarMetodos(Planetario sistemajavalar, Relatorio imprimir, int instantes) {
		sistemajavalar.moverplanetas(instantes);
		sistemajavalar.rotacionarPlanetas(instantes);
	}

	private void imprimiResultados(Planetario sistemajavalar, Relatorio imprimir) {

			imprimir.imprimirDados(sistemajavalar.getPlanetasLinguagens(), sistemajavalar.getBugsList(), sistemajavalar.getDevsList());
	}
	
}

