package mk.edu.seeu.java.Project.controller.exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException() {
        super();
    }

    public TeacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}