package com.avito.dao.interfaces;

public interface UserDao {
    List<User> getAllUsers ();
    User findUserByLogin (String login);
    User addUser (User user);
    User updateUser (User user);
    void deleteUser (long id);
}
