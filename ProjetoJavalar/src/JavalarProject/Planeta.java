package JavalarProject;

// classe pai que dará origem aos planetas 
public abstract class Planeta {

	// atributos dos planetas
	protected String nome;
	protected int coordenadaY;
	protected int coordenadaX;
	protected int limiteMinY;
	protected int limiteMinX;
	protected int limiteMaxY;
	protected int limiteMaxX;
	protected int velocidade;
	protected float velocidadeDeRotacao;
	protected float horas;
	protected String localizacao;
	protected int idade;
	protected int posicaoinicialX;
	protected int posicaoinicialY;
	protected int totalColisaoBugs;
	protected int totalColisaoDevs;

	// criacao dos geters e seters
	public Planeta(String nome) {

		this.nome = nome;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int getCordenadaX() {
		return coordenadaX;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCordenadaX(int cordenadaX) {

		coordenadaX = cordenadaX;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getTotalColisaoBugs() {
		return totalColisaoBugs;
	}

	public int getTotalColisaoDevs() {
		return totalColisaoDevs;
	}

	
	public float getHoras() {
		return horas;
	}

	public void setHoras(float horas) {
		this.horas = horas;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	// metodo rotacionar
	public float rotacionar(int instantes) {

		if (instantes > 0)
			this.horas = instantes * this.velocidadeDeRotacao;

		return horas;
	}

	// metodo transladar
	public void transladar(int instantes) {
		int contador = instantes * this.velocidade;

		if (this.velocidade > 0) {

			while (contador != 0) {

				if (this.coordenadaY == this.limiteMaxY && this.coordenadaX != this.limiteMinX) {
					this.coordenadaX--;
					contador--;
					
				} else if (this.coordenadaX == this.limiteMinX && this.coordenadaY != this.limiteMinY) {
					this.coordenadaY--;
					contador--;
					
				} else if (this.coordenadaY == this.limiteMinY && this.coordenadaX != this.limiteMaxX) {
					this.coordenadaX++;
					contador--;
					
				} else if (this.coordenadaX == this.limiteMaxX && this.coordenadaY != this.limiteMaxY) {
					this.coordenadaY++;
					contador--;
				}
				
				if (this.coordenadaX == this.posicaoinicialX && this.coordenadaY == this.posicaoinicialY)
					this.idade++;
			}
		} else
			this.velocidade = 0;
	}
}
