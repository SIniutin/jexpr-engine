package expression;

public class Divide extends BinaryOperation {
    public Divide(Operator arg1, Operator arg2) {
        super("/", Precedence.MEDIUM, Associativity.LEFT,false, arg1, arg2);
    }

	@Override
	public int evaluate(int num) {
        return operandFirst.evaluate(num) / operandSecond.evaluate(num);
	}

	@Override
	public int evaluate(int x, int y, int z) {
		return operandFirst.evaluate(x, y, z) / operandSecond.evaluate(x, y, z);
	}
}