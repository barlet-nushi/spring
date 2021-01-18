package mk.edu.seeu.java.Project.controller.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}