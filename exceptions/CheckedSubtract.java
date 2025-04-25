package expression.exceptions;

import expression.Subtract;
import expression.Operator;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(Operator arg1, Operator arg2) {
        super(arg1, arg2);
    }

    @Override
    public int evaluate(int num) {
        int left = operandFirst.evaluate(num);
        int right = operandSecond.evaluate(num);

        if ((right > 0 && left < Integer.MIN_VALUE + right) || 
            (right < 0 && left > Integer.MAX_VALUE + right)) {
            throw new OverflowException("Overflow: " + left + " - " + right + " is out of range.");
        }

        return left - right;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int left = operandFirst.evaluate(x, y, z);
        int right = operandSecond.evaluate(x, y, z);

        if ((right > 0 && left < Integer.MIN_VALUE + right) || 
            (right < 0 && left > Integer.MAX_VALUE + right)) {
            throw new OverflowException("Overflow: " + left + " - " + right + " is out of range.");
        }

        return left - right;
    }
}
