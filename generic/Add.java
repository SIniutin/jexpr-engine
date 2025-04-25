package expression.generic;

import expression.generic.calculation.Calculation;

public class Add<T extends Number> extends BinaryOperation<T> {

    public Add(Expression<T> arg1, Expression<T> arg2, Calculation<T> calc) {
        super("+", arg1, arg2, calc);
    }
    
    @Override
    public T evaluate(T num) {
        return calc.add(operandFirst.evaluate(num), operandSecond.evaluate(num));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return  calc.add(operandFirst.evaluate(x,y,z), operandSecond.evaluate(x,y,z));
    }
}
