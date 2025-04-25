package expression;

public class Subtract extends BinaryOperation {
    public Subtract(Operator arg1, Operator arg2) {
        super("-", Precedence.LOW, Associativity.LEFT,false, arg1, arg2);
    }

	@Override
	public int evaluate(int num) {
		return operandFirst.evaluate(num) - operandSecond.evaluate(num);
	}

	@Override
	public int evaluate(int x, int y, int z) {
		return operandFirst.evaluate(x, y, z) - operandSecond.evaluate(x, y, z);
	}
}
