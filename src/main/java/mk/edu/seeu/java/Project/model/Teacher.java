package mk.edu.seeu.java.Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;

    @Column(nullable = false)
    private String tname;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    @JsonBackReference
    public Course course;


    public Teacher(){

    }

    public Teacher(String tname) {
        this.tname = tname;
    }

    public Teacher(long tid, String tname, Course course) {
        this.tid = tid;
        this.tname = tname;
        this.course = course;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getTid().equals(teacher.getTid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31);
    }
}
