package com.service.productservice.controller;

import com.service.productservice.Model.Product;
import com.service.productservice.Service.FakeStoreProductService;
import com.service.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    private FakeStoreProductService fakeStoreProductService;
    private RestTemplate restTemplate;
    @Autowired
    public ProductController(ProductService productService, FakeStoreProductService fakeStoreProductService)
    {
        this.productService = productService;
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id)
    {
        return productService.getProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product)  {
        return productService.addNewProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product)  {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable("id") Long id)
    {
        productService.removeProduct(id);
    }

    @GetMapping("category/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") String name)
    {
        return productService.getProductByCategory(name);
    }

}
