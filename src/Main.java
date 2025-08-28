import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    protected static boolean isRunning = true;

    public static void main(String[] args) {
        calcApp();
    }

    protected static void calcApp() {
        System.out.println("Welcome To Calculator App.");
        while (isRunning) {
            double num1;
            double num2;
            double result = 0;
            String operator;

            System.out.printf("Result: %.1f\n", result);

            System.out.print("Enter The First Number:");

            num1 = scanner.nextDouble();

            System.out.println("Select Operation:");
            System.out.println("( + ) , ( - ) , ( * ) , ( / ) , ( ^ )");
            System.out.println("( c = clear ) , ( e = exit ) ");

            operator = scanner.nextLine().trim();

            System.out.print("Enter The Second Number: ");

            num2 = scanner.nextDouble();

            calculate(num1, num2, operator);
        }
    }

    public static void calculate(double num1, double num2, String operator) {
        double result = 0;


        boolean isValidOperator = "+ - * / ^ c e".contains(operator);

        if (!isValidOperator) {
            System.out.print("In-valid Operator");
            calcApp();
            return;
        }

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "x" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.print("Result Cannot be Divided By 0");
                    calcApp();
                }
                result = num1 / num2;
            }
            case "^" -> result = Math.pow(num1, num2);
        }

        System.out.printf("Result: %f", result);

        reCalc(result);
    }

    public static void reCalc(double result) {

        double newResult = result;
        double num2;
        String operator;

        System.out.println("Select Operation:");
        System.out.println("( + ) , ( - ) , ( * ) , ( / ) , ( ^ )");
        System.out.println("( c = clear ) , ( e = exit ) ");

        operator = scanner.nextLine().trim();

        boolean isValidOperator = "+ - * / ^ c e".contains(operator);

        if (!isValidOperator) {
            System.out.print("In-valid Operator");
            return;
        }

        if (operator.equals("e")) {
            isRunning = false;
            return;
        }

        if (operator.equals("c")) {
            calcApp();
            return;
        }

        System.out.print("Enter The Second Number: ");

        num2 = scanner.nextDouble();

        switch (operator) {
            case "+" -> newResult = result + num2;
            case "-" -> newResult = result - num2;
            case "x" -> newResult = result * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.print("Result Cannot be Divided By 0");
                }
                newResult = result / num2;
            }
            case "^" -> newResult = Math.pow(result, num2);
        }

        System.out.printf("Result: %f", newResult);

        reCalc(newResult);

    }
}
