package net.atos.start.student.interfaces;

import net.atos.start.student.entity.Student;

import java.util.Date;
import java.util.List;

/**
 * Created by lukasz on 25.07.16.
 */
public interface StudentManagerInterface {

    List<Student> listStudent();

    Student getStudent(int id);

    void setStudent(String name, String surname, Date data, String sex, String pesel, String email);

    void removeStudent(int id);

    void editStudent(int id, String name, String surname, String sex, String pesel, String email);

    void save(Student student);

    void deleteStudentSubject(Student student, int id);

}
