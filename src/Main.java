import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        System.out.println("Welcome To Calculator App.");
        calculator();
    }

    public static void calculator(){
        Scanner scanner = new Scanner(System.in);
        double num1;
        double num2;
        double result = 0;
        char operator;

        System.out.println("Result: 0");
        System.out.print("Enter The First Number:");

        num1 = scanner.nextDouble();


        System.out.println("Select Operation By Number: ");
        System.out.println("1.[ + ]");
        System.out.println("2.[ - ]");
        System.out.println("3.[ x ]");
        System.out.println("4.[ / ]");
        System.out.println("5.[ ^ ]");

        operator = scanner.next().charAt(0);

        boolean isValidOperator =
                operator == '+'
                || operator == '-'
                || operator == 'x'
                || operator == '/'
                || operator == '^';

        if(!isValidOperator){
            System.out.print("In-valid Operator");
            return;
        }

        System.out.print("Enter The Second Number: ");

        num2 = scanner.nextInt();

        switch (operator){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case 'x' -> result = num1 * num2;
            case '/' -> {
                if(num2 == 0){
                    System.out.print("Result Cannot be Divided By 0");
                }
                result = num1 / num2;
            }
            case '^' -> result = Math.pow(num1, num2);
        }
        System.out.printf("Result: %f", result);

        reCalc(result);

        scanner.close();
    }

    public static void reCalc (double result){
        Scanner scanner = new Scanner(System.in);

        double newResult = result;
        double num2;
        char operator;

        System.out.println("Select Operation:");
        System.out.println("1.[ + ]");
        System.out.println("2.[ - ]");
        System.out.println("3.[ x ]");
        System.out.println("4.[ / ]");
        System.out.println("5.[ ^ ]");
        System.out.println("6.[ c ]");
        System.out.println("0.[ e = exit]");

        operator = scanner.next().charAt(0);

        boolean isValidOperator =
                operator == '+'
                        || operator == '-'
                        || operator == 'x'
                        || operator == '/'
                        || operator == '^'
                        || operator == 'c'
                        || operator == 'e' ;

        if(!isValidOperator){
            System.out.print("In-valid Operator");
            return;
        }

        if(operator =='e'){
            scanner.close();
            return;
        }

        if(operator == 'c'){
            calculator();
            return;
        }

        System.out.print("Enter The Second Number: ");

        num2 = scanner.nextInt();

        switch (operator){
            case '+' -> newResult = result + num2;
            case '-' -> newResult = result - num2;
            case 'x' -> newResult = result * num2;
            case '/' -> {
                if(num2 == 0){
                    System.out.print("Result Cannot be Divided By 0");
                }
                    newResult = result / num2;
            }
            case '^' -> newResult = Math.pow(result, num2);
        }
        System.out.printf("Result: %f", newResult);
        reCalc(result);

    }
}
