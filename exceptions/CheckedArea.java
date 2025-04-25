package expression.exceptions;

import expression.*;;

public class CheckedArea extends BinaryOperation{
    public CheckedArea(Operator arg1, Operator arg2) {
        super("area", Precedence.LOW, Associativity.NONE, false, arg1, arg2);
    }

    private int calculate(int left, int right) {
        if (right < 0 || left < 0) {
            throw new EvaluateException("Can't evaluate area from negative values:" + left + ", "+ right);
        }
        if (left > 0 && right > 0 && left > Integer.MAX_VALUE / right ||
            left > 0 && right < 0 && right < Integer.MIN_VALUE / left ||
            left < 0 && right > 0 && left < Integer.MIN_VALUE / right ||
            left < 0 && right < 0 && left < Integer.MAX_VALUE / right) {
            throw new OverflowException("Overflow: " + left + " * " + right + " is out of range.");
        }

        return compute(left, right);
    }

    @Override
    public int evaluate(int x) {
        return compute(operandFirst.evaluate(x),operandSecond.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return compute(operandFirst.evaluate(x,y,z),operandSecond.evaluate(x,y,z));
    }   

    protected int compute(int a, int b) {
        if (multiplyOverflows(a, b)) {
            if (a % 2 == 0) {
                return (a / 2) * b;
            } else if (b % 2 == 0) {
                return (b / 2) * a;
            }
    
            Const TWO = new Const(2);
            Const constEven1 = new Const(a == Integer.MIN_VALUE ? a : a - 1);
            Const constEven2 = new Const(b == Integer.MIN_VALUE ? b : b - 1);
            CheckedDivide halfA = new CheckedDivide(constEven1, TWO);
            CheckedDivide halfB = new CheckedDivide(constEven2, TWO);
    
            return new CheckedAdd(
                    new CheckedAdd(new CheckedMultiply(halfA, constEven2), halfA),
                    halfB
            ).evaluate(0);
        } else {
            return (a * b) / 2;
        }
    }
    private boolean multiplyOverflows(int x, int y) {
        if (x == -1) {
            return y == Integer.MIN_VALUE;
        } else if (x > 0) {
    
            return y > Integer.MAX_VALUE / x || y < Integer.MIN_VALUE / x;
        } else if (x < -1) {
    
            return y > Integer.MIN_VALUE / x || y < Integer.MAX_VALUE / x;
        } else {
    
            return false;
        }
    }
}