package ba.unsa.etf.rpr;

/**
 * This class has main method which parse
 * input from console from paremeter args
 * and do its validation and prints result of evaluate method
 * of ExpressionEvaluator class
 */

public class App {
    public static void main(String[] args) {
        System.out.println(ExpressionEvaluator.evaluate(args[0]));
    }
}
