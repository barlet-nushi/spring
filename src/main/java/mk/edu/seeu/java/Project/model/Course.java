package mk.edu.seeu.java.Project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.*;

@Entity
public class Course  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    @Column(nullable = false, unique = true)
    private String cname;

    @JsonBackReference
    @ManyToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Teacher> teacher = new HashSet<>();


    public Course(){
    }

    public Course(final String cname) {
        this.cname = cname;
    }

    public Course(String cname, Set<Student> students) {
        this.cname = cname;
        this.students = students;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCid().equals(course.getCid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31);
    }
}
