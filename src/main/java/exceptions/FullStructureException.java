package exceptions;

public class FullStructureException extends RuntimeException {

    public FullStructureException() {
        super("The structure is full. The operation has been interrupted.");
    }

}
