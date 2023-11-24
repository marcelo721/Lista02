package planetas;

public class Cplus_plus extends Planet{

	public Cplus_plus(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 14;
		this.setMaximumLimitY(14);
		this.setMaximumLimitX(14);
		this.setMinimumLimitX(2);
		this.setMinimumLimitY(2);
		this.speed = 2;
		this.rotationSpeed = 0.5f;
		this.startingPositionX = 8;
		this.startingPositionY = 14;
		
	}
}
