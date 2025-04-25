package expression.generic;

import expression.exceptions.*;
import expression.generic.calculation.*;
import expression.*;
import java.math.BigInteger;

public class GenericTabulator implements Tabulator {

    public Calculation<?> getCalculation(String mode) {
        return switch (mode) {
            case "-i" -> IntegerCalculation
        
            default:
                break;
        }
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        int dx = x2 - x1 + 1;
        int dy = y2 - y1 + 1;
        int dz = z2 - z1 + 1;
        
        Object[][][] result = new Number[dx][dy][dz];
        
        Expression<?> expr;
        try {
            expr = parse(mode, expression);
        } catch (ParsingException e) {
            System.err.println("Caught Parsing Exception... quitting");
            System.err.println(e.getMessage());
            return null;
        }
        
        for (int i = 0; i < dx; i++) {
            for (int j = 0; j < dy; j++) {
                for (int k = 0; k < dz; k++) {
                    int x = x1 + i;
                    int y = y1 + j;
                    int z = z1 + k;
                    
                    try {
                        result[i][j][k] = evaluate(mode, expr, x, y, z);
                    } catch (ArithmeticException e) {
                        result[i][j][k] = null;
                    }
                }
            }
        }
        
        return result;
    }
    private Expression<> parse(String mode, String expression) throws ParsingException {
        switch (mode) {
            case "i":
                return new GenericParser<Integer>().parse(expression);
            case "d":
                return new GenericParser<Double>().parse(expression);
            case "bi":
                return new GenericParser<BigInteger>().parse(expression);
            default:
                throw new IllegalArgumentException("Unsupported mode: " + mode);
        }
    }

    private Number evaluate(String mode, Expression<?> expression, int x, int y, int z) throws ArithmeticException {
        switch (mode) {
            case "i":
                Expression<Integer> iExpr expression.evaluate(x, y, z);
                Integer integer = expression.evaluate(x, y, z);
                return integer;
            case "d":
                return ((Expression<Double>) expression).evaluate((double) x, (double) y, (double) z);
            case "bi":
                return ((Expression<BigInteger>) expression).evaluate(BigInteger.valueOf(x), BigInteger.valueOf(y), BigInteger.valueOf(z));
            default:
                throw new IllegalArgumentException("Unsupported mode: " + mode);
        }
    }
}