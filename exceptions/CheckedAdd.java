package expression.exceptions;

import expression.Add;
import expression.Operator;

public class CheckedAdd extends Add {
    public CheckedAdd(Operator arg1, Operator arg2) {
        super(arg1, arg2);
    }

    @Override
    public int evaluate(int x) {
        int left = operandFirst.evaluate(x);
        int right = operandSecond.evaluate(x);

        if ((right > 0 && left > Integer.MAX_VALUE - right) || 
            (right < 0 && left < Integer.MIN_VALUE - right)) {
            throw new OverflowException("Overflow: " + left + " + " + right + " is out of range.");
        }

        return left + right;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int left = operandFirst.evaluate(x, y, z);
        int right = operandSecond.evaluate(x, y, z);

        if ((right > 0 && left > Integer.MAX_VALUE - right) || 
            (right < 0 && left < Integer.MIN_VALUE - right)) {
            throw new OverflowException("Overflow: " + left + " + " + right + " is out of range.");
        }

        return left + right;
    }
}
