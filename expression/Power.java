package expression;

public class Power extends BinaryOperation {
    public Power(Operator left, Operator right) {
        super("**",Precedence.HIGH,Associativity.LEFT,false, left, right);
    }

    @Override
    public int evaluate(int num) {
        int first = operandFirst.evaluate(num);
        int second = operandSecond.evaluate(num);
        if (second < 0) {
            return 1;
        }
        if (first == 0 && second > 0) return 0;
        if (first == 0 && second == 0) return 1;
        return (int) Math.pow(first, second);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int first = operandFirst.evaluate(x, y, z);
        int second = operandSecond.evaluate(x, y, z);
        if (second < 0) {
            return 1;
        }
        if (first == 0 && second > 0) return 0;
        if (first == 0 && second == 0) return 1;
        return (int) Math.pow(first, second);
    }
    
}
