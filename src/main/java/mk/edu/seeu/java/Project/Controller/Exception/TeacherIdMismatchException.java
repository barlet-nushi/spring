package mk.edu.seeu.java.Project.Controller.Exception;

public class TeacherIdMismatchException extends RuntimeException {

    public TeacherIdMismatchException() {
        super();
    }

    public TeacherIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}