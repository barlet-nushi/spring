package mk.edu.seeu.java.Project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Student{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;

    @Column(nullable = false)
    private String sname;


    @ManyToMany(cascade = {
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "register",
            joinColumns = @JoinColumn(name = "sid"),
            inverseJoinColumns = @JoinColumn(name = "cid"))
    @JsonIgnoreProperties("students")
    private Set<Course> course = new HashSet<>();

    public Student(){
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getSid().equals(student.getSid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31);
    }

}
