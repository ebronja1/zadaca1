package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * This class has two methods.Its main method is evaluate
 * which evaluates input string
 * Its second method,isItValidString checks is input string valid or not
 */
public class ExpressionEvaluator {
    static Stack<Character> ops = new Stack<Character>();
    static Stack<Double> vals = new Stack<Double>();

    public ExpressionEvaluator() {
    }

    /**
     *
     * Method evaluate evaluates input
     * Accepts input string
     * returns evaluated Double number
     */
    public static Double evaluate(String s) {
        if (!isItValidString(s)) throw new RuntimeException("Invalid string!");
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals(' ')) continue;
            else if (c.equals('+')) ops.push(c);
            else if (c.equals('-')) ops.push(c);
            else if (c.equals('*')) ops.push(c);
            else if (c.equals('/')) ops.push(c);
            else if (c.equals('s')) {
                //Check is it sqrt
                String s1 = "sqrt";
                if (s.substring(i, (i + 4)).equals(s1)) {
                    ops.push(c);
                    i = i + 3;
                }
            }
            else if (c.equals(')')) {
                Character op = ops.pop();
                double v = vals.pop();
                if (op.equals('+')) v = vals.pop() + v;
                else if (op.equals('-')) v = vals.pop() - v;
                else if (op.equals('*')) v = vals.pop() * v;
                else if (op.equals('/')) v = vals.pop() / v;
                else if (op.equals('s')) v = Math.sqrt(v);
                vals.push(v);
            }
            else {
                int brojac = 0;
                while (!c.equals(' ') && !(i == s.length() - 1)) {
                    i++;
                    c = s.charAt(i);
                    brojac++;
                }
                vals.push(Double.parseDouble(s.substring(i - brojac, i)));
                Character c1 = ' ';
                if (!ops.empty()) {
                    c1 = ops.pop();
                    ops.push(c1);
                }
                if (c1.equals('s')) i++;
            }
            }
        return vals.pop();
    }

    /**
     * Method check is input string valid or not
     * Accepts input string
     * returns true if it is valid and false if it is not valid
     */
    public static boolean isItValidString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            Character c = s.charAt(i);
            Character c1 = s.charAt(i + 1);
            if (c.equals(' ') || c.equals('s') || c.equals('q') || c.equals('r')) continue;
            if (i == 0 && !c.equals('(')) return false;
            if ((c.equals('(') || c.equals(')') || c.equals('+')
               || c.equals('-') || c.equals('*') || c.equals('/') ||
                    c.equals('t')) && !c1.equals(' '))
                return false;
        }
        return true;
    }
}
