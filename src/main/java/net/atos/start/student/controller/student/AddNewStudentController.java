package net.atos.start.student.controller.student;

import net.atos.start.student.entity.StudentForm;
import net.atos.start.student.interfaces.StudentManagerInterface;
import net.atos.start.student.validate.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by lukasz on 25.07.16.
 */
@Controller
public class AddNewStudentController {

    private Logger logger = Logger.getLogger("AddNewStudentController.class");

    private static final String STUDENT_ADD_FORM = "addStudent";

    @Autowired
    private StudentValidator studentValidator;

    @Autowired
    private StudentManagerInterface studentManagerInterface;

    @RequestMapping(path = "/addStudent", method = RequestMethod.GET)
    public String showAddPage(Model model){
        logger.info("Rozpoczęto dodawanie nowego studenta");
        StudentForm form = new StudentForm();
        model.addAttribute("addStudentForm", form);
        return "addStudent";
    }

    @RequestMapping(path = "/addStudent", method = RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("addStudentForm") StudentForm studentForm,
                                BindingResult bindingResult, Model model){

        studentValidator.validate(studentForm, bindingResult);
        if (bindingResult.hasErrors()){
            return STUDENT_ADD_FORM;
        }

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date formatDate = null;
        try {
            formatDate = formatter.parse(studentForm.getBirthDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        studentManagerInterface.setStudent(studentForm.getName(), studentForm.getSurname(),
                formatDate, studentForm.getSex(), studentForm.getPesel(), studentForm.getEmail());
        logger.info("Dodano nowego studenta");

        return "redirect:/students";
    }

    public StudentManagerInterface getStudentManagerInterface() {
        return studentManagerInterface;
    }

    public void setStudentManagerInterface(StudentManagerInterface studentManagerInterface) {
        this.studentManagerInterface = studentManagerInterface;
    }

    public StudentValidator getStudentValidator() {
        return studentValidator;
    }

    public void setStudentValidator(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }
}
