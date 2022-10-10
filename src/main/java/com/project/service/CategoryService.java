package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.dto.CategoryDto;
import com.project.entity.Category;

public interface CategoryService {

	public Category saveCategory(Category category);

	public List<Category> getAllCategory();

public void UpdateCategoryById(int id);

public void editCategory(int categoryId, CategoryDto categoryDto);

public boolean findById(int categoryId);

	
	

}
