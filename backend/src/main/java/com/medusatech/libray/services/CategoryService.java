package com.medusatech.libray.services;

import com.medusatech.libray.dto.CategoryDTO;
import com.medusatech.libray.entities.Category;
import com.medusatech.libray.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(PageRequest pageRequest) {
        Page<Category> pages = categoryRepository.findAll(pageRequest);
        return pages.map(CategoryDTO::new);
    }
}
