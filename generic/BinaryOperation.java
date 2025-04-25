package expression.generic;

import expression.generic.calculation.*;
import java.util.Objects;

public abstract class BinaryOperation<T extends Number> implements Expression<T> {
    protected  final Expression<T> operandFirst;
    protected  final Expression<T> operandSecond;
    private final String operator;
    protected final Calculation<T> calc;

    protected BinaryOperation(String operator, Expression<T> operandFirst, Expression<T> operandSecond, Calculation<T> calc) {
        this.operator = operator;
        this.operandFirst = operandFirst;
        this.operandSecond = operandSecond;
        this.calc = calc;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append('(')
                .append(operandFirst.toString())
                .append(' ').append(operator).append(' ')
                .append(operandSecond.toString())
                .append(')').toString();
    };
    public Expression<T> getOperand(int n) {
        switch (n) {
            case 1 -> {
                return operandFirst;
            }
            case 2 -> {
                return operandSecond;
            }
            default -> throw new IllegalArgumentException("Invalid operand index: " + n);
        }
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && (object instanceof BinaryOperation<?>)) {
            BinaryOperation<?> expression = (BinaryOperation<?>) object;
            return this.getClass() == object.getClass() && operandFirst.equals(expression.getOperand(1)) && operandSecond.equals(expression.getOperand(2));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, operandFirst, operandSecond);
    }
    @Override
    public abstract T evaluate(T num);
    @Override
    public abstract T evaluate(T x, T y, T z);
}
