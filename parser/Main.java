package expression.parser;

import expression.Const;
import expression.Operator;
import expression.Power;

public class Main {
    public static void main(String[] args) {
        Operator expr = new Power(new Const(2),new Const(-3));
        System.out.println(expr.evaluate(0));
        expr = new Power(new Const(2),new Const(3));
        System.out.println(expr.evaluate(0));
        expr = new Power(new Const(0),new Const(-1));
        System.out.println(expr.evaluate(0,1,2));
        expr = new Power(new Const(0),new Const(1));
        System.out.println(expr.evaluate(0,1,2));
        ExpressionParser parser = new ExpressionParser();   
        String string = "0!";
        System.out.println(parser.parse(string));
        string = "(0)!";
        System.out.println(parser.parse(string));
        string = "-4!";
        System.out.println(parser.parse(string));
         string = "--2";
        System.out.println(parser.parse(string));
        string = "2³";
        System.out.println(parser.parse(string));
        System.out.println(parser.parse(string).getClass());
        string = "-2³";
        System.out.println(parser.parse(string));
        string = "- - x";
        System.out.println(parser.parse(string));
        string = "- -2147483648";
         System.out.println(parser.parse(string));
        string = """
                   
 -(0) 

                        """;
        System.out.println(parser.parse(string));
        string = "(0 + -1)";
        System.out.println(parser.parse(string));
        string = "-1";
        System.out.println(parser.parse(string));
        string = "x * (x - 2)*x + 1";
        System.out.println(parser.parse(string));
    }    
}
