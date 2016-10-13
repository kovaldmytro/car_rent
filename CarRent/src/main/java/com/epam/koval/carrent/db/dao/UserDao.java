package com.epam.koval.carrent.db.dao;

import java.util.List;

import com.epam.koval.carrent.db.entity.User;

/**
 * User DAO interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface UserDao {
    /**
     * Insert user.
     * 
     * @param user user to insert
     * @return inserted user
     */
    User insertUser(User user);

    /**
     * Update user.
     * 
     * @param user user to update
     * @return updated user
     */
    boolean updateUser(User user);

    /**
     * Deletes user.
     *
     * @param userId id of user to delete
     * @return true on success, false on failure
     */
    boolean deleteUser(Long userId);

    /**
     * Returns all users.
     *
     * @return list of users
     */
    List<User> getAllUsers();

    /**
     * Returns user by it's id.
     *
     * @param userId user's id
     * @return user model
     */
    User getUserById(Long userId);

    /**
     * Returns user by it's username.
     *
     * @param email e-mail
     * @return user model
     */
    User getUserByEmail(String email);
}
