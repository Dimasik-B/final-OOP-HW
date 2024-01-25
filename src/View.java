import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Factory factory;
    private Calculable calculator;
    private String type;


    public View() {
        this.factory = new Factory();
        this.calculator = setCalculator();
    }
    public void run(){
        while(true){
            calculate(setArguments());
            String answer = prompt();
            if(!answer.equalsIgnoreCase("y")){
                System.exit(0);
            }
        }
    }

    private String prompt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n): ");
        return scanner.nextLine();
    }

    private Calculable setCalculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose calculator (Complex or Standard): ");
        this.type = scanner.nextLine();
        return factory.choseCalc(type);
    }

    private void calculate(List<?> arguments){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operator (+, -, *, /): ");
        String operator = scanner.nextLine();
        switch (operator){
            case "+":
                calculator.sum(arguments.get(0), arguments.get(1));
                break;
            case "-":
                calculator.substract(arguments.get(0), arguments.get(1));
                break;
            case "*":
                calculator.multiply(arguments.get(0), arguments.get(1));
                break;
            case "/":
                calculator.division(arguments.get(0), arguments.get(1));
                break;
        }
        System.out.println(String.format("Result: %s", calculator.result()) );
        calculator.resetResult();
    }

    private List<?> setArguments(){
        Scanner scanner = new Scanner(System.in);
        if(type.equalsIgnoreCase("complex")){
            List<ComplexNumber> args = new ArrayList<>();
            int first;
            int second;
            System.out.println("Entering first complex number:");
            System.out.println("Enter first argument: ");
            first = scanner.nextInt();
            System.out.println("Enter second argument: ");
            second = scanner.nextInt();
            args.add(new ComplexNumber(first, second));
            System.out.println("Entering second complex number:");
            System.out.println("Enter first argument: ");
            first = scanner.nextInt();
            System.out.println("Enter second argument: ");
            second = scanner.nextInt();
            args.add(new ComplexNumber(first, second));
            return args;
        }
        else {
            List<Double> args = new ArrayList<>();
            System.out.println("Enter first argument: ");
            args.add(scanner.nextDouble());
            System.out.println("Enter second argument: ");
            args.add(scanner.nextDouble());
            return args;
        }
    }
}
