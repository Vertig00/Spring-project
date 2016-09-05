package net.atos.start.student.Dao;

import net.atos.start.student.entity.Student;
import net.atos.start.student.repository.StudentRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lukasz on 03.08.16.
 */
@Transactional
@Repository
public class StudentDao implements StudentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Student> findAll() {
        return getSession().createQuery("from Student").list();
    }

    public Student findById(int id) {
        String queryStr = "from Student s where s.id=:id";
        Query query = getSession().createQuery(queryStr);
        query.setParameter("id",id);
        Student student = (Student) query.getSingleResult();

        return student;
    }

    public void removeStudentById(int id) {
        Query query = getSession().createQuery("delete Student where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();
    }

    public void save(Student student) {
        Session session = getSession();
        session.saveOrUpdate(student);
    }

    public void update(int id, Student stud) {
        Session session = getSession();
        Student student = findById(id);
        student.setName(stud.getName());
        student.setSurname(stud.getSurname());
        student.setSex(stud.getSex());
        student.setEmail(stud.getEmail());
        student.setPesel(stud.getPesel());

        session.update(student);
    }

    public int checkIfPeselExist(String pesel) {
//        Query query = getSession().createQuery("select count(*) from Student where pesel ='" + pesel + "'");
        Criteria criteria = getSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("pesel",pesel));
        criteria.setProjection(Projections.rowCount());
        Integer count = ((Long)criteria.uniqueResult()).intValue();

        return count;
    }


}
