package net.atos.start.student.interfaces;

import net.atos.start.student.entity.SubjectEntity;

import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */
public interface SubjectInterface {

    void setSubject(String name, int ects, String description);
    List<SubjectEntity> listSubject();
    void removeSubject(int id);
    SubjectEntity getSubject(int id);
    void editStudent(int id_global, String name, int ects, String description);
}
