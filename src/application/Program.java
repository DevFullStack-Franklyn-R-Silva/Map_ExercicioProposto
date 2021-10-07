package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String caminho = "C:\\temp\\in.txt";

		Map<String, Integer> votos = new LinkedHashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String linha = br.readLine();
			while (linha != null) {
				String[] campo = linha.split(",");
				String nome = campo[0];
				int contagem = Integer.parseInt(campo[1]);
				System.out.println(votos.containsKey(nome));
				if (votos.containsKey(nome)) {
					int votosAteAgora = votos.get(nome);
					votos.put(nome, contagem + votosAteAgora);
				} else {
					votos.put(nome, contagem);
				}

				linha = br.readLine();
			}
			
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
