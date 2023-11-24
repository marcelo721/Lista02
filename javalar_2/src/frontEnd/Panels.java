package frontEnd;

import javax.swing.*;
import javax.swing.border.Border;

import controller.Bug;
import controller.Checker;
import controller.Developer;
import controller.JavalarSystem;
import controller.Planetary;
import planetas.Planet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("removal")
public class Panels {

	// constructor
	public Panels() {

		createButtonPanel();
		createPlanetary();

	}

	JavalarSystem javalarSystem = new JavalarSystem();
	private static final int NUM_PLANETS = 7;
	String[] planetImageNames = { "imagens/python.jpg", "imagens/javascript.jpg", "imagens/ruby.jpg", "imagens/php.jpg",
			"imagens/csharp.jpg", "imagens/cplusplus.jpg", "imagens/c.jpg" };

	// constant
	private static final int dimension_size = 16;

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

	public void createButtonPanel() {
		ButtonPanel = new JPanel();

		// panel settings
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
		ButtonPanel.setVisible(true);
		ButtonPanel.setSize(1000, 100);
		ButtonPanel.setBackground(Color.black);
		Border EmptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		ButtonPanel.setBorder(EmptyBorder);
		Border roundBorder = BorderFactory.createLineBorder(Color.black, 10, true);
		ButtonPanel.setBorder(roundBorder);
		ButtonPanel.setVisible(true);

		// will add the buttons inside the panel
		ButtonPanel.add(Box.createVerticalStrut(20));

		ButtonPanel.add(button1);
		ButtonPanel.add(Box.createVerticalStrut(20));

		ButtonPanel.add(button2);
		ButtonPanel.add(Box.createVerticalStrut(20));

		ButtonPanel.add(button3);
		ButtonPanel.add(Box.createVerticalStrut(20));

		ButtonPanel.add(button4);
		ButtonPanel.add(Box.createVerticalStrut(20));

		ButtonPanel.add(button5);
		ButtonPanel.add(Box.createVerticalStrut(20));

		// will add an image to the panel
		ImageIcon image = new ImageIcon("Imagens/javalar_.jpg");
		JLabel label = new JLabel(image);
		ButtonPanel.add(label);

		JLabel WELCOME = new JLabel("WELCOME TO THE JAVALAR SYSTEM !");
		ButtonPanel.add(WELCOME);

		button1.setEnabled(false);
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				playSound();
				clearPlanetary();
				addBugs();
				addDevs();
				removeBugs();
				removerDevs();
				moverPlanets();
			}
		});
		
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				javalarSystem.escolherArquivo();
				button1.setEnabled(true);
				
			}
		});
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				javalarSystem.enviarDados();
			}
		});
		
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				javalarSystem.receberDados();
			}
		});

	}

	public void createPlanetary() {

		planetary = new JPanel();
		planetary.setLayout(new GridLayout(dimension_size, dimension_size));
		planetary.setBackground(Color.black);

		for (int y = dimension_size - 1; y > 0; y--) {

			for (int x = 1; x < dimension_size; x++) {

				JLabel label = new JLabel();
				label.setBackground(Color.black);
				label.setBorder(BorderFactory.createLineBorder(Color.white));
				label.setPreferredSize(new Dimension(44, 44));
				label.setOpaque(true);
				label.putClientProperty("x", x);
				label.putClientProperty("y", y);
				labels.add(label);
				planetary.add(label);
			}
		}

		setPlanetImage(8, 8, "Imagens/java.jpg");
		setPlanetImage(8, 9, "Imagens/python.jpg");
		setPlanetImage(8, 10, "Imagens/javascript.jpg");
		setPlanetImage(8, 11, "Imagens/ruby.jpg");
		setPlanetImage(8, 12, "Imagens/php.jpg");
		setPlanetImage(8, 13, "Imagens/csharp.jpg");
		setPlanetImage(8, 14, "Imagens/cpp.jpg");
		setPlanetImage(8, 15, "Imagens/c.jpg");
	}

	private JLabel getPanel(int x, int y) {

		for (JLabel label : labels) {
			if ((int) label.getClientProperty("x") == x && (int) label.getClientProperty("y") == y) {
				return label;
			}
		}
		return null;
	}

	private void setPlanetImage(int x, int y, String imageName) {

		JLabel label = getPanel(x, y);

		if (label != null) {
			ImageIcon image = new ImageIcon(imageName);
			label.setIcon(image);
		}
	}

	public void playSound() {

		URL url = getClass().getResource("sound.wav");

		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}

	public void moverPlanets() {
		javalarSystem.moverPlanetas();

		for (int i = 0; i < NUM_PLANETS; i++) {
			int novaCoordenadaX = javalarSystem.getPlanetCoordenadaX(i);
			int novaCoordenadaY = javalarSystem.getPlanetCoordenadaY(i);
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

	public void addBugs() {

		javalarSystem.createBubgs();
		for (Bug bugs : javalarSystem.getBugs()) {

			JLabel label = getPanel(bugs.getCoordenadaX(), bugs.getCoordenadaY());

			if (label != null && label.getIcon() == null)
				setPlanetImage(bugs.getCoordenadaX(), bugs.getCoordenadaY(), "Imagens/DEV.png");
		}
	}

	public void addDevs() {

		javalarSystem.createDevs();
		for (Developer devs : javalarSystem.getDevs()) {

			JLabel label = getPanel(devs.getCoordenadaX(), devs.getCoordenadaY());

			if (label != null && label.getIcon() == null)
				setPlanetImage(devs.getCoordenadaX(), devs.getCoordenadaY(), "Imagens/bugs.jpg");
		}
	}

	public void removeBugs() {

		for (Bug bugs : javalarSystem.getBugs()) {

			for (int i = 0; i < NUM_PLANETS; i++) {

				int coordenadaX = javalarSystem.getPlanetCoordenadaX(i);
				int coordenadaY = javalarSystem.getPlanetCoordenadaY(i);
				JLabel label = getPanel(coordenadaX, coordenadaY); // Obtém o JLabel na posição (x, y)

				if (bugs.getCoordenadaX() == coordenadaX && bugs.getCoordenadaY() == coordenadaY) {
					label.setIcon(null); // Remove a imagem apenas na posição do planeta antigo
				}
			}

		}
	}

	public void removerDevs() {

		for (Developer devs : javalarSystem.getDevs()) {

			for (int i = 0; i < NUM_PLANETS; i++) {

				int coordenadaX = javalarSystem.getPlanetCoordenadaX(i);
				int coordenadaY = javalarSystem.getPlanetCoordenadaY(i);
				JLabel label = getPanel(coordenadaX, coordenadaY); // Obtém o JLabel na posição (x, y)

				if (devs.getCoordenadaX() == coordenadaX && devs.getCoordenadaY() == coordenadaY) {
					label.setIcon(null); // Remove a imagem apenas na posição do planeta antigo
				}
			}

		}
	}

}
