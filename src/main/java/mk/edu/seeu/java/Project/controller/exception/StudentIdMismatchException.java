package mk.edu.seeu.java.Project.controller.exception;

public class StudentIdMismatchException extends RuntimeException {

    public StudentIdMismatchException() {
        super();
    }

    public StudentIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}