package net.atos.start.student.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */
@Entity(name = "Subject")
@Table(name = "subject")
@SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    @Column(name = "subject_id", nullable = false, updatable = false, unique = true)
    private int subject_id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "ects")
    @Min(value = 1)
    @Max(value = 10)
    private int ects;

    @Column(name = "description")
    @Size(max = 1000)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy="subjects")
    private List<Student> students = new ArrayList<Student>();

//    TODO: zrobic builder

    public SubjectEntity(){}

    public SubjectEntity(int subject_id, String name, int ects, String description) {
        this.subject_id = subject_id;
        this.name = name;
        this.ects = ects;
        this.description = description;
    }

    public SubjectEntity(String name, int ects, String description) {
        this.name = name;
        this.ects = ects;
        this.description = description;
    }


    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public SubjectEntity getForm() {
        SubjectEntity subject = new SubjectEntity();
        subject.setSubject_id(this.getSubject_id());
        subject.setName(this.getName());
        subject.setEcts(this.getEcts());
        subject.setDescription(this.getDescription());
        return subject;
    }

}
