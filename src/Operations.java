package GUICalculator;

public class Operations {

    double calc(double num1, double num2, String oprtr) {
        switch(oprtr) {
            case "+" : return (num1 + num2);
            case "-" : return (num1 - num2);
            case "/" : if(num2 == 0) return 0;
                return (num1 / num2);
            case "*" : return (num1 * num2);
            case "^" : return power(num1, num2);
            default : return 0;
        }
    }
    public double power(double num1, double num2) {
        double result = 1;
        for(int i=1; i<=num2; i++) {
            result = result * num1;
        }
        return result;
    }
}
