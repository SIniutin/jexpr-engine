package expression.exceptions;

import expression.Divide;
import expression.Operator;

public class CheckedDivide extends Divide {
    public CheckedDivide(Operator arg1, Operator arg2) {
        super(arg1, arg2);
    }

    @Override
    public int evaluate(int num) {
        int left = operandFirst.evaluate(num);
        int right = operandSecond.evaluate(num);

        if (right == 0) {
            throw new DivideByZeroException("Division by zero: " + left + " / " + right);
        }
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException("Overflow: Division of " + left + " by " + right + " is not possible.");
        }
        return left / right;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int left = operandFirst.evaluate(x, y, z);
        int right = operandSecond.evaluate(x, y, z);

        if (right == 0) {
            throw new DivideByZeroException("Division by zero: " + left + " / " + right);
        }
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException("Overflow: Division of " + left + " by " + right + " is not possible.");
        }
        return left / right;
    }
}
