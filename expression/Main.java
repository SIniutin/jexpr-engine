package expression;

public class Main {
    public static void main(String[] args) {
        String expression = new Subtract(
                                    new Multiply(
                                        new Const(2),
                                        new Variable("x")
                                    ),
                                    new Const(3)
                                ).toString();
        System.out.println(expression);
        int num = new Subtract(
                    new Multiply(
                        new Const(2),
                        new Variable("x")
                    ),  
                    new Const(3)
                ).evaluate(5);
        System.out.println(num);
        expression = new Subtract(
                        new Multiply(
                            new Const(2),
                            new Variable("x")
                        ),
                        new Const(3)
                    ).toMiniString();
        System.out.println(expression);
        System.out.println(new Multiply(
                                new Const(2), 
                                new Variable("x"))
                            .equals(new Multiply(
                                        new Const(2), 
                                        new Variable("x"))));
        System.out.println(new Multiply(
                                new Const(2), 
                                new Variable("x"))
                            .equals(new Multiply(
                                        new Variable("x"), 
                                        new Const(2))));
        Operator expression1 = new Multiply(new Divide(new Const(10),new Const(3)),new Const(2));
        Operator expression2 = new Multiply(new Const(10),new Divide(new Const(3),new Const(2)));
        System.out.println(expression1.toString());
        System.out.println(expression1.toMiniString());
        System.out.println(expression2.toString());
        System.out.println(expression2.toMiniString());
        ///Exception in thread "main" java.lang.AssertionError: Invalid toMiniString
        //expected: 10 * (3 / 2)
        //actual: 10 * 3 / 2
        /// 
    }
}
