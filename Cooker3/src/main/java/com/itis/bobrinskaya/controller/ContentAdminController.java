package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Ekaterina on 15.04.2016.
 */
@Controller
@RequestMapping(value = "/contentadmin")
@SessionAttributes(types = String.class)
public class ContentAdminController {


    @Autowired
    ProductService productService;

    /**
     *
     * @return contentadmin page
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getTopage() {
        return "contentadmin";
    }

    /**
     *
     * @param name
     * @param price
     * @param type
     * @param description
     * @param photo
     * @return contentadmin page with new product added
     */
    @RequestMapping(value = "/addtoDB", method = RequestMethod.POST)
    public String addToDB(@RequestParam String name, @RequestParam double price, @RequestParam String type, @RequestParam String description, @RequestParam MultipartFile photo) {
        Product product = new Product();
        if (productService.getOne(name) != null) {
            System.out.println("такой продукт уже есть");
            return "redirect:/contentadmin";
        }
        product.setName(name);
        product.setPrice(price);
        ProductTypeEnum productTypeEnum = null;
        switch (type) {
            case "PIZZA":
                productTypeEnum = ProductTypeEnum.PIZZA;
                break;
            case "ROLL":
                productTypeEnum = ProductTypeEnum.ROLL;
                break;
            case "WOK":
                productTypeEnum = ProductTypeEnum.WOK;
                break;
            case "DESERT":
                productTypeEnum = ProductTypeEnum.DESERT;
                break;
            case "DRINK":
                productTypeEnum = ProductTypeEnum.DRINK;
                break;
            case "ANOTHER":
                productTypeEnum = ProductTypeEnum.ANOTHER;
                break;
            case "KOMBO":
                productTypeEnum = ProductTypeEnum.KOMBO;
        }
        product.setType(productTypeEnum);
        product.setDescription(description);
        product.setPhoto(savefile(photo));

        productService.createProduct(product);
        return "redirect:/contentadmin";
    }

    public String savefile(MultipartFile photo) {
        if (!photo.isEmpty()) {
            try {
                byte[] bytes = photo.getBytes();


                String rootPath = "C:\\Users\\Ekaterina\\IdeaProjects\\Cooker3\\src\\main\\webapp\\images";
                String rootPath2 = "C:\\Users\\Ekaterina\\IdeaProjects\\Cooker3\\target\\Cooker3-1.0-SNAPSHOT\\images";
                System.out.println("Server rootPath: " + rootPath);
                File dir = new File(rootPath);
                File dir2 = new File(rootPath2);

                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String photoname = photo.getOriginalFilename();

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + photoname);
                File uploadedFile2 = new File(dir2.getAbsolutePath() + File.separator + photoname);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
                BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(uploadedFile2));
                stream2.write(bytes);
                stream2.flush();
                stream2.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "images/" + photo.getOriginalFilename();
    }

    /**
     *
     * @param prodname
     * @return checks if selectted productname id free
     */
    @RequestMapping(value = "/addtoDB/check", method = RequestMethod.POST)
    public
    @ResponseBody
    String checkphone(@RequestParam String prodname) {
        if (productService.getOne(prodname) != null) {
            return "on";
        } else {
            return "off";
        }

    }

    /**
     *
     * @param prodname
     * @return checks if selectted productname id free
     */
    @RequestMapping(value = "/edit/check", method = RequestMethod.POST)
    public
    @ResponseBody
    String check(@RequestParam String prodname) {
        if (productService.getOne(prodname) != null) {
            return "on";
        } else {
            return "off";
        }

    }

    /**
     *
     * @param prod1
     * @param prod2
     * @param prod3
     * @return cpntentadmin page with selected products adeed to slider
     */
    @RequestMapping(value = "/addtoSlider", method = RequestMethod.POST)
    public String addToSlider(@RequestParam String prod1, @RequestParam String prod2, @RequestParam String prod3) {
        if (productService.getOne(prod1) == null) {
            System.out.println("Продукта с именем " + prod1 + " не существует ");
            return "redirect:/contentadmin";
        }
        if (productService.getOne(prod2) == null) {
            System.out.println("Продукта с именем " + prod2 + " не существует ");
            return "redirect:/contentadmin";
        }
        if (productService.getOne(prod3) == null) {
            System.out.println("Продукта с именем " + prod3 + " не существует ");
            return "redirect:/contentadmin";
        }
        productService.updateslider(prod1, prod2, prod3);
        return "redirect:/contentadmin";

    }

    /**
     *
     * @param prod1
     * @param prod2
     * @param prod3
     * @return all fields for adding to slider aren't empty
     */
    @RequestMapping(value = "/addtoSlider/check", method = RequestMethod.POST)
    public
    @ResponseBody
    String checkslider(@RequestParam String prod1, @RequestParam String prod2, @RequestParam String prod3) {
        String returnvalue;
        if (productService.getOne(prod1) == null && !prod1.equals("")) {
            returnvalue = "prod1";
        } else if (productService.getOne(prod2) == null && !prod2.equals("")) {
            returnvalue = "prod2";
        } else if (productService.getOne(prod3) == null && !prod3.equals("")) {
            returnvalue = "prod3";

        } else {
            returnvalue = "off";
        }
        return returnvalue;

    }

    /**
     *
     * @param prodremove
     * @return contentadnmin page with sekected product removed
     */
    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    public String removeProduct(@RequestParam String prodremove) {
        Product product = productService.getOne(prodremove);
        productService.deleteProd(product);

        return "redirect:/contentadmin";
    }


    /**
     *
     * @param oldname
     * @param editname
     * @param editprice
     * @param editdescription
     * @param editphoto
     * @return contentadmin page with selected product editted
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam String oldname, @RequestParam String editname, @RequestParam String editprice, @RequestParam String editdescription, @RequestParam MultipartFile editphoto) {
        Product product = productService.getOne(oldname);
        if (!editname.equals(oldname)) {
            if (productService.getOne(editname) != null) {
                System.out.println("такой продукт уже есть");
                return "redirect:/contentadmin";
            }
        }
        System.out.println(editname + " " + editprice + " " + editdescription + " " + editphoto);
        if (!editname.equals("")) {
            product.setName(editname);
        }
        if (!editprice.equals("")) {
            product.setPrice(Double.parseDouble(editprice));
        }
        if (!editdescription.equals("")) {
            product.setDescription(editdescription);
        }
        if (!editphoto.isEmpty()) {
            product.setPhoto(savefile(editphoto));
        }
        productService.createProduct(product);
        return "redirect:/contentadmin";
    }
}
