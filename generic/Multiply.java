package expression.generic;

import expression.generic.calculation.Calculation;

public class Multiply<T extends Number> extends BinaryOperation<T> {
    protected Multiply(Expression<T> operandFirst, Expression<T> operandSecond, Calculation<T> calc) {
        super("*", operandFirst, operandSecond, calc);
    }

    @Override
    public T evaluate(T num) {
        return  calc.multiply(operandFirst.evaluate(num), operandSecond.evaluate(num));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return  calc.multiply(operandFirst.evaluate(x,y,z), operandSecond.evaluate(x,y,z));
    }
    
}
