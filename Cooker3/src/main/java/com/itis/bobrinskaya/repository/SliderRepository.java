package com.itis.bobrinskaya.repository;


import com.itis.bobrinskaya.model.Slider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ekaterina on 17.04.2016.
 */
public interface SliderRepository extends JpaRepository<Slider, Long> {

//    @Query ("select s from Slider s where s.product.name = :name")
//    Product findByProductName();
}
