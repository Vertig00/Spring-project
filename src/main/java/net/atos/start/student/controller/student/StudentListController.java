package net.atos.start.student.controller.student;

import net.atos.start.student.entity.Student;
import net.atos.start.student.interfaces.StudentManagerInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

/**
 * Created by lukasz on 25.07.16.
 */
@Controller
public class StudentListController extends HttpServlet {

    private Logger logger = Logger.getLogger("StudentListController.class");

    @Autowired
    private StudentManagerInterface studentManagerInterface;

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public String showStudents(Model model)
            throws ServletException, IOException {

        List<Student> studentList = studentManagerInterface.listStudent();

        model.addAttribute("studentsList", studentList);
        logger.info("Wylistowano studentów");
        return "students";
    }

    public StudentManagerInterface getStudentManagerInterface() {
        return studentManagerInterface;
    }

    public void setStudentManagerInterface(StudentManagerInterface studentManagerInterface) {
        this.studentManagerInterface = studentManagerInterface;
    }

/*    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/
}
