package net.atos.start.student.controller.subject;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.SubjectInterface;
import net.atos.start.student.validate.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * Created by lukasz on 04.08.16.
 */
@Controller
public class AddSubjectController {

    private Logger logger = Logger.getLogger("AddSubjectController.class");

    private static final String SUBJECT_ADD_FORM = "addSubject";

    @Autowired
    private SubjectValidator subjectValidator;

    @Autowired
    private SubjectInterface subjectInterface;

    @RequestMapping(path = "/addSubject", method = RequestMethod.GET)
    public String showAddPage(Model model){
        logger.info("Rozpoczęto dodawanie nowego przedmiotu");
        SubjectEntity form = new SubjectEntity();
        model.addAttribute("addSubjectForm", form);
        return SUBJECT_ADD_FORM;
    }

    @RequestMapping(path = "/addSubject", method = RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("addSubjectForm") SubjectEntity subjectForm,
                                BindingResult bindingResult, Model model){

        subjectValidator.validate(subjectForm, bindingResult);
        if (bindingResult.hasErrors()){
            return SUBJECT_ADD_FORM;
        }

        subjectInterface.setSubject(subjectForm.getName(),
                                    subjectForm.getEcts(),
                                    subjectForm.getDescription());
        logger.info("Dodano nowy przedmiot");
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
