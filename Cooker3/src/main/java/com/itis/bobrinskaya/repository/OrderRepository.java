package com.itis.bobrinskaya.repository;

import com.itis.bobrinskaya.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    /**
     *
     * @return orders with status false
     */
    @Query("select o from Orders o where o.status = false ")
    List<Orders> findNotReady();
    /**
     *
     * @return orders with status true
     */

    @Query("select o from Orders o where o.status = true ")
    List<Orders> findReady();

    /**
     *
     * @param id
     * @return id of selected user's last order
     */
    @Query("select max(o.id) from Orders o where o.user.id = :id")
    int findUsersLastOrder(@Param("id") int id);
}
