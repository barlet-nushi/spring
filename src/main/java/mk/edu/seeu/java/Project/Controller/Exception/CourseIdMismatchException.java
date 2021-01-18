package mk.edu.seeu.java.Project.Controller.Exception;

public class CourseIdMismatchException extends RuntimeException {

    public CourseIdMismatchException() {
        super();
    }

    public CourseIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}