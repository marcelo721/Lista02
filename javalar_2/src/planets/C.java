package planets;

public class C extends Planet{

	public C(String name) {
		super(name);
		
		this.coordenadaX = 8;
		this.coordenadaY = 15;
		this.setMaximumLimitY(15);
		this.setMaximumLimitX(15);
		this.setMinimumLimitX(1);
		this.setMinimumLimitY(1);
		this.speed = 10;
		this.rotationSpeed = 0.1f;
		this.startingPositionX = 8;
		this.startingPositionY = 15;
	}
}
