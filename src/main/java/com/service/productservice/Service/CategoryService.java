package com.service.productservice.Service;

import com.service.productservice.Model.Category;
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
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(Long id) {
        Optional<Category> data = categoryRepository.findById(id);
        return data.get();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public Category updateCategory(Category category) {
        Optional<Category> product1 = categoryRepository.findById(category.getId());
        if(product1.isPresent())
        {
            return categoryRepository.save(category);
        }
        return null;
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
