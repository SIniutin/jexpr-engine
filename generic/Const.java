package expression.generic;

public class Const<T extends Number> implements Expression<T>{

    private final T value;

    public Const(T value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public T evaluate(T x, T y, T z) {
        return this.value;
    }
    @Override
    public T evaluate(T num) {
        return this.value;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Const<?>)) {
            return false;
        }
        Const<?> other = (Const<?>) obj;
        return this.value == other.value;
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
