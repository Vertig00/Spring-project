package net.atos.start.student.service;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.interfaces.SubjectInterface;
import net.atos.start.student.repository.SubjectRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */
@Service
public class SubjectService implements SubjectInterface{

    private Logger logger = Logger.getLogger("SubjectService.class");

    @Autowired
    SubjectRepository subjectRepository;

    public void setSubject(String name, int ects, String description) {
        SubjectEntity subject = new SubjectEntity(name,ects,description);
        subjectRepository.save(subject);
    }

    public List<SubjectEntity> listSubject() {
        List<SubjectEntity> subjectList = subjectRepository.findAll();
        return subjectList;
    }

    public void removeSubject(int id) {
        subjectRepository.removeById(id);
    }

    public SubjectEntity getSubject(int id) {
        SubjectEntity subject = subjectRepository.findById(id);
        return subject;
    }

    public void editStudent(int id_global, String name, int ects, String description) {
        SubjectEntity subject = new SubjectEntity(id_global, name, ects, description);
        subjectRepository.update(id_global, subject);
    }


}
