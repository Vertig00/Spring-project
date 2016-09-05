package net.atos.start.student.validate;

import net.atos.start.student.entity.StudentForm;
import net.atos.start.student.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by lukasz on 28.07.16.
 */
@Component
public class StudentValidator implements Validator {

    @Autowired
    private StudentRepository studentRepository;

    Logger logger = Logger.getLogger("StudentValidator.class");

    private static final String TEXT_PATTERN = "([a-zA-Z]|[Łł]){1}([a-z]|[ąęóźćżśł])*";
    private static final String PESEL_PATTERN = "[0-9]{11}";
    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}";
    private static final String DATE_PATTERN = "[0-9]{2}.[0-9]{2}.[0-9]{4}";

    public boolean supports(Class<?> aClass) {
        return StudentForm.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        StudentForm form = (StudentForm) o;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.emptyNameField");
        ValidationUtils.rejectIfEmpty(errors, "surname", "error.emptySurnameField");
        ValidationUtils.rejectIfEmpty(errors, "pesel", "error.emptyPeselField");
        ValidationUtils.rejectIfEmpty(errors, "birthDate", "error.emptyBirthDate");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.emptyEmailField");

        if(studentRepository.checkIfPeselExist(form.getPesel()) > 0){
            errors.rejectValue("pesel","error.peselAlreadyExist");
            logger.warn("Podany pesel istnieje w bazie");
        }

        if (!form.getName().matches(TEXT_PATTERN)){
            errors.rejectValue("name","error.invalidText");
            logger.warn("Nieprawidłowe imie");
        }

        if (!form.getSurname().matches(TEXT_PATTERN)){
            errors.rejectValue("surname","error.invalidText");
            logger.warn("Nieprawidłowe nazwisko");
        }

        if (!form.getPesel().matches(PESEL_PATTERN)){
            errors.rejectValue("pesel","error.invalidPesel");
            logger.warn("Nieprawidłowy pesel");
        }

        if (!form.getEmail().matches(EMAIL_PATTERN)){
            errors.rejectValue("email","error.invalidEmail");
            logger.warn("Nieprawidłowy email");
        }

        if (!form.getBirthDate().matches(DATE_PATTERN)){
            errors.rejectValue("birthDate","error.invalidBirthDate");
            logger.warn("Nieprawidłowa data");
        }
    }

    public void editStudentValidate(Object o, Errors errors) {
        StudentForm form = (StudentForm) o;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.emptyNameField");
        ValidationUtils.rejectIfEmpty(errors, "surname", "error.emptySurnameField");
        ValidationUtils.rejectIfEmpty(errors, "pesel", "error.emptyPeselField");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.emptyEmailField");

        if(studentRepository.checkIfPeselExist(form.getPesel()) > 1){
            errors.rejectValue("pesel","error.peselAlreadyExist");
            logger.warn("Podany pesel istnieje w bazie");
        }

        if (!form.getName().matches(TEXT_PATTERN)){
            errors.rejectValue("name","error.invalidText");
            logger.warn("Nieprawidłowe imie");
        }

        if (!form.getSurname().matches(TEXT_PATTERN)){
            errors.rejectValue("surname","error.invalidText");
            logger.warn("Nieprawidłowe nazwisko");
        }

        if (!form.getPesel().matches(PESEL_PATTERN)){
            errors.rejectValue("pesel","error.invalidPesel");
            logger.warn("Nieprawidłowy pesel");
        }

        if (!form.getEmail().matches(EMAIL_PATTERN)){
            errors.rejectValue("email","error.invalidEmail");
            logger.warn("Nieprawidłowy email");
        }
    }
}
