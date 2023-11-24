package planetas;

public class Php extends Planet {

	public Php(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 12;
		this.setMaximumLimitY(12);
		this.setMaximumLimitX(12);
		this.setMinimumLimitX(4);
		this.setMinimumLimitY(4);
		this.speed = 2;
		this.rotationSpeed = 60;	
		this.startingPositionX = 8;
		this.startingPositionY = 12;
	}

}
