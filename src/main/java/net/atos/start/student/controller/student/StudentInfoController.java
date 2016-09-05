package net.atos.start.student.controller.student;

import net.atos.start.student.entity.Student;
import net.atos.start.student.entity.StudentForm;
import net.atos.start.student.interfaces.StudentManagerInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lukasz on 25.07.16.
 */
@Controller
public class StudentInfoController {

    private Logger logger = Logger.getLogger("StudentInfoController.class");

    @Autowired
    private StudentManagerInterface studentManagerInterface;

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    public String showStudentInfo(@PathVariable("id") int id,
                                  @ModelAttribute("studentInfo") StudentForm studentForm,
                                  BindingResult bindingResult, Model model){

        Student student = studentManagerInterface.getStudent(id);
        studentForm = student.getForm();

        model.addAttribute("studentInfo", studentForm);
        model.addAttribute("subjectList", student.getSubjects());
        logger.info("Wyświetlono informacje o studencie");
        return "student";
    }


    @RequestMapping(path = "/student/removeStudentSubject", method = RequestMethod.POST)
    public String deleteStudentSubject(@RequestParam("subjectId") int subjectId,
                                       @RequestParam("id") int studentId,
                                       Model model){

        Student student = studentManagerInterface.getStudent(studentId);
        studentManagerInterface.deleteStudentSubject(student, subjectId);

        studentManagerInterface.save(student);

        logger.info("Pomyślnie usunięto przedmiot");
        return "redirect:/student/" + studentId;
    }

    public StudentManagerInterface getStudentManagerInterface() {
        return studentManagerInterface;
    }

    public void setStudentManagerInterface(StudentManagerInterface studentManagerInterface) {
        this.studentManagerInterface = studentManagerInterface;
    }

}
