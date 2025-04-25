package expression.generic;

import expression.generic.calculation.Calculation;

public class Perimeter<T extends Number> extends BinaryOperation<T>{

    protected Perimeter(Expression<T> operandFirst, Expression<T> operandSecond, Calculation<T> calc) {
            super("perimeter", operandFirst, operandSecond, calc);
        }
    
        @Override
    public T evaluate(T num) {
        return calc.perimeter(operandFirst.evaluate(num), operandSecond.evaluate(num));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.perimeter(operandFirst.evaluate(x,y,z), operandSecond.evaluate(x,y,z));
    }
    
}
