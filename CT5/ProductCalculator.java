import java.util.Scanner;

public class ProductCalculator {
	
	
    public static void main(String[] args) {
    	// user input
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("Product: " + product(numbers, 0));
    }

    public static int product(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }
        return numbers[index] * product(numbers, index + 1);
    }
}