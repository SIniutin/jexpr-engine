package expression;

public class Cbrt extends UnaryOperation {

    public Cbrt(Operator oper) {
        super("∛", Precedence.UNARY, oper,false);
    }

    @Override
    public String toString() {
        return "∛"+getOperand();
    }

    @Override
    public int evaluate(int num) {
        return (int) Math.cbrt(operand.evaluate(num));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int) Math.cbrt(operand.evaluate(x, y, z));
    }
}
