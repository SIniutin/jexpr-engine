package expression;

public class Factorial extends UnaryOperation {

    public Factorial(Operator oper) {
        super("!", Precedence.FACT, oper,true);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public String toString() {
        return getOperand()+"!";
    }

    @Override
    public int evaluate(int num) {
        return factorial(operand.evaluate(num));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return factorial(operand.evaluate(x, y, z));
    }
}
