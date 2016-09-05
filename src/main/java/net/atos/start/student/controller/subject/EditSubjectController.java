package net.atos.start.student.controller.subject;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.SubjectInterface;
import net.atos.start.student.validate.SubjectValidator;
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
public class EditSubjectController extends HttpServlet {

    private Logger logger = Logger.getLogger("EditSubjectController.class");

    private static final String EDIT_SUBJECT_FORM = "editSubject";
    private int ID_GLOBAL;

    @Autowired
    private SubjectInterface subjectInterface;

    @Autowired
    private SubjectValidator subjectValidator;

    @RequestMapping(path = "/editSubject/{id}", method = RequestMethod.GET)
    public String showSubjectInfo(@PathVariable("id") int id,
                                  @ModelAttribute("editSubjectForm") SubjectEntity subjectForm,
                                  Model model){
        ID_GLOBAL = id;
        SubjectEntity subject = subjectInterface.getSubject(id);
        subjectForm = subject.getForm();

        model.addAttribute("editSubjectForm", subjectForm);
        logger.info("Rozpoczeto edycje przedmiotu");
        return EDIT_SUBJECT_FORM;
    }


    @RequestMapping(path = "/editSubject", method = RequestMethod.POST)
    public String editSubject(@ModelAttribute("editSubjectForm") SubjectEntity subjectForm,
                           BindingResult bindingResult, Model model){

        subjectValidator.validate(subjectForm, bindingResult);
        if (bindingResult.hasErrors()){
            return EDIT_SUBJECT_FORM;
        }

        subjectInterface.editStudent(ID_GLOBAL, subjectForm.getName(),
                                     subjectForm.getEcts(), subjectForm.getDescription());
        logger.info("Pomyslnie zedytowano przedmiot");
        return "redirect:/subjects";
    }

    public SubjectInterface getSubjectInterface() {
        return subjectInterface;
    }

    public void setSubjectInterface(SubjectInterface subjectInterface) {
        this.subjectInterface = subjectInterface;
    }

    public SubjectValidator getSubjectValidator() {
        return subjectValidator;
    }

    public void setSubjectValidator(SubjectValidator subjectValidator) {
        this.subjectValidator = subjectValidator;
    }
}



