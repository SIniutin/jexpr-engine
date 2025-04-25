package expression;

/**
 *
 * @author p0tniy
 */
public abstract class UnaryOperation extends Operator{
    final String operator;
    //final Precedence precedence;
    protected  final Operator operand;
    // private  boolean postfix = false;

    protected UnaryOperation(String operator, Precedence precedence, Operator operand, boolean postfix) {
        this.operator = operator;
    //    this.precedence = precedence;
        this.operand = operand;
    // this.postfix = postfix;
    }

    @Override
    public abstract String toString();

    public Operator getOperand() {
        return operand;
    }
    // public Precedence getPrecedence() {
    //     return precedence;
    // }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && (object instanceof UnaryOperation)) {
            UnaryOperation expression = (UnaryOperation) object;
            return this.getClass() != object.getClass() && operand.equals(expression.getOperand());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 7 * operator.hashCode() + 31 * operand.hashCode();
    }
    @Override
    public abstract int evaluate(int num);
    @Override
    public abstract int evaluate(int x, int y, int z);
}

