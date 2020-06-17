package com.avito.service.serviceUser;


public interface ServiceUser {
        List<User> getAllUsers ();
        User findUserByLogin (String login);
        User addUser (User user);
        User updateUser (User user);
        void deleteUser (long id);
}
