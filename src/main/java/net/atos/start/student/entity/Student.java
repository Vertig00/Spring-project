package net.atos.start.student.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lukasz on 25.07.16.
 */

@Entity(name = "Student")
@Table(name = "student")
@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Type(type = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

    @NotNull
    @Size(max = 11, min = 11)
    @Column(name = "pesel", unique = true)
    private String pesel;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 1)
    @Column(name = "sex")
    private String sex;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "subject_id"
            )
    )
    private List<SubjectEntity> subjects = new ArrayList<SubjectEntity>();

//    TODO: zrobic buildera

    public Student(){}

    public Student(int id, String name, String surname, Date date, String sex, String pesel, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.sex = sex;
        this.pesel = pesel;
        this.email = email;
    }

    public Student(int id, String name, String surname, String sex, String pesel, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.pesel = pesel;
        this.email = email;
    }

    public Student(String name, String surname, Date date, String sex, String pesel, String email) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.pesel = pesel;
        this.date = date;
        this.email = email;
    }

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentForm getForm(){
        StudentForm form = new StudentForm();
        form.setId(this.getId());
        form.setName(this.getName());
        form.setSurname(this.getSurname());
        form.setSex(this.getSex());
        form.setPesel(this.getPesel());
        form.setEmail(this.getEmail());

        return form;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
}
