package expression.generic.calculation;

public interface Calculation<T extends Number> {

    public T area(T a, T b);

    public T perimeter(T a, T b);

    public T add(T a, T b);

    public T subtract(T a, T b);

    public T divide(T a, T b);

    public T multiply(T a, T b);

    public T negate(T x);
}
