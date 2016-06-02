package com.itis.bobrinskaya.repository;

import com.itis.bobrinskaya.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ekaterina on 22.04.2016.
 */
public interface UserRepository extends JpaRepository<Users, Long> {
    /**
     *
     * @param login
     * @return user selected by login
     */
    Users findByLogin(String login);

    /**
     *
     * @param phone
     * @return user selected by phone
     */

    Users findByPhone(String phone);
}
