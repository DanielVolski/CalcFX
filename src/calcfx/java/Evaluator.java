package calcfx.java;

import java.util.Stack;

public class Evaluator {
    public static Number evaluate(String expr) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length(); i++)
        {
            if (expr.charAt(i) >= '0' && expr.charAt(i) <= '9')
            {
                StringBuffer strBuf = new StringBuffer();

                while (i < expr.length() && (expr.charAt(i) >= '0' && expr.charAt(i) <= '9' || expr.charAt(i) == '.'))
                {
                    strBuf.append(expr.charAt(i));
                    i++;
                }
                
                values.push(Double.parseDouble(strBuf.toString()));

                i--;
            }

            else if (expr.charAt(i) == '(')
            {
                operators.push(expr.charAt(i));
            }

            else if (expr.charAt(i) == ')')
            {
                while (operators.peek() != '(')
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));

                operators.pop();
            }

            else if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '*' || expr.charAt(i) == '/')
            {
                while (!operators.empty() && hasPrecedence(expr.charAt(i), operators.peek()))
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                operators.push(expr.charAt(i));
            }
        }

        while (!operators.empty())
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    private static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    private static double applyOp(char operator, double n1, double n2)
    {
        switch (operator)
        {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return 0.0;
    }
}