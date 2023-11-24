package controller;

// classe pai que dará origens aos bugs e devs 
public abstract class Entity {
    protected int coordenadaX;
    protected int coordenadaY;

	public Entity(int coordenadaX, int coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
}
