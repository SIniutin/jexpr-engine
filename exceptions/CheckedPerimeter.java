package expression.exceptions;

import expression.*;;

public class CheckedPerimeter extends BinaryOperation{

    public CheckedPerimeter(Operator arg1, Operator arg2) {
        super("perimeter", Precedence.LOW, Associativity.NONE, false, arg1, arg2);
    }

    private int calculate(int right, int left) {
        if (right < 0 || left < 0) {
            throw new EvaluateException("Can't evaluate perimeter from negative values:" + left + ", "+ right);
        }

        if ((right > 0 && left > Integer.MAX_VALUE - right) || 
            (right < 0 && left < Integer.MIN_VALUE - right)) {
            throw new OverflowException("Overflow: " + left + " + " + right + " is out of range.");
        }

        int sum = left + right;

        if (sum > Integer.MAX_VALUE / 2 || sum < Integer.MIN_VALUE / 2) {
            throw new OverflowException("Overflow: 2 * (" + sum + ") is out of range.");
        }

        return 2 * sum;
    }

    @Override
    public int evaluate(int x) {
        return calculate(operandFirst.evaluate(x),operandSecond.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(operandFirst.evaluate(x,y,z),operandSecond.evaluate(x,y,z));
    }
}
