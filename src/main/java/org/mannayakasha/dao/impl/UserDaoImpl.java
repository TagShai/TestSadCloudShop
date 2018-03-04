package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IUserDao;
import org.mannayakasha.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of the {@link org.mannayakasha.dao.interfaces.IUserDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Transactional
@Repository
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        String hql = "SELECT user FROM User as user";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User getByEmail(String email) {
        String hql = "SELECT user FROM User as user WHERE lower(user.email) like :email";

        User user = null;

        try {
            user = (User) entityManager.createQuery(hql).setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {

        } finally {
            return user;
        }
    }

    @Override
    public User getByUsername(String username) {
        String hql = "SELECT user FROM User as user WHERE lower(user.username) like :username";

        User user = null;

        try {
            user = (User) entityManager.createQuery(hql).setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {

        } finally {
            return user;
        }
    }

    @Override
    public boolean userExists(String username) {
        String hql = "FROM User as u WHERE u.username = ?";
        int count = entityManager.createQuery(hql).setParameter(1, username).getResultList().size();
        return count > 0;
    }

    @Override
    public User getById(int id) {
        String hql = "SELECT user FROM User as user WHERE user.id = :userId";

        User user = (User) entityManager.createQuery(hql).setParameter("userId", id).getSingleResult();

        return user;
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
