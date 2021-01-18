package mk.edu.seeu.java.Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;

    @Column(nullable = false)
    private String tname;


    @ManyToOne
    @JoinColumn(name = "cid")
    public Course course;


    public Teacher(){

    }

    public Teacher(Long tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher(long tid, String tname, Course course) {
        this.tid = tid;
        this.tname = tname;
        this.course = course;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
