package expression.generic.calculation;

import expression.exceptions.DivideByZeroException;
import expression.exceptions.EvaluateException;
import expression.exceptions.OverflowException;

public class IntegerCalculation implements Calculation<Integer> {

    @Override
    public Integer area(Integer a, Integer b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'area'");
    }

    @Override
    public Integer perimeter(Integer a, Integer b) {
        if (a < 0 || b < 0) {
            throw new EvaluateException("Can't evaluate perimeter from negative values:" + a + ", "+ b);
        }

        if ((b > 0 && a > Integer.MAX_VALUE - b) || 
            (b < 0 && a < Integer.MIN_VALUE - b)) {
            throw new OverflowException("Overflow: " + a + " + " + b + " is out of range.");
        }

        int sum = a + b;

        if (sum > Integer.MAX_VALUE / 2 || sum < Integer.MIN_VALUE / 2) {
            throw new OverflowException("Overflow: 2 * (" + sum + ") is out of range.");
        }

        return 2 * sum;
    }

    @Override
    public Integer add(Integer a, Integer b) {

        if ((b > 0 && a > Integer.MAX_VALUE - b) || 
            (b < 0 && a < Integer.MIN_VALUE - b)) {
            throw new OverflowException("Overflow: " + a + " + " + b + " is out of range.");
        }

        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        if ((b > 0 && a < Integer.MIN_VALUE + b) || 
            (b < 0 && a > Integer.MAX_VALUE + b)) {
            throw new OverflowException("Overflow: " + a + " - " + b + " is out of range.");
        }

        return a - b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException("Division by zero: " + a + " / " + b);
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException("Overflow: Division of " + a + " by " + b + " is not possible.");
        }
        return a / b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b ||
            a > 0 && b < 0 && b < Integer.MIN_VALUE / a ||
            a < 0 && b > 0 && a < Integer.MIN_VALUE / b ||
            a < 0 && b < 0 && a < Integer.MAX_VALUE / b) {
            throw new OverflowException("Overflow: " + a + " * " + b + " is out of range.");
        }

        return a * b;
    }

    @Override
    public Integer negate(Integer x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException("Overflow: cannot negate Integer.MIN_VALUE");
        }
        return -x;
    }
    
}
