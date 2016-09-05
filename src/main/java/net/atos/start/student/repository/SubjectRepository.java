package net.atos.start.student.repository;

import net.atos.start.student.entity.SubjectEntity;

import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */
public interface SubjectRepository /*extends CrudRepository<Subject, Integer>*/{

    List<SubjectEntity> findAll();
    SubjectEntity findById(int id);
    void removeById(int id);
    void save(SubjectEntity subject);
    void update(int id, SubjectEntity subject);


}
