package net.atos.start.student.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by lukasz on 26.07.16.
 */

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {MvcConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebAppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
