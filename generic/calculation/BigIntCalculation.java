package expression.generic.calculation;

import java.math.BigInteger;

public class BigIntCalculation implements Calculation<BigInteger> {
    private final BigInteger TWO = new BigInteger("2");

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }


    // @Override
    // public BigInteger intToType(int a) {
    //     return BigInteger.valueOf(a);
    // }

    @Override
    public BigInteger area(BigInteger x, BigInteger y) {
        return x.multiply(y).divide(TWO);
    }

    @Override
    public BigInteger perimeter(BigInteger x, BigInteger y) {
        BigInteger sm = x.add(y);
        return sm.multiply(TWO);
    }
}
