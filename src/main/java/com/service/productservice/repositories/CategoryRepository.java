package com.service.productservice.repositories;

import com.service.productservice.Model.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category product);

    Optional<Category> findById(Long id);

    @Override
    List<Category> findAll();

    @Override
    void deleteById(Long id);

    Category getCategoryByName(String name);
}

