import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String expression = "1 2 + 3 *";

        double result = evaluatePostfix(expression);

        System.out.println("Expression: " + expression);
        System.out.println("Result: " + result);
    }

    public static double evaluatePostfix(String expr) {

        Stack<Double> stack = new Stack<>();

        String[] tokens = expr.split("\\s+");

        for (String token : tokens) {

            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {

                double b = stack.pop();
                double a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        return stack.pop();
    }
}