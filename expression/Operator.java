package expression;

public abstract class Operator implements Expression, TripleExpression{
    public abstract int evaluate(int num);

    public abstract int evaluate(int x, int y, int z);

    //public abstract String toMiniString();
}
