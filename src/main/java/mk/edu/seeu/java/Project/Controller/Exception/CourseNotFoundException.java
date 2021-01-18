package mk.edu.seeu.java.Project.Controller.Exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}