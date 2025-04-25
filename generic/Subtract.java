package expression.generic;

import expression.generic.calculation.Calculation;

public class Subtract<T extends Number> extends BinaryOperation<T> {

    protected Subtract( Expression<T> operandFirst, Expression<T> operandSecond, Calculation<T> calc) {
            super("-", operandFirst, operandSecond, calc);
        }
    
        @Override
    public T evaluate(T num) {
        return  calc.subtract(operandFirst.evaluate(num), operandSecond.evaluate(num));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return  calc.subtract(operandFirst.evaluate(x,y,z), operandSecond.evaluate(x,y,z));
    }
    
}
