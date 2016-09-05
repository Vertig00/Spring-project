package net.atos.start.student.controller.student;

import net.atos.start.student.entity.Student;
import net.atos.start.student.entity.StudentForm;
import net.atos.start.student.interfaces.StudentManagerInterface;
import net.atos.start.student.validate.StudentValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

/**
 * Created by lukasz on 25.07.16.
 */
@Controller
public class EditStudentController extends HttpServlet {

    private static final String EDIT_STUDENT_FORM = "editStudent";
    private Logger logger = Logger.getLogger("EditStudentController.class");
    private int ID_GLOBAL;

    @Autowired
    private StudentValidator studentValidator;

    @Autowired
    private StudentManagerInterface studentManagerInterface;

    @RequestMapping(path = "/editStudent/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") int id, Model model){

        ID_GLOBAL = id;
        logger.info("Rozpoczęto edycje studenta");
        Student student = studentManagerInterface.getStudent(id);
        StudentForm form = student.getForm();
        model.addAttribute("editStudentForm", form);
        return "editStudent";
    }

    @RequestMapping(path = "/editStudent", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("editStudentForm") StudentForm studentForm,
                           BindingResult bindingResult, Model model){

        studentValidator.editStudentValidate(studentForm, bindingResult);
        if (bindingResult.hasErrors()){
            return EDIT_STUDENT_FORM;
        }

        studentManagerInterface.editStudent(ID_GLOBAL, studentForm.getName(), studentForm.getSurname(),
                studentForm.getSex(), studentForm.getPesel(), studentForm.getEmail());

        logger.info("Pomyslnie zedytowano nowego studenta");
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
