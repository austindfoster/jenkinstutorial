import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        boolean b = false;
        int num = 0;
        String bin = "";
        Calculator calc = new Calculator();
        if (Objects.equals(args[0], "add")) {
            num = calc.add(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (Objects.equals(args[0], "subtract")) {
            num = calc.subtract(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (Objects.equals(args[0], "multiply")) {
            num = calc.multiply(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (Objects.equals(args[0], "divide")) {
            num = calc.divide(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (Objects.equals(args[0], "fibonacci")) {
            num = calc.fibonacciNumberFinder(Integer.parseInt(args[1]));
        } else if (Objects.equals(args[0], "binary")) {
            bin = calc.intToBinaryNumber(Integer.parseInt(args[1]));
            System.out.println(bin);
            b = true;
        }
        if (!b) {
            System.out.println(num);
        }
    }
}