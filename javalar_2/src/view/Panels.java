package view;

import javax.swing.*;
import javax.swing.border.Border;
import controller.Bug;
import controller.Developer;
import controller.JavalarSystem;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class Panels {

	// constructor
	public Panels() {
		createButtonPanel();
		createPlanetary();
	}

	JavalarSystem javalarSystem = new JavalarSystem();

	String[] planetImageNames = { "imagens/python.jpg", "imagens/javascript.jpg", "imagens/ruby.jpg", "imagens/php.jpg",
			"imagens/csharp.jpg", "imagens/cplusplus.jpg", "imagens/c.jpg" };

	// constant
	private static final int dimension_size = 16;
	private static final int NUM_PLANETS = 7;

	// panels
	protected JPanel ButtonPanel;
	protected JPanel planetary;

	// panel array
	protected ArrayList<JLabel> labels = new ArrayList<>();

	// Code area reserved for creating buttons
	Button button1 = new Button("PROCESS NEXT INSTANT");
	Button button2 = new Button("READ NEW INPUT FILE");
	Button button3 = new Button("RECORD REPORT");
	Button button4 = new Button("READ THE DATA OF OTHER PARTICIPANTS");
	Button button5 = new Button(" WRITE OUTPUT FILE");
	Button button6 = new Button("CLOSE THE JAVALAR SYSTEM");

	public void createButtonPanel() {
		ButtonPanel = new JPanel();

		// panel settings
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
		ButtonPanel.setVisible(true);
		ButtonPanel.setBackground(Color.black);
		Border EmptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		ButtonPanel.setBorder(EmptyBorder);
		Border roundBorder = BorderFactory.createLineBorder(Color.black, 10, true);
		ButtonPanel.setBorder(roundBorder);

		// will add the buttons inside the panel
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button1);
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button2);
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button3);
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button4);
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button5);
		ButtonPanel.add(Box.createVerticalStrut(10));

		ButtonPanel.add(button6);
		ButtonPanel.add(Box.createVerticalStrut(1));

		// will add an image to the panel
		ImageIcon image = new ImageIcon("Imagens/javalar_.jpg");
		JLabel label = new JLabel(image);
		ButtonPanel.add(label);

		JLabel WELCOME = new JLabel("WELCOME TO THE JAVALAR SYSTEM !");
		ButtonPanel.add(WELCOME);

		ActionlistenerButtons();
	}

	public void createPlanetary() {

		planetary = new JPanel();
		planetary.setLayout(new GridLayout(dimension_size, dimension_size));
		planetary.setBackground(Color.black);

		for (int y = dimension_size - 1; y > 0; y--) {

			for (int x = 1; x < dimension_size; x++) {

				JLabel label = new JLabel();
				label.setBackground(Color.black);
				label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				label.setOpaque(true);
				label.putClientProperty("x", x);
				label.putClientProperty("y", y);
				labels.add(label);
				planetary.add(label);
			}
		}

		// will add an image to the panel
		setPlanetImage(8, 8, "imagens/java.jpg");

		for (int i = 0; i < planetImageNames.length; i++)
			setPlanetImage(8, i + 9, planetImageNames[i]);
	}

	public void ActionlistenerButtons() {

		button1.setEnabled(false);
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				playSound();
				clearPlanetary();
				addBugsAndDevs();
				javalarSystem.checkEvents();
				removeBugsAndDevs();
				movePlanets();
				warning();
			}
		});

		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				playSound();
				javalarSystem.escolherArquivo();
				button1.setEnabled(true);
			}
		});

		button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				playSound();
				javalarSystem.ChamarMetodos2();
				javalarSystem.enviarDados();
				JOptionPane.showMessageDialog(null, "All data has been successfully sent.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		button5.setEnabled(false);
		button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				button5.setEnabled(true);
				playSound();
				javalarSystem.receberDados();
				javalarSystem.getDatas();
				JOptionPane.showMessageDialog(null, "All data has been success fully read", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				playSound();
				javalarSystem.recordReport();
				JOptionPane.showMessageDialog(null, "The report was successfully recorded.", null,
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				playSound();
				JOptionPane.showMessageDialog(null, "Thank you for using the Javalar system", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
	}

	private JLabel getPanel(int x, int y){

		for (JLabel label : labels) {
			if ((int) label.getClientProperty("x") == x && (int) label.getClientProperty("y") == y) {
				return label;
			}
		}
		return null;
	}

	private void setPlanetImage(int x, int y, String imageName) {
		JLabel label = getPanel(x, y);

		if (label != null){
			
			ImageIcon image = new ImageIcon(imageName);
			label.setIcon(image);
		}
	}

	public void playSound() {
		URL url = getClass().getResource("sound.wav");

		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}

	public void movePlanets() {
		javalarSystem.moverPlanetas();

		for (int i = 0; i < NUM_PLANETS; i++) {
			int novaCoordenadaX = javalarSystem.getPlanetCoordenadaX(i);
			int novaCoordenadaY = javalarSystem.getPlanetCoordenadaY(i);

			if (javalarSystem.getPlanets().get(i).getSpeed() > 0)
				setPlanetImage(novaCoordenadaX, novaCoordenadaY, planetImageNames[i]);
		}
	}

	public void clearPlanetary() {
		for (int i = 0; i < NUM_PLANETS; i++) {

			int coordenadaX = javalarSystem.getPlanetCoordenadaX(i);
			int coordenadaY = javalarSystem.getPlanetCoordenadaY(i);
			JLabel label = getPanel(coordenadaX, coordenadaY); // Obtém o JLabel na posição (x, y)

			if (label != null) {
				label.setIcon(null); // Remove a imagem apenas na posição do planeta antigo
			}
		}
	}

	public void addBugsAndDevs() {
		
		javalarSystem.createBubgs();

		for (Bug bugs : javalarSystem.getBugs()) {

			setPlanetImage(bugs.getCoordenadaX(), bugs.getCoordenadaY(), "Imagens/bugs.jpg");
		}

		javalarSystem.createDevs();
		for (Developer devs : javalarSystem.getDevs()) {

			setPlanetImage(devs.getCoordenadaX(), devs.getCoordenadaY(), "Imagens/DEV.png");
		}
	}

	public void removeBugsAndDevs() {

		for (Bug bugs : javalarSystem.getBugs()) {

			for (int i = 0; i < NUM_PLANETS; i++) {

				int coordenadaX = javalarSystem.getPlanetCoordenadaX(i);
				int coordenadaY = javalarSystem.getPlanetCoordenadaY(i);
				JLabel label = getPanel(coordenadaX, coordenadaY); // Obtém o JLabel na posição (x, y)

				if (bugs.getCoordenadaX() == coordenadaX && bugs.getCoordenadaY() == coordenadaY)
					label.setIcon(null); // Remove a imagem apenas na posição do planeta antigo
			}
		}

		for (Developer devs : javalarSystem.getDevs()) {

			for (int i = 0; i < NUM_PLANETS; i++) {

				int coordenadaX = javalarSystem.getPlanetCoordenadaX(i);
				int coordenadaY = javalarSystem.getPlanetCoordenadaY(i);
				JLabel label = getPanel(coordenadaX, coordenadaY); // Obtém o JLabel na posição (x, y)

				if (devs.getCoordenadaX() == coordenadaX && devs.getCoordenadaY() == coordenadaY)
					label.setIcon(null); // Remove a imagem apenas na posição do planeta antigo
			}
		}
	}

	private void warning() {
		boolean verificador = javalarSystem.verificarPlanetasMortos();
		if (verificador == false)
			JOptionPane.showMessageDialog(null,
					"Todos os planetas explodiram!, pegue sua nave e procure outro sistema planetario", "Aviso",
					JOptionPane.WARNING_MESSAGE);
	}
}
