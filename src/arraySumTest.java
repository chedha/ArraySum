import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.Test;

class arraySumTest {

	@Test
	public void testArraySum() {

		int[] arr = new int[200000000];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10) + 1;
		}

		singleSum test = new singleSum();

		long start = System.currentTimeMillis();
		int output = test.sum(arr);
		System.out.println("Single sum time: " + (System.currentTimeMillis() - start + "ms")); // single time

		System.out.println();

		start = System.currentTimeMillis();
		int pOutput = ParallelSum.parallelArraySum(arr);
		System.out.println("Parallel sum time: " + (System.currentTimeMillis() - start) + "ms"); // parallel time

		assertEquals(pOutput, output);

	}

}
