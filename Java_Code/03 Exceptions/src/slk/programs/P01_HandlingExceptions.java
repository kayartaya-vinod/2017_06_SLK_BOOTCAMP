package slk.programs;

public class P01_HandlingExceptions {

	public static void main(String[] args) {

		try {
			int n, d, q;
			n = Integer.parseInt(args[0]);
			d = Integer.parseInt(args[1]);
			q = n / d;
			System.out.printf("The quotient of %d/%d is %d\n", n, d, q);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("You must pass two integers!");
		} catch (ArithmeticException e) {
			System.out.println("Are you trying to divide by zero. Not allowed!");
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		} finally {
			System.out.println("Inside the finally block. This is usually used for clean up activities.");
		}

		System.out.println("End of program!");
	}
}
