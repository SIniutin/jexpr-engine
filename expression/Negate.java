package expression;

public class Negate extends UnaryOperation{
    public Negate(Operator oper) {
        super("-",Precedence.UNARY, oper,false);
    }

	@Override
	public String toString() {
        return "-" + getOperand();
    }

	@Override
	public int evaluate(int num) {
		return -operand.evaluate(num);
	}
	@Override
	public int evaluate(int x, int y, int z) {
		return -operand.evaluate(x, y, z);
	}
}
