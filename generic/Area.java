package expression.generic;

import expression.generic.calculation.Calculation;

public class Area<T extends Number> extends BinaryOperation<T> {
    public Area(Expression<T> arg1, Expression<T> arg2, Calculation<T> calc) {
        super("area", arg1, arg2, calc);
    }
    
    @Override
    public T evaluate(T num) {
        return  calc.area(operandFirst.evaluate(num), operandSecond.evaluate(num));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return  calc.area(operandFirst.evaluate(x,y,z), operandSecond.evaluate(x,y,z));
    }
}
