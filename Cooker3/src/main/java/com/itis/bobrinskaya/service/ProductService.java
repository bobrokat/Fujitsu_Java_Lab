package com.itis.bobrinskaya.service;


import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;

import java.util.List;

/**
 * Created by Ekaterina on 10.04.2016.
 */
public interface ProductService {
    /**
     *
     * @return all pructs
     */
    List<Product> getAll();

    /**
     *
     * @param name
     * @return ine product by name
     */
    Product getOne(String name);

    /**
     *
     * @param prod1
     * @param prod2
     * @param prod3
     * updates productis in slider
     */
    void updateslider(String prod1, String prod2, String prod3);

    /**
     *
     * @return products fron slider
     */
    List<Product> getSlider();

    /**
     *
     * @return products from meals of the day
     */

    List<Product> getMealsOfDay();

    /**
     *
     * @return products from featured meals
     */

    List<Product> getFeaturedMeals();

    /**
     *
     * @param type
     * @return products delected by type
     */

    List<Product> sendToListing(ProductTypeEnum type);

    /**
     *
     * @param product
     * creates or updates selected product to DB
     */

    void createProduct(Product product);

    /**
     *
     * @param product
     * deletes selected product
     */

    void deleteProd(Product product);
}
