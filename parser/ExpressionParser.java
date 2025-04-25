package expression.parser;

import expression.*;
import expression.exceptions.*;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionParser implements TripleParser {
    private String string;
    private int index;
    private final int RECURSION_STEP;
    private final int RECURSION_MIN;
    private final int RECURSION_MAX;
    private Stack<Character> parantness;

    private final Map<Character,Character> brackets = Map.of(
        '{','}',
        '(',')',
        '[',']'
    );

    private final Map<String, Integer> binary = Map.of(
        "perimeter", 10,
        "area", 10,
        "+", 20,
        "-", 20,
        "*", 100,
        "/", 100);
    private final Map<String, Function<Operator[], Operator>> binToClassMap = Map.of(
        "perimeter", args -> new CheckedPerimeter(args[0], args[1]),
        "area", args -> new CheckedArea(args[0], args[1]),
        "+", args -> new CheckedAdd(args[0], args[1]),
        "-", args -> new CheckedSubtract(args[0], args[1]),
        "*", args -> new CheckedMultiply(args[0], args[1]),
        "/", args -> new CheckedDivide(args[0], args[1])
    );
    private final Map<String, Function<Operator[], Operator>> unToClassMap = Map.of(
        "-", args -> new CheckedNegate(args[0])
    );
    private final Set<String> unary = Set.of(
        "-");

    private Operator createOperator(String operator, Operator left, Operator right) throws ParsingException {
        Function<Operator[], Operator> constructor = binToClassMap.get(operator);
        if (constructor == null) {
            throw new ParsingException("Unknown operator: " + operator);
        }
        return constructor.apply(new Operator[]{left, right});
    }
    private Operator createOperator(String operator, Operator left) throws ParsingException {
        Function<Operator[], Operator> constructor = unToClassMap.get(operator);
        if (constructor == null) {
            throw new ParsingException("Unknown operator: " + operator);
        }
        return constructor.apply(new Operator[]{left});
    }

    private boolean hasNext() {
        return index < string.length();
    }

    private void skipWhitespaces() {
        while (hasNext() && Character.isWhitespace(string.charAt(index))) {
            index++;
        }
    }

    private String getOperator() {
        int start = index;
        String bestMatch = "";
        int bestMatchLength = 0;
    
        while (hasNext()) {
            String sub = string.substring(start, index + 1);
            if (binary.containsKey(sub) || unary.contains(sub)) {
                bestMatch = sub;
                bestMatchLength = index - start + 1;
            }
            index++;
        }
    
        index = start + bestMatchLength;
        return bestMatch;
    }
    
    

    private Operator parseBinary(int recursion) throws ParsingException {
        Operator left = recursion < RECURSION_MAX ? parseBinary(recursion + RECURSION_STEP) : parseUnary();
        skipWhitespaces();
        if (binary.values().contains(recursion)) {
            while (hasNext()) {
                skipWhitespaces();
                String operator = getOperator();
                if (!binary.containsKey(operator) || binary.get(operator) != recursion) {
                    index -= operator.length();
                    break;
                }
        
                if (!hasNext()) {
                    throw new ParsingException("Expected operand after " + operator + " at index " + index);
                }

                Operator right = recursion < RECURSION_MAX ? parseBinary(recursion + RECURSION_STEP) : parseUnary();
                left = createOperator(operator, left, right);
            }
        }
        return left;
    }

    private boolean isNum() {
        char symbol = string.charAt(index);
        return Character.isDigit(symbol) ||
                (symbol == '-' && (hasNext() && Character.isDigit(string.charAt(index+1))));
    }

    private Operator parseUnary() throws ParsingException {
        skipWhitespaces();

        if (hasNext() && isNum()) {
            return parseFactor();
        }
        while (hasNext()) {
            skipWhitespaces();
            String operator = getOperator();
            if (unary.contains(operator)) {
                return createOperator(operator, parseUnary());
            }
            else {
                if (!operator.isEmpty()) throw new ParsingException("No argument at index: "+ index+","+string.charAt(index));
                break;
            }
        }
        return parseFactor();
    }

    private Operator parseFactor() throws ParsingException {
        skipWhitespaces();
        if (!hasNext()) {
            throw new ParsingException("Unexpected end of expression");
        }
    
        Operator result;
        char symbol = string.charAt(index);
    
        if (isNum()) {
            return parseConst();
        } else if (Character.isLetter(symbol)) {
            return parseVariable();
        } else if (brackets.keySet().contains(symbol)) {
            parantness.push(symbol);
            index++;
            result = parseBinary(RECURSION_MIN);
            skipWhitespaces();

            if (!hasNext()) {
                throw new ParsingException("Expected closing bracket at index " + index);
            }
    
            char closeCh = string.charAt(index);
    
            if (!brackets.values().contains(closeCh)) {
                throw new ParsingException("Expected closing bracket at index " + index);
            }
    
            if (parantness.isEmpty() || brackets.get(parantness.peek()) != closeCh) {
                throw new ParsingException("Mismatched brackets at index: " + index);
            }
    
            parantness.pop();
            index++;
        } else if (brackets.values().contains(symbol)) {
            throw new ParsingException("Unexpected closing parenthesis at index " + index);
        } else {
            throw new ParsingException("Unexpected symbol: " + symbol + " at index " + index);
        }
    
        return result;
    }
    

    private Const parseConst() throws ParsingException {
        skipWhitespaces();
        StringBuilder sb = new StringBuilder();
        while (hasNext()
                && ((Character.isDigit(string.charAt(index))) || (string.charAt(index) == '-' && sb.isEmpty()))) {
            sb.append(string.charAt(index));
            index++;
        }
        if (sb.isEmpty()) {
            throw new IllegalArgumentException("Expected a constant at index " + index);
        }
        try {
            return new Const(Integer.parseInt(sb.toString()));
        } catch (NumberFormatException e) {
            throw new ParsingException("Invalid number format: " + sb + " at index " + index);
        }
    }

    private Variable parseVariable() throws ParsingException {
        skipWhitespaces();
        StringBuilder sb = new StringBuilder();
        while (hasNext() && Character.isLetter(string.charAt(index))) {
            sb.append(string.charAt(index));
            index++;
        }
        char ch = sb.charAt(sb.length() - 1);
        if (ch != 'x' && ch != 'y' && ch != 'z') {
            throw new ParsingException("Invalid character: " + ch);
        }
        return new Variable(sb.toString());
    }

    public ExpressionParser() {
        index = 0;
        string = null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int step = Integer.MAX_VALUE;
        for (int priority : binary.values()) {
            if (priority < min) {
                min = priority;
            }
            if (priority > max) {
                max = priority;
            }
        }
        List<Integer> sorted = new ArrayList<>(binary.values());
        Collections.sort(sorted);

        for (int i = 1; i < sorted.size(); i++) {
            int diff = sorted.get(i) - sorted.get(i - 1);
            if (diff < step && sorted.get(i) != sorted.get(i - 1)) {
                step = diff;
            }
        }
        RECURSION_STEP = step != Integer.MAX_VALUE ? step : 0;
        RECURSION_MAX = max;
        RECURSION_MIN = min;
    }

    @Override
    public TripleExpression parse(String expression){
        if (expression.isEmpty() || expression == null) {
            throw new IllegalArgumentException("expression can't be empty");
        }
        parantness = new Stack<>();
        System.out.println(parantness);
        System.out.println("#"+expression+"#");
        string = expression;
        index = 0;
        try {
            Operator oper = parseBinary(RECURSION_MIN);
            if (!parantness.isEmpty()) {
                throw new ParsingException("Mismatching parantness");
            }
            if (hasNext()) {
                throw new ParsingException("Unexpected character after expression at index " + index);
            }
            System.out.println("@"+oper+"@");
            return oper;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}