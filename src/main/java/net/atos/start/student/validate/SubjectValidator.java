package net.atos.start.student.validate;

import net.atos.start.student.entity.SubjectEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by lukasz on 05.08.16.
 */
@Component
public class SubjectValidator implements Validator{

    Logger logger = Logger.getLogger("SubjectValidator.class");

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 10;

    private static final String TEXT_PATTERN = "([a-zA-Z]|[Łł]|[ąęóźćżśł]|[ ])*";


    public boolean supports(Class<?> aClass) {
        return SubjectEntity.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        SubjectEntity form = (SubjectEntity) o;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.subject.emptyNameField");
        ValidationUtils.rejectIfEmpty(errors, "ects", "error.ects.emptyEctsField");

        if (form.getEcts() < MIN_VALUE || form.getEcts() > MAX_VALUE){
            errors.rejectValue("ects","error.invalidText");
            logger.warn("Nieprawidłowa wartość pola ECTS");
        }
        if (!form.getName().matches(TEXT_PATTERN)){
            errors.rejectValue("name","error.invalidText");
            logger.warn("Nieprawidłowa nazwa przedmiotu");
        }
    }
}
