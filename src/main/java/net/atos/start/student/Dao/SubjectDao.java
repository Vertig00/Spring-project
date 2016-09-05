package net.atos.start.student.Dao;

import net.atos.start.student.entity.SubjectEntity;
import net.atos.start.student.repository.SubjectRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lukasz on 04.08.16.
 */

@Transactional
@Repository
public class SubjectDao implements SubjectRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<SubjectEntity> findAll() {
        return getSession().createQuery("from Subject").list();
    }

    public SubjectEntity findById(int id) {
        String queryStr = "from Subject s where s.id=:id";
        Query query = getSession().createQuery(queryStr);
        query.setParameter("id",id);
        SubjectEntity subject = (SubjectEntity) query.getSingleResult();

        return subject;
    }

    public void removeById(int id) {
        Query query = getSession().createQuery("delete Subject where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
    }

    public void save(SubjectEntity subject) {
        Session session = getSession();
        session.saveOrUpdate(subject);
    }

    public void update(int id, SubjectEntity subject) {
        Session session = getSession();
        session.saveOrUpdate(subject);
    }
}
