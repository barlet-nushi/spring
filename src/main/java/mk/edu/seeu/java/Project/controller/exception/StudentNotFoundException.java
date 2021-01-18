package mk.edu.seeu.java.Project.controller.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}