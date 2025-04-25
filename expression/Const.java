package expression;

public class Const extends Operator{
    private final int value;

    public Const(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public String toMiniString() {
        return toString();
    }
    
    @Override
    public int evaluate(int x, int y, int z) {
        return this.value;
    }
    @Override
    public int evaluate(int num) {
        return this.value;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Const)) {
            return false;
        }
        Const other = (Const) obj;
        return this.value == other.value;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
