package expression;

public class Add extends BinaryOperation {
    public Add(Operator arg1, Operator arg2) {
        //super("+", Precedence.LOW, Associativity.BOTH, true, arg1, arg2);
        super("+", Precedence.LOW, Associativity.BOTH, true, arg1, arg2);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return operandFirst.evaluate(x, y, z) + operandSecond.evaluate(x, y, z);
    }

    @Override
    public int evaluate(int num) {
        return operandFirst.evaluate(num) + operandSecond.evaluate(num);
    }
}
