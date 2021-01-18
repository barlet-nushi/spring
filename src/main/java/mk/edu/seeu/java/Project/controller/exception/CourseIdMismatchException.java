package mk.edu.seeu.java.Project.controller.exception;

public class CourseIdMismatchException extends RuntimeException {

    public CourseIdMismatchException() {
        super();
    }

    public CourseIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}