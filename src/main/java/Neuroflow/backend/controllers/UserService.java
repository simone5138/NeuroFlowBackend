package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.User;
import Neuroflow.backend.config.DataBaseConfig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @PersistenceContext()
    private EntityManager entityManager;


    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public User find(Long userId) {
        return entityManager.find(User.class, userId);
    }

    public Optional<User> find(String username, String password) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultStream()
                .findFirst();
    }

    public void delete(Long userId) {
        User user = find(userId);
        if (user != null)
            entityManager.remove(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public Boolean exists(String username, String password) {
        Long count = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username AND u.password =: password", Long.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        return count > 0;
    }
}
