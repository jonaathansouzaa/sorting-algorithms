package sort;

import org.junit.Test;

public class ShellSortTest {

	@Test
	public void testSomeLibraryMethod() {
		int quantidade = 1000;
		int[] vetor = new int[quantidade];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}
		
		long tempoInicial = System.currentTimeMillis();
		ShellSort shellSort = new ShellSort();
		shellSort.shellSort(vetor);
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("Troca: " + shellSort.getRetornaDados().get(SortKeys.KEY_TROCA));
		System.out.println("Comparações: " + shellSort.getRetornaDados().get(SortKeys.KEY_COMPARA));
	}
	
}
