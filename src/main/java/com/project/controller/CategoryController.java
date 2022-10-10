package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.congif.ApiResponse;
import com.project.dto.CategoryDto;
import com.project.entity.Category;
import com.project.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDto categoryDto) {
	     Category category=new Category();
	     category.setCategoryName(categoryDto.getCategoryName());
	     
	     
		 categoryService.saveCategory(category);
	     return new ResponseEntity<>(new ApiResponse(true, " a new Category created"),HttpStatus.CREATED);

	}
	
	@GetMapping("/category")
	public List<Category> getAllCAtegories() {
		return categoryService.getAllCategory();
		
	}
	


	@PutMapping("/category/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody CategoryDto categoryDto) {
		if(! categoryService.findById(categoryId)) {
		     return new ResponseEntity<>(new ApiResponse(false, " category does not exist "),HttpStatus.NOT_FOUND);

		}
		
		categoryService.editCategory(categoryId,categoryDto);
	     return new ResponseEntity<>(new ApiResponse(true, " updatedcategory hass been "),HttpStatus.OK);

	}
}
