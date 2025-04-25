package expression;

public class Log extends BinaryOperation {
    public Log(Operator left, Operator right) {
        super("//",Precedence.HIGH,Associativity.LEFT,false, left, right);
    }

    @Override
    public int evaluate(int num) {
        int base = operandSecond.evaluate(num);
        int value = operandFirst.evaluate(num);

        if (!validateArguments(value, base)) {
            return Integer.MIN_VALUE;
        }

        return (int) (Math.log(value) / Math.log(base));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int base = operandSecond.evaluate(x, y, z);
        int value = operandFirst.evaluate(x, y, z);

        if (!validateArguments(value, base)) {
            return Integer.MIN_VALUE;
        }

        return (int) (Math.log(value) / Math.log(base));
    }

    private boolean validateArguments(int value, int base) {
        return value > 0 && base > 0 && base != 1;
    }
}
