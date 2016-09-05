package net.atos.start.student.controller.subject;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.SubjectInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lukasz on 04.08.16.
 */
@Controller
public class SubjectInfoController {

    private Logger logger = Logger.getLogger("SubjectInfoController.class");

    private static final String SUBJECT = "subject";

    @Autowired
    private SubjectInterface subjectInterface;

    @RequestMapping(path = "/subject/{id}", method = RequestMethod.GET)
    public String showSubjectInfo(@PathVariable("id") int id,
                                  @ModelAttribute("subjectInfo") SubjectEntity subjectForm,
                                  BindingResult bindingResult, Model model){

        SubjectEntity subject = subjectInterface.getSubject(id);
        subjectForm = subject.getForm();

        model.addAttribute("subjectInfo", subjectForm);
        model.addAttribute("studentList", subject.getStudents());
        logger.info("Wyświetlono informacje o przedmiocie");
        return SUBJECT;
    }

    public SubjectInterface getSubjectInterface() {
        return subjectInterface;
    }

    public void setSubjectInterface(SubjectInterface subjectInterface) {
        this.subjectInterface = subjectInterface;
    }
}
