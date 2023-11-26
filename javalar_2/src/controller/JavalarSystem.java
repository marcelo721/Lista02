
package controller;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Arquivos;
import model.PlanetaDAO;
import planets.*;

public class JavalarSystem {

	Planetary planetary = new Planetary();
	Arquivos arquives = new Arquivos();
	Checker checker = new Checker();
	PlanetaDAO planetaDAO = new PlanetaDAO();
	Calculator calculator = new Calculator();

	private String path;

	public JavalarSystem() {

		instantiatePlanets(planetary);
	}

	private void instantiatePlanets(Planetary sistemajavalar) {

		sistemajavalar.addPlanet(new Python("python"));
		sistemajavalar.addPlanet(new JavaScript("javascript"));
		sistemajavalar.addPlanet(new RubyOnRails("ruby on rails"));
		sistemajavalar.addPlanet(new Php("php"));
		sistemajavalar.addPlanet(new Csharp("c#"));
		sistemajavalar.addPlanet(new Cplus_plus("c++"));
		sistemajavalar.addPlanet(new C("C"));
	}

	public void moverPlanetas() {

		if (arquives.getNumberOfInstants().size() >= 7) {

			for (int i = 0; i < planetary.getPlanet().size(); i++) {

				int amount = arquives.getNumberOfInstants().get(i);
				planetary.getPlanet().get(i).transladar(amount);

			}
		}

		else
			JOptionPane.showMessageDialog(null, "The file has already been fully read; please select another file.",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);

		if (arquives.getNumberOfInstants().size() > 6)
			arquives.getNumberOfInstants().subList(0, 6).clear();
	}

	public int getPlanetCoordenadaX(int indice) {
		return planetary.getPlanet().get(indice).getCoordenadaX();
	}

	public int getPlanetCoordenadaY(int indice) {
		return planetary.getPlanet().get(indice).getCoordenadaY();
	}

	public void createBubgs() {

		int quant = 0;

		if (arquives.getNumberOfBugs().size() > 0) {

			quant = arquives.getNumberOfBugs().get(0);
			checker.maximumBugsAnddevs = checker.maximumBugsAnddevs + quant;
		}

		if (checker.maximumBugsAnddevs < 256 && arquives.getNumberOfBugs().size() > 0) {

			planetary.createBugs(quant);
			arquives.getNumberOfBugs().remove(0);
		}
	}

	public void createDevs() {

		int quant = 0;

		if (arquives.getNumberOfDevs().size() > 0) {

			quant = arquives.getNumberOfDevs().get(0);
			checker.maximumBugsAnddevs = checker.maximumBugsAnddevs + quant;
		}

		if (checker.maximumBugsAnddevs < 256 && arquives.getNumberOfDevs().size() > 0) {

			planetary.createDevs(quant);
			arquives.getNumberOfDevs().remove(0);
		}
	}

	public ArrayList<Bug> getBugs() {
		return planetary.getBugsList();
	}

	public ArrayList<Developer> getDevs() {
		return planetary.getDevsList();
	}

	public void chamarMetodos() {

		checker.VerificarColisaoComBug(planetary.getBugsList(), planetary.getPlanet());
		checker.VerificarColisaoComDevs(planetary.getDevsList(), planetary.getPlanet());
		checker.verificarAlinhamento(planetary.getPlanet());
		checker.verificarLocalizacaoDoPlaneta(planetary.getPlanet());
		calculator.calcularQauntDevs(planetary.getDevsList());
		calculator.calcularQauntbugss(planetary.getBugsList());

	}

	public void escolherArquivo() {
		JFileChooser fileChooser = new JFileChooser();

		// Defina o diretório inicial para a pasta onde estão os arquivos CSV
		File initialDirectory = new File("C:\\Users\\mh047\\OneDrive\\Área de Trabalho\\Arquivos");
		fileChooser.setCurrentDirectory(initialDirectory);

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			// Associe o arquivo selecionado à string path
			path = selectedFile.getAbsolutePath();
			arquives.readArquives(path);
		}
	}

	public void enviarDados() {

		planetaDAO.inserir(planetary.getPlanet(), calculator.getQuantBugsQ(), calculator.getQuantDevsQ());
	}

	public void receberDados() {

		planetaDAO.selecionarPlaneta();
	}

	public ArrayList<Planet> getPlanets() {

		return planetary.getPlanet();
	}

	public boolean verificarPlanetasMortos() {

		for (Planet planetas : planetary.getPlanet()) {

			if (planetas.getSpeed() != 0)
				return true;
		}
		return false;
	}

}
