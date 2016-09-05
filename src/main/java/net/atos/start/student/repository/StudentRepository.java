package net.atos.start.student.repository;

import net.atos.start.student.entity.Student;

import java.util.List;

/**
 * Created by lukasz on 02.08.16.
 */

public interface StudentRepository {

    List<Student> findAll();
    Student findById(int id);
    void removeStudentById(int id);
    void save(Student student);
    void update(int id, Student stud);
    int checkIfPeselExist(String pesel);

}
