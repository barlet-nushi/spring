package mk.edu.seeu.java.Project.Controller.Exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException() {
        super();
    }

    public TeacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}