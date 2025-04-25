package expression.generic;

import java.util.Objects;

import expression.generic.calculation.Calculation;

public class Negate<T extends Number> implements Expression<T> {
    protected  final Expression<T> operand;
    protected final Calculation<T> calc;

    public Negate(Expression<T> operand, Calculation<T> calc) {
        this.operand = operand;
        this.calc = calc;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("-(")
                .append(operand.toString())
                .append(')').toString();
    };
    public Expression<T> getOperand() {
        return operand;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && (object instanceof Negate<?>)) {
            Negate<?> expression = (Negate<?>) object;
            return this.getClass() == object.getClass() && operand.equals(expression.getOperand());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash("-", operand);
    }
    @Override
    public T evaluate(T num) {
        return calc.negate(operand.evaluate(num));
    }
    @Override
    public T evaluate(T x, T y, T z) {
        return calc.negate(operand.evaluate(x,y,z));
    }
}
