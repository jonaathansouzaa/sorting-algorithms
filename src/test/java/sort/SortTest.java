package sort;

import java.io.File;
import java.io.PrintWriter;

import org.junit.Test;

public class SortTest {

	@Test
	public void test() {
		int quantidade = 1000;
		int[] original = new int[quantidade];
		for (int i = 0; i < original.length; i++) {
			original[i] = (int) (Math.random() * quantidade);
		}
		
		File file = new File("/home/jonathansantos/Downloads/SortTest_100000_vetor3.csv");
		try {
			PrintWriter pw = new PrintWriter(file);
			for (int count = 0; count < original.length; count++) {
				pw.print(original[count] + ",");
			}
			pw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Arquivo gerado");
	}

}
