package sort;

import java.util.HashMap;
import java.util.Map;

public class ShellSort {
	
	private Long troca;
	private Long compara;
	
	public ShellSort() {
		this.troca = 0L;
		this.compara = 0L;
	}

	public void shellSort(int vetor[]) {
		int tamanho = vetor.length;

		for (int gap = tamanho / 2; gap > 0; gap /= 2) {
			for (int contadorUm = gap; contadorUm < tamanho; contadorUm += 1) {
				int temp = vetor[contadorUm];
				int contadorDois;
				for (contadorDois = contadorUm; contadorDois >= gap && vetor[contadorDois - gap] > temp; contadorDois -= gap) {
					compara += 2;
					vetor[contadorDois] = vetor[contadorDois - gap];
					troca++;
				}
				compara++;
				vetor[contadorDois] = temp;
				troca++;
			}
		}
	}

	public Map<String, Long> getRetornaDados() {
		Map<String, Long> retornoDados = new HashMap<String, Long>();
		retornoDados.put(SortKeys.KEY_TROCA, troca);
		retornoDados.put(SortKeys.KEY_COMPARA, compara);
		return retornoDados;
	}

}