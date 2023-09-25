package Lista02;

public class Utilidades {

	// questao 01
	public int Somatorio(int vetor[]) {

		int soma = 0;

		for (int i = 0; i < vetor.length; i++) {

			soma += vetor[i];
		}

		return soma;
	}

	// questao 02
	public void NumerosPares(int number) {

		for (int i = number; i <= 0; i--) {

			if (i % 2 == 0) {

				System.out.println(i);
			}
		}
	}

	// questao 03
	public int Media(int vet1[], int vet2[]) {

		int soma = 0;
		int media = 0;

		for (int i = 0; i < vet1.length; i++) {

			soma = soma + vet1[i];
		}

		for (int i = 0; i < vet2.length; i++) {

			soma = soma + vet2[i];
		}

		media = soma / (vet1.length + vet2.length);

		return media;
	}

	// questao 04
	public int MediaPonderada(int vector1[], int VetorPesos[]) {

		int soma = 0;

		int SomaPesos = 0;

		for (int i = 0; i < VetorPesos.length; i++) {

			soma += (vector1[i] * VetorPesos[i]);
			SomaPesos += VetorPesos[i];
		}

		return (soma / SomaPesos);
	}

	// questao 05
	public int ContagemDeElementos(int vector1[], int vector2[], int number) {

		int contador = 0;

		for (int i = 0; i < vector2.length; i++) {

			if (vector2[i] == number) {

				contador++;
			}
		}

		for (int i = 0; i < vector1.length; i++) {

			if (vector1[i] == number) {

				contador++;
			}
		}

		return contador;
	}

	// questao 06
	public int[] CopiaDeVetor(int vetorteste[]) {

		int vetcopia[] = new int[vetorteste.length];

		for (int i = 0; i < vetorteste.length; i++) {

			vetcopia[i] = vetorteste[i];
		}

		return vetcopia;
	}

	// questao 07
	public int[] OrndenacaoCrescente(int vet[]) {

		for (int i = 0; i < vet.length; i++) {

			for (int j = 0; j < vet.length; j++) {

				if (vet[i] < vet[j]) {

					int aux = vet[j];
					vet[j] = vet[i];
					vet[i] = aux;
				}
			}
		}
		return vet;
	}

	// questao 08

	public boolean VerificarOrdenacao(int vet[]) {

		boolean teste = false;

		for (int i = 0; i < vet.length - 1; i++) {

			if (vet[i] > vet[i + 1]) {

				teste = false;

			} else {

				teste = true;
			}
		}

		return teste;
	}

	// questao 09

	public int MaiorValorK(int vet[], int K) {

		if (K > vet.length) {

			return 0;

		} else {

			for (int i = 0; i < vet.length; i++) {

				for (int j = 0; j < vet.length; j++) {

					if (vet[i] < vet[j]) {

						int aux = vet[j];
						vet[j] = vet[i];
						vet[i] = aux;
					}
				}
			}
		}
		return vet[K - 1];
	}

	// questao 10
	public int MenorValorK(int vet[], int K) {

		if (K > vet.length) {

			return 0;

		} else {

			for (int i = 0; i < vet.length; i++) {

				for (int j = 0; j < vet.length; j++) {

					if (vet[i] > vet[j]) {

						int aux = vet[j];
						vet[j] = vet[i];
						vet[i] = aux;
					}
				}
			}
		}
		return vet[K - 1];
	}

	// questao 11

	public boolean VerificadorDeIgualdade(int vetA[], int vetB[]) {

		if (vetA.length == vetB.length) {

			for (int i = 0; i < vetB.length; i++) {

				if (vetA[i] != vetB[i]) {

					return false;

				} else {

					return true;
				}
			}
		}
		return false;
	}
	
	public float potenciacao(int base , int potencia ) {
		
		float auxiliar = base;
		
		if(potencia == 0 ) {
			
			return 1;
			
		} else if(potencia  > 0 ) {
			
			for (int i = 2; i <= potencia ; i++) {
				
				auxiliar *= base;
			}
			
		} else if(potencia < 0) {
			
			for (int i = 2; i <= - potencia ; i++) {
							
				auxiliar *= base;	
			}
			return  1.0f / auxiliar;
		}
		return auxiliar;
	} 
	
	public  boolean Primo(int numero) {
        
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; 
            }
        }

        return true; 
    }
	
	public int[] BuscaPorOcorrencias(int vet1[], int vet2[]) {
		
		int vet3[] = new int[vet2.length];
		
		for (int i = 0; i < vet1.length; i++) {
			
			for (int j = 0; j < vet2.length; j++) {
				
				if(vet1[i] == vet2[j])
					vet3[i] = vet1[i];		
			}
		}
		
		return vet3;
	}
	
	public int[] RemocaoDeElemento(int vet[], int number) {
		
		for (int i : vet) {
			
			if(vet[i] == number)
				vet[i]++;
		}
		
		int NovoVetor[] = vet;
		
		return  NovoVetor;
	}
	
	
	 public  boolean Palindromo(String str) {
	        
	        str = str.replaceAll("\\s+", "").toLowerCase();

	        int esquerda = 0;
	        int direita = str.length() - 1;

	        while (esquerda < direita) {
	            if (str.charAt(esquerda) != str.charAt(direita)) {
	                return false; 
	            }
	            esquerda++;
	            direita--;
	        }

	        return true;
	    }
	
	 public String inverterString(String str) {
	        StringBuilder reversed = new StringBuilder();

	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed.append(str.charAt(i));
	        }

	        return reversed.toString();
	    }
	
	 public static double calcularJurosCompostos(double Vi, double tx, int periodo) {
	       
	        if (tx > 1.0) {
	            tx = tx / 100.0;
	        }
	        
	        double montante = Vi * Math.pow(1 + tx, periodo);
	        return montante;
	    }
	 
	  public  boolean NumeroPerfeito(int numero) {
	        
	        if (numero <= 1) {
	            return false;
	        }

	        int somaDivisores = 0;

	        for (int i = 1; i < numero; i++) {
	            if (numero % i == 0) {
	                somaDivisores += i;
	            }
	        }

	        return somaDivisores == numero;
	    }
	
	  
	  public int[] diminuirvetor(int number) {
		  
		  int vector[] = new int[number];
		  vector[0] = number;
		  for (int i = number - 1; i < 1; i--) {
			
			  vector[i] = i;
		}
		  
		  return vector;
	  }
}
