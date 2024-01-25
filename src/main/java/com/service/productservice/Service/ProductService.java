package com.service.productservice.Service;

import com.service.productservice.Model.Category;
import com.service.productservice.Model.Product;
import com.service.productservice.dto.FakeStoreProductDto;
import com.service.productservice.repositories.CategoryRepository;
import com.service.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        Optional<Product> data = productRepository.findById(id);
        return data.get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product updateProduct(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1.isPresent())
        {
            return productRepository.save(product);
        }
        return null;
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductByCategory(String name) {
        Long cat_id = categoryRepository.getCategoryByName(name).getId();
        return productRepository.findAllByCategoryId(cat_id);
    }
}
