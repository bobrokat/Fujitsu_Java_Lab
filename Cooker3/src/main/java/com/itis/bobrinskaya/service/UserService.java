package com.itis.bobrinskaya.service;

import com.itis.bobrinskaya.model.Users;

/**
 * Created by Ekaterina on 22.04.2016.
 */

public interface UserService {
     /**
      *
      * @param login
      * @return user selected by login
      */
     Users getOneByLogin(String login);

     /**
      *
      * @param user
      * creates or updates selected user
      */
     void createUser(Users user);

     /**
      *
      * @param phone
      * @return user selected by phone
      */
     Users getOneByPhone(String phone);
}
