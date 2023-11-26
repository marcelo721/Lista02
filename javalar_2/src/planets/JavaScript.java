package planets;

public class JavaScript extends Planet {

	public JavaScript(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 10;
		this.setMaximumLimitY(10);
		this.setMaximumLimitX(10);
		this.setMinimumLimitX(6);
		this.setMinimumLimitY(6);
		this.speed = 3;
		this.rotationSpeed = 10;
		this.startingPositionX = 8;
		this.startingPositionY = 10;
	}	
}
