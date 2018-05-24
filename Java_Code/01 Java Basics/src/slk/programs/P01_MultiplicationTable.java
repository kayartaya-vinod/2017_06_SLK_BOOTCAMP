package slk.programs;

public class P01_MultiplicationTable {

	static long factorial(int num) {
		long f = 1;

		while (num > 1) {
			f *= num; // f = f * num;
			num--;
		}
		return f;
	}

	static void printTable(int num) {
		for (int i = 1; i <= 10; i++) {
			int p = num * i;
			System.out.printf("%d * %d = %d\n", num, i, p);
			// System.out.println(num + " * " + i + " = " + p);
		}
	}

	public static void main(String[] args) {
		// printTable(17);
		System.out.printf("Factorial of %d is %d\n", 5, factorial(5));
		System.out.printf("Factorial of %d is %d\n", 7, factorial(7));
		System.out.printf("Factorial of %d is %d\n", 12, factorial(12));
	}

}









