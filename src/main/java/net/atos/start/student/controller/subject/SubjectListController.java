package net.atos.start.student.controller.subject;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.SubjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by lukasz on 04.08.16.
 */
@Controller
public class SubjectListController {

    private Logger logger = Logger.getLogger("SubjectListController.class");

    private static final String SUBJECT = "subjects";

    @Autowired
    private SubjectInterface subjectInterface;

    @RequestMapping(path = "/subjects", method = RequestMethod.GET)
    public String listSubjects(Model model){
        List<SubjectEntity> subjectList = subjectInterface.listSubject();

        model.addAttribute("subjectList", subjectList);
        logger.info("Wylistowano przedmioty");
        return SUBJECT;
    }


    @RequestMapping(path = "/removeSubject", method = RequestMethod.POST)
    public String removeStudent(@RequestParam("id") int id, Model model, HttpServletRequest request){
        subjectInterface.removeSubject(id);

        request.setAttribute("notification", true);
        request.setAttribute("masseage", "Pomyślnie usunięto przedmiot");

        logger.info("Pomyślnie usunięto studenta");
        return "redirect:" + SUBJECT;
    }


    public SubjectInterface getSubjectInterface() {
        return subjectInterface;
    }

    public void setSubjectInterface(SubjectInterface subjectInterface) {
        this.subjectInterface = subjectInterface;
    }

}
