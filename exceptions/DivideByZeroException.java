package expression.exceptions;

/**
 *
 * @author p0tniy_zadr
 */
public class DivideByZeroException extends EvaluateException{

    public DivideByZeroException() {
        super("Division by zero is not allowed.");
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}