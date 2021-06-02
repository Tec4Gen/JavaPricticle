package com.ssu.archive.dao;

import com.ssu.archive.entity.UserAccount;
import com.ssu.archive.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {
    private SessionFactory sessionFactory;
    private EntityManager em;

    public UserDao() {

        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        this.em = sessionFactory.createEntityManager();
    }

    public boolean registration(UserAccount userAccount) {
        Session session = sessionFactory.openSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);

            Root<UserAccount> variableRoot = query.from(UserAccount.class);


            query
                .select(variableRoot)
                    .where(builder.equal(variableRoot.get("login"), userAccount.getLogin()));

            List<UserAccount> resultList = em.createQuery(query).getResultList();
            if (resultList.isEmpty()) {
                session.beginTransaction();
                session.save(userAccount);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }

        } finally {
            session.close();
        }
    }

    public boolean authorization(String login, String password) {
        Session session = sessionFactory.openSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);

            Root<UserAccount> variableRoot = query.from(UserAccount.class);


            query
                    .select(variableRoot)
                    .where(builder.equal(variableRoot.get("login"), login));

            List<UserAccount> resultList = em.createQuery(query).getResultList();
            for (var itVar : resultList)
            {
                if(BCrypt.checkpw(password, itVar.getHashPassword())) {
                    return true;
                }
                else {
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
        finally {
            session.close();

        }
    }
}
