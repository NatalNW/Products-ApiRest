package com.product.apirest.controllers;

import com.product.apirest.repository.ProductRepository;

import java.util.List;

import com.product.apirest.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/Products")
    @ApiOperation(value = "Return a products list")
    public List<Product> listarProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/Product/{id}")
    @ApiOperation(value = "Return a single product")
    public Product listarProduct(@PathVariable(value = "id") long id) {
        return productRepository.getOne(id);
    }

    @PostMapping("/Product")
    @ApiOperation(value = "Save a product")
    public Product salvarProduct(@RequestBody Product Product) {
        return productRepository.save(Product);
    }

    @PutMapping("/Product")
    @ApiOperation(value = "Update a product")
    public Product atualizarProduct(@RequestBody Product Product) {
        return productRepository.save(Product);
    }

    @DeleteMapping("/Product")
    @ApiOperation(value = "Remove a product")
    public void deletarProduct(@RequestBody Product Product) {
        productRepository.delete(Product);
    }
}