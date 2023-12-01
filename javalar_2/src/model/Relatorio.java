package model;

import java.io.FileWriter;

public class Relatorio {

	public void escreverRelatorio(String file, String mensagem) {
		
		try {
			
		FileWriter arquivo = new FileWriter(file);
		arquivo.write(mensagem);
		arquivo.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
