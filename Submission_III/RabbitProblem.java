import java.util.Scanner;

public class RabbitProblem {

    // Fibonacci logic
    public static int rabbitCount(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        return rabbitCount(month - 1) + rabbitCount(month - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of months: ");
        int month = sc.nextInt();

        int result = rabbitCount(month);
        System.out.println("Number of rabbit pairs after " + month + " months: " + result);

        sc.close();
    }
}
