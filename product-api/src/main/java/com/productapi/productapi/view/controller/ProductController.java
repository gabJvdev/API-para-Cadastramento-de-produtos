package com.productapi.productapi.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.productapi.model.ProductModel;
import com.productapi.productapi.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductModel> getId(@PathVariable Integer id) {
        return productService.getId(id);
    }

    @PostMapping
    public ProductModel add(@RequestBody ProductModel product) {
        return productService.add(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductModel update(@PathVariable Integer id, @RequestBody ProductModel product) {
        product.setId(id);
        return productService.update(id, product);
    }

}
