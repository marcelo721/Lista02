package planetas;

public class Python extends Planet {

	public Python(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 9;
		this.setMaximumLimitY(9);
		this.setMaximumLimitX(9);
		this.setMinimumLimitX(7);
		this.setMinimumLimitY(7);
		this.speed = 4;
		this.rotationSpeed = 24.0f;
		this.startingPositionX = 8;
		this.startingPositionY = 9;
	}
}
