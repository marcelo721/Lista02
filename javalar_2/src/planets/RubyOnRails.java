package planets;

public class RubyOnRails extends Planet {

	public RubyOnRails(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 11;
		this.setMaximumLimitY(11);
		this.setMaximumLimitX(11);
		this.setMinimumLimitX(5);
		this.setMinimumLimitY(5);
		this.speed = 3;
		this.rotationSpeed = 48;
		this.startingPositionX = 8;
		this.startingPositionY = 11;
	}

	
}
