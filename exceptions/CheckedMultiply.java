package expression.exceptions;

import expression.Multiply;
import expression.Operator;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(Operator arg1, Operator arg2) {
        super(arg1, arg2);
    }

    @Override
    public int evaluate(int num) {
        int left = operandFirst.evaluate(num);
        int right = operandSecond.evaluate(num);

        if (left > 0 && right > 0 && left > Integer.MAX_VALUE / right ||
            left > 0 && right < 0 && right < Integer.MIN_VALUE / left ||
            left < 0 && right > 0 && left < Integer.MIN_VALUE / right ||
            left < 0 && right < 0 && left < Integer.MAX_VALUE / right) {
            throw new OverflowException("Overflow: " + left + " * " + right + " is out of range.");
        }

        return left * right;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int left = operandFirst.evaluate(x, y, z);
        int right = operandSecond.evaluate(x, y, z);

        if (left > 0 && right > 0 && left > Integer.MAX_VALUE / right ||
            left > 0 && right < 0 && right < Integer.MIN_VALUE / left ||
            left < 0 && right > 0 && left < Integer.MIN_VALUE / right ||
            left < 0 && right < 0 && left < Integer.MAX_VALUE / right) {
            throw new OverflowException("Overflow: " + left + " * " + right + " is out of range.");
        }

        return left * right;
    }
}

