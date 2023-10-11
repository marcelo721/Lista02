package JavalarProject;

public class C extends Planeta{

	public C(String nome) {
		super(nome);
		
		this.coordenadaX = 8;
		this.coordenadaY = 15;
		this.limiteMaxX = 15;
		this.limiteMaxY = 15;
		this.limiteMinX = 1;
		this.limiteMinY = 1;
		this.velocidade = 10;
		this.velocidadeDeRotacao = 0.1f;
		this.posicaoinicialX = 8;
		this.posicaoinicialY = 15;
	}
}
