import Calculator.*;

public class Main {
    public static void main(String[] args) {
      int num = 0;
      Calculator calc = new Calculator();
        if (args[0] == "add") {
          num = calc.add(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (args[0] == "subtract") {
          num = calc.subtract(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (args[0] == "multiply") {
          num = calc.multiply(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (args[0] == "divide") {
          num = calc.divide(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        } else if (args[0] == "fibonacci") {
          num = calc.fibonacciNumberFinder(Integer.parseInt(args[1]));
        } else if (args[0] == "binary") {
          num = calc.intToBinary(Integer.parseInt(args[1]));
        }
      System.out.println(num);
    }
}
