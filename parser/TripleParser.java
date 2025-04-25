package expression.parser;

import expression.TripleExpression;

public interface TripleParser {
    public TripleExpression parse (String expression);
}