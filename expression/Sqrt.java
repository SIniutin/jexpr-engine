package expression;

public class Sqrt extends UnaryOperation {
    public Sqrt(Operator oper) {
        super("√",Precedence.UNARY, oper,false);
    }

    @Override
    public String toString() {
        return  "√(" + getOperand() + ")";
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int)Math.sqrt(operand.evaluate(x, y, z));
    }
    @Override
    public int evaluate(int x) {
        return (int)Math.sqrt(operand.evaluate(x));
    }
}
