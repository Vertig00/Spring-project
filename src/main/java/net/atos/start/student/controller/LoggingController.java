package net.atos.start.student.controller;

import net.atos.start.student.entity.Login;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lukasz on 08.08.16.
 */
@Controller
public class LoggingController {

    Logger logger = Logger.getLogger("LoggingController.class");

    @RequestMapping(path = "/loginPage", method = RequestMethod.GET)
    public String showSubjectInfo(Model model){

        Login form = new Login();
        model.addAttribute("logginForm", form);
        logger.info("Dodawanie studentów do przedmiotów");
        return "loginPage";
    }

}
