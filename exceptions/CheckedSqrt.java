package expression.exceptions;

import expression.Sqrt;
import expression.Operator;

public class CheckedSqrt extends Sqrt{
    
    public CheckedSqrt(Operator oper) {
        super(oper);
    }

    @Override
    public String toString() {
        return getOperator() + this.buildString();
    }

    @Override
    public int evaluate(int num) {
        int value = operand.evaluate(num);

        if (value < 0) {
            throw new ArithmeticException("Invalid argument for square root: " + value);
        }
        return (int) Math.sqrt(value);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int value = operand.evaluate(x, y, z);

        if (value < 0) {
            throw new ArithmeticException("Invalid argument for square root: " + value);
        }
        return (int) Math.sqrt(value);
    }
}
