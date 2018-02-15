package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
public class ProductController {

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        //List<Product> products = productService.getAll();
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Milk");
        product1.setPrice(100.0);
        product1.setDescription("This is the milk");
        product1.setFullDescription("This is full description of the milk");
        product1.setImage("image.png");
        product1.setNovelty(true);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
