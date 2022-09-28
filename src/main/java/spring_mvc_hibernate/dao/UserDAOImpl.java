package spring_mvc_hibernate.dao;

import org.springframework.stereotype.Repository;
import spring_mvc_hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userToUpdated = getUser(id);
        userToUpdated.setName(user.getName());
        userToUpdated.setSurname(user.getSurname());
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> query = entityManager
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id",id);

        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        entityManager
                .createQuery("DELETE FROM User u WHERE u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}




























































