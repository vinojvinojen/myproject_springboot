/**
 * 
 */
package com.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CategoryDto;
import com.project.entity.Category;
import com.project.repositories.CategoryRepository;
import com.project.service.CategoryService;

/**
 * @author ADMIN
 *
 */
@Service
class CategoryServiceImple implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void UpdateCategoryById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCategory(int categoryId, CategoryDto UpdatecategoryDto) {
		// TODO Auto-generated method stub
		Category category=categoryRepository.getById(categoryId);
		category.setCategoryName(UpdatecategoryDto.getCategoryName());
		categoryRepository.save(category);
	}

	@Override
	public boolean findById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId).isPresent();
	}



}
