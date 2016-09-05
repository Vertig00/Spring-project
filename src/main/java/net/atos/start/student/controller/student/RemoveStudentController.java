package net.atos.start.student.controller.student;

import net.atos.start.student.interfaces.StudentManagerInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lukasz on 25.07.16.
 */
@Controller
public class RemoveStudentController extends HttpServlet {

    private Logger logger = Logger.getLogger("RemoveStudentController.class");

    @Autowired
    private StudentManagerInterface studentManagerInterface;

    @RequestMapping(path = "/removeStudent", method = RequestMethod.POST)
    public String removeStudent(@RequestParam("id") int id, Model model, HttpServletRequest request){
        studentManagerInterface.removeStudent(id);

        request.setAttribute("notification", true);
        request.setAttribute("masseage", "Pomyślnie usunięto studenta");

        logger.info("Pomyślnie usunięto studenta");
        return "redirect:/students";
    }

    public StudentManagerInterface getStudentManagerInterface() {
        return studentManagerInterface;
    }

    public void setStudentManagerInterface(StudentManagerInterface studentManagerInterface) {
        this.studentManagerInterface = studentManagerInterface;
    }

}
