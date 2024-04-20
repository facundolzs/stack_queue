package exceptions;

public class EmptyStructureException extends RuntimeException {

    public EmptyStructureException() {
        super("The structure is empty. The operation has been interrupted.");
    }

}
