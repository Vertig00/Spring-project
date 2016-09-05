package net.atos.start.student.controller;

import net.atos.start.student.entity.Student;
import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.StudentManagerInterface;
import net.atos.start.student.interfaces.SubjectInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */
@Controller
public class StudentSetterController {

    private Logger logger = Logger.getLogger("StudentSetterController.class");

    private static final String STUDENT_SETTER_FORM = "studentSetter";


    @Autowired
    private SubjectInterface subjectInterface;

    @Autowired
    private StudentManagerInterface studentManagerInterface;


    //TODO: pobierać z bazy tylko Id i nazwe - subject || id, imie, nazwisko - student
    @RequestMapping(path = "/studentSetter", method = RequestMethod.GET)
    public String showSubjectInfo(Model model){
        List<Student> studentList = studentManagerInterface.listStudent();
        List<SubjectEntity> subjectList = subjectInterface.listSubject();

        model.addAttribute("subjectList", subjectList);
        model.addAttribute("studentList", studentList);
        logger.info("Dodawanie studentów do przedmiotów");
        return STUDENT_SETTER_FORM;
    }


    @RequestMapping(path = "/setStudentToSubject", method = RequestMethod.POST)
    public String addStudentToSubject(@RequestParam(value="student", required = false) int studentId,
                                      @RequestParam(value="subject", required = false) List<Integer> subjectList,
                                      Model model){

        Student student = studentManagerInterface.getStudent(studentId);
        List<SubjectEntity> tempSubjectList = new ArrayList<SubjectEntity>(student.getSubjects());

        for (Integer subjectId:subjectList) {

            if(!checkStudentSubjects(tempSubjectList,subjectId)){
                SubjectEntity subject = subjectInterface.getSubject(subjectId);
                student.getSubjects().add(subject);
            }
        }
        studentManagerInterface.save(student);

        logger.info("Pomyslnie zapisano studenta na przedmiot");
        return "redirect:/studentSetter";
    }

    //TODO: zastanowic się nad ta metoda
    private boolean checkStudentSubjects(List<SubjectEntity> subject, int subjectId){
        boolean haveSubject = false;
        for (int i = 0; i < subject.size(); i++ ) {
            if(subject.get(i).getSubject_id() == subjectId){
                haveSubject = true;
                subject.remove(i);
            }
        }
        return haveSubject;
    }

    public SubjectInterface getSubjectInterface() {
        return subjectInterface;
    }

    public void setSubjectInterface(SubjectInterface subjectInterface) {
        this.subjectInterface = subjectInterface;
    }

    public StudentManagerInterface getStudentManagerInterface() {
        return studentManagerInterface;
    }

    public void setStudentManagerInterface(StudentManagerInterface studentManagerInterface) {
        this.studentManagerInterface = studentManagerInterface;
    }
}
