package expression;

public class Square extends UnaryOperation {
    public Square(Operator oper) {
        super("²",Precedence.UNARY,oper,true);
        
    }

    @Override
    public String toString() {
        return  "(" + getOperand() + ")²";
    }

    @Override
    public int evaluate(int num) {
        int ev = operand.evaluate(num);
        return ev * ev;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ev = operand.evaluate(x, y, z);
        return ev * ev;
    }
}
