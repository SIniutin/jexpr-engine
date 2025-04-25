package expression.generic.calculation;

public class DoubleCalculation implements Calculation<Double> {

    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {

        return x / y;
    }

    @Override
    public Double negate(Double x) {
        return -x;
    }

    // @Override
    // public Double intToType(int x) {
    //     return (double) x;
    // }

    @Override
    public Double area(Double x, Double y) {
        return x * y / 2;
    }

    @Override
    public Double perimeter(Double x, Double y) {
        return (x + y) * 2;
    }
}