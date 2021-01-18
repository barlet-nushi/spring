package mk.edu.seeu.java.Project.Controller.Exception;

public class StudentIdMismatchException extends RuntimeException {

    public StudentIdMismatchException() {
        super();
    }

    public StudentIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}