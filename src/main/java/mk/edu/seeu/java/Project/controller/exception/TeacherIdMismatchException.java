package mk.edu.seeu.java.Project.controller.exception;

public class TeacherIdMismatchException extends RuntimeException {

    public TeacherIdMismatchException() {
        super();
    }

    public TeacherIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}