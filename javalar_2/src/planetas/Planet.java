package planetas;

// abstract class that gave rise to the planets
public abstract class Planet {

	// attributes of the planets
	protected String name;
	protected int coordenadaY;
	protected int coordenadaX;
	private int minimumLimitY;
	private int minimumLimitX;
	private int MaximumLimitY;
	private int MaximumLimitX;
	protected int speed;
	protected float rotationSpeed;
	protected float hours;
	protected String location;
	protected int age;
	protected int startingPositionX;
	protected int startingPositionY;
	protected int totalCollisionsBugs;
	private int totalCollisionsDevs;

	// constructor
	public Planet(String name) {
		
		this.name = name;
	}

	
	//  create geters and seters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getMinimumLimitY() {
		return minimumLimitY;
	}

	public void setMinimumLimitY(int minimumLimitY) {
		this.minimumLimitY = minimumLimitY;
	}

	public int getMinimumLimitX() {
		return minimumLimitX;
	}

	public void setMinimumLimitX(int minimumLimitX) {
		this.minimumLimitX = minimumLimitX;
	}

	public int getMaximumLimitY() {
		return MaximumLimitY;
	}

	public void setMaximumLimitY(int maximumLimitY) {
		MaximumLimitY = maximumLimitY;
	}

	public int getMaximumLimitX() {
		return MaximumLimitX;
	}

	public void setMaximumLimitX(int maximumLimitX) {
		MaximumLimitX = maximumLimitX;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public float getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStartingPositionX() {
		return startingPositionX;
	}

	public void setStartingPositionX(int startingPositionX) {
		this.startingPositionX = startingPositionX;
	}

	public int getStartingPositionY() {
		return startingPositionY;
	}

	public void setStartingPositionY(int startingPositionY) {
		this.startingPositionY = startingPositionY;
	}

	public int getTotalCollisionsBugs() {
		return totalCollisionsBugs;
	}

	public void setTotalCollisionsBugs(int totalCollisionsBugs) {
		this.totalCollisionsBugs = totalCollisionsBugs;
	}

	public int getTotalCollisionsDevs() {
		return totalCollisionsDevs;
	}

	public void setTotalCollisionsDevs(int totalCollisionsDevs) {
		this.totalCollisionsDevs = totalCollisionsDevs;
	}
	
	
	// method that will rotate the planets
		public float rotacionar(int instantes) {

			if (instantes > 0)
				this.hours = instantes * this.rotationSpeed;

			return hours;
		}

	// method that will translate the planets
	public void transladar(int instantes) {
		int counter = instantes * this.speed;

		if (this.speed > 0) {

			while (counter != 0) {

				if (this.coordenadaY == this.getMaximumLimitY() && this.coordenadaX != this.getMinimumLimitX()) {
					this.coordenadaX--;
					counter--;
					
				} else if (this.coordenadaX == this.getMinimumLimitX() && this.coordenadaY != this.getMinimumLimitY()) {
					this.coordenadaY--;
					counter--;
					
				} else if (this.coordenadaY == this.getMinimumLimitY() && this.coordenadaX != this.getMaximumLimitX()) {
					this.coordenadaX++;
					counter--;
					
				} else if (this.coordenadaX == this.getMaximumLimitX() && this.coordenadaY != this.getMaximumLimitY()) {
					this.coordenadaY++;
					counter--;
				}
				
				if (this.coordenadaX == this.startingPositionX && this.coordenadaY == this.startingPositionY)
					this.age++;
			}
		} else
			this.speed = 0;
	}

}
