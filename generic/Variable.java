package expression.generic;

public class Variable<T extends Number> implements Expression<T> {
    final String name;

    public Variable(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public T evaluate(T x) {
        return x;
    }
    @Override
    public T evaluate(T x, T y, T z) {
        switch (name.charAt(name.length()-1)) {
            case 'x' -> {
                return x;
            }
            case 'y' -> {
                return y;
            }
            case 'z' -> {
                return z;
            }
            default -> throw new AssertionError();
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Variable<?>)) {
            Variable<?> eq = (Variable<?>) obj;
            return this.name.equals(eq.name);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }    
}
