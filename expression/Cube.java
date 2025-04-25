package expression;

public class Cube extends UnaryOperation{
    public Cube(Operator oper) {
        super("³", Precedence.UNARY, oper,true);
    }

    @Override
    public String toString() {
        return getOperand()+"³";
    }

    @Override
    public int evaluate(int num) {
        int ev = operand.evaluate(num);
        return ev * ev * ev;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ev = operand.evaluate(x, y, z);
        return ev * ev * ev;
    }
}
