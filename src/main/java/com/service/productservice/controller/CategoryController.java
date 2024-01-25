package com.service.productservice.controller;

import com.service.productservice.Model.Category;
import com.service.productservice.Model.Product;
import com.service.productservice.Service.FakeStoreProductService;
import com.service.productservice.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategories(@PathVariable("id") Long id)
    {
        return categoryService.getCategory(id);
    }

    @GetMapping()
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addNewCategory(@RequestBody Category category)  {
        return categoryService.addNewCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category)  {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void removeCategory(@PathVariable("id") Long id)
    {
        categoryService.removeCategory(id);
    }
}
