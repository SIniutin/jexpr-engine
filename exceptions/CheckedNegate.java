package expression.exceptions;

import expression.Negate;
import expression.Operator;

public class CheckedNegate extends Negate {
    public CheckedNegate(Operator oper) {
        super(oper);
    }

    @Override
    public String toString() {
        return "-("+getOperand()+")";
    }

    @Override
    public int evaluate(int num) {
        int value = operand.evaluate(num);
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException("Overflow: cannot negate Integer.MIN_VALUE");
        }
        return -value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int value = operand.evaluate(x, y, z);
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException("Overflow: cannot negate Integer.MIN_VALUE");
        }
        return -value;
    }
}
