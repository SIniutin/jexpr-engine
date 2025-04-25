package expression.generic;

public interface Expression<T extends Number> {
    public abstract T evaluate(T num);

    public abstract T evaluate(T x, T y, T z);
}
