package planets;

public class Csharp extends Planet{

	public Csharp(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 13;
		this.setMaximumLimitY(13);
		this.setMaximumLimitX(13);
		this.setMinimumLimitX(3);
		this.setMinimumLimitY(3);
		this.speed = 1;
		this.rotationSpeed = 4;
		this.startingPositionX = 8;
		this.startingPositionY = 13;
		
	}
}
