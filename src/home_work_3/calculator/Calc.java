package home_work_3.calculator;

public class Calc {
    public static double calculate(StringBuilderWithCounter ts) {
        double value = expression(ts);
        if (ts.length() > 0) {
            System.out.println("Malformed expression starting at position " + ts.counter);
            System.exit(1);
        }
        return value;
    }

    public static double expression(StringBuilderWithCounter ts) {
        double value = multiplyingExpression(ts);
        while (ts.length() > 0 && ((ts.charAt(0) == '+' || ts.charAt(0) == '-'))) {   
            char op = ts.charAt(0);
            ts.deleteCharAt(0);
            double nextTerm = multiplyingExpression(ts);
            if (op == '+') {
                value = value + nextTerm;
            } else /* "-" */ {
                value = value - nextTerm;
            }
        }
        return value;
    }

    private static double multiplyingExpression(StringBuilderWithCounter ts) {
        double value = powExpression(ts);
        while (ts.length() > 0 && ((ts.charAt(0) == '*' || ts.charAt(0) == '/'))) {
            char op = ts.charAt(0);
            ts.deleteCharAt(0);
            double nextTerm = powExpression(ts);
            if (op == '*') {
                value = value * nextTerm;
            } else /* "/" */ {
                value = value / nextTerm;
            }
        }
        return value;
    }

    private static double powExpression(StringBuilderWithCounter ts) {
        double value = atom(ts);
        while (ts.length() > 0 && ts.charAt(0) == '^') {
            ts.deleteCharAt(0);
            double nextTerm = atom(ts);
            value = Math.pow(value, nextTerm);
        }
        return value;
    }

    private static double atom(StringBuilderWithCounter ts) {
        double value = 0;
        ts.deleteSpaces();
        if (ts.length() == 0) {
            System.out.println("Missing operand at position " + ts.counter);
            System.exit(1);
        }
        if (ts.charAt(0) == '(') {
            ts.deleteCharAt(0);
            value = expression(ts);
            // Mismatched parentheses case
            if (ts.length() == 0 || ts.charAt(0) != ')') {
                System.out.println("Mismatched parentheses.");
                System.exit(1);
            }
            ts.deleteCharAt(0);
        } else if (Character.isDigit(ts.charAt(0))) {
            value = scientific(ts);
        } else if (ts.length() >= 2 && ( ts.charAt(0) == 'P' || ts.charAt(1) == 'I' )) {
            value = Math.PI;
            ts.deleteCharAt(0);
            ts.deleteCharAt(0);
        } else {
            System.out.println("Illegal character '" + ts.charAt(0) + "' at position " + ts.counter);
            System.exit(1);
        }
        ts.deleteSpaces();
        return value;
    }

    private static double scientific(StringBuilderWithCounter ts) {
        String value = "";
        ts.deleteSpaces();
        while (ts.length() > 0 && (Character.isDigit(ts.charAt(0)) || ts.charAt(0) == '.')) {
            value += ts.charAt(0);
            ts.deleteCharAt(0);
        }
        if (ts.length() > 0 && ts.charAt(0) == 'E') {
            value += "e";
            ts.deleteCharAt(0);
            if (ts.length() == 0) {
                System.out.println("Missing power argument after 'E'.");
                System.exit(1);
            }
            if (ts.charAt(0) == '+' || ts.charAt(0) == '-') {
                value += ts.charAt(0);
                ts.deleteCharAt(0);
            }
            if (ts.length() == 0 || !Character.isDigit(ts.charAt(0))) {
                System.out.println("Missing power argument after 'E'.");
                System.exit(1);
            }
            while(ts.length() > 0 && Character.isDigit(ts.charAt(0))) {
                value += ts.charAt(0);
                ts.deleteCharAt(0);
            }
        }
        ts.deleteSpaces();
        if (ts.length() > 0 && "+-*/^)".indexOf(ts.charAt(0)) == -1) {
            System.out.println("Illegal character '" + ts.charAt(0) + "' at position " + ts.counter);
            System.exit(1);
        }
        return Double.parseDouble(value);
    }

    public static void main(String[] args) {
        String expr = args[0];
        StringBuilderWithCounter ts = new StringBuilderWithCounter(expr);
        double value = calculate(ts);
        System.out.println(expr + " = " + value);
    }
}

class StringBuilderWithCounter {
    public int counter = 1;
    public StringBuilder sb;
    public StringBuilderWithCounter(String expr) {
        sb = new StringBuilder(expr);
    }
    public void deleteCharAt(int index) {
        ++counter;
        sb.deleteCharAt(index);
    }
    public int length() {
        return sb.length();
    }
    public char charAt(int index) {
        return sb.charAt(index);
    }
    public void deleteSpaces() {
        while (sb.length() > 0 && sb.charAt(0) == ' ') {
            deleteCharAt(0);
        }
    }
}
