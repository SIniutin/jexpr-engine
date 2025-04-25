package expression.exceptions;

public class Main {

    public static void main(String[] args) throws ParsingException {
        ExpressionParser parser = new ExpressionParser();
        //String string = "(((0) + 0)))";
        String string = "(1 area 1)";
        System.out.println(parser.parse(string).evaluate(0, 0, 0));
    }
}

