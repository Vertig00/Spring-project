package net.atos.start.student.service;

import net.atos.start.student.entity.Student;
import net.atos.start.student.interfaces.StudentManagerInterface;
import net.atos.start.student.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by lukasz on 25.07.16.
 */
@Service
public class StudentService implements StudentManagerInterface{

    private Logger logger = Logger.getLogger("StudentService.class");

    @Autowired
    private StudentRepository studentDao;

    public List<Student> listStudent(){
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }

    public Student getStudent(int id) {
        Student student = studentDao.findById(id);
        return student;
    }

    public void removeStudent(int id){
        studentDao.removeStudentById(id);
    }

    public void setStudent(String name, String surname, Date date, String sex, String pesel, String email) {
        Student student = new Student(name,surname,date,sex,pesel,email);
        studentDao.save(student);
    }

    public void editStudent(int id, String name, String surname, String sex, String pesel, String email) {
        Student student = new Student(id, name, surname, sex, pesel, email);
        studentDao.update(id, student);
    }


    public void deleteStudentSubject(Student student, int subjectId){
        for (int i = 0; i < student.getSubjects().size(); i++){
            if(student.getSubjects().get(i).getSubject_id() == subjectId){
                student.getSubjects().remove(i);
            }
        }
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    private static Date parseDate(){
        Date today = new Date();
        return today;
    }

    public StudentRepository getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }
}