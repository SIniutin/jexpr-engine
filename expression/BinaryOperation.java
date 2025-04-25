package expression;

import java.util.Objects;

public abstract class BinaryOperation extends Operator {
    //MathOperations operation;
    protected  final Operator operandFirst;
    protected  final Operator operandSecond;
    final String operator;
    //final Precedence precedence;
    //final Associativity associativity;
    //final boolean commutativity;

    protected BinaryOperation(String operator,Precedence precedence, Associativity associativity, boolean commutativity, Operator operandFirst, Operator operandSecond) {
        this.operator = operator;
        // this.precedence = precedence;
        // this.associativity = associativity;
        // this.commutativity = commutativity;
        this.operandFirst = operandFirst;
        this.operandSecond = operandSecond;
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
    public Operator getOperand(int n) {
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
    // public Precedence getPrecedence() {
    //     return precedence;
    // }
    // public Associativity isAssociative() {
    //     return associativity;
    // }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && (object instanceof BinaryOperation)) {
            BinaryOperation expression = (BinaryOperation) object;
            return this.getClass() == object.getClass() && operandFirst.equals(expression.getOperand(1)) && operandSecond.equals(expression.getOperand(2));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, operandFirst, operandSecond);
    }
    @Override
    public abstract int evaluate(int num);
    @Override
    public abstract int evaluate(int x, int y, int z);
}
