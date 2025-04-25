package expression.exceptions;

public class OverflowException extends EvaluateException{
    public OverflowException() {
        super("Overflow");
    }

    public OverflowException(String message) {
        super(message);
    }    
}
